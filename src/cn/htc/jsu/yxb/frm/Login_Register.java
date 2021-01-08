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
	 * ��¼����
	 */
	//��¼�����ʼ��
	public void init() {
	JFrame frame = new JFrame("��¼");
        frame.getContentPane().setLayout(null);
        
        JLabel nameStr = new JLabel("�˺�:");
        nameStr.setBounds(250, 200, 100, 25);
        frame.getContentPane().add(nameStr);
        
        JLabel passwordStr = new JLabel("����:");
        passwordStr.setBounds(250, 250, 100, 25);
        frame.getContentPane().add(passwordStr);  
        
        JTextField userID = new JTextField();
        userID.setBounds(300, 200, 150, 25);
        frame.getContentPane().add(userID);
        
        JPasswordField password = new JPasswordField();
        password.setBounds(300, 250, 150, 25);
        frame.getContentPane().add(password);
        
        JButton buttonlogin = new JButton("��¼");
        buttonlogin.setIcon(new ImageIcon("C:\\Users\\13638\\Desktop\\\u56FE\u5E93\\bird7.png"));
        buttonlogin.setBounds(250, 300, 95, 25);
        frame.getContentPane().add(buttonlogin);
        
        JButton buttonregister = new JButton("ע��");
        buttonregister.setIcon(new ImageIcon("C:\\Users\\13638\\Desktop\\\u56FE\u5E93\\bird6.png"));
        buttonregister.setBounds(375, 300, 100, 25);
        frame.getContentPane().add(buttonregister);
        
        JDesktopPane desktopPane = new JDesktopPane() {
        	public void paintComponent(Graphics g) {//�ػ���屳��
				//����һ��δ��ʼ����ͼ��ͼ�꣬�ο�API
				ImageIcon icon=new ImageIcon("img/10.jpg");
				//����ָ��ͼ���������ŵ��ʺ�ָ�������ڲ���ͼ�񣬲ο�API
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(),this);
			}
        };
        desktopPane.setBounds(0, 0, 784, 527);
        frame.getContentPane().add(desktopPane);
        
        frame.setBounds(400, 100, 800, 566);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        //Ϊ��¼��ť��Ӽ�����
         buttonlogin.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {
                String ID = userID.getText();
                String passwd = new String (password.getPassword());
                  
                //����һ��Admin�û�����������е��û�������������
                Admin admin = new Admin();
                admin.setID(ID);
                admin.setPassword(passwd);
                
                //��¼
                Login login = new Login();
                login.setAdmin(admin);
          
                if(login.JudgeAdmin()==0) {
                	//�����˺Ż��������Ĵ���
                	JOptionPane.showMessageDialog(null, "�˺Ż��������", "�˺Ż��������", JOptionPane.WARNING_MESSAGE);
                	//���������е���Ϣ
                	password.setText("");
                	//����˺ſ��е���Ϣ
                	userID.setText("");
                	
                	//System.out.println("��½ʧ��");
                } else {
                	//������¼�ɹ��Ĵ���
                	JOptionPane.showMessageDialog(null, "��½�ɹ�", "��½�ɹ�", JOptionPane.NO_OPTION);
                	//���ȷ�������ת��������
                	frame.setVisible(false);
                	Background a=new Background();
    				a.show();  
                }
               
            }
        });
         
         //Ϊע�ᰴť��Ӽ�����
         buttonregister.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e) {
        		 //ע��ҳ��
                 frame.setVisible(false);
        		 AdminRegister ar = new AdminRegister(); 
        	 }
         });
         
         
	}
	
    public static void main(String []args) { 
       //������
       //��¼����
    	Login_Register login_register = new Login_Register();
    }
}
