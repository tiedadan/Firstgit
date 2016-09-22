package com.xiao;
import java.sql.*;
public class ProcedureTest {
	public static void main(String args[]) throws Exception {
		// 加载驱动
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		// 获得连接
		Connection conn = DriverManager.getConnection("ojdbc:oracle:thin:@192.168.1.184:1521:orcl", "wxq_weimei",
				"a123");
		// 创建存储过程的对象
		CallableStatement c = conn.prepareCall("{call p_update(?,?)}");
		// 给存储过程的参数设置值
		c.setInt(1, 2); // 将第一个参数的值设置成100
		c.setString(2, "goole"); // 将第一个参数的值设置成100
		// 执行存储过程
		c.execute();
		conn.close();
	}
}
