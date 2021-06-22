package Apresentacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Persistencia.Conexao_BD;

import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Cadastro_Fornecedor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

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
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome: ");
		lblNewLabel.setBounds(45, 55, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cidade: ");
		lblNewLabel_1.setBounds(45, 92, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("email: ");
		lblNewLabel_2.setBounds(45, 128, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("tel: ");
		lblNewLabel_3.setBounds(45, 173, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Cnpj: ");
		lblNewLabel_4.setBounds(45, 207, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(93, 204, 217, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(93, 170, 217, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(93, 125, 217, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(93, 89, 217, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(93, 52, 217, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					Conexao_BD con = new Conexao_BD();
					
					String query = "INSERT INTO fornecedor (nome, cidade, email, tel, Cnpj) VALUES (?, ?, ?, ?, ?)";
					
					PreparedStatement stmt = con.conectar().prepareStatement(query);
					
					stmt.setString(1, textField.getText());
					stmt.setString(2, textField_1.getText());
					stmt.setString(3, textField_2.getText());
					stmt.setString(4, textField_3.getText());
					stmt.setString(5, textField_4.getText());
					
					stmt.executeUpdate();
					stmt.close();
					
					System.out.println("Dados do fornecedor preenchidos.");
					System.out.println("Conection closed...");
					
				}catch (Exception x) {
					System.err.println("Erro ao conectar !" + x.getMessage());
				}
				
				
			}
		});
		btnNewButton.setBounds(93, 294, 104, 34);
		contentPane.add(btnNewButton);
	}
}
