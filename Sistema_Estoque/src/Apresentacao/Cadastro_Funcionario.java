package Apresentacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Persistencia.Conexao_BD;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Cadastro_Funcionario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

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
		setBounds(100, 100, 600, 500);
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
		lblNewLabel_5.setBounds(28, 45, 45, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Senha: ");
		lblNewLabel_6.setBounds(28, 78, 45, 13);
		contentPane.add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(83, 42, 216, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(83, 75, 216, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
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
			public void actionPerformed(ActionEvent e) {
				try 
				{
					Conexao_BD con = new Conexao_BD();
					
					String query = "INSERT INTO administrador (nome, cidade, email, tel, Cpf, login, senha) VALUES (? ,? ,?, ?, ?, ?, ?)";
					
					PreparedStatement stmt = con.conectar().prepareStatement(query);
					
					stmt.setString(1, textField.getText());
					stmt.setString(2, textField_1.getText());
					stmt.setString(3, textField_2.getText());
					stmt.setString(4, textField_3.getText());
					stmt.setString(5, textField_4.getText());
					stmt.setString(6, textField_5.getText());
					stmt.setString(7, textField_6.getText());
					
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
	}

}
