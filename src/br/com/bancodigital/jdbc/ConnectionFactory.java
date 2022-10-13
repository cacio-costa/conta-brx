package br.com.bancodigital.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Design Pattern: FACTORY
 * 	- um problema recorrente
 *  - uma solução comum
 *  - nome associoado
 */
public class ConnectionFactory {

	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/stfd", "system", "123456");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
