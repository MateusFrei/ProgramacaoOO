package Apresentacao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Persistencia.Conexao_BD;
import Persistencia.Estoque_BD;
import Sistema_Controle_Estoque.Estoque;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Tela_Estoque extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Estoque frame = new Tela_Estoque();
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
	public Tela_Estoque() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 781, 256);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome do Produto: ");
		lblNewLabel.setBounds(40, 28, 92, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Quantidade: ");
		lblNewLabel_1.setBounds(40, 64, 76, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Pre\u00E7o Venda: ");
		lblNewLabel_2.setBounds(40, 94, 76, 23);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Pre\u00E7o de Compra: ");
		lblNewLabel_3.setBounds(40, 127, 92, 25);
		contentPane.add(lblNewLabel_3);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(263, 72, 332, 80);
		contentPane.add(textArea);
		
		textField = new JTextField();
		textField.setBounds(142, 29, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(142, 65, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(142, 96, 96, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(142, 130, 96, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Listar Estoque");
		btnNewButton.addActionListener(new ActionListener() {
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
							
							textArea.setText(textArea.getText() + et.getNome_produto() + " - " + et.getQuantidade_produto() +" - " + et.getPreco_compra() +" - "+ et.getPreco_venda() + "\n");
						}	
						
					}
					conecta.fechar_conexao();
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(359, 41, 125, 21);
		contentPane.add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("Cadastrar Produto");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try 
				{
					Conexao_BD con = new Conexao_BD();
					
					String query = "INSERT INTO estoque (nome_produto, quantidade_produto, preco_venda, preco_compra) VALUES ( ?, ?, ?, ?)";
					
					PreparedStatement stmt = con.conectar().prepareStatement(query);
					
					stmt.setString(1, textField.getText());
					stmt.setString(2, textField_1.getText());
					stmt.setString(3, textField_2.getText());
					stmt.setString(4, textField_3.getText());
;
					stmt.executeUpdate();
					stmt.close();
					
					System.out.println("Produto Cadastrado. ");
					System.out.println("Conection closed...");
					
				}catch (Exception x) {
					System.err.println("Erro ao conectar !" + x.getMessage());
				}
				
			}
		});
		btnNewButton_1.setBounds(61, 174, 142, 23);
		contentPane.add(btnNewButton_1);
	}
}
