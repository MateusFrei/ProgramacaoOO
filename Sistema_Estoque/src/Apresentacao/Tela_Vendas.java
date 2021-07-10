package Apresentacao;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Persistencia.Conexao_BD;
import Persistencia.Estoque_BD;
import Sistema_Controle_Estoque.Estoque;

@SuppressWarnings("serial")
public class Tela_Vendas extends JFrame {

	private JPanel contentPane;
	private JTextField txt_quantidade;
	private JTextField txt_valot_total;
	private JTextField txt_nome_produto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Vendas frame = new Tela_Vendas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela_Vendas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 802, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(294, 79, 258, 89);
		contentPane.add(textArea);
		
		JLabel lblNewLabel = new JLabel("Quantidade:");
		lblNewLabel.setBounds(10, 80, 116, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Valor Total:");
		lblNewLabel_1.setBounds(10, 117, 80, 29);
		contentPane.add(lblNewLabel_1);
		
		
		txt_nome_produto = new JTextField();
		txt_nome_produto.setBounds(96, 37, 120, 19);
		contentPane.add(txt_nome_produto);
		txt_nome_produto.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nome Produto: ");
		lblNewLabel_2.setBounds(10, 40, 76, 13);
		contentPane.add(lblNewLabel_2);
		
		txt_quantidade = new JTextField();
		txt_quantidade.setBounds(96, 79, 119, 19);
		contentPane.add(txt_quantidade);
		txt_quantidade.setColumns(10);
		
		txt_valot_total = new JTextField();
		txt_valot_total.setEditable(false);
		txt_valot_total.setBounds(96, 122, 119, 19);
		contentPane.add(txt_valot_total);
		txt_valot_total.setColumns(10);
		
		JButton btnNewButton = new JButton("Comprar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try 
				{
					Conexao_BD con = new Conexao_BD();
					
					String query = "INSERT INTO sistema_controle_estoque.vendas (quantidade, valor_total) VALUES (?, ?)";
					String up_query = "UPDATE sistema_controle_estoque.estoque SET quantidade_produto = ? WHERE nome_produto = ? ";
					
					double valor = 0;
					int quanti = 0;
					
					PreparedStatement stmt = con.conectar().prepareStatement(query);
					PreparedStatement stmt2 = con.conectar().prepareStatement(up_query);
					
					Estoque_BD est_bd = new Estoque_BD();
					
					
					ArrayList<Estoque> produto = est_bd.buscar_produto(txt_nome_produto.getText());
					
					for(Estoque et: produto)
					{
						if(et.getNome_produto().equals(txt_nome_produto.getText()) == true)
						{
							quanti = et.getQuantidade_produto() - Integer.parseInt(txt_quantidade.getText());
							
							if(quanti >= 0)
							{
								
								valor = Integer.parseInt(txt_quantidade.getText()) * et.getPreco_venda();

								stmt.setString(1, txt_quantidade.getText());
								stmt.setDouble(2, valor);
								
								stmt2.setInt(1,quanti);
								stmt2.setString(2, txt_nome_produto.getText());
								
								stmt.executeUpdate();
								stmt2.executeUpdate();
								
								txt_valot_total.setText(""+ valor);
								
								System.out.println("Venda submetida.");
							}else {
								System.err.println("Quantidade fora do estoque!");
							}
						}else {
							System.err.println("Produto Invalido!");
						}
						
					}
					
					stmt.close();
					
					System.out.println("Conection closed...");
					
				}catch (Exception x) {
					System.err.println("Erro ao conectar !" + x.getMessage());
				}
			}
		});
		btnNewButton.setBounds(106, 156, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Listar Produtos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Conexao_BD conecta = new Conexao_BD();
					
					Estoque_BD est = new Estoque_BD();
					
					ArrayList<Estoque> lista_e = est.listar_Estoque();
					
					
					if(lista_e != null)
					{
						textArea.setText("");
						
						for(Estoque et : lista_e)
						{
							
							textArea.setText(textArea.getText() + et.getNome_produto() + " - " + et.getQuantidade_produto() +" - " + et.getPreco_venda() + "\n");
						}	
						
					}
					conecta.fechar_conexao();
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setBounds(294, 48, 124, 21);
		contentPane.add(btnNewButton_1);

	}
}
