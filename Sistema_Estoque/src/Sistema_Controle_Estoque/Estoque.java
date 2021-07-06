package Sistema_Controle_Estoque;

public class Estoque 
{
	private String nome_produto;
	private int quantidade_produto;
	private double preco_venda;
	private double preco_compra;
	
	public String getNome_produto() {
		return nome_produto;
	}

	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}

	public int getQuantidade_produto() {
		return quantidade_produto;
	}

	public void setQuantidade_produto(int quantidade_produto) {
		this.quantidade_produto = quantidade_produto;
	}

	public double getPreco_venda() {
		return preco_venda;
	}

	public void setPreco_venda(double preco_venda) {
		this.preco_venda = preco_venda;
	}

	public double getPreco_compra() {
		return preco_compra;
	}

	public void setPreco_compra(double preco_compra) {
		this.preco_compra = preco_compra;
	}

	public void cadastrar_produto()
	{
		
	}
	
}
