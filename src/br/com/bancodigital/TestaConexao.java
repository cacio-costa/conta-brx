package br.com.bancodigital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		Connection conexao = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "123456");
		System.out.println("Conectou");
	}
	
}
