package Persistencia;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.SQLException;

import Sistema_Controle_Estoque.Fornecedor;

public class Fornecedor_BD {
	
	public ArrayList<Fornecedor> listar_Fornecedores()
	{
		try {
			
			Conexao_BD conecta = new Conexao_BD();
			
			String SQL = "SELECT * FROM fornecedor";
			PreparedStatement stmt = conecta.conectar().prepareStatement(SQL);
			
			ResultSet rs = stmt.executeQuery();
			
			ArrayList<Fornecedor> lista_fornece = new ArrayList<Fornecedor>();
			
			while(rs.next())
			{
				Fornecedor forne = new Fornecedor(
						rs.getString("nome"),
						rs.getString("cidade"),
						rs.getString("email"),
						rs.getString("tel"),
						rs.getString("Cnpj"));
				lista_fornece.add(forne);
			}
			
			stmt.close();
			return lista_fornece;
			
			
		} catch (Exception ex) {
			System.err.println("Erro geral"+ ex.getMessage());
		}
		return null;
	}
	
	
	public ArrayList<Fornecedor> Buscar_Fornecedor(String nome)
	{
		try {
			
			Conexao_BD conecta = new Conexao_BD();
			
			String SQL = "SELECT * FROM sistema_controle_estoque.fornecedor WHERE nome like '%"+nome+"%'";
			PreparedStatement stmt = conecta.conectar().prepareStatement(SQL);
			
			ResultSet rs = stmt.executeQuery();
			
			ArrayList<Fornecedor> lista_fornece = new ArrayList<Fornecedor>();
			
			while(rs.next())
			{
				Fornecedor forne = new Fornecedor(
						rs.getString("nome"),
						rs.getString("cidade"),
						rs.getString("email"),
						rs.getString("tel"),
						rs.getString("Cnpj"));
				lista_fornece.add(forne);
			}
			
			stmt.close();
			return lista_fornece;
			
			
		} catch (Exception ex) {
			System.err.println("Erro geral"+ ex.getMessage());
		}
		return null;
	}
	
	public void deletar_fornecedor(Fornecedor f)
	{
		try {
			Conexao_BD conecta = new Conexao_BD();
			
			String SQL = "DELETE FROM sistema_controle_estoque.fornecedor WHERE nome = ?";
			
			PreparedStatement stmt = conecta.conectar().prepareStatement(SQL);
			
			stmt.setString(1, f.getNome());
			
			stmt.executeUpdate();
			
			conecta.fechar_conexao();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
