/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.factory;

import java.sql.Connection;
import java.sql.DriverManager;
 
/**
 * Classe responsável pela Conexão com o Banco de dados. É utilizada por outras
 * classes de persistência de dados.
 * 
 */
public class ConnectionFactory {
	public Connection getConexao() {
		Connection conexao = null;
		String usuario = "postgres";
		String senha = "postgres";
		String nomeBancoDados = "postgres";
 
		try {
			Class.forName("org.postgresql.Driver");
			conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + nomeBancoDados,
					 usuario, senha);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conexao;
	}
}