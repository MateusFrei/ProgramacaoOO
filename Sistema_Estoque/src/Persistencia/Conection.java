package Persistencia;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException;  
import java.sql.Statement;

public class Conection {

	public void conectar_BD() throws SQLException 
    {
        final String url = "jdbc:mysql://localhost:3306";
        final String usuario = "root";
        final String senha = "1234";

        Connection conexao = DriverManager.getConnection(url, usuario, senha);

        Statement stmt = conexao.createStatement();
        stmt.execute("CREATE DATABASE IF NOT EXISTS Sistema_Controle_Estoque");

        stmt.execute("USE Sistema_Controle_Estoque");
		
		stmt.execute("CREATE TABLE IF NOT EXISTS Cliente(\r\n"
				+ "	nome VARCHAR(150),\r\n"
				+ "    cidade VARCHAR(150),\r\n"
				+ "    email VARCHAR(150),\r\n"
				+ "    tel VARCHAR(150),\r\n"
				+ "    Cpf VARCHAR(150)\r\n"
				+ ");");
		
		System.out.println("Cliente criado \n");
		
		stmt.execute("CREATE TABLE IF NOT EXISTS Administrador(\r\n"
				+ "	nome VARCHAR(150),\r\n"
				+ "    cidade VARCHAR(150),\r\n"
				+ "    email VARCHAR(150),\r\n"
				+ "    tel VARCHAR(150),\r\n"
				+ "    Cpf VARCHAR(150),\r\n"
				+ "    login VARCHAR(150),\r\n"
				+ "    senha VARCHAR(150)\r\n"
				+ ");");
		
		System.out.println("Administrador criado \n");
		
		stmt.execute("CREATE TABLE IF NOT EXISTS Fornecedor(\r\n"
				+ "	nome VARCHAR(150),\r\n"
				+ "    cidade VARCHAR(150),\r\n"
				+ "    email VARCHAR(150),\r\n"
				+ "    tel VARCHAR(150),\r\n"
				+ "    Cnpj VARCHAR(150)\r\n"
				+ ");\r\n"
				+ "");
		
		System.out.println("Fornecedor criado \n");
		
		stmt.execute("CREATE TABLE IF NOT EXISTS Vendas(\r\n"
				+ "	quantidade INT,\r\n"
				+ "    valor_total DOUBLE\r\n"
				+ ");");
		
		System.out.println("Vendas criado \n");
		
		stmt.execute("CREATE TABLE IF NOT EXISTS Estoque(\r\n"
				+ "	nome_produto VARCHAR(150),\r\n"
				+ "    quantidade_produto INT,\r\n"
				+ "    preco_venda DOUBLE,\r\n"
				+ "    preco_compra DOUBLE\r\n"
				+ ");");
		System.out.println("Estoque criado \n");
		
		
	}  
	
}
