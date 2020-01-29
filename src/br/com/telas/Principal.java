package br.com.telas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.util.Date;

public class Principal extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Principal dialog = new Principal();
			//bota a tela no meio
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
	public Principal() {
		setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				nomeUsuario();
				alterarLabel();
			}
		});
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/br/com/icons/logo_colnovagalax-32.png")));
		getContentPane().setFont(new Font("Calibri", Font.PLAIN, 12));
		getContentPane().setLayout(null);
		{
			btnNotas = new JButton("");
			btnNotas.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 22));
			btnNotas.setToolTipText("Notas");
			btnNotas.setIcon(new ImageIcon(Principal.class.getResource("/br/com/icons/icone_notas.png")));
			btnNotas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				Notas notas = new Notas();
				notas.txtProf.setText(lblNomeUsuario.getText());
				notas.setVisible(true);
				}
			});
			btnNotas.setBounds(1101, 474, 324, 137);
			btnNotas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
			getContentPane().add(btnNotas);
		}
		{
			btnAtividades = new JButton("");
			btnAtividades.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 22));
			btnAtividades.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Atividades atividades = new Atividades();
					atividades.txtProfAtiv.setText(lblNomeUsuario.getText());
					atividades.setVisible(true);
				}
			});
			btnAtividades.setToolTipText("Atividades");
			btnAtividades.setIcon(new ImageIcon(Principal.class.getResource("/br/com/icons/botao_atividade.png")));
			btnAtividades.setBounds(573, 232, 343, 137);
			btnAtividades.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
			getContentPane().add(btnAtividades);
		}
		{
			btnTurmas = new JButton("");
			btnTurmas.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 22));
			btnTurmas.setToolTipText("Turma");
			btnTurmas.setIcon(new ImageIcon(Principal.class.getResource("/br/com/icons/botao_turmas.png")));
			btnTurmas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				Turmas turmas = new Turmas();
				turmas.setVisible(true);
				}
			});
			btnTurmas.setBounds(583, 474, 333, 137);
			btnTurmas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
			getContentPane().add(btnTurmas);
		}
		{
			btnDocentes = new JButton("");
			btnDocentes.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 22));
			btnDocentes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FuncionariosCadastrados docentes = new FuncionariosCadastrados();
					docentes.setLocationRelativeTo(null);					//centralizando a tela
					docentes.setVisible(true);
					}
			});
			btnDocentes.setToolTipText("Docentes");
			btnDocentes.setIcon(new ImageIcon(Principal.class.getResource("/br/com/icons/ICON_Professor_botao.png")));
			btnDocentes.setBounds(51, 232, 340, 137);
			btnDocentes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
			getContentPane().add(btnDocentes);
		}
		{
			btnAlunos = new JButton("");
			btnAlunos.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 22));
			btnAlunos.setToolTipText("Alunos");
			btnAlunos.setIcon(new ImageIcon(Principal.class.getResource("/br/com/icons/botao_alunos.png")));
			btnAlunos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					AlunosCadastro alunos = new AlunosCadastro();
					alunos.setLocationRelativeTo(null);
					alunos.setVisible(true);
				}
			});
			btnAlunos.setBounds(51, 473, 343, 139);
			btnAlunos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
			getContentPane().add(btnAlunos);
		}
		{
			lblNomeUsuario = new JLabel("x");
			lblNomeUsuario.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 26));
			lblNomeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
			lblNomeUsuario.setBounds(808, 23, 553, 37);
			getContentPane().add(lblNomeUsuario);
		}
		
		lblData = new JLabel("x");
		lblData.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 24));
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setBounds(825, 89, 536, 42);
		getContentPane().add(lblData);
		
		JButton btnRelatorios = new JButton("");
		btnRelatorios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RelatoriosAlunosTurmas relatorios = new RelatoriosAlunosTurmas();
				relatorios.setLocationRelativeTo(null);
				relatorios.setVisible(true);
			}
		});
		btnRelatorios.setIcon(new ImageIcon(Principal.class.getResource("/br/com/icons/report os.png")));
		btnRelatorios.setToolTipText("Notas");
		btnRelatorios.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 22));
		btnRelatorios.setBounds(1101, 232, 324, 137);
		getContentPane().add(btnRelatorios);
		{
			lblNewLabel = new JLabel("Sistema de Gest\u00E3o");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 34));
			lblNewLabel.setBounds(51, 10, 430, 122);
			getContentPane().add(lblNewLabel);
		}
		{
			lblWeducare = new JLabel("WEDUCARE");
			lblWeducare.setHorizontalAlignment(SwingConstants.CENTER);
			lblWeducare.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 34));
			lblWeducare.setBounds(456, 10, 315, 122);
			getContentPane().add(lblWeducare);
		}
		
		btnSobre = new JButton("");
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre sobre = new Sobre();
				sobre.setLocationRelativeTo(null);
				sobre.setVisible(true);
			}
		});
		btnSobre.setIcon(new ImageIcon(Principal.class.getResource("/br/com/icons/pergunta-questao (2).png")));
		btnSobre.setBounds(1395, 38, 85, 73);
		getContentPane().add(btnSobre);
		
		JLabel lblNewLabel_1 = new JLabel("Funcionarios");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel_1.setBounds(51, 188, 340, 34);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblAlunos = new JLabel("Alunos");
		lblAlunos.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlunos.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 24));
		lblAlunos.setBounds(51, 432, 340, 34);
		getContentPane().add(lblAlunos);
		
		JLabel lblTurmas = new JLabel("Turmas");
		lblTurmas.setHorizontalAlignment(SwingConstants.CENTER);
		lblTurmas.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 24));
		lblTurmas.setBounds(573, 430, 340, 34);
		getContentPane().add(lblTurmas);
		
		JLabel lblAtividades = new JLabel("Atividades");
		lblAtividades.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtividades.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 24));
		lblAtividades.setBounds(573, 186, 340, 34);
		getContentPane().add(lblAtividades);
		
		JLabel lblNotas = new JLabel("Notas");
		lblNotas.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotas.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 24));
		lblNotas.setBounds(1088, 430, 340, 34);
		getContentPane().add(lblNotas);
		
		JLabel lblRelatorios = new JLabel("Relat\u00F3rios");
		lblRelatorios.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelatorios.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 24));
		lblRelatorios.setBounds(1088, 186, 340, 34);
		getContentPane().add(lblRelatorios);
		setTitle("Principal");
		setResizable(false);
		setBounds(100, 100, 1514, 780);
	}
	
	private void nomeUsuario() {
		String usuario = lblNomeUsuario.getText();
	}
	
	private void alterarLabel() {
		Date data = new Date();
		DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
		lblData.setText(formatador.format(data));
	}
	
	String testeteste = null;
	JButton btnTurmas;
	JButton btnDocentes;
	JButton btnAlunos;
	JButton btnNotas;
	JButton btnAtividades;
	JLabel lblNomeUsuario;
	private JLabel lblData;
	private JLabel lblNewLabel;
	private JLabel lblWeducare;
	private JButton btnSobre;
}
