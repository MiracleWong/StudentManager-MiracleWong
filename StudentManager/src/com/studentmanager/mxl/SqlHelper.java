package com.studentmanager.mxl;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * ����SqlHelper��
 * ����:ʵ�������ݿ�����ӣ����������ݿ�(����ɾ���ġ���)
 * @author MiracleWong
 *
 */
public class SqlHelper {
	//�������ݿ����Ϣ
	private String driver = "com.mysql.jdbc.Driver";			//MySQL����
	private String url = "jdbc:mysql://localhost:3306/javaproject";	//MySQL����
	private String username = "root";							//�û���
	private String password = "wr";
	//�����������ݿ�Ķ���
	Connection connection = null;			
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	//����sql�����������ϻ�ȡ�����
	public ResultSet queryResult(String sql, String[] params) {
		try {
			Class.forName(driver);
			System.out.println("���������ɹ�");
			connection = DriverManager.getConnection(url,username,password);	 //�������ݿ�
			System.out.println("�������ݿ�ɹ�!");
			ps = connection.prepareStatement(sql);			//��ȡPreparedStatement����
			
			//ѭ�������������ϣ��SQL����е�"?"
			for (int i = 0; i < params.length; i++) {
				ps.setString(i+1, params[i]);
			}
			//��ѯ���ݿ����ȡResultSet����
			rs = ps.executeQuery();			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
		}
		return rs;		//����ResultSet����
	}
	
	//����sql�����������ϻ�ȡ�����
	public boolean isUpdate(String sql, String[] params) {
		boolean b = true;
		try {
			Class.forName(driver);
			System.out.println("���������ɹ�");
			connection = DriverManager.getConnection(url,username,password);	 //�������ݿ�
			System.out.println("�������ݿ�ɹ�!");
			ps = connection.prepareStatement(sql);			//��ȡPreparedStatement����
			
			//ѭ�������������ϣ��SQL����е�"?"
			for (int i = 0; i < params.length; i++) {
				ps.setString(i+1, params[i]);
			}
			//ִ�в���������ȡ��Ӱ�������
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
		return b;		//����ResultSet����
	}
	
	//�ر����ݿ�ĸ�����Դ
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
