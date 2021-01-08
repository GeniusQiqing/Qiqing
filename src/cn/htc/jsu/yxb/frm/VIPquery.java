package cn.htc.jsu.yxb.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.RowFilter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VIPquery extends JFrame {

	private JPanel contentPane;
	private JTable table;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VIPquery frame = new VIPquery();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * 	文件储存	
	 * 
	 */
	public static void initTable(DefaultTableModel model) {
			  try(FileReader fr=new FileReader("e:/text.txt");//实例化字符文件流
			      BufferedReader br=new BufferedReader(fr);){//实例化缓冲流
			    String row=null;
			    while((row=br.readLine())!=null) {//按行读取数据
			      model.addRow(row.split("\t"));//将读取的行按分隔符拆分成字符串数组存入数据模型，关键代码
			    }
			  }catch(Exception e1) {e1.printStackTrace();}
			}

	public static Vector<Vector> initTable1() {//初始化表格数据
		  Vector<Vector> rows=new Vector<Vector>();//创建行数据容器
		  try(FileReader fr=new FileReader("e:/text.txt");
		      BufferedReader br=new BufferedReader(fr);){//使用缓冲流读取文件
		    String line=null;
		    while((line=br.readLine())!=null) {//按行读取
		      String[] col=line.split("\t");//读取的行按分隔符拆分成字符串数组
		      Vector row=new Vector();//定义行数据
		      for(int i=0;i<col.length;i++) {
		        if(i==2) {row.add(Integer.valueOf(col[2]));//将成绩转换成整数加入
		        }else {row.add(col[i]);}//增加行中其它数据
		      }
		      rows.add(row);//将行数据增加到行容器中
		    }
		  }catch(Exception e1) {e1.printStackTrace();}
		  return rows;}//返回所有的行

	/**
	 * Create the frame.
	 */
	public VIPquery() {
		setTitle("\u4F1A\u5458\u4FE1\u606F\u67E5\u8BE2");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 803, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane(){
			public void paintComponent(Graphics g) {//重绘面板背景
				//创建一个未初始化的图像图标，参考API
				ImageIcon icon=new ImageIcon("img/7.jpg");
				//绘制指定图像中已缩放到适合指定矩形内部的图像，参考API
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(),this);
			}
		};
		desktopPane.setBounds(0, 0, 787, 355);
		contentPane.add(desktopPane);
		
		JLabel lblNewLabel = new JLabel("\u5173\u952E\u5B57\u67E5\u8BE2");
		lblNewLabel.setBounds(31, 25, 125, 29);
		desktopPane.add(lblNewLabel);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(127, 25, 200, 29);
		desktopPane.add(textPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 85, 732, 241);
		desktopPane.add(scrollPane);
		
		String[] titles = { "姓名", "电话号码", "会员编号"};// 定义数组表示表格标题
		DefaultTableModel model=new DefaultTableModel(titles, 0);//定义表格数据模型的表格标题和行数(为0行)
		VIPquery.initTable(model);//调用方法装载数据
		table = new JTable(model);//实例化表格装载表格模型
		scrollPane.setViewportView(table);
		table.setAutoCreateRowSorter(true);//当用户单击列标题时可以自动排序
		
		

		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\13638\\Desktop\\\u56FE\u5E93\\bird7.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//在上述创建表格实例中通过获取表格的数据模型，得到第一行第一个单元格的数据
				   TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);//设置表格模型排序器
				   table.setRowSorter(sorter);//设置表格排序器
				   sorter.setRowFilter(null);//不设置过滤条件，显示全部数据
				   sorter.setRowFilter(RowFilter.regexFilter(textPane.getText()));
			}
		});
		btnNewButton.setBounds(355, 25, 93, 29);
		desktopPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\13638\\Desktop\\\u56FE\u5E93\\bird8.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTable table = new JTable(model) {
					  @Override
					  public boolean isCellEditable(int row, int column) {
					  if(column==0) {//设置第1列不可编辑
					    return false;
					  }
					  return true;
					  }
					};// 实例化表格装载表格模型实例
				try (BufferedWriter bw = new BufferedWriter(new FileWriter("e:/text.txt"))) {
					  for (int i = 0; i < model.getRowCount(); i++) {// 遍历表格数据，加入集合中
					String row = model.getValueAt(i, 0).toString() + "\t" + model.getValueAt(i, 1).toString() + "\t"+ model.getValueAt(i, 2).toString() + "\t";// 获取表格中每一行的每一个单元格
					    bw.write(row);// 向文本文件中增加数据
					    bw.newLine();// 写入回车换行
					    
					  }JOptionPane.showMessageDialog(null, "修改成功");
					} catch (Exception e1) {
					  e1.printStackTrace();
					}

			}
		});
		btnNewButton_1.setBounds(458, 25, 93, 29);
		desktopPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("删除");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\13638\\Desktop\\\u56FE\u5E93\\bird9.png"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		  		if (table.getSelectedRow() != -1) {// 是否选择了要删除的行
		  		  if (JOptionPane.showConfirmDialog(null, "确定要删除数据吗？", "",    JOptionPane.YES_NO_OPTION) == 0) {// 确定对话框
		  		    model.removeRow(table.convertRowIndexToModel(table.getSelectedRow()));
		  		    //从表格数据中删除行,model1为DefaultTableModel类型，排序后不能直接使用表格的getSelectedRow方法获取被选中的行
		  		  try (BufferedWriter bw1 = new BufferedWriter(new FileWriter("e:/text.txt"))) {
		  		  for (int i = 0; i < model.getRowCount(); i++) {// 遍历表格数据，加入集合中
		  		String row1 = model.getValueAt(i, 0).toString() + "\t" + model.getValueAt(i, 1).toString() + "\t"+ model.getValueAt(i, 2).toString() + "\t";// 获取表格中每一行的每一个单元格
		  		    bw1.write(row1);// 向文本文件中增加数据
		  		    bw1.newLine();// 写入回车换行
		  		  }JOptionPane.showMessageDialog(null,"删除成功");
		  		} catch (Exception e1) {
		  		  e1.printStackTrace();
		  		}
		  		  } 
		  		}else {
		  		    JOptionPane.showMessageDialog(null, "请选择要删除的行");
		  		  }
			}
		});
		btnNewButton_2.setBounds(561, 25, 93, 29);
		desktopPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("排序");
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\13638\\Desktop\\\u56FE\u5E93\\bird10.png"));
		btnNewButton_3.setBounds(668, 25, 93, 29);
		desktopPane.add(btnNewButton_3);
		
		
		
		
		
		
	}
}
