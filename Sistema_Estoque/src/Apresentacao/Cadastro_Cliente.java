package Apresentacao;


import java.awt.EventQueue;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import Persistencia.Cliente_BD;
import Persistencia.Conexao_BD;
import Sistema_Controle_Estoque.Cliente;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Cadastro_Cliente extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnNewButton;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro_Cliente frame = new Cadastro_Cliente();
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
	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	public Cadastro_Cliente() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 979, 623);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Nome: ");
		lblNewLabel_4.setBounds(34, 50, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("Cidade: ");
		lblNewLabel.setBounds(34, 97, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email: ");
		lblNewLabel_1.setBounds(34, 150, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tel: ");
		lblNewLabel_2.setBounds(34, 199, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cpf:");
		lblNewLabel_3.setBounds(34, 242, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(89, 47, 268, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(89, 94, 268, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(89, 147, 268, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(89, 196, 268, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(89, 234, 268, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		btnNewButton = new JButton("Enviar");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				try 
				{
					Conexao_BD con = new Conexao_BD();
					
					String query = "INSERT INTO cliente (nome, cidade, email, tel, Cpf) VALUES (?, ?, ?, ?, ?)";
					
					PreparedStatement stmt = con.conectar().prepareStatement(query);
					
					stmt.setString(1, textField.getText());
					stmt.setString(2, textField_1.getText());
					stmt.setString(3, textField_2.getText());
					stmt.setString(4, textField_3.getText());
					stmt.setString(5, textField_4.getText());
					
					stmt.executeUpdate();
					stmt.close();
					
					System.out.println("Dados do cliente preenchidos.");
					System.out.println("Conection closed...");
					
				}catch (Exception x) {
					System.err.println("Erro ao conectar !" + x.getMessage());
				}
				
				
			}
		});
		

		
		btnNewButton.setBounds(89, 296, 105, 34);
		contentPane.add(btnNewButton);

		
		DefaultListModel model;
		model = new DefaultListModel();
		
		try {
			Conexao_BD conecta = new Conexao_BD();
			
			Cliente_BD cliente_bd = new Cliente_BD();
			
			
			ArrayList<Cliente> lista = cliente_bd.listar_Cliente();
			
			if(lista != null)
			{
					
					for (Cliente c : lista)
					{
						model.addElement(c.getNome() + " - " + c.getCidade()+ " - " +c.getEmail()+ " - " +c.getTelefone()+ " - " +c.getCpf());
					}					
			}
			conecta.fechar_conexao();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		
		JList list = new JList(model);
		list.setBounds(691, 78, 239, 206);
		contentPane.add(list);
		
		JTextArea textArea = new JTextArea();
		textArea.setColumns(35);
		textArea.setRows(30);
		textArea.setBounds(34, 403, 720, 173);
		contentPane.add(textArea);
		
		
		
		JButton btnNewButton_1 = new JButton("Listar Cadastros");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Conexao_BD conecta = new Conexao_BD();
					
					Cliente_BD cliente_bd = new Cliente_BD();
					
					
					ArrayList<Cliente> lista = cliente_bd.listar_Cliente();
					
					
					if(lista != null)
					{
						textArea.setText("");
						for(Cliente c : lista)
						{
							
							textArea.setText(textArea.getText() + c.getNome() +" - " + c.getCidade() + " - " + c.getEmail() + " - "+ c.getTelefone() +" - "+ c.getCpf()+ "\n");
							
						}
					}
					conecta.fechar_conexao();
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton_1.setBounds(204, 296, 107, 34);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_5 = new JLabel("Buscas");
		lblNewLabel_5.setBounds(691, 43, 134, 26);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton_1_1 = new JButton("Buscar Cliente");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Conexao_BD conecta = new Conexao_BD();
					
					Cliente_BD cliente_bd = new Cliente_BD();
					
					
					ArrayList<Cliente> lista = cliente_bd.Buscar_Cliente(textField.getText());
					
					
					if(lista != null)
					{
						textArea.setText("");
						for(Cliente c : lista)
						{
							
							textField.setText("" + c.getNome());
							textField_1.setText("" + c.getCidade());
							textField_2.setText("" + c.getEmail());
							textField_3.setText("" + c.getTelefone());
							textField_4.setText("" + c.getCpf());
							
						}
					}
					conecta.fechar_conexao();
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1_1.setBounds(701, 296, 121, 34);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_2 = new JButton("Atualizar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Conexao_BD conecta = new Conexao_BD();									
					
					String nome = textField.getText();
					String cidade = textField_1.getText();
					String email = textField_2.getText(); 
					String telefone = textField_3.getText();
					String Cpf = textField_4.getText();
					
					String querySQL = "UPDATE sistema_controle_estoque.cliente SET `nome` = ?, `cidade` = ?, `email` = ?,  `telefone` = ?, `cpf` = ? WHERE nome = ? ";
					
					PreparedStatement stmt = conecta.conectar().prepareStatement(querySQL);
					
					stmt.setString(1, nome);
					stmt.setString(2, cidade);
					stmt.setString(3, email);
					stmt.setString(4, telefone);
					stmt.setString(5, Cpf);
					
					
					
					
					int rowsAffected = stmt.executeUpdate();
					System.out.println("Atualizado :"+ rowsAffected+" linha(s)");
					
					System.out.println("Cliente Cadastrado com Sucesso!!!");
					
					//FECHA O COMANDO STMT E A CONEXÃO
					stmt.close();
					conecta.fechar_conexao();
					System.out.println("Conexão Encerrada Com Sucesso!!!");
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
			}
			
		});
		btnNewButton_2.setBounds(321, 296, 91, 34);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Limpar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
			}
		});
		btnNewButton_3.setBounds(422, 296, 91, 34);
		contentPane.add(btnNewButton_3);


	}
}
