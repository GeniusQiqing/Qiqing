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
 * 登记入住界面
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
					frame.setLocationRelativeTo(null);//窗体居中
					frame.setVisible(true);//窗体可见
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * 宾馆客户登记方法
	 */
	
	public Check() {
		setTitle("宾馆登记入住");
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
		
		JLabel Xb0 = new JLabel("性别");
		Xb0.setBounds(25, 44, 64, 24);
		contentPane.add(Xb0);
		
		JLabel lblMsgXb = new JLabel("");
		lblMsgXb.setForeground(Color.RED);
		lblMsgXb.setBounds(304, 42, 212, 27);
		contentPane.add(lblMsgXb);
		
		contentPane.setLayout(new BorderLayout(0, 0));
		JDesktopPane desktopPane = new JDesktopPane(){
			@Override
			public void paintComponent(Graphics g) {//重绘面板背景
				//创建一个未初始化的图像图标，参考API
				ImageIcon icon=new ImageIcon("img/5.jpg");
				//绘制指定图像中已缩放到适合指定矩形内部的图像，参考API
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(),this);
			}
		};
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);
		
		JButton btnNewButton = new JButton("登记入住");
		btnNewButton.setBounds(62, 253, 189, 33);
		desktopPane.add(btnNewButton);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\13638\\Desktop\\\u56FE\u5E93\\bird5.png"));
		
		JTextPane Tfrq = new JTextPane();
		Tfrq.setBounds(95, 212, 195, 21);
		desktopPane.add(Tfrq);
		
		JLabel Tfrq0 = new JLabel("退房日期");
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
		
		JLabel lblNewLabel = new JLabel("当前日期为："+date.format(formatter));
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
				  if(Nl.getText().length()==0) {//获取成绩输入框的内容长度
				    lblMsgNl.setText("年龄不能为空");//设置警告信息
				    Nl.requestFocus();//成绩输入框获取焦点
				    return false;
				  }else if(!Nl.getText().matches("\\d+")) {//正则匹配整数
					lblMsgNl.setText("年龄必须是整数");
				    Nl.requestFocus();//成绩输入框获取焦点
				    Nl.selectAll();//全选当中的内容
				    return false;
				  } else if(Integer.parseInt(Nl.getText())<18) {
					  lblMsgNl.setText("未成年人未满18周岁不得办理入住手续");
					  Nl.requestFocus();//成绩输入框获取焦点
					  return false;
				  } lblMsgNl.setText("");
				  return true;}
			
			public boolean checkInputXm() {
				  if(Xm.getText().length()==0) {//获取成绩输入框的内容长度
				    lblMsgXm.setText("姓名不能为空");//设置警告信息
				    Xm.requestFocus();//成绩输入框获取焦点
				    return false;
				  } lblMsgNl.setText("");
				  return true;}
			
			public boolean checkInputSfzh() {
				  if(Sfzh.getText().length()==0) {//获取成绩输入框的内容长度
				    lblMsgSfzh.setText("身份证号不能为空");//设置警告信息
				    Sfzh.requestFocus();//成绩输入框获取焦点
				    return false;
				  } lblMsgSfzh.setText("");
				  return true;}
			
			public boolean checkInputFjh() {
				  if(Fjh.getText().length()==0) {//获取成绩输入框的内容长度
				    lblMsgFjh.setText("房间号不能为空");//设置警告信息
				    Fjh.requestFocus();//成绩输入框获取焦点
				    return false;
				  } lblMsgFjh.setText("");
				  return true;}
			
			public boolean checkInputRzrq() {
				  if(Rzrq.getText().length()==0) {//获取成绩输入框的内容长度
				    lblMsgRzrq.setText("入住日期不能为空");//设置警告信息
				    Rzrq.requestFocus();//成绩输入框获取焦点
				    return false;
				  } lblMsgRzrq.setText("");
				  return true;}
			
			public boolean checkInputXb() {
				  if(Xb.getText().length()==0) {//获取成绩输入框的内容长度
				    lblMsgXb.setText("性别不能为空");//设置警告信息
				    Xb.requestFocus();//成绩输入框获取焦点
				    return false;
				  } lblMsgXb.setText("");
				  return true;}
			
			public boolean checkInputTfrq() {
				  if(Tfrq.getText().length()==0) {//获取成绩输入框的内容长度
				    lblMsgTfrq.setText("入住日期不能为空");//设置警告信息
				    Tfrq.requestFocus();//成绩输入框获取焦点
				    return false;
				  } lblMsgTfrq.setText("");
				  return true;}
			
			/**
			 * Create the frame.
			 */
			
			/**
			* 判断身份证格式
			*
			* @param idNum 身份证号
			* @return 结果
			*/
			public boolean isIdNum(String idNum) {
			// 中国公民身份证格式：长度为15或18位，最后一位可以为字母
			Pattern idNumPattern = Pattern.compile("(\\d+{14}[0-9a-zA-Z])|\\d+({17}[0-9a-zA-Z])");
			// 格式验证
			if (!idNumPattern.matcher(idNum).matches()){
				lblMsgSfzh.setText("身份证格式不正确");
				return false;
			}
			
			// 合法性验证
			int year = 0;
			int month = 0;
			int day = 0;
			if (idNum.length() == 15) {
			// 提取身份证上的前6位以及出生年月日
			Pattern birthDatePattern = Pattern.compile("\\d{6}(\\d{2})(\\d{2})(\\d{2}).");
			Matcher birthDateMather = birthDatePattern.matcher(idNum);
			if (birthDateMather.find()) {
			year = Integer.valueOf("19" + birthDateMather.group(1));
			month = Integer.valueOf(birthDateMather.group(2));
			day = Integer.valueOf(birthDateMather.group(3));
			}
			} else if (idNum.length() == 18) {
			// 提取身份证上的前6位以及出生年月日
			Pattern birthDatePattern = Pattern.compile("\\d{6}(\\d{4})(\\d{2})(\\d{2}).*");
			Matcher birthDateMather = birthDatePattern.matcher(idNum);
			if (birthDateMather.find()) {
			year = Integer.valueOf(birthDateMather.group(1));
			month = Integer.valueOf(birthDateMather.group(2));
			day = Integer.valueOf(birthDateMather.group(3));
			}
			}
			// 年份判断，100年前至今
			Calendar cal = Calendar.getInstance();
			// 当前年份
			int currentYear = cal.get(Calendar.YEAR);
			if (year <= currentYear - 100 || year > currentYear) {
				lblMsgSfzh.setText("身份证年份不合法");
				return false;
			}
			if(currentYear-year<18) {
				lblMsgSfzh.setText("未成年人未满18周岁不得办理入住手续");
				return false;
			}
			if(currentYear-year!=Integer.parseInt(Nl.getText())) {
				lblMsgSfzh.setText("身份证号年龄与所填年龄不符");
				return false;
			}
			// 月份判断
			if (month < 1 || month > 12) {
				lblMsgSfzh.setText("身份证月份不合法");
				return false;
			}
			
			// 日期判断
			// 计算月份天数
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
			// 2月份判断是否为闰年
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
				lblMsgSfzh.setText("身份证日期不合法");
				return false;
			}
			return day >= 1 && day <= dayCount;
			}
			
			
		});
		
	}
}
