package cn.htc.jsu.yxb.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.htc.jsu.yxb.dao.Roomquery;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
/**
 * ����������
 * @author ����
 *
 */
public class Background extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Background frame = new Background();
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
	public Background() {
		setTitle("������ס����ϵͳ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1044, 705);
		
		JMenuBar menucjgl = new JMenuBar();
		menucjgl.setToolTipText("");
		setJMenuBar(menucjgl);
		
		JMenu mnNewMenu = new JMenu("������ס����");
		mnNewMenu.setIcon(new ImageIcon("C:\\Users\\13638\\Desktop\\\u56FE\u5E93\\bird1.png"));
		menucjgl.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("�Ǽ���ס");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Check a=new Check();
				a.show();
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon("C:\\Users\\13638\\Desktop\\\u56FE\u5E93\\bird2.png"));
		
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_2 = new JMenu("\u67E5\u8BE2\u529F\u80FD");
		mnNewMenu_2.setIcon(new ImageIcon("C:\\Users\\13638\\Desktop\\\u56FE\u5E93\\bird8.png"));
		mnNewMenu.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("�ͻ���ס���");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerInquiry y=new CustomerInquiry ();
				y.show();
			}
		});
		mntmNewMenuItem_6.setIcon(new ImageIcon("C:\\Users\\13638\\Desktop\\\u56FE\u5E93\\bird7.png"));
		mnNewMenu_2.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("�˷�����");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckOut a=new CheckOut();
				a.show();
			}
		});
		mntmNewMenuItem_2.setIcon(new ImageIcon("C:\\Users\\13638\\Desktop\\\u56FE\u5E93\\bird4.png"));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("ɾ������");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete a=new Delete();
					a.show();
			}
		});
		mntmNewMenuItem_3.setIcon(new ImageIcon("C:\\Users\\13638\\Desktop\\\u56FE\u5E93\\bird8.png"));
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_1 = new JMenu("��Ա����ϵͳ");
		mnNewMenu_1.setIcon(new ImageIcon("C:\\Users\\13638\\Desktop\\\u56FE\u5E93\\bird8.png"));
		menucjgl.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("��Ա��ѯ");
		mnNewMenu_1.add(mntmNewMenuItem_4);
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VIPquery c=new VIPquery();
				c.show();
			}
		});
		mntmNewMenuItem_4.setIcon(new ImageIcon("C:\\Users\\13638\\Desktop\\\u56FE\u5E93\\bird6.png"));
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("��Աע��");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VIPadd a=new VIPadd();
				a.show();
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon("C:\\Users\\13638\\Desktop\\\u56FE\u5E93\\bird2.png"));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JDesktopPane desktopPane = new JDesktopPane(){
			@Override
			public void paintComponent(Graphics g) {//�ػ���屳��
				//����һ��δ��ʼ����ͼ��ͼ�꣬�ο�API
				ImageIcon icon=new ImageIcon("img/ݼ������.jpg");
				//����ָ��ͼ���������ŵ��ʺ�ָ�������ڲ���ͼ�񣬲ο�API
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(),this);
			}
		};
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);

	}
}
