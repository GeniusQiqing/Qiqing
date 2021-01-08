package cn.htc.jsu.yxb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import cn.htc.jsu.yxb.dbc.DatabaseConnection;

public class SelectRoom {
	public static Vector<Vector> getSelectAll(String sql){
    	Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
    	DatabaseConnection dbcs=new DatabaseConnection();//ʹ��1�ж�����������ݿ����
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
    		ResultSet rs=pstmt.executeQuery();//ִ�в�ѯ��䣬����ŵ����ݼ���
    		while(rs.next()) {//�������ݼ�
    			Vector row=new Vector();//����������
    			row.add(rs.getString(1));//��ȡ��һ���ֶ�����
    			row.add(rs.getString(2));//��ȡ�ڶ����ֶ��Ա�
    			row.add(rs.getString(3));
    			row.add(rs.getString(4));
    			row.add(rs.getString(5));
    			row.add(rs.getString(6));
    			row.add(rs.getString(7));
    			rows.add(row);//����������ӵ���¼������
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return rows;//��������������
    }

}
