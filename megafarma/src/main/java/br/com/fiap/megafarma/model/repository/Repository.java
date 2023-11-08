package br.com.fiap.megafarma.model.repository;
/*
 * classe pai para obter uma conexão e fechar a conexão com o banco de dados*/

import java.sql.Connection;

public abstract class Repository {
	protected static Connection connection;
	
	//construtor obtém conexão com método get
	public Repository() {
		getConnection();
	}

	//método para obter conexão
	public static Connection getConnection() {
		try {
			connection = ConnectionFactory.getInstance().getConexao();
			return connection;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;		
	}
	
	//método para fechar conexão
	public static void closeConnnection() {
		try {
			if (!connection.isClosed()) {
				connection.close();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	
	
}
