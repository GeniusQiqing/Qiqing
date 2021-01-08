package cn.htc.jsu.yxb.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.htc.jsu.yxb.vo.Admin;
/**
 * 连接数据库且判断账号密码是否正确
 */
public class Login {//连接数据库且判断账号密码是否正确
	Admin admin;//用户实体类
	
	public void setAdmin(Admin admin) {
		this.admin=admin;
		//System.out.println(this.admin.getPassword()+"   " + this.admin.getID());
	}
	/*
	 * JudgeAdmin()方法
	 * 判断Admin的ID和密码是否正确，如果正确，显示登录成功
	 * 如果错误，弹出一个窗口，显示账号或密码错误
	 */
	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String url = "jdbc:sqlserver://localhost:1433;DatabaseName=t";
    private String user = "sa";
    private String password = "123456";
    
    
	
	 public boolean login(Admin admin) throws SQLException, ClassNotFoundException {
	    	String sql="select * from admin where id=? and password=?";
	        
	    	Class.forName(driver);
	    	Connection conn = DriverManager.getConnection(url, user, password);
	    	PreparedStatement ps = conn.prepareStatement(sql);
	    	
	        ps.setString(1, admin.getID());
	        ps.setString(2, admin.getPassword());
	        ResultSet rs = ps.executeQuery();
	        int ans = 0;
	        if(rs.next()) {//遍历数据集
	        	ans = 1;
	        }  
	        rs.close();
	        ps.close();
	        conn.close();
	        if(ans == 1) {
	        	return true;
	        }
	        else return false;
	    }
	public int JudgeAdmin() {
		
		    try {
		        if(login(this.admin)) {
		        	System.out.println("登录成功");
		        	return 1;
		        }else {
		            return 0;
		        }
		    }catch(Exception e) {
		        e.printStackTrace();
		    	//System.out.println("!!!!!!!!!");
		    }
		return 0;
		
	}	

}
