package cn.htc.jsu.yxb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import cn.htc.jsu.yxb.dbc.DatabaseConnection;
/**
 * ����������� �Ա� ����ŵ���Ϣ��ӵ����ݿ�ı�a��
 */
public class DataOperate {
	static int a;static int x;static int y;
	//��������
	private static String firstName="��Ǯ��������֣��������������������������ʩ�ſײ��ϻ���κ�ս���л������ˮ��������˸��ɷ�����³Τ������ﻨ������Ԭ��ۺ��ʷ�Ʒ����Ѧ�׺����������ޱϺ�����������ʱ��Ƥ���뿵����Ԫ������ƽ�ƺ�������Ҧ��տ����ë����ױ���갼Ʒ��ɴ�̸��é���ܼ�������ף������������ϯ����ǿ��·¦Σ��ͯ�չ�÷ʢ�ֵ�����������Ĳ��﷮���������֧�¾̹�¬Ī�������Ѹɽ�Ӧ�������ڵ��������������ʯ�޼�ť�������ϻ���½��������춻���κ�ӷ����ഢ���������ɾ��θ����ڽ��͹�����ɽ�ȳ������ȫۭ�����������������ﱩ�����������������ղ����Ҷ��˾��۬�輻��ӡ�ް׻���̨�Ӷ����̼���׿�����ɳ����������ܲ�˫��ݷ����̷�����̼������Ƚ��۪Ӻȴ�ɣ���ţ��ͨ�����༽ۣ����ũ�±�ׯ�̲����ֳ�Ľ����ϰ�°���������������θ����߾Ӻⲽ�����������Ŀܹ�»�ڶ�Ź�����εԽ��¡ʦ�������˹��������������Ǽ��Ŀ�����ɳؿ������ᳲ�������󽭺�����Ȩ�ָ��滸����ٹ˾���Ϲ�ŷ���ĺ�������˶��������ʸ�ξ�ٹ����̨��ұ���������������̫����������������ԯ�������������Ľ����������˾ͽ˾������˾���붽�ӳ�����ľ����������������ṫ���ذμй��׸����������ַ���۳Ϳ�նθɰ��ﶫ�����ź��ӹ麣����΢����˧�ÿ�������������������������Ĳ��٦�����Ϲ�ī�������갮��١�����Ը��ټ�����";
	//����Ů������
	private static String girl="���Ӣ���������Ⱦ���������֥��Ƽ�����ҷ���ʴ��������÷���������滷ѩ�ٰ���ϼ����ݺ�����𷲼Ѽ�������������Ҷ�������������ɺɯ������ٻ�������ӱ¶������������Ǻɵ���ü������ޱݼ���Է�ܰ�������԰��ӽ�������ع���ѱ�ˬ������ϣ����Ʈ�����������������������ܿ�ƺ������˿ɼ���Ӱ��֦˼�� ";
	//������������
    private static String boy="ΰ�����㿡��ǿ��ƽ�����Ļ�������������־��������ɽ�ʲ���������Ԫȫ��ʤѧ��ŷ���������ɱ�˳���ӽ��β��ɿ��ǹ���ﰲ����ï�����м�ͱ벩���Ⱦ�����׳��˼Ⱥ���İ�����ܹ����ƺ���������ԣ���ܽ���������ǫ�����֮�ֺ��ʲ����������������ά�������������󳿳�ʿ�Խ��������׵���ʱ̩ʢ��衾��ڲ�����ŷ纽��";
    public static int getNum(int start,int end) {//������ط���ָ����Χ�������
    	//Math.random()�������0.0��1.0֮�����
        return (int)(Math.random()*(end-start+1)+start);
    }
    //��������������� 
    public static String getChineseName() {
        int index=getNum(0, firstName.length()-1);//���ȡ�����ַ����е�����λ��
        String first=firstName.substring(index, index+1);//��ȡ��λ�õ�����
        int sex=getNum(0,1);//���ȡ�Ա�����1Ϊ������0ΪŮ��
        a=sex;
        String str=boy;//��������Ϊ�����ַ���
        int length=boy.length();//��ȡ�����ַ����ĳ���
        if(sex==0){//��������ȡΪ0�������ָ�ΪŮ��
            str=girl;
            length=girl.length();
        }
        index=getNum(0,length-1);//�����ȡ���ֵ�λ��
        String second=str.substring(index, index+1);//��ȡ��λ���е�����
        int hasThird=getNum(0,1);//�����ȡ�����Ƿ��е�������
        String third="";//Ĭ��û�е�������
        if(hasThird==1){//��������ȡΪ1�����е�������
            index=getNum(0,length-1);
            third=str.substring(index, index+1);
        }
        return first+second+third;//��������
    }
    
    public static void main(String[] args) {
    	addMsg();
    }
    public static void addMsg() {//���ӿͻ���¼
    	DatabaseConnection dbcs=new DatabaseConnection();//ʹ��1�ж�����������ݿ����
    	String sql="insert into a(name,sex,age,ID,room,datein,dateout) values(?,?,?,?,?,?,?)";
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
        		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
            	ArrayList<String> alist=new ArrayList<String>();//���弯��
        		for(int i=1;i<=81;) {
        			String ID=IDCardUtil.generateID();
        			if(!alist.contains(ID)) {//�ж�ѧ���Ƿ�Ψһ
        				alist.add(ID);//��ѧ�ż��뼯��
        				String name=getChineseName();//�����ȡ����
        				String sex;
        				int b=2021-Integer.valueOf(IDCardUtil.getAge());
        				String age=String.valueOf(b);
        				if(a==1) {
        					sex="��";
        				}else{sex="Ů";}
        				String room;
        				if(i%9==0) {
        					x=9;
        				}
        				else x=i%9;
        				y=1+i/10;
        				int h=y*100+x;
        				String s = String.valueOf(h);//������hת�����ַ���s
        				room=s;	
        				String datein="2019-05-09";
        				String dateout="2019-05-15";
        				pstmt.setString(1, name);//�����1��ռλ��������
        	    		pstmt.setString(2,sex );//�����2��ռλ��������
        	    		pstmt.setString(3, age);//�����3��ռλ��������
        	    		pstmt.setString(4,ID );
        	    		pstmt.setString(5, room);
        	    		pstmt.setString(6, datein);
        	    		pstmt.setString(7, dateout);
        	    		pstmt.addBatch();//����������ȴ�ִ��
        				i++;//ѧ��Ψһ��ѭ����������ִ��
        			}
        		}
        		pstmt.executeBatch();//����ִ�в������
        		JOptionPane.showMessageDialog(null, "sucess");
        	}catch(SQLException e) {
        		e.printStackTrace();
        	}
    }
    
}
