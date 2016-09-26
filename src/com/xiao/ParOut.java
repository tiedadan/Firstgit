package com.xiao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
public class ParOut {
	public static void main(String args[]) throws Exception {
		// 加载驱动
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		// 获得连接
		Connection conn = DriverManager.getConnection("ojdbc:oracle:thin:@192.168.1.184:1521:orcl", "wxq_weimei",
				"a123");
		// 创建存储过程的对象
		CallableStatement c = conn.prepareCall("{call p_out(?,?)}");
		// 给存储过程的参数设置值
		c.setInt(1, 2); // 将第一个参数的值设置成100
//		c.setString(2, "goole"); // 将第一个参数的值设置成100
		  //注册存储过程的第二个参数
        c.registerOutParameter(2,java.sql.Types.VARCHAR);//java.sql.Types.INTEGER（类型必须写）
		// 执行存储过程
		c.execute();
	    System.out.println (c.getString(2));
		conn.close();
		//好大爷
	}
}
