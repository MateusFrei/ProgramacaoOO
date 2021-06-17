package Sistema_Controle_Estoque;

public class Cliente extends Dados_Cadastrais{
	private String cpf;
	

	public Cliente(String nome, String cidade, String email, String telefone, String obs, String cpf) 
	{
		super(nome, cidade, email, telefone, obs);
		this.cpf = cpf;
	}

	public String getCpf() 
	{
		return cpf;
	}

	public void setCpf(String cpf) 
	{
		this.cpf = cpf;
	}

	public void novo_cadastro()
	{
		
	}
	
	public void consultar_cliente()
	{
		
	}
}
