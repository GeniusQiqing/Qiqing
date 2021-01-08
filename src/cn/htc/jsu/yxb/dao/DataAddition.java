package cn.htc.jsu.yxb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import cn.htc.jsu.yxb.dbc.DatabaseConnection;

/**
 * 连接数据库增加客户数据
 */
public class DataAddition {
	public void pdd(String a,String b,String c,String d,String e,String f,String g) {
		DatabaseConnection dbcs=new DatabaseConnection();//使用1中定义的连接数据库的类
		String sql="insert into a(name,sex,age,ID,room,datein,dateout) values(?,?,?,?,?,?,?)";//使用占位符定义插入语句
		try(Connection conn=dbcs.getConnection();//获取数据库接
			PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化
			pstmt.setString(1, a);//定义第1个占位符的内容
			pstmt.setString(2, b);//定义第2个占位符的内容
			pstmt.setString(3, c);
			pstmt.setString(4, d);
			pstmt.setString(5, e);
			pstmt.setString(6, f);
			pstmt.setString(7, g);
			pstmt.executeUpdate();//执行插入语句
			JOptionPane.showMessageDialog(null, "添加成功");
	        pstmt.close();	
	        conn.close();
		}catch(SQLException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "此人已存在不能添加");
		}
	
}
}
