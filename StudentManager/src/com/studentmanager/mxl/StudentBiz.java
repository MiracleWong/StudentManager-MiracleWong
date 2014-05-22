package com.studentmanager.mxl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

/**
 * 业务管理类——StudentBiz，生成表格组件的类
 * @author Miracle_Wong
 *
 */
public class StudentBiz extends AbstractTableModel {
	
	//构建数据库连接类和Result对象
	private SqlHelper sqlHelper;
	private  ResultSet rs = null;
	//创建表格的相关数据
	//使用Vector类的对象来存储行和列的数据
	private Vector rowDatas, columnNames;
	
	@Override
	//获取表格中行的数量
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.rowDatas.size();
	}

	@Override
	//获取表格中指定行的列的值
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return ((Vector)this.rowDatas.get(rowIndex)).get(columnIndex);
	}
	
	@Override
	//获取表格中列的数量
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.columnNames.size();
	}	
	//获取列名
	public String getColumnCount(int column) {
		return (String)this.columnNames.get(column);
	}
	
	//获取查询的数据
	public void queryStudent(String sql, String[] params) {
		columnNames = new Vector();				//添加列
		columnNames.add("学号");
		columnNames.add("姓名");
		columnNames.add("性别");
		columnNames.add("年龄");
		columnNames.add("所属班级");
		columnNames.add("住址");
		rowDatas = new Vector();
		try {
			sqlHelper = new SqlHelper();//创建数据库访问类的对象
			rs = sqlHelper.queryResult(sql, params);//调用查询方法
			//循环读取查询结果集，将每条数据作为一个Vector对象，添加到rowDatas中去
			while (rs.next()) {
				Vector row = new Vector();
				row.add(rs.getString(1));
				row.add(rs.getString(2));
				row.add(rs.getString(3));
				row.add(rs.getInt(4));
				row.add(rs.getString(5));
				row.add(rs.getString(6));
				rowDatas.add(row);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			sqlHelper.close();
		}
	}
	
	//执行更新、删除、修改操作
	public boolean updateStu(String sql, String[] params) {
		sqlHelper = new SqlHelper();
		return sqlHelper.isUpdate(sql, params);
	}
	
}
