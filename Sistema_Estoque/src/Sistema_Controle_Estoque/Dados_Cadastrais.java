package Sistema_Controle_Estoque;

public abstract class Dados_Cadastrais {
	
	protected String Nome;
	protected String Cidade;
	protected String Email;
	protected String Telefone;
	protected String obs;
	
	
	
	public Dados_Cadastrais(String nome, String cidade, String email, String telefone, String obs)
	{
		
		this.Nome = nome;
		this.Cidade = cidade;
		this.Email = email;
		this.Telefone = telefone;
		this.obs = obs;
	}

	public String getNome() 
	{
		return Nome;
	}
	
	public void setNome(String nome) 
	{
		Nome = nome;
	}
	
	public String getCidade() 
	{
		return Cidade;
	}
	
	public void setCidade(String cidade) 
	{
		Cidade = cidade;
	}
	
	public String getEmail() 
	{
		return Email;
	}
	
	public void setEmail(String email) 
	{
		Email = email;
	}
	
	public String getTelefone() 
	{
		return Telefone;
	}
	
	public void setTelefone(String telefone) 
	{
		Telefone = telefone;
	}
	
	public String getObs() 
	{
		return obs;
	}
	
	public void setObs(String obs) 
	{
		this.obs = obs;
	}
	
	public void novo_cadastro () 
	{
		
	}
}
