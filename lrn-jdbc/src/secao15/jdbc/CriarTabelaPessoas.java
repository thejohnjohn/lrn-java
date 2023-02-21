package secao15.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelaPessoas {
	public static void main(String[] args) throws SQLException {
		Connection conexao = FabricaConexao.getConexao();
		
		String sql = "create table pessoas ("
				+ "codigo int auto_increment primary key,"
				+ "nome varchar(80) not null"
				+ ")";
		
		Statement statement = conexao.createStatement();
		statement.execute(sql);
		
		System.out.println("ok");
		conexao.close();
	}
}
