package com.zbmatsu.iov.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class PostgresqlFunctionTest {

	
	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		
		Connection connection = null;

		try {
			Class.forName("org.postgresql.Driver");

			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/iov", "postgres", "aptx4869");
			
			
			CallableStatement statement = connection.prepareCall("{? = call func_add_menu(?)}");
			statement.registerOutParameter(1, Types.OTHER);
			statement.setString(2, "123");
			
			statement.execute();
			
			Object result = statement.getObject(1);
			
			JSONObject json = JSON.parseObject(result.toString());
			System.out.println(json);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
