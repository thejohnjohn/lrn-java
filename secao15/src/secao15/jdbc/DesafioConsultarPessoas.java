package secao15.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DesafioConsultarPessoas {
	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Digite os caracteres: ");
		String caracteresEspeciais = scanner.nextLine();
		
		Connection conexao = FabricaConexao.getConexao();
		
		String sql = "select * from pessoas where nome like concat( '%',?,'%')";
		
		PreparedStatement preparedStatement = conexao.prepareStatement(sql);
		preparedStatement.setString(1, caracteresEspeciais);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		List<Pessoa> pessoas = new ArrayList<>();
		
		while(resultSet.next()) {
			int codigo = resultSet.getInt(1);
			String nome = resultSet.getString(2);
			pessoas.add(new Pessoa(codigo, nome));
		}
		
		for(Pessoa pessoa : pessoas) {
			System.out.format("CÓDIGO 👉 %d NOME 👉 %s \n", pessoa.id, pessoa.nome);
		}
		
		preparedStatement.close();
		conexao.close();
	}
}
