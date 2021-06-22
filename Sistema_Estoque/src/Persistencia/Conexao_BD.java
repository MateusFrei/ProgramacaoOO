package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao_BD 
{
	
    final String url = "jdbc:mysql://localhost:3306";
    final String usuario = "root";
    final String senha = "1234";
    
    private Connection conection;
    
    public Conexao_BD() 
    {
    	try 
    	{
    		
    		conection = DriverManager.getConnection(url, usuario, senha);
    		
    		Statement stmt = conection.createStatement();
    		
    		stmt.execute("USE Sistema_Controle_Estoque");
    		
    		System.err.println("Tabela selecionada,.");
    		
    	}
    	catch (Exception ex)
    	{
			System.err.println("Erro geral " + ex.getMessage());
		}
    	
    }
    
    public Connection conectar()
    {
    	return this.conection;
    }
    
    public void fechar_conexao()throws SQLException
    {
    	conection.close();
    }

}
