package br.com.bancodigital;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.bancodigital.jdbc.ConnectionFactory;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		Connection conexao = new ConnectionFactory().getConnection();
		System.out.println("Conectou");
		
		conexao.close();
	}
	
}
