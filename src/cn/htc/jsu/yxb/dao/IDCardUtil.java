package cn.htc.jsu.yxb.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.xmlbeans.impl.regex.ParseException;

public class IDCardUtil {
	/**
     * <pre>
     * ʡ��ֱϽ�д����
     *     11 : ����  12 : ���  13 : �ӱ�   14 : ɽ��  15 : ���ɹ�
     *     21 : ����  22 : ����  23 : ������ 31 : �Ϻ�  32 : ����
     *     33 : �㽭  34 : ����  35 : ����   36 : ����  37 : ɽ��
     *     41 : ����  42 : ����  43 : ����   44 : �㶫  45 : ����  46 : ����
     *     50 : ����  51 : �Ĵ�  52 : ����   53 : ����  54 : ����
     *     61 : ����  62 : ����  63 : �ຣ   64 : ����  65 : �½�
     *     71 : ̨��
     *     81 : ���  82 : ����
     *     91 : ����
     * </pre>
     */
    final static String CITY_CODE[] = { "37"};
    static String s;
    /**
     * Ч����
     */
    final static char[] PARITYBIT = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
 
    /**
     * ��Ȩ����
     * Math.pow(2,  i - 1) % 11
     */
    final static int[] POWER = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
 
    /**
     * ���֤��֤
     *
     * @param id ��������
     * @return �Ƿ���Ч
     */
    public final static boolean isValid(String id) {
        if (id == null)
            return false;
 
        int len = id.length();
        if (len != 15 && len != 18)
            return false;
 
        //У����λ��
        if (!validCityCode(id.substring(0, 2)))
            return false;
 
        //У������
        if (!validDate(id))
            return false;
 
        if (len == 15)
            return true;
 
        //У��λ��
        return validParityBit(id);
 
    }
 
    private static boolean validParityBit(String id) {
        char[] cs = id.toUpperCase().toCharArray();
        int power = 0;
        for (int i = 0; i < cs.length; i++) {
            //���һλ������X
            if (i == cs.length - 1 && cs[i] == 'X')
                break;
 
            // ������
            if (cs[i] < '0' || cs[i] > '9')
                return false;
 
            // ��Ȩ���
            if (i < cs.length - 1) {
                power += (cs[i] - '0') * POWER[i];
            }
        }
        return PARITYBIT[power % 11] == cs[cs.length - 1];
    }
 
    private static boolean validDate(String id) {
        try {
            String birth = id.length() == 15 ? "19" + id.substring(6, 12) : id.substring(6, 14);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            Date birthDate = sdf.parse(birth);
            if (!birth.equals(sdf.format(birthDate)))
                return false;
        } catch (ParseException e) {
            return false;
        } catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return true;
    }
 
    private static boolean validCityCode(String cityCode) {
        for (String code : CITY_CODE) {
            if (code.equals(cityCode))
                return true;
        }
        return false;
    }
 
    /**
     * ��15λ�����֤ת��18λ���֤
     *
     * @param id
     * @return
     */
    final public static String id15To18(String id) {
        if (id == null || id.length() != 15)
            return null;
 
        if (!isValid(id))
            return null;
 
        String id17 = id.substring(0, 6) + "19" + id.substring(6);
 
        int power = 0;
        char[] cs = id17.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            power += (cs[i] - '0') * POWER[i];
        }
 
        // ��ǰ17λ���18λУ����ƴ��
        return id17 + String.valueOf(PARITYBIT[power % 11]);
    }
 
    /**
     * �����������
     * <p>
     *
     * @param min
     * @param max
     * @return
     */
    public static int rand(int min, int max) {
        Random random = new Random();
        return random.nextInt(max + 1) % (max - min + 1) + min;
    }
    /**
	 * �õ�������ɵ����֤�е�����Ա��ڵõ�����
	 */
    public static String getAge() {
    	return s;
    }
    /**
	 * �õ�������ɵ����֤��
	 */
    public final static String generateID() {
        // ��ַ��
        String body = CITY_CODE[rand(0, CITY_CODE.length - 1)] + "0812";
 
        // ������
        String y = String.valueOf(rand(1970, Calendar.getInstance().get(Calendar.YEAR)));
		boolean a = true;
		while(a){
			if(Integer.parseInt(y)<2000){
				a = false;
			}else{
				y= String.valueOf(rand(1950, Calendar.getInstance().get(Calendar.YEAR)));
			}
		}
		s=y;
        String m = String.valueOf(rand(1, 12));
        if (m.length() == 1)
            m = "0" + m;
        String d = String.valueOf(rand(1, 28));
        if (d.length() == 1)
            d = "0" + d;
 
        String idx = String.valueOf(rand(1, 999));
        if (idx.length() == 1)
            idx = "00" + idx;
        else if (idx.length() == 2)
            idx = "0" + idx;
 
        body += y + m + d + idx;
 
        // �ۼ�body������λ�ü�Ȩ�Ļ�
        int power = 0;
        char[] cs = body.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            power += (cs[i] - '0') * POWER[i];
        }
 
        // �ó�У����
        return body + String.valueOf(PARITYBIT[power % 11]);
    }
}
