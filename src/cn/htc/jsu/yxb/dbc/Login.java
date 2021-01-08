package cn.htc.jsu.yxb.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.htc.jsu.yxb.vo.Admin;
/**
 * �������ݿ����ж��˺������Ƿ���ȷ
 */
public class Login {//�������ݿ����ж��˺������Ƿ���ȷ
	Admin admin;//�û�ʵ����
	
	public void setAdmin(Admin admin) {
		this.admin=admin;
		//System.out.println(this.admin.getPassword()+"   " + this.admin.getID());
	}
	/*
	 * JudgeAdmin()����
	 * �ж�Admin��ID�������Ƿ���ȷ�������ȷ����ʾ��¼�ɹ�
	 * ������󣬵���һ�����ڣ���ʾ�˺Ż��������
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
	        if(rs.next()) {//�������ݼ�
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
		        	System.out.println("��¼�ɹ�");
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
