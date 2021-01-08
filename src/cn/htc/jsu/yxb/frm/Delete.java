package cn.htc.jsu.yxb.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.htc.jsu.yxb.dao.DataDelete;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
/**
 * ɾ������
 */
public class Delete extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete frame = new Delete();
					frame.setLocationRelativeTo(null);//�������
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Delete() {
		setTitle("\u5220\u9664\u5BA2\u6237\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblID = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7");
		lblID.setBounds(67, 82, 48, 31);
		contentPane.add(lblID);
		
		JTextPane ID = new JTextPane();
		ID.setBounds(136, 82, 200, 31);
		contentPane.add(ID);
		
		/**
		 * �������ݿ�ɾ������
		 */
		JButton btnNewButton = new JButton("ɾ���ͻ�");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\13638\\Desktop\\\u56FE\u5E93\\bird6.png"));
		btnNewButton.setBounds(349, 82, 131, 31);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a=ID.getText();
				DataDelete b=new DataDelete();
				b.pelete(a);
			}
		});
		contentPane.add(btnNewButton);
		
		JDesktopPane desktopPane = new JDesktopPane() {
			public void paintComponent(Graphics g) {//�ػ���屳��
				//����һ��δ��ʼ����ͼ��ͼ�꣬�ο�API
				ImageIcon icon=new ImageIcon("img/4.jpg");
				//����ָ��ͼ���������ŵ��ʺ�ָ�������ڲ���ͼ�񣬲ο�API
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(),this);
			}
		};
		desktopPane.setBounds(0, 0, 534, 285);
		contentPane.add(desktopPane);
	}
}
