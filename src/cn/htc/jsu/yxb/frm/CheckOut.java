package cn.htc.jsu.yxb.frm;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.htc.jsu.yxb.dao.DataModification;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * �˷�����
 * @author ����
 *
 */
public class CheckOut extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckOut frame = new CheckOut();
					frame.setLocationRelativeTo(null);//�������
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * �˷����� ���޸����ڣ�
	 */
	public CheckOut() {
		setTitle("�˿��˷�");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 682, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane() {
			public void paintComponent(Graphics g) {//�ػ���屳��
				//����һ��δ��ʼ����ͼ��ͼ�꣬�ο�API
				ImageIcon icon=new ImageIcon("img/6.jpg");
				//����ָ��ͼ���������ŵ��ʺ�ָ�������ڲ���ͼ�񣬲ο�API
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(),this);
			}
		};
		desktopPane.setBounds(0, 0, 666, 300);
		contentPane.add(desktopPane);
		
		JLabel lblXm = new JLabel("\u59D3\u540D");
		lblXm.setBounds(43, 38, 112, 26);
		desktopPane.add(lblXm);
		
		JLabel lblID = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7");
		lblID.setBounds(43, 74, 112, 26);
		desktopPane.add(lblID);
		
		JLabel lblDateIn = new JLabel("��ס����");
		lblDateIn.setBounds(43, 110, 112, 26);
		desktopPane.add(lblDateIn);
		
		JTextPane Xm = new JTextPane();
		Xm.setBounds(135, 38, 196, 26);
		desktopPane.add(Xm);
		
		JTextPane ID = new JTextPane();
		ID.setBounds(135, 74, 196, 26);
		desktopPane.add(ID);
		
		JTextPane DateIn = new JTextPane();
		DateIn.setBounds(135, 110, 196, 26);
		desktopPane.add(DateIn);
		
		JTextPane DateOut = new JTextPane();
		DateOut.setBounds(135, 146, 196, 26);
		desktopPane.add(DateOut);
		
		JButton btnNewButton = new JButton("�˷�");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a=Xm.getText();
				String b=ID.getText();
				String c=DateIn.getText();
				String d=DateOut.getText();
				DataModification h=new DataModification();
				h.Modify(a,b,c,d);
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\13638\\Desktop\\\u56FE\u5E93\\bird7.png"));
		btnNewButton.setBounds(43, 201, 128, 35);
		desktopPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u65E5\u671F\u7ED3\u7B97");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\13638\\Desktop\\\u56FE\u5E93\\bird4.png"));
		btnNewButton_1.setBounds(203, 201, 128, 35);
		desktopPane.add(btnNewButton_1);
		
		JLabel lblDateOut = new JLabel("�˷�����");
		lblDateOut.setBounds(43, 146, 112, 26);
		desktopPane.add(lblDateOut);
		
		
	}

}
