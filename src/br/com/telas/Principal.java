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

public class Principal extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Principal dialog = new Principal();
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
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/br/com/icons/logo_colnovagalax-32.png")));
		getContentPane().setFont(new Font("Calibri", Font.PLAIN, 12));
		getContentPane().setLayout(null);
		{
			JButton btnNotas = new JButton("");
			btnNotas.setToolTipText("Notas");
			btnNotas.setIcon(new ImageIcon(Principal.class.getResource("/br/com/icons/icone_notas.png")));
			btnNotas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				Notas notas = new Notas();
				notas.setVisible(true);
				}
			});
			btnNotas.setBounds(385, 22, 137, 137);
			btnNotas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
			getContentPane().add(btnNotas);
		}
		{
			JButton btnAtividades = new JButton("");
			btnAtividades.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Atividades atividades = new Atividades();
					atividades.setVisible(true);
				}
			});
			btnAtividades.setToolTipText("Atividades");
			btnAtividades.setIcon(new ImageIcon(Principal.class.getResource("/br/com/icons/botao_atividade.png")));
			btnAtividades.setBounds(385, 231, 137, 137);
			btnAtividades.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
			getContentPane().add(btnAtividades);
		}
		{
			JButton btnTurmas = new JButton("");
			btnTurmas.setToolTipText("Turma");
			btnTurmas.setIcon(new ImageIcon(Principal.class.getResource("/br/com/icons/botao_turmas.png")));
			btnTurmas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				Turmas turmas = new Turmas();
				turmas.setVisible(true);
				}
			});
			btnTurmas.setBounds(209, 108, 137, 137);
			btnTurmas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
			getContentPane().add(btnTurmas);
		}
		{
			JButton btnDocentes = new JButton("");
			btnDocentes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				FuncionariosCadastrados docentes = new FuncionariosCadastrados();
				docentes.setLocationRelativeTo(null);					//centralizando a tela
				docentes.setVisible(true);
				}
			});
			btnDocentes.setToolTipText("Docentes");
			btnDocentes.setIcon(new ImageIcon(Principal.class.getResource("/br/com/icons/ICON_Professor_botao.png")));
			btnDocentes.setBounds(38, 22, 137, 137);
			btnDocentes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
			getContentPane().add(btnDocentes);
		}
		{
			JButton btnAlunos = new JButton("");
			btnAlunos.setToolTipText("Alunos");
			btnAlunos.setIcon(new ImageIcon(Principal.class.getResource("/br/com/icons/botao_alunos.png")));
			btnAlunos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AlunosCadastro alunos = new AlunosCadastro();
					alunos.setLocationRelativeTo(null);					//centralizando a tela
					alunos.setVisible(true);
				}
			});
			btnAlunos.setBounds(38, 229, 137, 139);
			btnAlunos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
			getContentPane().add(btnAlunos);
		}
		setTitle("Principal");
		setResizable(false);
		setBounds(100, 100, 560, 427);
	}

}
