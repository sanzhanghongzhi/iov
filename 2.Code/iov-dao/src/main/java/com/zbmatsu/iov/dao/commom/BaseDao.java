package com.zbmatsu.iov.dao.commom;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zbmatsu.iov.common.web.ServiceContext;


public class BaseDao {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	/**
	 * 调用 PG 存储过程
	 * @return JSONObject
	 */
	public ServiceContext callPostgresqlFunction(final String funcName, final List<InputParameter> paramList){
		
		CallableStatementCreator callableStatementCreator = new CallableStatementCreator() {
			
			@Override
			public CallableStatement createCallableStatement(Connection connection) throws SQLException {
				
				StringBuffer sql = new StringBuffer();
				sql.append("{? = call ");
				sql.append(funcName);
				sql.append("(");
				
				if(paramList != null){//判空
					for (int i = 0; i < paramList.size(); i++) {
						if(i == paramList.size() - 1){
							sql.append("?");
						}else{
							sql.append("?,");
						}
					}
				}
				
				sql.append(")}");
				
				CallableStatement callableStatement = connection.prepareCall(sql.toString());
				callableStatement.registerOutParameter(1, Types.OTHER);//存储过程的输出参数 统一为 json格式
				
				logger.info("=====> function name is : " + funcName);
				
				//set callableStatement parameter
				if(paramList != null){
					for (int j = 0; j < paramList.size(); j++) {
						
						InputParameter param = paramList.get(j);
						
						int index = param.getIndex() + 1;//入参
						Object value = param.getValue();
						Class<?> clazz = param.getClazz();
						
						logger.info("=====> INPUT PARAM [ " + value + " ]");
						
						if(clazz == String.class)
							callableStatement.setString(index, StringUtils.isEmpty(value) ? null : value.toString());
						else if(clazz == Integer.class)
							callableStatement.setInt(index, StringUtils.isEmpty(value) ? null : Integer.parseInt(value.toString()));
						else
							callableStatement.setObject(index, null);
						
					}
				}
				
				return callableStatement;
			}
		};
		
		CallableStatementCallback<ServiceContext> callableStatementCallback = new CallableStatementCallback<ServiceContext>() {

			@Override
			public ServiceContext doInCallableStatement(CallableStatement callableStatement) throws SQLException, DataAccessException {
				
				callableStatement.execute();
				Object obj = callableStatement.getObject(1);
				JSONObject jsonObject = null;
				
				ServiceContext serviceContext = new ServiceContext();
				
				try {
					jsonObject = JSON.parseObject(obj.toString());
					serviceContext = PostgresqlUtils.parse(jsonObject);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				logger.info("=====> OUT PARAM ERR_CODE[ " + serviceContext.getErrCode() + " ]");
				logger.info("=====> OUT PARAM ERR_MSG[ " + serviceContext.getErrMsg() + " ]");
				logger.info("=====> OUT PARAM OBJ[ " + serviceContext.getObj() + " ]");
				logger.info("=====> OUT PARAM LIST[ " + serviceContext.getList() + " ]");
				
				return serviceContext;
			}
		};
		
		
		ServiceContext serviceContext = jdbcTemplate.execute(callableStatementCreator, callableStatementCallback);
		
		return serviceContext;
	}
	
}
