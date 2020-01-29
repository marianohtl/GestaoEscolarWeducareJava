package br.com.dal;

import java.sql.*;

public class ModuloConexao {
	public static Connection conector() {
		java.sql.Connection conexao = null;
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://192.168.0.2:3306/weducare?useSSL=false";
		String user = "admin";
		String password = "123@senac";
		try {
			Class.forName(driver);
			conexao = DriverManager.getConnection(url,user,password);
			return conexao;
		} catch (Exception e) {
			System.out.println(e);
			return null;
			
		}
	}

}
