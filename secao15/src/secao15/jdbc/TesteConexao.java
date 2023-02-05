package secao15.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class TesteConexao {
	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost";
		String usuario = "root";
		String senha = "root";
		
		
		Connection conexao = FabricaConexao.getConexao();
		
		Statement statement = conexao.createStatement();
		statement.execute("show databases");
		
		System.out.println("ok");
		conexao.close();
	}
}
