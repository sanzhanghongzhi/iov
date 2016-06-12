--公共方法 获取 ret_json
create or replace function common_get_ret_json(err_code varchar, err_msg varchar, ret_obj json, ret_list json) returns json as $$

declare ret_json json;
begin
	
	select "row_to_json"(result) into ret_json from (select err_code, err_msg, ret_obj as obj, ret_list as list) as result;
	return ret_json;
end; 
$$
language 'plpgsql' stable;

--查询所有
create or replace function menu_get() returns json as $$

declare ret_json json;
declare ret_list json;
declare ret_obj json;
declare err_code varchar;
declare err_msg varchar;
begin 
	
	err_code := '0';
	err_msg := '';
	ret_obj := null;
	ret_list := null;
	
	select 
		"array_to_json"("array_agg"(list)) 
		into 
		ret_list 
		FROM 
		iov_menu as list;
	
	ret_json := common_get_ret_json(err_code, err_msg, ret_obj, ret_list);
	
	return ret_json;
end; 
$$
language 'plpgsql' stable;

--根据ID 查询菜单
create or replace function menu_get_by_id(menu_id varchar) returns json as $$

declare ret_json json;

declare ret_list json;
declare ret_obj json;
declare err_code varchar;
declare err_msg varchar;

begin 
	
	err_code := '0';
	err_msg := '';
	ret_obj := null;
	ret_list := null;
	
	SELECT 
		"row_to_json"(result) into ret_obj 
		FROM 
		(select 
			id,
			menu_name,
			menu_type,
			url,
			parent_id,
			icon_image
		from iov_menu where id = $1) as result;
	
	ret_json := common_get_ret_json(err_code, err_msg, ret_obj, ret_list);
	
	return ret_json;
end; 
$$
language 'plpgsql' stable;

--新增菜单
create or replace function menu_add(id varchar, menu_name varchar, menu_type varchar, url varchar, 
	parent_id varchar, menu_desc varchar, icon_image varchar, menu_sort int, status varchar) returns json as $$

declare ret_json json;

declare ret_list json;
declare ret_obj json;
declare err_code varchar;
declare err_msg varchar;

begin 
	err_code := '0';
	err_msg := '';
	ret_obj := null;
	ret_list := null;
	
	insert into
		iov_menu 
		values(id, 
			menu_name, 
			menu_type, 
			url, 
			parent_id, 
			menu_desc, 
			icon_image, 
			menu_sort, 
			status);
		
	ret_json := common_get_ret_json(err_code, err_msg, ret_obj, ret_list);
	
	
	return ret_json;
end; 
$$
language 'plpgsql' volatile;