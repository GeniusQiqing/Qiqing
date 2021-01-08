package cn.htc.jsu.yxb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;
/**
 * �ж�ע����˺��Ƿ���Ϲ���
 * �����ݿ��������˻�
 * @author ����
 *
 */
public class Register {
    String ID;
    String password;
    String confirmpassword;
    
    private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String url = "jdbc:sqlserver://localhost:1433;DatabaseName=t";
    private String user = "sa";
    private String sqlpassword = "123456";
    
    public void setID(String ID) {
        this.ID = ID;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setconfirmpasswd(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }
    
    
    //�ж�ע����˺��Ƿ���Ϲ���
    public boolean JudgeRegister() throws SQLException, ClassNotFoundException {
        
        if(this.ID.equals("")) {
            JOptionPane.showMessageDialog(null, "�˺Ų���Ϊ�գ�", "�˺�Ϊ��", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(this.password.equals("")) {
            JOptionPane.showMessageDialog(null, "���벻��Ϊ�գ�", "����Ϊ��", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(!this.password.equals(this.confirmpassword)) {
            JOptionPane.showMessageDialog(null, "������������벻һ��!", "���벻һ��", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        //���Ϲ��򣬵���ע��ɹ��Ĵ��ڣ������˺�������ݿ�
        JOptionPane.showMessageDialog(null, "ע��ɹ�");
        addAdmin();
        return true;
    }
    
    //�����ݿ����Admin�˻�
    void addAdmin() throws ClassNotFoundException, SQLException {
    	String sql="insert into admin (id, password) values (?,?)";
    	Class.forName(driver);
    	try {
	    	Connection conn = DriverManager.getConnection(url, user, sqlpassword);
	    	java.sql.PreparedStatement ps = conn.prepareStatement(sql);
	    	ps.setString(1, this.ID);
	        ps.setString(2, this.password);
	        ps.executeUpdate();
	        ps.close();	
	        conn.close();
	        
    	}catch(SQLException ex) {
    		ex.printStackTrace();
    		System.out.println("����û�ʧ�ܣ�");
    	}
    	
    }
}
