package cn.htc.jsu.yxb.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import cn.htc.jsu.yxb.dbc.DatabaseConnection;

/**
 * �������ݿ�ɾ������
 */
public class DataDelete {
	public void pelete(String a) {
		DatabaseConnection dbcs=new DatabaseConnection();
		String sql="delete from a where ID="+a;
		
		try (Connection conn=dbcs.getConnection();
			Statement stmt=conn.createStatement();){
			stmt.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
	        stmt.close();	
	        conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "���˲����ڲ���ɾ��");
		}
	}
}
