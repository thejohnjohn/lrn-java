package secao15.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class NovaPessoa {
	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Informe o nome: ");
		String nome = scanner.nextLine();
		
		Connection conexao = FabricaConexao.getConexao();
		
		String sql = "insert into pessoas (nome) values (?)";
		
		PreparedStatement preparedStatement = conexao.prepareStatement(sql);
		preparedStatement.setString(1, nome);
		preparedStatement.execute();
		
		scanner.close();
	}
}
