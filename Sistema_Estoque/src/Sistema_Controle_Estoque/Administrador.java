package Sistema_Controle_Estoque;

public class Administrador extends Dados_Cadastrais
{
	
	private String login;
	private String senha;
	
	
	
	public Administrador(String nome, String cidade, String email, String telefone, String login, String senha)
	{
		super(nome, cidade, email, telefone);
		this.login = login;
		this.senha = senha;
	}

	public String getLogin() 
	{
		return login;
	}
	
	public void setLogin(String login) 
	{
		this.login = login;
	}
	
	public String getSenha() 
	{
		return senha;
	}
	
	public void setSenha(String senha) 
	{
		this.senha = senha;
	}
	
	public void novo_cadastro()
	{
		
	}
}
