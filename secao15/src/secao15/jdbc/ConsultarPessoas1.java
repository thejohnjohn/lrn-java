package secao15.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultarPessoas1 {
	public static void main(String[] args) throws SQLException {
		Connection conexao = FabricaConexao.getConexao();
		String sql = "select * from pessoas";
		
		Statement statement = conexao.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		List<Pessoa> pessoas = new ArrayList<>();
		
		while(resultSet.next()) {
			int codigo = resultSet.getInt(0);
			String nome = resultSet.getString(1);
			pessoas.add(new Pessoa(codigo, nome));
		}
		
		statement.close();
		conexao.close();
	}
}
