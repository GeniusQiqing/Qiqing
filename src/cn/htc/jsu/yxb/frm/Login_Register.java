package cn.htc.jsu.yxb.frm;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cn.htc.jsu.yxb.dbc.Login;
import cn.htc.jsu.yxb.vo.Admin;

import javax.swing.JRadioButton;
import javax.swing.JDesktopPane;

public class Login_Register extends JFrame {

	Login_Register() {
		init();
	}
	/**
	 * 登录界面
	 */
	//登录界面初始化
	public void init() {
	JFrame frame = new JFrame("登录");
        frame.getContentPane().setLayout(null);
        
        JLabel nameStr = new JLabel("账号:");
        nameStr.setBounds(250, 200, 100, 25);
        frame.getContentPane().add(nameStr);
        
        JLabel passwordStr = new JLabel("密码:");
        passwordStr.setBounds(250, 250, 100, 25);
        frame.getContentPane().add(passwordStr);  
        
        JTextField userID = new JTextField();
        userID.setBounds(300, 200, 150, 25);
        frame.getContentPane().add(userID);
        
        JPasswordField password = new JPasswordField();
        password.setBounds(300, 250, 150, 25);
        frame.getContentPane().add(password);
        
        JButton buttonlogin = new JButton("登录");
        buttonlogin.setIcon(new ImageIcon("C:\\Users\\13638\\Desktop\\\u56FE\u5E93\\bird7.png"));
        buttonlogin.setBounds(250, 300, 95, 25);
        frame.getContentPane().add(buttonlogin);
        
        JButton buttonregister = new JButton("注册");
        buttonregister.setIcon(new ImageIcon("C:\\Users\\13638\\Desktop\\\u56FE\u5E93\\bird6.png"));
        buttonregister.setBounds(375, 300, 100, 25);
        frame.getContentPane().add(buttonregister);
        
        JDesktopPane desktopPane = new JDesktopPane() {
        	public void paintComponent(Graphics g) {//重绘面板背景
				//创建一个未初始化的图像图标，参考API
				ImageIcon icon=new ImageIcon("img/10.jpg");
				//绘制指定图像中已缩放到适合指定矩形内部的图像，参考API
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(),this);
			}
        };
        desktopPane.setBounds(0, 0, 784, 527);
        frame.getContentPane().add(desktopPane);
        
        frame.setBounds(400, 100, 800, 566);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        //为登录按钮添加监听器
         buttonlogin.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {
                String ID = userID.getText();
                String passwd = new String (password.getPassword());
                  
                //创建一个Admin用户，把输入框中的用户名密码和提出来
                Admin admin = new Admin();
                admin.setID(ID);
                admin.setPassword(passwd);
                
                //登录
                Login login = new Login();
                login.setAdmin(admin);
          
                if(login.JudgeAdmin()==0) {
                	//弹出账号或密码错误的窗口
                	JOptionPane.showMessageDialog(null, "账号或密码错误", "账号或密码错误", JOptionPane.WARNING_MESSAGE);
                	//清除密码框中的信息
                	password.setText("");
                	//清除账号框中的信息
                	userID.setText("");
                	
                	//System.out.println("登陆失败");
                } else {
                	//弹出登录成功的窗口
                	JOptionPane.showMessageDialog(null, "登陆成功", "登陆成功", JOptionPane.NO_OPTION);
                	//点击确定后会跳转到主窗口
                	frame.setVisible(false);
                	Background a=new Background();
    				a.show();  
                }
               
            }
        });
         
         //为注册按钮添加监听器
         buttonregister.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e) {
        		 //注册页面
                 frame.setVisible(false);
        		 AdminRegister ar = new AdminRegister(); 
        	 }
         });
         
         
	}
	
    public static void main(String []args) { 
       //主程序
       //登录窗口
    	Login_Register login_register = new Login_Register();
    }
}
