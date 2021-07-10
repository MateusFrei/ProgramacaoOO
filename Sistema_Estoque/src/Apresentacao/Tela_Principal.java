package Apresentacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Toolkit;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Tela_Principal extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Principal frame = new Tela_Principal();
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
	public Tela_Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tela_Principal.class.getResource("/imagens/estoque.png")));
		setResizable(false);
		setSize(900,600);
		setLocationRelativeTo(null);
		getContentPane().setForeground(Color.WHITE);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		
		JPanel panel = new JPanel();
		
		
		getContentPane().add(panel,BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JMenuBar MenuBar = new JMenuBar();
		panel.add(MenuBar);
		
		JMenu mnNewMenu = new JMenu("Cadastro");
		MenuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Cliente");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro_Cliente cadCliente = new Cadastro_Cliente();
				cadCliente.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Fornecedor");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro_Fornecedor cadFornecedor = new Cadastro_Fornecedor();
				cadFornecedor.setVisible(true);
			}
		});
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Administrador");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro_Funcionario cadFuncionario = new Cadastro_Funcionario();
				cadFuncionario.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_4);
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuBar menuBar = new JMenuBar();
		MenuBar.add(menuBar);
		
		JMenu mnNewMenu_1 = new JMenu("Estoque");
		MenuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Consultar Estoque");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_Estoque estoca = new Tela_Estoque();
				estoca.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Vendas");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_Vendas vende = new Tela_Vendas();
				vende.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Tela_Principal.class.getResource("/imagens/Wallpaper2.jpg")));
		lblNewLabel.setBounds(0, 0, 896, 540);
		panel_1.add(lblNewLabel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
