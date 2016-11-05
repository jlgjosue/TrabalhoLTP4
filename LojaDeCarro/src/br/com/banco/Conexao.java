package br.com.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public static Connection getConexao() throws SQLException{
		try {
			System.out.println(":)");
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/projeto123?user=root&password=root");
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println( "null...");
		return  null;
	}
	
	//teste da coneção com o banco
	//public static void main(String[] args) {
	//	Connection c = getConexao();
	//	System.out.println(c);
		
	//}

}
