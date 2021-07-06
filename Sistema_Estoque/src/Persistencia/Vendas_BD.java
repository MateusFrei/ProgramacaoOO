package Persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Sistema_Controle_Estoque.Vendas;

public class Vendas_BD {

	public ArrayList<Vendas> listar_Vendas()
	{
		try {
			
			Conexao_BD conecta = new Conexao_BD();
			
			String SQL = "SELECT * FROM vendas";
			PreparedStatement stmt = conecta.conectar().prepareStatement(SQL);
			
			ResultSet rs = stmt.executeQuery();
			
			ArrayList<Vendas> lista_vendas = new ArrayList<Vendas>();
			
			while(rs.next())
			{
				Vendas vende = new Vendas();
				
				vende.setQuantidade(rs.getInt("quantidade"));
				vende.setValor_total(rs.getDouble("valor_total"));
				
				lista_vendas.add(vende);
			}
			
			
			stmt.close();
			return lista_vendas;
			
			
		} catch (Exception ex) {
			System.err.println("Erro geral"+ ex.getMessage());
		}
		return null;
	}
	
	
	public ArrayList<Vendas> Buscar_Vendas(String nome)
	{
		try {
			
			Conexao_BD conecta = new Conexao_BD();
			
			String SQL = "SELECT * FROM vendas";
			PreparedStatement stmt = conecta.conectar().prepareStatement(SQL);
			
			ResultSet rs = stmt.executeQuery();
			
			ArrayList<Vendas> lista_vendas = new ArrayList<Vendas>();
			
			while(rs.next())
			{
				Vendas vende = new Vendas();
				
				vende.setQuantidade(rs.getInt("quantidade"));
				vende.setValor_total(rs.getDouble("valor_total"));
				
				lista_vendas.add(vende);
			}
			stmt.close();
			return lista_vendas;
			
			
		} catch (Exception ex) {
			System.err.println("Erro geral"+ ex.getMessage());
		}
		return null;
	}
	
}
