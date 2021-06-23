package Persistencia;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import java.sql.ResultSet;

import Sistema_Controle_Estoque.Administrador;

public class Funcionario_BD {
	
	public ArrayList<Administrador> listar_Funcionario()
	{
		try {
			
			Conexao_BD conecta = new Conexao_BD();
			
			String SQL = "SELECT * FROM administrador";
			PreparedStatement stmt = conecta.conectar().prepareStatement(SQL);
			
			ResultSet rs = stmt.executeQuery();
			
			ArrayList<Administrador> lista_admin = new ArrayList<Administrador>();
			
			while(rs.next())
			{
				Administrador adm = new Administrador(
						rs.getString("nome"),
						rs.getString("cidade"),
						rs.getString("email"),
						rs.getString("tel"),
						rs.getString("login"),
						rs.getString("senha"));
				lista_admin.add(adm);
			}
			
			stmt.close();
			return lista_admin;
			
			
		} catch (Exception ex) {
			System.err.println("Erro geral"+ ex.getMessage());
		}
		return null;
	}
	
	
	public ArrayList<Administrador> Buscar_Cliente(String nome)
	{
		try {
			
			Conexao_BD conecta = new Conexao_BD();
			
			String SQL = "SELECT * FROM sistema_controle_estoque.cliente WHERE nome like '%"+nome+"%'";
			PreparedStatement stmt = conecta.conectar().prepareStatement(SQL);
			
			ResultSet rs = stmt.executeQuery();
			
			ArrayList<Administrador> lista_admin = new ArrayList<Administrador>();
			
			while(rs.next())
			{
				Administrador adm = new Administrador(
						rs.getString("nome"),
						rs.getString("cidade"),
						rs.getString("email"),
						rs.getString("tel"),
						rs.getString("login"),
						rs.getString("senha"));
				lista_admin.add(adm);
			}
			
			stmt.close();
			return lista_admin;
			
			
		} catch (Exception ex) {
			System.err.println("Erro geral"+ ex.getMessage());
		}
		return null;
	}

}
