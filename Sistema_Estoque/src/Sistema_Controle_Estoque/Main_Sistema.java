package Sistema_Controle_Estoque;


import java.sql.SQLException;
import Persistencia.Conection;

public class Main_Sistema {

	public static void main(String[] args) throws SQLException
	{
		Conection.conectar_BD();
	}

}
