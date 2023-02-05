package secao15.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DesafioAtualizarPessoas {
	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Digite o código da pessoa desejada: ");
		String codigoDaPessoa = scanner.nextLine();
		
		System.out.print("Digite o novo nome: ");
		String novoNome = scanner.nextLine();
		
		Connection conexao = FabricaConexao.getConexao();
		
		String sql = "update pessoas set nome = ? where codigo = ?";
		
		PreparedStatement preparedStatement = conexao.prepareStatement(sql);
		preparedStatement.setString(1, novoNome);
		preparedStatement.setString(2, codigoDaPessoa);
		preparedStatement.executeUpdate();
		
		preparedStatement.close();
		conexao.close();
	}
}
