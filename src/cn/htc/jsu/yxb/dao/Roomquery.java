package cn.htc.jsu.yxb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

import javax.swing.JOptionPane;

import cn.htc.jsu.yxb.dbc.DatabaseConnection;
public class Roomquery {
	public static Integer persen=0;
	public static Vector<Vector> query() {
		Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		String A=date.format(formatter);
		DatabaseConnection dbcs=new DatabaseConnection();//ʹ��ռλ������sqlʶ��
        String sql="select * from a where dateout>=?";
		try(Connection conn=dbcs.getConnection();
			PreparedStatement stmt=conn.prepareStatement(sql);){	
			stmt.setString(1, A);
			ResultSet rs=stmt.executeQuery();//ִ�в�ѯ��䣬����ŵ����ݼ���
    		while(rs.next()) {//�������ݼ�
    			Vector row=new Vector();//����������
    			row.add(rs.getString(1));//��ȡ��һ���ֶ�����
    			row.add(rs.getString(2));//��ȡ�ڶ����ֶ��Ա�
    			row.add(rs.getString(3));
    			row.add(rs.getString(4));
    			row.add(rs.getString(5));
    			row.add(rs.getString(6));
    			row.add(rs.getString(7));
    			rows.add(row);//����������ӵ���¼������
    			persen++;//ͳ������
    		}JOptionPane.showMessageDialog(null, "��ǰ������Ա��ס������Ϊ��"+persen);
	        stmt.close();	
	        conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;//��������������
	}

	
}
