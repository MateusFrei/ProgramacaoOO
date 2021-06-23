package Sistema_Controle_Estoque;

public class Fornecedor extends Dados_Cadastrais
{
	private String cnpj;
	
	
	public Fornecedor(String nome, String cidade, String email, String telefone, String cnpj)
	{
		super(nome, cidade, email, telefone);
		this.cnpj = cnpj;
	}
	
	public String getCnpj() 
	{
		return cnpj;
	}
	
	public void setCnpj(String cnpj) 
	{
		
		this.cnpj = cnpj;
	}
	
	public void novo_cadastro()
	{
		
	}
}
