package cn.htc.jsu.yxb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import org.apache.poi.util.SystemOutLogger;

import cn.htc.jsu.yxb.dbc.DatabaseConnection;

/**
 * �������ݿ��޸�������Ϣ
 */

public class DataModification {
	public void Modify(String A,String B,String C,String D) {
		DatabaseConnection dbcs=new DatabaseConnection();//ʹ��ռλ������sqlʶ��
        String sql="update a set dateout=? where ID=?";
		try(Connection conn=dbcs.getConnection();
			PreparedStatement stmt=conn.prepareStatement(sql);){	
			stmt.setString(1, D);
			stmt.setString(2, B);
			stmt.executeUpdate();
			if(stmt.executeUpdate()==0) {JOptionPane.showMessageDialog(null, "���˲����ڲ����˷�");}//û���²�������������ִ�� ����û�б��쳣Update��Ҫע��ĵ�
			else{JOptionPane.showMessageDialog(null, "�˷��ɹ�");}
	        stmt.close();	
	        conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "���˲����ڲ����˷�");
			
		}
	
	}
	
	
}
