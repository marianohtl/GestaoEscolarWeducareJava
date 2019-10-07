package br.com.telas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.dal.ModuloConexao;

import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

public class RelatoriosAlunosTurmas extends JDialog {
	private final ButtonGroup buttonGroup1 = new ButtonGroup();
	private JLabel lblUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RelatoriosAlunosTurmas dialog = new RelatoriosAlunosTurmas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	public RelatoriosAlunosTurmas() {
		
		
		setTitle("Relatorios");
		setBounds(100, 100, 591, 479);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Selecione de quem deseja gerar o relat\u00F3rio das notas:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 50, 555, 35);
		getContentPane().add(lblNewLabel);
		
		JRadioButton btnTurma = new JRadioButton("Turma:");
		btnTurma.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 16));
		buttonGroup1.add(btnTurma);
		btnTurma.setBounds(20, 102, 92, 46);
		getContentPane().add(btnTurma);
		
		JRadioButton btnAluno = new JRadioButton("Aluno:");
		btnAluno.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 16));
		buttonGroup1.add(btnAluno);
		btnAluno.setBounds(20, 192, 92, 46);
		getContentPane().add(btnAluno);
		
		JLabel lblNewLabel_1 = new JLabel("Ol\u00E1 Professor(a)");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 11, 166, 28);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblPorFavor = new JLabel(", por favor,");
		lblPorFavor.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblPorFavor.setBounds(439, 11, 126, 28);
		getContentPane().add(lblPorFavor);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "Ano Letivo"}));
		comboBox.setBounds(471, 117, 94, 22);
		getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Gerar Relatorio");
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		btnNewButton.setBounds(167, 310, 195, 86);
		getContentPane().add(btnNewButton);
		
		lblUser = new JLabel("admin teste");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblUser.setBounds(186, 18, 243, 21);
		getContentPane().add(lblUser);
		conexao = ModuloConexao.conector();
	}
}
