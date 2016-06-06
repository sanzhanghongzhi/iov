create or replace function func_getmenu()
returns json as
$$
declare ret_json json;
begin 
	select "array_to_json"("array_agg"(result)) into ret_json FROM iov_menu as result;
	return ret_json;
end; 
$$
language 'plpgsql' stable;