package cn.htc.jsu.yxb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import cn.htc.jsu.yxb.dbc.DatabaseConnection;

/**
 * �������ݿ����ӿͻ�����
 */
public class DataAddition {
	public void pdd(String a,String b,String c,String d,String e,String f,String g) {
		DatabaseConnection dbcs=new DatabaseConnection();//ʹ��1�ж�����������ݿ����
		String sql="insert into a(name,sex,age,ID,room,datein,dateout) values(?,?,?,?,?,?,?)";//ʹ��ռλ������������
		try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
			PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����
			pstmt.setString(1, a);//�����1��ռλ��������
			pstmt.setString(2, b);//�����2��ռλ��������
			pstmt.setString(3, c);
			pstmt.setString(4, d);
			pstmt.setString(5, e);
			pstmt.setString(6, f);
			pstmt.setString(7, g);
			pstmt.executeUpdate();//ִ�в������
			JOptionPane.showMessageDialog(null, "��ӳɹ�");
	        pstmt.close();	
	        conn.close();
		}catch(SQLException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "�����Ѵ��ڲ������");
		}
	
}
}
