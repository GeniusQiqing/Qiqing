package cn.htc.jsu.yxb.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import cn.htc.jsu.yxb.dbc.DatabaseConnection;

/**
 * 连接数据库删除数据
 */
public class DataDelete {
	public void pelete(String a) {
		DatabaseConnection dbcs=new DatabaseConnection();
		String sql="delete from a where ID="+a;
		
		try (Connection conn=dbcs.getConnection();
			Statement stmt=conn.createStatement();){
			stmt.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "删除成功");
	        stmt.close();	
	        conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "此人不存在不能删除");
		}
	}
}
