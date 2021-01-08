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
 * ��¼ע�����
 * @author ����
 *
 */
public class AdminRegister extends JFrame {

	AdminRegister () {
		init();
		}
	void init() {
        JFrame frame = new JFrame("ע�����Ա�˺�");
        frame.getContentPane().setLayout(null);
    
        JLabel IDStr = new JLabel("�˺�:");
        IDStr.setBounds(250, 200, 100, 25);
        frame.getContentPane().add(IDStr);

        JLabel passwordStr = new JLabel("����:");
        passwordStr.setBounds(250, 250, 100, 25);
        frame.getContentPane().add(passwordStr);  
           
        JLabel confrimStr = new JLabel("ȷ������:");
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
        
        JButton buttonregister = new JButton("ע��");
        buttonregister.setIcon(new ImageIcon("C:\\Users\\13638\\Desktop\\\u56FE\u5E93\\bird5.png"));
        buttonregister.setBounds(320, 350, 100, 25);
        frame.getContentPane().add(buttonregister);
        
        JDesktopPane desktopPane = new JDesktopPane(){
        	public void paintComponent(Graphics g) {//�ػ���屳��
				//����һ��δ��ʼ����ͼ��ͼ�꣬�ο�API
				ImageIcon icon=new ImageIcon("img/9.jpg");
				//����ָ��ͼ���������ŵ��ʺ�ָ�������ڲ���ͼ�񣬲ο�API
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(),this);
			}
        };
        desktopPane.setBounds(0, 0, 784, 601);
        frame.getContentPane().add(desktopPane);
        


        frame.setBounds(400, 100, 800, 640);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
      //Ϊע�ᰴť���Ӽ�����
        buttonregister.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = userID.getText();
                String passwd = new String (password.getPassword());
                String confrimpasswd = new String (confrimPassword.getPassword());
                
                //����Register��
                Register register = new Register();
                register.setID(ID);
                register.setPassword(passwd);
                register.setconfirmpasswd(confrimpasswd);
                
                //���ע��ɹ������ص�¼����
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
