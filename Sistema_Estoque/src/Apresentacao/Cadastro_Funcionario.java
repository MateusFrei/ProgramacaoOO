package Apresentacao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Persistencia.Conexao_BD;
import Persistencia.Funcionario_BD;
import Sistema_Controle_Estoque.Administrador;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Cadastro_Funcionario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro_Funcionario frame = new Cadastro_Funcionario();
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
	public Cadastro_Funcionario() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 665, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome: ");
		lblNewLabel.setBounds(28, 112, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cidade: ");
		lblNewLabel_1.setBounds(28, 226, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email: ");
		lblNewLabel_2.setBounds(28, 186, 45, 19);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tel: ");
		lblNewLabel_3.setBounds(28, 263, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Cpf: ");
		lblNewLabel_4.setBounds(28, 151, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Login: ");
		lblNewLabel_5.setBounds(28, 27, 45, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Senha: ");
		lblNewLabel_6.setBounds(28, 78, 45, 13);
		contentPane.add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(83, 24, 216, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(83, 109, 216, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(83, 148, 216, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(83, 186, 216, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(83, 223, 216, 19);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(83, 260, 216, 19);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try 
				{
					Conexao_BD con = new Conexao_BD();
					
					String query = "INSERT INTO administrador (nome, cidade, email, tel, Cpf, login, senha) VALUES (? ,? ,?, ?, ?, ?, ?)";
					
					PreparedStatement stmt = con.conectar().prepareStatement(query);
					
					stmt.setString(1, textField.getText());
					stmt.setString(2, textField_2.getText());
					stmt.setString(3, textField_3.getText());
					stmt.setString(4, textField_4.getText());
					stmt.setString(5, textField_5.getText());
					stmt.setString(6, textField_6.getText());
					stmt.setString(7, passwordField.getText());
					stmt.executeUpdate();
					stmt.close();
					
					System.out.println("Dados do funcionario preenchidos. ");
					System.out.println("Conection closed...");
					
				}catch (Exception x) {
					System.err.println("Erro ao conectar !" + x.getMessage());
				}
				
			}
		});
		btnNewButton.setBounds(42, 339, 126, 27);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(83, 75, 216, 19);
		contentPane.add(passwordField);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(28, 376, 508, 86);
		contentPane.add(textArea);
		
		JButton btnNewButton_1 = new JButton("Listar Funcionario");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Conexao_BD conecta = new Conexao_BD();
					
					Funcionario_BD adm = new Funcionario_BD();
					
					
					ArrayList<Administrador> lista = adm.listar_Funcionario();
					
					
					if(lista != null)
					{
						textArea.setText("");
						for(Administrador c : lista)
						{
							
							textArea.setText(textArea.getText() + c.getNome() +" - " + c.getCidade() + " - " + c.getEmail() + " - "+ c.getTelefone() +" - "+ c.getCpf() +" - "+ c.getLogin()+ "\n");
							
						}
					}
					conecta.fechar_conexao();
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton_1.setBounds(191, 339, 126, 27);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Buscar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Conexao_BD conecta = new Conexao_BD();
					
					Funcionario_BD adm = new Funcionario_BD();
					
					
					ArrayList<Administrador> lista = adm.Buscar_Adm(textField.getText());
					
					
					if(lista != null)
					{
						textArea.setText("");
						for(Administrador c : lista)
						{
							
							textField.setText("" + c.getLogin());
							passwordField.setText("" + c.getSenha());
							textField_2.setText("" + c.getEmail());
							textField_3.setText("" + c.getTelefone());
							textField_4.setText("" + c.getNome());
							textField_5.setText("" + c.getCidade());
							textField_6.setText("" + c.getCpf());
							
							
						}
					}
					conecta.fechar_conexao();
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_2.setBounds(83, 44, 85, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Demitir");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				Administrador adm = new Administrador(textField.getText(), textField_2.getText(), textField_3.getText(), textField_4.getText() , textField_5.getText(), textField_6.getText(), passwordField.getText());
				
				Funcionario_BD dao = new Funcionario_BD();
				
				dao.deletar_adm(adm);
				
			}
		});
		btnNewButton_2_1.setBounds(178, 44, 85, 21);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_3 = new JButton("Editar info.");
		btnNewButton_3.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Conexao_BD conecta = new Conexao_BD();									
					
					String nome = textField.getText();
					String cidade = textField_2.getText();
					String email = textField_3.getText(); 
					String telefone = textField_4.getText();
					String Cpf = textField_6.getText();
					String login = textField_5.getText();
					String password = passwordField.getText();
					
					String querySQL = "UPDATE sistema_controle_estoque.administrador SET `cidade` = ?, `email` = ?,  `tel` = ?, `Cpf` = ?,`login` = ?, `senha` = ? WHERE nome = ? ";
					
					PreparedStatement stmt = conecta.conectar().prepareStatement(querySQL);
					
					stmt.setString(1, cidade);
					stmt.setString(2, email);
					stmt.setString(3, telefone);
					stmt.setString(4, Cpf);
					stmt.setString(5, login);
					stmt.setString(6, password);
					stmt.setString(7, nome);
										
					int rowsAffected = stmt.executeUpdate();
					System.out.println("Atualizado :"+ rowsAffected+" linha(s)");
					
					System.out.println("Funcionario Cadastrado com Sucesso!!!");
					
					//FECHA O COMANDO STMT E A CONEXÃO
					stmt.close();
					conecta.fechar_conexao();
					System.out.println("Conexão Encerrada Com Sucesso!!!");
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
			}
				
		});
		btnNewButton_3.setBounds(342, 342, 126, 21);
		contentPane.add(btnNewButton_3);	

	}
}
