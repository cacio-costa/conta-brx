package br.com.bancodigital.main;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.bancodigital.dao.ContaDao;
import br.com.bancodigital.jdbc.ConnectionFactory;

public class TestaExcluiConta {

	public static void main(String[] args) throws SQLException {
		Connection conexao = new ConnectionFactory().getConnection();
		
		ContaDao contaDao = new ContaDao(conexao); // Injeto a dependência
		contaDao.exclui(2L);
		
		contaDao.listaTodas();
		
		conexao.close();
	}
	
}
