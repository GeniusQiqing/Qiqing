package cn.htc.jsu.yxb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

import javax.swing.JOptionPane;

import cn.htc.jsu.yxb.dbc.DatabaseConnection;
public class Roomquery {
	public static Integer persen=0;
	public static Vector<Vector> query() {
		Vector<Vector> rows=new Vector<Vector>();//定义要返回的所有记录集合
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		String A=date.format(formatter);
		DatabaseConnection dbcs=new DatabaseConnection();//使用占位符便于sql识别
        String sql="select * from a where dateout>=?";
		try(Connection conn=dbcs.getConnection();
			PreparedStatement stmt=conn.prepareStatement(sql);){	
			stmt.setString(1, A);
			ResultSet rs=stmt.executeQuery();//执行查询语句，结果放到数据集中
    		while(rs.next()) {//遍历数据集
    			Vector row=new Vector();//定义行数据
    			row.add(rs.getString(1));//获取第一个字段姓名
    			row.add(rs.getString(2));//获取第二个字段性别
    			row.add(rs.getString(3));
    			row.add(rs.getString(4));
    			row.add(rs.getString(5));
    			row.add(rs.getString(6));
    			row.add(rs.getString(7));
    			rows.add(row);//将行数据添加到记录集合中
    			persen++;//统计人数
    		}JOptionPane.showMessageDialog(null, "当前宾馆人员入住总人数为："+persen);
	        stmt.close();	
	        conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;//返回所有行数据
	}

	
}
