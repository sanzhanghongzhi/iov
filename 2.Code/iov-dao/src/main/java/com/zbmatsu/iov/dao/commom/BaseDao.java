package com.zbmatsu.iov.dao.commom;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


@Repository("baseDao")
public class BaseDao {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	/**
	 * 调用 PG 存储过程
	 * @return JSONObject
	 */
	public ProductResult callPostgresqlFunction(final ProductNameEnum funcName, final JSONObject inputParams){
		
		CallableStatementCreator callableStatementCreator = new CallableStatementCreator() {
			
			@Override
			public CallableStatement createCallableStatement(Connection connection) throws SQLException {
				
				StringBuffer sql = new StringBuffer();
				sql.append("{? = call ");
				sql.append(funcName);
				sql.append("(");
				
				if(inputParams != null){
					sql.append("?");
				}
				
				sql.append(")}");
				
				CallableStatement callableStatement = connection.prepareCall(sql.toString());
				callableStatement.registerOutParameter(1, Types.OTHER);//存储过程的输出参数 统一为 json格式
				
				logger.info("=====> function name is : " + funcName);
				
				//set callableStatement parameter
				if(inputParams != null){
					
					String inputParamsStr = inputParams.toJSONString();
					
					callableStatement.setObject(2, inputParamsStr);
					
					logger.info("=====> INPUT PARAM [ " + inputParamsStr + " ]");
				}
				
				
				return callableStatement;
			}
		};
		
		CallableStatementCallback<ProductResult> callableStatementCallback = new CallableStatementCallback<ProductResult>() {

			@Override
			public ProductResult doInCallableStatement(CallableStatement callableStatement) throws SQLException, DataAccessException {
				
				callableStatement.execute();
				String jsonStr = callableStatement.getObject(1).toString();
				JSONObject jsonObject = JSON.parseObject(jsonStr);
				
				ProductResult result = new ProductResult();
				result = JSON.toJavaObject(jsonObject, ProductResult.class);
				
				logger.info("=====> OUT PARAM OBJECT[ " + result.getObject() + " ]");
				logger.info("=====> OUT PARAM LIST[ " + result.getList() + " ]");
				
				return result;
			}
		};
		
		
		ProductResult result = jdbcTemplate.execute(callableStatementCreator, callableStatementCallback);
		
		return result;
	}
	
}
