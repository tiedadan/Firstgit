package com.xiao;
import java.sql.*;
public class ProcedureTest {
	public static void main(String args[]) throws Exception {
		// ��������
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		// �������
		Connection conn = DriverManager.getConnection("ojdbc:oracle:thin:@192.168.1.184:1521:orcl", "wxq_weimei",
				"a123");
		// �����洢���̵Ķ���
		CallableStatement c = conn.prepareCall("{call p_update(?,?)}");
		// ���洢���̵Ĳ�������ֵ
		c.setInt(1, 2); // ����һ��������ֵ���ó�100
		c.setString(2, "goole"); // ����һ��������ֵ���ó�100
		// ִ�д洢����
		c.execute();
		conn.close();
	}
}
