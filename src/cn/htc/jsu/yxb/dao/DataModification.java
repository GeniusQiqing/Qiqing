package cn.htc.jsu.yxb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import org.apache.poi.util.SystemOutLogger;

import cn.htc.jsu.yxb.dbc.DatabaseConnection;

/**
 * 连接数据库修改日期信息
 */

public class DataModification {
	public void Modify(String A,String B,String C,String D) {
		DatabaseConnection dbcs=new DatabaseConnection();//使用占位符便于sql识别
        String sql="update a set dateout=? where ID=?";
		try(Connection conn=dbcs.getConnection();
			PreparedStatement stmt=conn.prepareStatement(sql);){	
			stmt.setString(1, D);
			stmt.setString(2, B);
			stmt.executeUpdate();
			if(stmt.executeUpdate()==0) {JOptionPane.showMessageDialog(null, "此人不存在不能退房");}//没更新操作但继续往下执行 所以没有报异常Update需要注意的点
			else{JOptionPane.showMessageDialog(null, "退房成功");}
	        stmt.close();	
	        conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "此人不存在不能退房");
			
		}
	
	}
	
	
}
