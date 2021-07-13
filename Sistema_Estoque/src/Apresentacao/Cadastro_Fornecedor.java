package Apresentacao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Persistencia.Conexao_BD;
import Persistencia.Fornecedor_BD;
import Sistema_Controle_Estoque.Fornecedor;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Cadastro_Fornecedor extends JFrame {

	private JPanel contentPane;
	private JTextField txt_cnpj;
	private JTextField txt_tel;
	private JTextField txt_email;
	private JTextField txt_cidade;
	private JTextField txt_nome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro_Fornecedor frame = new Cadastro_Fornecedor();
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
	public Cadastro_Fornecedor() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 733, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome: ");
		lblNewLabel.setBounds(45, 61, 45, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cidade: ");
		lblNewLabel_1.setBounds(45, 122, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("email: ");
		lblNewLabel_2.setBounds(45, 161, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("tel: ");
		lblNewLabel_3.setBounds(45, 206, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Cnpj: ");
		lblNewLabel_4.setBounds(45, 249, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		txt_cnpj = new JTextField();
		txt_cnpj.setBounds(93, 246, 217, 19);
		contentPane.add(txt_cnpj);
		txt_cnpj.setColumns(10);
		
		txt_tel = new JTextField();
		txt_tel.setBounds(93, 203, 217, 19);
		contentPane.add(txt_tel);
		txt_tel.setColumns(10);
		
		txt_email = new JTextField();
		txt_email.setBounds(93, 158, 217, 19);
		contentPane.add(txt_email);
		txt_email.setColumns(10);
		
		txt_cidade = new JTextField();
		txt_cidade.setBounds(93, 119, 217, 19);
		contentPane.add(txt_cidade);
		txt_cidade.setColumns(10);
		
		txt_nome = new JTextField();
		txt_nome.setBounds(93, 61, 217, 19);
		contentPane.add(txt_nome);
		txt_nome.setColumns(10);
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					Conexao_BD con = new Conexao_BD();
					
					String query = "INSERT INTO fornecedor (nome, cidade, email, tel, Cnpj) VALUES (?, ?, ?, ?, ?)";
					
					PreparedStatement stmt = con.conectar().prepareStatement(query);
					
					stmt.setString(5, txt_cnpj.getText());
					stmt.setString(4, txt_tel.getText());
					stmt.setString(3, txt_email.getText());
					stmt.setString(2, txt_cidade.getText());
					stmt.setString(1, txt_nome.getText());
					
					stmt.executeUpdate();
					stmt.close();
					
					con.fechar_conexao();
					System.out.println("Dados do fornecedor preenchidos.");
					System.out.println("Conection closed...");
					
				}catch (Exception x) {
					System.err.println("Erro ao conectar !" + x.getMessage());
				}
				
				
			}
		});
		btnNewButton.setBounds(45, 294, 104, 34);
		contentPane.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(45, 364, 517, 88);
		contentPane.add(textArea);
		
		JButton btnNewButton_1 = new JButton("Relatorio Fornecedores");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Conexao_BD conecta = new Conexao_BD();
					
					Fornecedor_BD dao = new Fornecedor_BD();
					
					
					ArrayList<Fornecedor> lista = dao.listar_Fornecedores();
					
					
					if(lista != null)
					{
						textArea.setText("");
						for(Fornecedor c : lista)
						{
							
							textArea.setText(textArea.getText() + c.getNome() +" - " + c.getCidade() + " - " + c.getEmail() + " - "+ c.getTelefone() +" - "+ c.getCnpj()+ "\n");
							
						}
					}
					conecta.fechar_conexao();
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(159, 294, 151, 34);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Buscar Fornecedor");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Conexao_BD conecta = new Conexao_BD();
					
					Fornecedor_BD dao = new Fornecedor_BD();
					
					
					ArrayList<Fornecedor> lista = dao.Buscar_Fornecedor(txt_nome.getText());
					
					
					if(lista != null)
					{
						textArea.setText("");
						for(Fornecedor c : lista)
						{
							
							txt_nome.setText("" + c.getNome());
							txt_cidade.setText("" + c.getCidade());
							txt_email.setText("" + c.getEmail());
							txt_tel.setText("" + c.getTelefone());
							txt_cnpj.setText("" + c.getCnpj());
							
						}
					}
					conecta.fechar_conexao();
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(93, 90, 147, 19);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Demitir Fornecedor");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Fornecedor forn = new Fornecedor(txt_nome.getText(),txt_cidade.getText() , txt_email.getText(),txt_tel.getText(), txt_cnpj.getText());
				
				Fornecedor_BD dao = new Fornecedor_BD();
				
				dao.deletar_fornecedor(forn);
				
			}
		});
		btnNewButton_2_1.setBounds(250, 90, 153, 19);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnEditarInfo = new JButton("Editar info.");
		btnEditarInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Conexao_BD conecta = new Conexao_BD();									
					
					String nome = txt_nome.getText();
					String cidade = txt_cidade.getText();
					String email = txt_email.getText(); 
					String telefone = txt_tel.getText();
					String Cnpj = txt_cnpj.getText();
					
					String querySQL = "UPDATE sistema_controle_estoque.fornecedor SET `cidade` = ?, `email` = ?,  `tel` = ?, `Cnpj` = ? WHERE nome = ? ";
					
					PreparedStatement stmt = conecta.conectar().prepareStatement(querySQL);
					
					stmt.setString(1, cidade);
					stmt.setString(2, email);
					stmt.setString(3, telefone);
					stmt.setString(4, Cnpj);
					stmt.setString(5, nome);
										
					stmt.executeUpdate();
									
					System.out.println("Cliente Cadastrado com Sucesso!!!");
					
				
					stmt.close();
					conecta.fechar_conexao();
					System.out.println("Conexão Encerrada Com Sucesso!!!");
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
			}
				
		});
		btnEditarInfo.setBounds(322, 294, 104, 34);
		contentPane.add(btnEditarInfo);
		
	}
}
