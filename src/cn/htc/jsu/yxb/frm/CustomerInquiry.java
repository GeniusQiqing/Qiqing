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
 * �ͻ���Ϣ��ѯ����
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
		titles = new Vector<String>();// ���嶯̬�����ʾ������
		Collections.addAll(titles, "����", "�Ա�", "����", "���֤��", "�����", "��ס����", "�˷�����");
		
		
		setTitle("�ͻ���ס���");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1024, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton_3 = new JButton("������ס�����ѯ");
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\13638\\Desktop\\\u56FE\u5E93\\bird2.png"));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector<Vector> stuInfo1 = Roomquery.query();
					DefaultTableModel model1 = new DefaultTableModel(stuInfo1, titles) {
						public Class getColumnClass(int column) {// ��ȡ�е�����
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
					TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(model1);// ����������
					table.setRowSorter(sorter);
			}
		});
		btnNewButton_3.setBounds(584, 22, 212, 36);
		contentPane.add(btnNewButton_3);

		String sql = "select * from a";// �����ѯ���
		Vector<Vector> stuInfo = DataDisplay.getSelectAll(sql);// �����ݿ��ж�ȡ����������
		DefaultTableModel model = new DefaultTableModel(stuInfo, titles) {
			public Class getColumnClass(int column) {// ��ȡ�е�����
				Class returnValue;
				if ((column >= 0) && (column < getColumnCount())) {
					returnValue = getValueAt(0, column).getClass();
				} else {
					returnValue = Object.class;
				}
				return returnValue;
			}
		};
		TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(model);// ����������
		ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();// ��������ļ��ϣ�
		sortKeys.add(new RowSorter.SortKey(2, SortOrder.DESCENDING));// ���õ�һ������ʽ����1������2��Ϊ�����ֶΣ�ָ��Ϊ3�ڸ��ֶ�cj����2������Ϊ����
		sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));// �����һ����������ֵͬ�����õڶ�������ʽ����1������0��Ϊ�����ֶΣ�ָ��Ϊ1�ڸ��ֶ�xh����2������Ϊ����
		sorter.setSortKeys(sortKeys);// �������������������

		JLabel lblKey = new JLabel("��ѯ�ؼ���");
		lblKey.setBounds(40, 22, 133, 36);
		contentPane.add(lblKey);

		textKey = new JTextField();
		textKey.setBounds(191, 22, 255, 36);
		contentPane.add(textKey);
		textKey.setColumns(10);

		JButton btnNewButton_1 = new JButton("Excel����");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\13638\\Desktop\\\u56FE\u5E93\\bird4.png"));
		btnNewButton_1.addActionListener(new ActionListener() {

	/**
			 * Excel���ݵ���
			 */
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "��ӡ�ɹ�", "�ɹ�", JOptionPane.NO_OPTION);
				File file = new File("e:/Excel����.xlsx");// ��λҪ������excel�ļ�
				Workbook workbook = new XSSFWorkbook();// ��������������
				org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("test1");// �������������

				// int i2=0;
				for (int i1 = 0; i1 < model.getRowCount(); i1++) {
					Row row = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(i1);// �����ж����±��0��ʼ
					Cell cell1 = row.createCell(0);// ������Ԫ�񣬴�0��ʼ
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
					workbook.write(fos);// ������д�뵽ָ����excel�ĵ�
				} catch (IOException e5) {
					e5.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(812, 22, 117, 36);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton = new JButton("��ѯ");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\13638\\Desktop\\\u56FE\u5E93\\bird1.png"));
		btnNewButton.addActionListener(new ActionListener() {
			/**
			 * ģ����ѯ����
			 */
			public void actionPerformed(ActionEvent e) {
				String key = textKey.getText().trim();// ��ȡ����ؼ����ı����ֵ
				if (key.length() != 0) {
					sorter.setRowFilter(RowFilter.regexFilter(key));// �Ƿ����������ֵ
				} else {
					sorter.setRowFilter(null);// �����ˣ���ʾ��������
				}
			}
		});
		btnNewButton.setBounds(456, 22, 117, 36);
		contentPane.add(btnNewButton);

		contentPane.setLayout(new BorderLayout(0, 0));
		JDesktopPane desktopPane = new JDesktopPane() {
			@Override
			public void paintComponent(Graphics g) {// �ػ���屳��
				// ����һ��δ��ʼ����ͼ��ͼ�꣬�ο�API
				ImageIcon icon = new ImageIcon("img/2" + ".jpg");
				// ����ָ��ͼ���������ŵ��ʺ�ָ�������ڲ���ͼ�񣬲ο�API
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 85, 978, 263);
		desktopPane.add(scrollPane);
		table = new JTable(model);// ʹ��DefaultTableModel����ģ��ʵ�������
		table.setSurrendersFocusOnKeystroke(true);
		table.setRowSorter(sorter);// ���ñ���������
		scrollPane.setViewportView(table);

	}
}
