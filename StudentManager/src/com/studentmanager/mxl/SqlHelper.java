package com.studentmanager.mxl;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 创建SqlHelper类
 * 功能:实现与数据库的连接，并操作数据库(增、删、改、查)
 * @author MiracleWong
 *
 */
public class SqlHelper {
	//连接数据库的信息
	private String driver = "com.mysql.jdbc.Driver";			//MySQL驱动
	private String url = "jdbc:mysql://localhost:3306/javaproject";	//MySQL驱动
	private String username = "root";							//用户名
	private String password = "wr";
	//声明操作数据库的对象
	Connection connection = null;			
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	//根据sql语句与参数集合获取结果集
	public ResultSet queryResult(String sql, String[] params) {
		try {
			Class.forName(driver);
			System.out.println("加载驱动成功");
			connection = DriverManager.getConnection(url,username,password);	 //连接数据库
			System.out.println("连接数据库成功!");
			ps = connection.prepareStatement(sql);			//获取PreparedStatement对象
			
			//循环遍历参数集合，填补SQL语句中的"?"
			for (int i = 0; i < params.length; i++) {
				ps.setString(i+1, params[i]);
			}
			//查询数据库表，获取ResultSet对象
			rs = ps.executeQuery();			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
		}
		return rs;		//返回ResultSet对象
	}
	
	//根据sql语句与参数集合获取结果集
	public boolean isUpdate(String sql, String[] params) {
		boolean b = true;
		try {
			Class.forName(driver);
			System.out.println("加载驱动成功");
			connection = DriverManager.getConnection(url,username,password);	 //连接数据库
			System.out.println("连接数据库成功!");
			ps = connection.prepareStatement(sql);			//获取PreparedStatement对象
			
			//循环遍历参数集合，填补SQL语句中的"?"
			for (int i = 0; i < params.length; i++) {
				ps.setString(i+1, params[i]);
			}
			//执行操作，并获取受影响的行数
			int i = ps.executeUpdate();
			if (i != 1) {
				b = false;
			} else {
				b = true;
			}
			rs = ps.executeQuery();			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			this.close();
		}
		return b;		//返回ResultSet对象
	}
	
	//关闭数据库的各种资源
	public void close() {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (ps != null) {
				ps.close();
				ps = null;
			}
			if (connection != null) {
				connection.close();
				connection = null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
	}
	
}
