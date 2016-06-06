package com.zbmatsu.iov.dao.commom;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;

public class BaseDao {

	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	/**
	 * 调用 PG 存储过程
	 */
	public void call(){
		
		CallableStatementCreator callableStatementCreator = new CallableStatementCreator() {
			
			@Override
			public CallableStatement createCallableStatement(Connection connection) throws SQLException {
				
				CallableStatement callableStatement = connection.prepareCall("{? = call func_getmenu()}");
				callableStatement.registerOutParameter(1, Types.OTHER);
				
				return callableStatement;
			}
		};
		
		CallableStatementCallback<Object> callableStatementCallback = new CallableStatementCallback<Object>() {

			@Override
			public Object doInCallableStatement(CallableStatement callableStatement) throws SQLException, DataAccessException {
				
				callableStatement.execute();
				return callableStatement.getObject(1);
			}
		};
		
		
		Object obj = jdbcTemplate.execute(callableStatementCreator, callableStatementCallback);
		
		System.out.println(obj);
	}
	
	/**
	 * main method
	 * @param args
	 */
	@Autowired
	public static void main(String[] args) {
		
//		DriverManager driverManager = Class.forName("");
		
		Connection connection = null;
		
		Object result = null;
		try {
			Class.forName("org.postgresql.Driver");

			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/iov", "postgres", "aptx4869");
			
			CallableStatement statement = connection.prepareCall("{? = call func_getmenu()}");
			statement.registerOutParameter(1, Types.OTHER);
			statement.execute();
			result = statement.getObject(1);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(result);
	}
}
