package Persistencia;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import java.sql.ResultSet;

import Sistema_Controle_Estoque.Cliente;

public class Cliente_BD {
	
	public ArrayList<Cliente> listar_Cliente()
	{
		try {
			
			Conexao_BD conecta = new Conexao_BD();
			
			String SQL = "SELECT * FROM cliente";
			PreparedStatement stmt = conecta.conectar().prepareStatement(SQL);
			
			ResultSet rs = stmt.executeQuery();
			
			ArrayList<Cliente> lista_cliente = new ArrayList<Cliente>();
			
			while(rs.next())
			{
				Cliente cli = new Cliente(
						rs.getString("nome"),
						rs.getString("cidade"),
						rs.getString("email"),
						rs.getString("tel"),
						rs.getString("Cpf"));
				lista_cliente.add(cli);
			}
			
			stmt.close();
			return lista_cliente;
			
			
		} catch (Exception ex) {
			System.err.println("Erro geral"+ ex.getMessage());
		}
		return null;
	}
	
	
	public ArrayList<Cliente> Buscar_Cliente(String nome)
	{
		try {
			
			Conexao_BD conecta = new Conexao_BD();
			
			String SQL = "SELECT * FROM sistema_controle_estoque.cliente WHERE nome like '%"+nome+"%'";
			PreparedStatement stmt = conecta.conectar().prepareStatement(SQL);
			
			ResultSet rs = stmt.executeQuery();
			
			ArrayList<Cliente> lista_cliente = new ArrayList<Cliente>();
			
			while(rs.next())
			{
				Cliente cli = new Cliente(
						rs.getString("nome"),
						rs.getString("cidade"),
						rs.getString("email"),
						rs.getString("tel"),
						rs.getString("Cpf"));
				lista_cliente.add(cli);
			}
			
			stmt.close();
			return lista_cliente;
			
			
		} catch (Exception ex) {
			System.err.println("Erro geral"+ ex.getMessage());
		}
		return null;
	}
	
}
