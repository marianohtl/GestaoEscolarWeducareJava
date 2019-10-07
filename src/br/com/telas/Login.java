package br.com.telas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import br.com.dal.ModuloConexao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JPasswordField;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtEmail;
	// classes, objetos e - Variáveis para trabalhar o MySQL)
	// ========================================================================================================================
	Connection conexao = null; // conexão
	PreparedStatement pst = null; // executar uma query(script) SQL
	ResultSet rs = null; // "trazer"os dados
	private JLabel lblStatus;
	private JPasswordField txtSenha;
	// ========================================================================================================================

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	/**
	 * Create the dialog.
	 */
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/br/com/icons/logo_colnovagalax-32.png")));
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Login");
		setBounds(100, 100, 413, 246);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("E-MAIL:");
			lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblNewLabel.setBounds(56, 44, 46, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("SENHA:");
			lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(56, 94, 46, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			txtEmail = new JTextField();
			txtEmail.setBounds(112, 39, 240, 24);
			contentPanel.add(txtEmail);
			txtEmail.setColumns(10);
		}
		{
			lblStatus = new JLabel(".");
			lblStatus.setIcon(new ImageIcon(Login.class.getResource("/br/com/icons/fail.png")));
			lblStatus.setBounds(312, 125, 70, 70);
			contentPanel.add(lblStatus);
		}
		{
			JButton btnLogar = new JButton("LOGAR");
			btnLogar.setFont(new Font("Tahoma", Font.PLAIN, 13));
			
			btnLogar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					logar();
				}
			});
			btnLogar.setBounds(47, 155, 78, 30);
			contentPanel.add(btnLogar);
			btnLogar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		}
		{
			txtSenha = new JPasswordField();
			txtSenha.setFont(new Font("Calibri", Font.PLAIN, 14));
			txtSenha.setBounds(112, 90, 240, 24);
			contentPanel.add(txtSenha);
		}
		
		// estabelecendo a conexão com o banco
		conexao = ModuloConexao.conector();
		if (conexao != null) {
			System.out.println("CONECTADO");
			lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icons/conectado.png")));
		} else {
			System.out.println("ERRO DE CONEXÃO");
			lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icons/fail.png")));
		}	
	
	}
		
	
public void logar() {
	String read = "select * from tb_dados_funcionarios where emailf=? and senhaf=?";
	try {
		pst = conexao.prepareStatement(read);
		pst.setString(1, txtEmail.getText());
		pst.setString(2, txtSenha.getText());
		// linha que faz a pesquisa
		rs = pst.executeQuery();
		if (rs.next()) {
			Principal principal = new Principal();
			// centralizando e abrindo a tela
			principal.setLocationRelativeTo(null);
			principal.setVisible(true);
			this.dispose();
		//	conexao.close();
		} else {
			JOptionPane.showMessageDialog(null, "Usuário e/ou senha incorretos.");
			txtEmail.setText(null);
			txtSenha.setText(null);
		}
	} catch (Exception e) {
		System.out.println(e);
		}
	}
}

