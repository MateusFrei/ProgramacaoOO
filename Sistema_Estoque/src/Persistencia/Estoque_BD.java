package Persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Sistema_Controle_Estoque.Estoque;


public class Estoque_BD {

	public ArrayList<Estoque> listar_Estoque()
	{
		try {
			
			Conexao_BD conecta = new Conexao_BD();
			
			String SQL = "SELECT * FROM estoque";
			PreparedStatement stmt = conecta.conectar().prepareStatement(SQL);
			
			ResultSet rs = stmt.executeQuery();
			
			ArrayList<Estoque> lista_estoque = new ArrayList<Estoque>();
			
			while(rs.next())
			{
				Estoque lista = new Estoque();
				
				lista.setNome_produto(rs.getString("nome_produto"));
				lista.setPreco_compra(rs.getDouble("preco_compra"));
				lista.setPreco_venda(rs.getDouble("preco_venda"));
				lista.setQuantidade_produto(rs.getInt("quantidade_produto"));
				
				lista_estoque.add(lista);
			}
			
			
			stmt.close();
			return lista_estoque;
			
			
		} catch (Exception ex) {
			System.err.println("Erro geral"+ ex.getMessage());
		}
		return null;
	}
}
