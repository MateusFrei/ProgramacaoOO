package Persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Sistema_Controle_Estoque.Estoque;
import Sistema_Controle_Estoque.Fornecedor;
import Sistema_Controle_Estoque.Vendas;


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
	
	public void Deletar_Produto(Estoque f)
	{
		try {
			Conexao_BD conecta = new Conexao_BD();
			
			String SQL = "DELETE FROM sistema_controle_estoque.estoque WHERE produto = ?";
			
			PreparedStatement stmt = conecta.conectar().prepareStatement(SQL);
			
			stmt.setString(1, f.getNome_produto());
			
			stmt.executeUpdate();
			
			conecta.fechar_conexao();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public ArrayList<Estoque> buscar_produto(String produto)
	{
		try {
			
			Conexao_BD conecta = new Conexao_BD();
			
			String SQL = "SELECT * FROM sistema_controle_estoque.estoque WHERE produto like '%"+produto+"%'";
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
