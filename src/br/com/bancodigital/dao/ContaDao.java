package br.com.bancodigital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bancodigital.jdbc.ConnectionFactory;
import br.com.bancodigital.modelo.Conta;

public class ContaDao {
	
	private Connection conexao;
	
	public ContaDao(Connection conexao) { // declaro a dependência
		this.conexao = conexao;
	}
		

	public void insere(Conta conta) throws SQLException {
		String sql = "INSERT INTO banco.conta " 
		           + "  (agencia, numero, cliente, saldo) " 
				   + "VALUES "
				   + "  (?, ?, ?, ?) ";

		String[] colunaParaRetornar = { "id" };
		
		PreparedStatement comando = conexao.prepareStatement(sql, colunaParaRetornar);
		comando.setLong(1, conta.getAgencia());
		comando.setString(2, conta.getNumero());
		comando.setString(3, conta.getCliente());
		comando.setBigDecimal(4, conta.getSaldo());

		comando.execute();

		ResultSet rs = comando.getGeneratedKeys();
		rs.next();
		
		conta.setId(rs.getLong(1));

		comando.close();
	}

	public List<Conta> listaTodas() throws SQLException {
		String sql = "select * from banco.conta";
		PreparedStatement comandoPreparado = conexao.prepareStatement(sql);
		
		List<Conta> contas = new ArrayList<>();
		ResultSet registros = comandoPreparado.executeQuery();
		while (registros.next()) {
			Conta conta = new Conta(
				registros.getLong("agencia"), 
				registros.getString("numero"), 
				registros.getString("cliente"), 
				registros.getBigDecimal("saldo")
			);
			
			conta.setId(registros.getLong("id"));
		 	contas.add(conta);
		}
		
		registros.close();
		comandoPreparado.close();
		
		return contas;
	}
	
	public void exclui(Long id) throws SQLException {
		String sql = "delete from banco.conta where id = ?";
		
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setLong(1, id);
		ps.execute();
		
		ps.close();
	}	

}
