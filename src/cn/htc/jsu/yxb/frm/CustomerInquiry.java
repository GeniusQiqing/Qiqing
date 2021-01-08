package cn.htc.jsu.yxb.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.mysql.jdbc.Connection;

import cn.htc.jsu.yxb.dao.DataDisplay;
import cn.htc.jsu.yxb.dao.Roomquery;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;

/**
 * 客户信息查询界面
 * 
 * @author 13638
 *
 */
public class CustomerInquiry extends JFrame {

	private JPanel contentPane;
	private JTextField textKey;
	private JTable table;
	private Vector<String> titles;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerInquiry frame = new CustomerInquiry();
					frame.setLocationRelativeTo(null);
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
	public CustomerInquiry() {
		titles = new Vector<String>();// 定义动态数组表示表格标题
		Collections.addAll(titles, "姓名", "性别", "年龄", "身份证号", "房间号", "入住日期", "退房日期");
		
		
		setTitle("客户入住情况");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1024, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton_3 = new JButton("房间入住情况查询");
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\13638\\Desktop\\\u56FE\u5E93\\bird2.png"));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector<Vector> stuInfo1 = Roomquery.query();
					DefaultTableModel model1 = new DefaultTableModel(stuInfo1, titles) {
						public Class getColumnClass(int column) {// 获取列的类型
							Class returnValue;
							if ((column >= 0) && (column < getColumnCount())) {
								returnValue = getValueAt(0, column).getClass();
							} else {
								returnValue = Object.class;
							}
							return returnValue;
						}
					};
					table.setModel(model1);
					TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(model1);// 设置排序器
					table.setRowSorter(sorter);
			}
		});
		btnNewButton_3.setBounds(584, 22, 212, 36);
		contentPane.add(btnNewButton_3);

		String sql = "select * from a";// 定义查询语句
		Vector<Vector> stuInfo = DataDisplay.getSelectAll(sql);// 从数据库中读取所有行数据
		DefaultTableModel model = new DefaultTableModel(stuInfo, titles) {
			public Class getColumnClass(int column) {// 获取列的类型
				Class returnValue;
				if ((column >= 0) && (column < getColumnCount())) {
					returnValue = getValueAt(0, column).getClass();
				} else {
					returnValue = Object.class;
				}
				return returnValue;
			}
		};
		TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(model);// 设置排序器
		ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();// 设置排序的集合，
		sortKeys.add(new RowSorter.SortKey(2, SortOrder.DESCENDING));// 设置第一种排序方式：第1个参数2，为排序字段，指明为3第个字段cj，第2个参数为升序
		sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));// 如果第一种排序有相同值，设置第二种排序方式：第1个参数0，为排序字段，指明为1第个字段xh，第2个参数为升序
		sorter.setSortKeys(sortKeys);// 设置排序器的排序规则

		JLabel lblKey = new JLabel("查询关键字");
		lblKey.setBounds(40, 22, 133, 36);
		contentPane.add(lblKey);

		textKey = new JTextField();
		textKey.setBounds(191, 22, 255, 36);
		contentPane.add(textKey);
		textKey.setColumns(10);

		JButton btnNewButton_1 = new JButton("Excel导出");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\13638\\Desktop\\\u56FE\u5E93\\bird4.png"));
		btnNewButton_1.addActionListener(new ActionListener() {

	/**
			 * Excel数据导出
			 */
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "打印成功", "成功", JOptionPane.NO_OPTION);
				File file = new File("e:/Excel数据.xlsx");// 定位要操作的excel文件
				Workbook workbook = new XSSFWorkbook();// 创建工作簿对象
				org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("test1");// 创建工作表对象

				// int i2=0;
				for (int i1 = 0; i1 < model.getRowCount(); i1++) {
					Row row = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(i1);// 创建行对象，下标从0开始
					Cell cell1 = row.createCell(0);// 创建单元格，从0开始
					cell1.setCellValue(model.getValueAt(i1, 0).toString());
					Cell cell2 = row.createCell(1);
					cell2.setCellValue(model.getValueAt(i1, 1).toString());
					Cell cell3 = row.createCell(2);
					cell3.setCellValue(model.getValueAt(i1, 2).toString());
					Cell cell4 = row.createCell(3);
					cell4.setCellValue(model.getValueAt(i1, 3).toString());
					Cell cell5 = row.createCell(4);
					cell5.setCellValue(model.getValueAt(i1, 4).toString());
					Cell cell6 = row.createCell(5);
					cell6.setCellValue(model.getValueAt(i1, 5).toString());
					Cell cell7 = row.createCell(6);
					cell7.setCellValue(model.getValueAt(i1, 6).toString());

				}
				try (FileOutputStream fos = new FileOutputStream(file);) {
					workbook.write(fos);// 将内容写入到指定的excel文档
				} catch (IOException e5) {
					e5.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(812, 22, 117, 36);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton = new JButton("查询");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\13638\\Desktop\\\u56FE\u5E93\\bird1.png"));
		btnNewButton.addActionListener(new ActionListener() {
			/**
			 * 模糊查询方法
			 */
			public void actionPerformed(ActionEvent e) {
				String key = textKey.getText().trim();// 获取输入关键字文本框的值
				if (key.length() != 0) {
					sorter.setRowFilter(RowFilter.regexFilter(key));// 是否包含输入框的值
				} else {
					sorter.setRowFilter(null);// 不过滤，显示所有数据
				}
			}
		});
		btnNewButton.setBounds(456, 22, 117, 36);
		contentPane.add(btnNewButton);

		contentPane.setLayout(new BorderLayout(0, 0));
		JDesktopPane desktopPane = new JDesktopPane() {
			@Override
			public void paintComponent(Graphics g) {// 重绘面板背景
				// 创建一个未初始化的图像图标，参考API
				ImageIcon icon = new ImageIcon("img/2" + ".jpg");
				// 绘制指定图像中已缩放到适合指定矩形内部的图像，参考API
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 85, 978, 263);
		desktopPane.add(scrollPane);
		table = new JTable(model);// 使用DefaultTableModel数据模型实例化表格
		table.setSurrendersFocusOnKeystroke(true);
		table.setRowSorter(sorter);// 设置表格的排序器
		scrollPane.setViewportView(table);

	}
}
