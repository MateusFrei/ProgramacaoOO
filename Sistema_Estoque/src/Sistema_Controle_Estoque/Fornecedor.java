package Sistema_Controle_Estoque;

public class Fornecedor 
{
	private String produto;
	private String cnpj;
	
	
	public Fornecedor(String produto, String cnpj)
	{
		super();
		this.produto = produto;
		this.cnpj = cnpj;
	}

	public String getProduto() 
	{
		return produto;
	}
	
	public void setProduto(String produto) 
	{
		this.produto = produto;
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
