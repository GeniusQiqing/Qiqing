package cn.htc.jsu.yxb.frm;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.htc.jsu.yxb.dao.DataAddition;

import javax.swing.JLabel;
import javax.swing.JTextPane;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import com.jgoodies.forms.factories.DefaultComponentFactory;
/**
 * �Ǽ���ס����
 * @author 13638
 *
 */
public class Check extends JFrame {

	private JPanel contentPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Check frame = new Check();
					frame.setLocationRelativeTo(null);//�������
					frame.setVisible(true);//����ɼ�
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * ���ݿͻ��ǼǷ���
	 */
	
	public Check() {
		setTitle("���ݵǼ���ס");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 575, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Xm0 = new JLabel("\u59D3\u540D");
		Xm0.setBounds(25, 10, 64, 24);
		contentPane.add(Xm0);
		
		JLabel Nl0 = new JLabel("\u5E74\u9F84");
		Nl0.setBounds(25, 81, 64, 24);
		contentPane.add(Nl0);
		
		JLabel Sfzh0 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7");
		Sfzh0.setBounds(25, 115, 64, 24);
		contentPane.add(Sfzh0);
		
		JLabel Fjh0 = new JLabel("\u623F\u95F4\u53F7");
		Fjh0.setBounds(25, 149, 64, 24);
		contentPane.add(Fjh0);
		
		JLabel Rzrq0 = new JLabel("\u5165\u4F4F\u65E5\u671F");
		Rzrq0.setBounds(25, 183, 65, 24);
		contentPane.add(Rzrq0);
		
		
		
		JTextPane Xm = new JTextPane();//
		Xm.setBounds(99, 10, 196, 24);
		contentPane.add(Xm);
		
		JTextPane Nl = new JTextPane();
		Nl.setBounds(99, 78, 196, 24);
		contentPane.add(Nl);
		
		JTextPane Sfzh = new JTextPane();
		Sfzh.setBounds(99, 115, 196, 21);
		contentPane.add(Sfzh);
		
		JTextPane Fjh = new JTextPane();
		Fjh.setBounds(99, 146, 196, 24);
		contentPane.add(Fjh);
		
		
		
		JTextPane Rzrq = new JTextPane();
		Rzrq.setBounds(99, 186, 196, 21);
		contentPane.add(Rzrq);
		
		JTextPane Xb = new JTextPane();
		Xb.setBounds(99, 44, 196, 24);
		contentPane.add(Xb);
		
		JLabel lblMsgXm = new JLabel("");
		lblMsgXm.setForeground(Color.RED);
		lblMsgXm.setBounds(305, 10, 211, 22);
		contentPane.add(lblMsgXm);
		
		JLabel lblMsgNl = new JLabel("");
		lblMsgNl.setForeground(Color.RED);
		lblMsgNl.setBounds(305, 78, 211, 27);
		contentPane.add(lblMsgNl);
		
		JLabel lblMsgFjh = new JLabel("");
		lblMsgFjh.setForeground(Color.RED);
		lblMsgFjh.setBounds(305, 149, 211, 24);
		contentPane.add(lblMsgFjh);
		
		JLabel lblMsgRzrq = new JLabel("");
		lblMsgRzrq.setForeground(Color.RED);
		lblMsgRzrq.setBounds(305, 183, 211, 24);
		contentPane.add(lblMsgRzrq);
		
		JLabel Xb0 = new JLabel("�Ա�");
		Xb0.setBounds(25, 44, 64, 24);
		contentPane.add(Xb0);
		
		JLabel lblMsgXb = new JLabel("");
		lblMsgXb.setForeground(Color.RED);
		lblMsgXb.setBounds(304, 42, 212, 27);
		contentPane.add(lblMsgXb);
		
		contentPane.setLayout(new BorderLayout(0, 0));
		JDesktopPane desktopPane = new JDesktopPane(){
			@Override
			public void paintComponent(Graphics g) {//�ػ���屳��
				//����һ��δ��ʼ����ͼ��ͼ�꣬�ο�API
				ImageIcon icon=new ImageIcon("img/5.jpg");
				//����ָ��ͼ���������ŵ��ʺ�ָ�������ڲ���ͼ�񣬲ο�API
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(),this);
			}
		};
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);
		
		JButton btnNewButton = new JButton("�Ǽ���ס");
		btnNewButton.setBounds(62, 253, 189, 33);
		desktopPane.add(btnNewButton);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\13638\\Desktop\\\u56FE\u5E93\\bird5.png"));
		
		JTextPane Tfrq = new JTextPane();
		Tfrq.setBounds(95, 212, 195, 21);
		desktopPane.add(Tfrq);
		
		JLabel Tfrq0 = new JLabel("�˷�����");
		Tfrq0.setBounds(19, 212, 87, 21);
		desktopPane.add(Tfrq0);
		
		JLabel lblMsgTfrq = new JLabel("");
		lblMsgTfrq.setForeground(Color.RED);
		lblMsgTfrq.setBounds(300, 212, 222, 21);
		desktopPane.add(lblMsgTfrq);
		
		JLabel lblMsgSfzh = new JLabel("");
		lblMsgSfzh.setBounds(300, 111, 211, 24);
		desktopPane.add(lblMsgSfzh);
		lblMsgSfzh.setForeground(Color.RED);		
		
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String a=date.format(formatter);
		
		JLabel lblNewLabel = new JLabel("��ǰ����Ϊ��"+date.format(formatter));
		lblNewLabel.setBounds(384, 255, 138, 29);
		desktopPane.add(lblNewLabel);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				if(checkInputXm()&&checkInputXb()&&checkInputNl()&&checkInputSfzh()&&checkInputFjh()&&checkInputRzrq()&&checkInputTfrq()&&isIdNum(Sfzh.getText())) {
					 
					String a=Xm.getText();
					String b=Xb.getText();
					String c=Nl.getText();
					String d=Sfzh.getText();
					String e=Fjh.getText();
					String f=Rzrq.getText();
					String g=Rzrq.getText();
					DataAddition h=new DataAddition();
					h.pdd(a, b, c, d, e, f,g);	
				}
		}
			public boolean checkInputNl() {
				  if(Nl.getText().length()==0) {//��ȡ�ɼ����������ݳ���
				    lblMsgNl.setText("���䲻��Ϊ��");//���þ�����Ϣ
				    Nl.requestFocus();//�ɼ�������ȡ����
				    return false;
				  }else if(!Nl.getText().matches("\\d+")) {//����ƥ������
					lblMsgNl.setText("�������������");
				    Nl.requestFocus();//�ɼ�������ȡ����
				    Nl.selectAll();//ȫѡ���е�����
				    return false;
				  } else if(Integer.parseInt(Nl.getText())<18) {
					  lblMsgNl.setText("δ������δ��18���겻�ð�����ס����");
					  Nl.requestFocus();//�ɼ�������ȡ����
					  return false;
				  } lblMsgNl.setText("");
				  return true;}
			
			public boolean checkInputXm() {
				  if(Xm.getText().length()==0) {//��ȡ�ɼ����������ݳ���
				    lblMsgXm.setText("��������Ϊ��");//���þ�����Ϣ
				    Xm.requestFocus();//�ɼ�������ȡ����
				    return false;
				  } lblMsgNl.setText("");
				  return true;}
			
			public boolean checkInputSfzh() {
				  if(Sfzh.getText().length()==0) {//��ȡ�ɼ����������ݳ���
				    lblMsgSfzh.setText("���֤�Ų���Ϊ��");//���þ�����Ϣ
				    Sfzh.requestFocus();//�ɼ�������ȡ����
				    return false;
				  } lblMsgSfzh.setText("");
				  return true;}
			
			public boolean checkInputFjh() {
				  if(Fjh.getText().length()==0) {//��ȡ�ɼ����������ݳ���
				    lblMsgFjh.setText("����Ų���Ϊ��");//���þ�����Ϣ
				    Fjh.requestFocus();//�ɼ�������ȡ����
				    return false;
				  } lblMsgFjh.setText("");
				  return true;}
			
			public boolean checkInputRzrq() {
				  if(Rzrq.getText().length()==0) {//��ȡ�ɼ����������ݳ���
				    lblMsgRzrq.setText("��ס���ڲ���Ϊ��");//���þ�����Ϣ
				    Rzrq.requestFocus();//�ɼ�������ȡ����
				    return false;
				  } lblMsgRzrq.setText("");
				  return true;}
			
			public boolean checkInputXb() {
				  if(Xb.getText().length()==0) {//��ȡ�ɼ����������ݳ���
				    lblMsgXb.setText("�Ա���Ϊ��");//���þ�����Ϣ
				    Xb.requestFocus();//�ɼ�������ȡ����
				    return false;
				  } lblMsgXb.setText("");
				  return true;}
			
			public boolean checkInputTfrq() {
				  if(Tfrq.getText().length()==0) {//��ȡ�ɼ����������ݳ���
				    lblMsgTfrq.setText("��ס���ڲ���Ϊ��");//���þ�����Ϣ
				    Tfrq.requestFocus();//�ɼ�������ȡ����
				    return false;
				  } lblMsgTfrq.setText("");
				  return true;}
			
			/**
			 * Create the frame.
			 */
			
			/**
			* �ж����֤��ʽ
			*
			* @param idNum ���֤��
			* @return ���
			*/
			public boolean isIdNum(String idNum) {
			// �й��������֤��ʽ������Ϊ15��18λ�����һλ����Ϊ��ĸ
			Pattern idNumPattern = Pattern.compile("(\\d+{14}[0-9a-zA-Z])|\\d+({17}[0-9a-zA-Z])");
			// ��ʽ��֤
			if (!idNumPattern.matcher(idNum).matches()){
				lblMsgSfzh.setText("���֤��ʽ����ȷ");
				return false;
			}
			
			// �Ϸ�����֤
			int year = 0;
			int month = 0;
			int day = 0;
			if (idNum.length() == 15) {
			// ��ȡ���֤�ϵ�ǰ6λ�Լ�����������
			Pattern birthDatePattern = Pattern.compile("\\d{6}(\\d{2})(\\d{2})(\\d{2}).");
			Matcher birthDateMather = birthDatePattern.matcher(idNum);
			if (birthDateMather.find()) {
			year = Integer.valueOf("19" + birthDateMather.group(1));
			month = Integer.valueOf(birthDateMather.group(2));
			day = Integer.valueOf(birthDateMather.group(3));
			}
			} else if (idNum.length() == 18) {
			// ��ȡ���֤�ϵ�ǰ6λ�Լ�����������
			Pattern birthDatePattern = Pattern.compile("\\d{6}(\\d{4})(\\d{2})(\\d{2}).*");
			Matcher birthDateMather = birthDatePattern.matcher(idNum);
			if (birthDateMather.find()) {
			year = Integer.valueOf(birthDateMather.group(1));
			month = Integer.valueOf(birthDateMather.group(2));
			day = Integer.valueOf(birthDateMather.group(3));
			}
			}
			// ����жϣ�100��ǰ����
			Calendar cal = Calendar.getInstance();
			// ��ǰ���
			int currentYear = cal.get(Calendar.YEAR);
			if (year <= currentYear - 100 || year > currentYear) {
				lblMsgSfzh.setText("���֤��ݲ��Ϸ�");
				return false;
			}
			if(currentYear-year<18) {
				lblMsgSfzh.setText("δ������δ��18���겻�ð�����ס����");
				return false;
			}
			if(currentYear-year!=Integer.parseInt(Nl.getText())) {
				lblMsgSfzh.setText("���֤���������������䲻��");
				return false;
			}
			// �·��ж�
			if (month < 1 || month > 12) {
				lblMsgSfzh.setText("���֤�·ݲ��Ϸ�");
				return false;
			}
			
			// �����ж�
			// �����·�����
			int dayCount = 31;
			switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
			dayCount = 31;
			break;
			case 2:
			// 2�·��ж��Ƿ�Ϊ����
			if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
			dayCount = 29;
			break;
			} else {
			dayCount = 28;
			break;
			}
			case 4:
			case 6:
			case 9:
			case 11:
			dayCount = 30;
			break;
			}
			if(!(day >= 1 && day <= dayCount)) {
				lblMsgSfzh.setText("���֤���ڲ��Ϸ�");
				return false;
			}
			return day >= 1 && day <= dayCount;
			}
			
			
		});
		
	}
}
