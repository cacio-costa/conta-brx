package br.com.bancodigital.main;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

import br.com.bancodigital.dao.ContaDao;
import br.com.bancodigital.jdbc.ConnectionFactory;
import br.com.bancodigital.modelo.Conta;

public class TestaAlteraConta {

	public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();
		
		ContaDao contaDao = new ContaDao(connection);
		Conta conta = contaDao.buscaPorId(1L);
		conta.setCliente("Ana Solteira");
		conta.saca(new BigDecimal("500"));
		
		contaDao.altera(conta);
		
		connection.close();
		System.out.println("Conta alterada.");
	}
	
}
