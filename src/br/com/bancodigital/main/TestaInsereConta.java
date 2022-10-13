package br.com.bancodigital.main;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

import br.com.bancodigital.dao.ContaDao;
import br.com.bancodigital.jdbc.ConnectionFactory;
import br.com.bancodigital.modelo.Conta;

public class TestaInsereConta {

	public static void main(String[] args) throws SQLException {
		Conta novaConta = new Conta(345L, "3321-9", "Dani", new BigDecimal("1500"));
				
		Connection conexao = new ConnectionFactory().getConnection();
		
		ContaDao contaDao = new ContaDao(conexao);
		contaDao.insere(novaConta);
		
		conexao.close();
	}
	
}
