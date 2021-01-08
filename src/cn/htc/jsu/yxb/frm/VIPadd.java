package cn.htc.jsu.yxb.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.event.ActionEvent;

public class VIPadd extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VIPadd frame = new VIPadd();
					frame.setLocationRelativeTo(null);//�������
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * ��Ա��¼����
	 */
	public VIPadd() {
		setTitle("\u4F1A\u5458\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 716, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u59D3\u540D");
		lblNewLabel.setBounds(33, 28, 110, 30);
		contentPane.add(lblNewLabel);
		
		JTextPane Name = new JTextPane();
		Name.setBounds(127, 28, 191, 30);
		contentPane.add(Name);
		
		JLabel lblNewLabel_1 = new JLabel("\u7535\u8BDD\u53F7\u7801");
		lblNewLabel_1.setBounds(33, 68, 110, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u4F1A\u5458\u7F16\u53F7");
		lblNewLabel_2.setBounds(33, 108, 110, 30);
		contentPane.add(lblNewLabel_2);
		
		JTextPane Dh = new JTextPane();
		Dh.setBounds(127, 68, 191, 30);
		contentPane.add(Dh);
		
		JTextPane Hy = new JTextPane();
		Hy.setBounds(127, 108, 191, 30);
		contentPane.add(Hy);
		
		JLabel lblName = new JLabel("");
		lblName.setBounds(335, 28, 191, 30);
		contentPane.add(lblName);
		
		JLabel lblDh = new JLabel("");
		lblDh.setBounds(335, 68, 191, 30);
		contentPane.add(lblDh);
		
		JLabel lblHy = new JLabel("");
		lblHy.setBounds(335, 108, 191, 30);
		contentPane.add(lblHy);
		
		JButton btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkInputName()&&checkInputDh()&&checkInputHy()) {
					File file=new File("e:/text.txt");
					try(FileWriter fw=new FileWriter(file,true);
						FileReader fr=new FileReader(file);
							BufferedReader br=new BufferedReader(fr);){//�����ַ������
						String row=null;
						while((row=br.readLine())!=null) {
							if(row.contains(Hy.getText())) {
								JOptionPane.showMessageDialog(null, "�˱���Ѵ��ڣ���������");
								return;
							}
						}
					    //���û��������Ϣд��ָ���ļ�
					   fw.write(Name.getText()+"\t"+Dh.getText()+"\t"+Hy.getText()+"\r\n");
					   
					
					}catch(Exception e1) {e1.printStackTrace();}
					JOptionPane.showMessageDialog(null, "��ӳɹ���");
			}
				
			}
			private boolean checkInputName() {
				if(Name.getText().length()==0) {//��ȡѧ�����������ݳ���
				    lblName.setText("��������Ϊ��");//���þ�����Ϣ
				    Name.requestFocus();//ѧ��������ȡ����
				    return false;
				  } lblName.setText("");
				return true;
				}
			private boolean checkInputDh() {
				if(Dh.getText().length()==0) {//��ȡѧ�����������ݳ���
				    lblDh.setText("�绰���벻��Ϊ��");//���þ�����Ϣ
				    Dh.requestFocus();//ѧ��������ȡ����
				    return false;
				  } lblDh.setText("");
				return true;
				}
			private boolean checkInputHy() {
				if(Hy.getText().length()==0) {//��ȡѧ�����������ݳ���
				    lblHy.setText("��Ա��Ų���Ϊ��");//���þ�����Ϣ
				    Hy.requestFocus();//ѧ��������ȡ����
				    return false;
				  } lblHy.setText("");
				return true;
				}
		});
		
		
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\13638\\Desktop\\\u56FE\u5E93\\bird3.png"));
		btnNewButton.setBounds(78, 175, 220, 30);
		contentPane.add(btnNewButton);
		
		JDesktopPane desktopPane = new JDesktopPane() {
			public void paintComponent(Graphics g) {//�ػ���屳��
				//����һ��δ��ʼ����ͼ��ͼ�꣬�ο�API
				ImageIcon icon=new ImageIcon("img/8.jpg");
				//����ָ��ͼ���������ŵ��ʺ�ָ�������ڲ���ͼ�񣬲ο�API
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(),this);
			}
		};
		desktopPane.setBounds(0, 0, 700, 350);
		contentPane.add(desktopPane);
		}
}
