package com.studentmanager.mxl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

/**
 * ҵ������ࡪ��StudentBiz�����ɱ���������
 * @author Miracle_Wong
 *
 */
public class StudentBiz extends AbstractTableModel {
	
	//�������ݿ��������Result����
	private SqlHelper sqlHelper;
	private  ResultSet rs = null;
	//���������������
	//ʹ��Vector��Ķ������洢�к��е�����
	private Vector rowDatas, columnNames;
	
	@Override
	//��ȡ������е�����
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.rowDatas.size();
	}

	@Override
	//��ȡ�����ָ���е��е�ֵ
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return ((Vector)this.rowDatas.get(rowIndex)).get(columnIndex);
	}
	
	@Override
	//��ȡ������е�����
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.columnNames.size();
	}	
	//��ȡ����
	public String getColumnCount(int column) {
		return (String)this.columnNames.get(column);
	}
	
	//��ȡ��ѯ������
	public void queryStudent(String sql, String[] params) {
		columnNames = new Vector();				//�����
		columnNames.add("ѧ��");
		columnNames.add("����");
		columnNames.add("�Ա�");
		columnNames.add("����");
		columnNames.add("�����༶");
		columnNames.add("סַ");
		rowDatas = new Vector();
		try {
			sqlHelper = new SqlHelper();//�������ݿ������Ķ���
			rs = sqlHelper.queryResult(sql, params);//���ò�ѯ����
			//ѭ����ȡ��ѯ���������ÿ��������Ϊһ��Vector������ӵ�rowDatas��ȥ
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
	
	//ִ�и��¡�ɾ�����޸Ĳ���
	public boolean updateStu(String sql, String[] params) {
		sqlHelper = new SqlHelper();
		return sqlHelper.isUpdate(sql, params);
	}
	
}
