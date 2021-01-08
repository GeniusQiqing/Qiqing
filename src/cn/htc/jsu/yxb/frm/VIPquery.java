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
	 * 	�ļ�����	
	 * 
	 */
	public static void initTable(DefaultTableModel model) {
			  try(FileReader fr=new FileReader("e:/text.txt");//ʵ�����ַ��ļ���
			      BufferedReader br=new BufferedReader(fr);){//ʵ����������
			    String row=null;
			    while((row=br.readLine())!=null) {//���ж�ȡ����
			      model.addRow(row.split("\t"));//����ȡ���а��ָ�����ֳ��ַ��������������ģ�ͣ��ؼ�����
			    }
			  }catch(Exception e1) {e1.printStackTrace();}
			}

	public static Vector<Vector> initTable1() {//��ʼ���������
		  Vector<Vector> rows=new Vector<Vector>();//��������������
		  try(FileReader fr=new FileReader("e:/text.txt");
		      BufferedReader br=new BufferedReader(fr);){//ʹ�û�������ȡ�ļ�
		    String line=null;
		    while((line=br.readLine())!=null) {//���ж�ȡ
		      String[] col=line.split("\t");//��ȡ���а��ָ�����ֳ��ַ�������
		      Vector row=new Vector();//����������
		      for(int i=0;i<col.length;i++) {
		        if(i==2) {row.add(Integer.valueOf(col[2]));//���ɼ�ת������������
		        }else {row.add(col[i]);}//����������������
		      }
		      rows.add(row);//�����������ӵ���������
		    }
		  }catch(Exception e1) {e1.printStackTrace();}
		  return rows;}//�������е���

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
			public void paintComponent(Graphics g) {//�ػ���屳��
				//����һ��δ��ʼ����ͼ��ͼ�꣬�ο�API
				ImageIcon icon=new ImageIcon("img/7.jpg");
				//����ָ��ͼ���������ŵ��ʺ�ָ�������ڲ���ͼ�񣬲ο�API
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
		
		String[] titles = { "����", "�绰����", "��Ա���"};// ���������ʾ������
		DefaultTableModel model=new DefaultTableModel(titles, 0);//����������ģ�͵ı����������(Ϊ0��)
		VIPquery.initTable(model);//���÷���װ������
		table = new JTable(model);//ʵ�������װ�ر��ģ��
		scrollPane.setViewportView(table);
		table.setAutoCreateRowSorter(true);//���û������б���ʱ�����Զ�����
		
		

		
		JButton btnNewButton = new JButton("��ѯ");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\13638\\Desktop\\\u56FE\u5E93\\bird7.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�������������ʵ����ͨ����ȡ��������ģ�ͣ��õ���һ�е�һ����Ԫ�������
				   TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);//���ñ��ģ��������
				   table.setRowSorter(sorter);//���ñ��������
				   sorter.setRowFilter(null);//�����ù�����������ʾȫ������
				   sorter.setRowFilter(RowFilter.regexFilter(textPane.getText()));
			}
		});
		btnNewButton.setBounds(355, 25, 93, 29);
		desktopPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("�޸�");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\13638\\Desktop\\\u56FE\u5E93\\bird8.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTable table = new JTable(model) {
					  @Override
					  public boolean isCellEditable(int row, int column) {
					  if(column==0) {//���õ�1�в��ɱ༭
					    return false;
					  }
					  return true;
					  }
					};// ʵ�������װ�ر��ģ��ʵ��
				try (BufferedWriter bw = new BufferedWriter(new FileWriter("e:/text.txt"))) {
					  for (int i = 0; i < model.getRowCount(); i++) {// ����������ݣ����뼯����
					String row = model.getValueAt(i, 0).toString() + "\t" + model.getValueAt(i, 1).toString() + "\t"+ model.getValueAt(i, 2).toString() + "\t";// ��ȡ�����ÿһ�е�ÿһ����Ԫ��
					    bw.write(row);// ���ı��ļ�����������
					    bw.newLine();// д��س�����
					    
					  }JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
					} catch (Exception e1) {
					  e1.printStackTrace();
					}

			}
		});
		btnNewButton_1.setBounds(458, 25, 93, 29);
		desktopPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("ɾ��");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\13638\\Desktop\\\u56FE\u5E93\\bird9.png"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		  		if (table.getSelectedRow() != -1) {// �Ƿ�ѡ����Ҫɾ������
		  		  if (JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ��������", "",    JOptionPane.YES_NO_OPTION) == 0) {// ȷ���Ի���
		  		    model.removeRow(table.convertRowIndexToModel(table.getSelectedRow()));
		  		    //�ӱ��������ɾ����,model1ΪDefaultTableModel���ͣ��������ֱ��ʹ�ñ���getSelectedRow������ȡ��ѡ�е���
		  		  try (BufferedWriter bw1 = new BufferedWriter(new FileWriter("e:/text.txt"))) {
		  		  for (int i = 0; i < model.getRowCount(); i++) {// ����������ݣ����뼯����
		  		String row1 = model.getValueAt(i, 0).toString() + "\t" + model.getValueAt(i, 1).toString() + "\t"+ model.getValueAt(i, 2).toString() + "\t";// ��ȡ�����ÿһ�е�ÿһ����Ԫ��
		  		    bw1.write(row1);// ���ı��ļ�����������
		  		    bw1.newLine();// д��س�����
		  		  }JOptionPane.showMessageDialog(null,"ɾ���ɹ�");
		  		} catch (Exception e1) {
		  		  e1.printStackTrace();
		  		}
		  		  } 
		  		}else {
		  		    JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ������");
		  		  }
			}
		});
		btnNewButton_2.setBounds(561, 25, 93, 29);
		desktopPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("����");
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\13638\\Desktop\\\u56FE\u5E93\\bird10.png"));
		btnNewButton_3.setBounds(668, 25, 93, 29);
		desktopPane.add(btnNewButton_3);
		
		
		
		
		
		
	}
}
