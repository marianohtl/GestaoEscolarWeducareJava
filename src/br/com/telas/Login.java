package br.com.telas;

//import static br.com.telas.Principal.txtTeste;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import br.com.dal.ModuloConexao;
//import br.com.infox.telas.Principal;

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
import javax.swing.SwingConstants;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsuario;
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
			dialog.setLocationRelativeTo(null);
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
		setBounds(100, 100, 669, 359);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Login:");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
			lblNewLabel.setBounds(84, 153, 109, 36);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Senha:");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 18));
			lblNewLabel_1.setBounds(84, 210, 114, 36);
			contentPanel.add(lblNewLabel_1);
		}
		{
			txtUsuario = new JTextField();
			txtUsuario.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
			txtUsuario.setBounds(208, 151, 289, 38);
			contentPanel.add(txtUsuario);
			txtUsuario.setColumns(10);
		}
		{
			lblStatus = new JLabel(".");
			lblStatus.setIcon(new ImageIcon(Login.class.getResource("/br/com/icons/dberror.png")));
			lblStatus.setBounds(549, 172, 36, 36);
			contentPanel.add(lblStatus);
		}
		{
			JButton btnLogar = new JButton("LOGAR");
			
			btnLogar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					logar();
				}
			});
			btnLogar.setBounds(293, 269, 100, 30);
			contentPanel.add(btnLogar);
			btnLogar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		}
		
		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		txtSenha.setBounds(208, 210, 289, 36);
		contentPanel.add(txtSenha);
		
		JLabel lblNewLabel_2 = new JLabel("Bem Vindo ao Weducare");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 28));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(76, 27, 506, 92);
		contentPanel.add(lblNewLabel_2);
		
		// estabelecendo a conexão com o banco
		conexao = ModuloConexao.conector();
		if (conexao != null) {
			System.out.println("CONECTADO");
			lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icons/dbok.png")));
		} else {
			System.out.println("ERRO DE CONEXÃO");
			lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icons/dberror.png")));
		}	
	
	}
		
	
public void logar() {
	String read = "select * from tb_dados_funcionarios where emailf=? and senhaf=?";
	try {
		pst = conexao.prepareStatement(read);
		pst.setString(1, txtUsuario.getText());
		pst.setString(2, txtSenha.getText());
		// linha que faz a pesquisa
		rs = pst.executeQuery();
		if (rs.next()) {
			
			// a linha abaixo obtem o conteúdo do campo perfil da tabela do banco de dados
			String perfil = rs.getString(15);
			String nome = rs.getString(2);
			// tratamento do perfil
			if (perfil.equals("ADMIN")) {
			
				Principal principal = new Principal();
				principal.setLocationRelativeTo(null);
				principal.setVisible(true);
//				Atividades.txtProfAtiv.setText(nome);
//				Atividades.lblTeste.setText(rs.getString(2));
				//principal.lblId.setText(rs.getString(1));
				principal.lblNomeUsuario.setText(rs.getString(2));
				dispose();
				
			} else if(perfil.equals("PROFESSOR")){
				Principal principal = new Principal();
				principal.setLocationRelativeTo(null);
				principal.setVisible(true);
				principal.btnTurmas.setEnabled(false);
				principal.btnAlunos.setEnabled(false);
				principal.btnDocentes.setEnabled(false);
				//principal.lblId.setText(rs.getString(1));
				principal.lblNomeUsuario.setText(rs.getString(2));
				dispose();
				
				

			} else {
				
				
				Principal principal = new Principal();
				principal.setLocationRelativeTo(null);
				principal.setVisible(true);
				principal.btnAtividades.setEnabled(false);
				principal.btnNotas.setEnabled(false);
				//principal.lblId.setText(rs.getString(1));
				principal.lblNomeUsuario.setText(rs.getString(2));
				dispose();
			}

		} else {
			JOptionPane.showMessageDialog(null, "Usuário e/ou senha incorretos.");
			txtUsuario.setText(null);
			txtSenha.setText(null);
		}
		
	} catch (Exception e) {
		System.out.println(e);
		}
	}
}

