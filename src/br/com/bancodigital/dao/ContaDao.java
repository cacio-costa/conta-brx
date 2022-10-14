package br.com.bancodigital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		PreparedStatement comandoPreparado = conexao.prepareStatement("select * from banco.conta");
		
		List<Conta> contas = new ArrayList<>();
		ResultSet registros = comandoPreparado.executeQuery();
		while (registros.next()) {
		 	contas.add(this.populaConta(registros));
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
	
	public void altera(Conta conta) throws SQLException {
		String sql = "update banco.conta "
				   + "   set agencia = ?, "
				   + "       numero  = ?, "
				   + "       cliente = ?, "
				   + "       saldo   = ? "
				   + " where id = ?";
		
		
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setLong(1, conta.getAgencia());
		ps.setString(2, conta.getNumero());
		ps.setString(3, conta.getCliente());
		ps.setBigDecimal(4, conta.getSaldo());
		ps.setLong(5, conta.getId());
		ps.execute();
		
		ps.close();
	}

	public Conta buscaPorId(long id) throws SQLException {
		String sql = "select * from banco.conta where id = ?";
		
		try (PreparedStatement ps = this.conexao.prepareStatement(sql)) {
			ps.setLong(1, id);
			
			try (ResultSet registro = ps.executeQuery()) {
				Conta conta = null;
				if (registro.next()) {
					conta = this.populaConta(registro);
				}
					
				return conta;
			}
		}
	}
	
	private Conta populaConta(ResultSet registro) throws SQLException {
		Conta conta = new Conta(
			registro.getLong("agencia"), 
			registro.getString("numero"), 
			registro.getString("cliente"), 
			registro.getBigDecimal("saldo")
		);
		
		conta.setId(registro.getLong("id"));
		return conta;
	}

}
