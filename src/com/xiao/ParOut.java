package com.xiao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
public class ParOut {
	public static void main(String args[]) throws Exception {
		// ��������
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		// �������
		Connection conn = DriverManager.getConnection("ojdbc:oracle:thin:@192.168.1.184:1521:orcl", "wxq_weimei",
				"a123");
		// �����洢���̵Ķ���
		CallableStatement c = conn.prepareCall("{call p_out(?,?)}");
		// ���洢���̵Ĳ�������ֵ
		c.setInt(1, 2); // ����һ��������ֵ���ó�100
//		c.setString(2, "goole"); // ����һ��������ֵ���ó�100
		  //ע��洢���̵ĵڶ�������
        c.registerOutParameter(2,java.sql.Types.VARCHAR);//java.sql.Types.INTEGER�����ͱ���д��
		// ִ�д洢����
		c.execute();
	    System.out.println (c.getString(2));
		conn.close();
		//�ô�ү
	}
}
