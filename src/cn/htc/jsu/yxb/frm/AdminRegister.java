package cn.htc.jsu.yxb.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cn.htc.jsu.yxb.dao.Register;
import javax.swing.JDesktopPane;
/**
 * 登录注册界面
 * @author 耆卿
 *
 */
public class AdminRegister extends JFrame {

	AdminRegister () {
		init();
		}
	void init() {
        JFrame frame = new JFrame("注册管理员账号");
        frame.getContentPane().setLayout(null);
    
        JLabel IDStr = new JLabel("账号:");
        IDStr.setBounds(250, 200, 100, 25);
        frame.getContentPane().add(IDStr);

        JLabel passwordStr = new JLabel("密码:");
        passwordStr.setBounds(250, 250, 100, 25);
        frame.getContentPane().add(passwordStr);  
           
        JLabel confrimStr = new JLabel("确认密码:");
        confrimStr.setBounds(250, 300, 100, 30);
        frame.getContentPane().add(confrimStr);

        JTextField userID = new JTextField();
        userID.setBounds(320, 200, 150, 25);
        frame.getContentPane().add(userID);

        JPasswordField password = new JPasswordField();
        password.setBounds(320, 250, 150, 25);
        frame.getContentPane().add(password);

        JPasswordField confrimPassword = new JPasswordField();
        confrimPassword.setBounds(320, 300, 150, 25);
        frame.getContentPane().add(confrimPassword);
        
        JButton buttonregister = new JButton("注册");
        buttonregister.setIcon(new ImageIcon("C:\\Users\\13638\\Desktop\\\u56FE\u5E93\\bird5.png"));
        buttonregister.setBounds(320, 350, 100, 25);
        frame.getContentPane().add(buttonregister);
        
        JDesktopPane desktopPane = new JDesktopPane(){
        	public void paintComponent(Graphics g) {//重绘面板背景
				//创建一个未初始化的图像图标，参考API
				ImageIcon icon=new ImageIcon("img/9.jpg");
				//绘制指定图像中已缩放到适合指定矩形内部的图像，参考API
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(),this);
			}
        };
        desktopPane.setBounds(0, 0, 784, 601);
        frame.getContentPane().add(desktopPane);
        


        frame.setBounds(400, 100, 800, 640);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
      //为注册按钮增加监听器
        buttonregister.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = userID.getText();
                String passwd = new String (password.getPassword());
                String confrimpasswd = new String (confrimPassword.getPassword());
                
                //创建Register类
                Register register = new Register();
                register.setID(ID);
                register.setPassword(passwd);
                register.setconfirmpasswd(confrimpasswd);
                
                //如果注册成功，返回登录界面
                try {
					if(register.JudgeRegister()) {

					    frame.setVisible(false);
					    Login_Register login_register = new Login_Register();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

            }
            
        });
}
}
