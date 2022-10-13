package br.com.bancodigital.main;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.bancodigital.jdbc.ConnectionFactory;

public class TestaAlteraConta {

	public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();
		
		String sql = "update banco.conta "
				   + "   set saldo = ? "
				   + " where id = ? ";
		
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setBigDecimal(1, new BigDecimal("2000"));
		ps.setLong(2, 2);
		ps.execute();
		
		ps.close();
		connection.close();
	}
	
}
