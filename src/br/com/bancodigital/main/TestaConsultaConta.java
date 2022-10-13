package br.com.bancodigital.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.bancodigital.dao.ContaDao;
import br.com.bancodigital.jdbc.ConnectionFactory;
import br.com.bancodigital.modelo.Conta;

public class TestaConsultaConta {

	public static void main(String[] args) throws SQLException {
		Connection conexao = new ConnectionFactory().getConnection();
		
		ContaDao contaDao = new ContaDao(conexao);
		List<Conta> listaDeContas = contaDao.listaTodas();
		
		for (Conta conta : listaDeContas) {
			System.out.println(conta);
		}
		
		conexao.close();
	}
	
}
