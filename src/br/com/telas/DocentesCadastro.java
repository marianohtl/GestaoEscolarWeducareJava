package br.com.telas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class DocentesCadastro extends JDialog {
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtCep;
	private JTextField txtEndereco;
	private JTextField txtNascimento;
	private JTextField txtTelefone;
	private JTextField txtSalario;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DocentesCadastro dialog = new DocentesCadastro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DocentesCadastro() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DocentesCadastro.class.getResource("/br/com/icons/logo_colnovagalax-32.png")));
		setTitle("Docentes");
		setModal(true);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NOME COMPLETO:");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewLabel.setBounds(39, 228, 98, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CPF:");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(112, 257, 21, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("RG:");
		lblNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(389, 257, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CEP:");
		lblNewLabel_3.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(112, 287, 21, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ENDERE\u00C7O:");
		lblNewLabel_4.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(75, 318, 64, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("DATA DE NASCIMENTO:");
		lblNewLabel_5.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(480, 228, 130, 14);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("TELEFONE:");
		lblNewLabel_6.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(344, 375, 64, 14);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("TELEFONE 2:");
		lblNewLabel_7.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(344, 410, 64, 14);
		getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("SAL\u00C1RIO:");
		lblNewLabel_8.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewLabel_8.setBounds(86, 391, 53, 14);
		getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("CARGA HOR\u00C1RIA:");
		lblNewLabel_9.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewLabel_9.setBounds(48, 416, 98, 14);
		getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_11 = new JLabel("DATA DE CADASTRO:");
		lblNewLabel_11.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewLabel_11.setBounds(36, 353, 114, 14);
		getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("FOTO DO DOCENTE:");
		lblNewLabel_12.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewLabel_12.setBounds(638, 287, 108, 14);
		getContentPane().add(lblNewLabel_12);
		
		txtNome = new JTextField();
		txtNome.setBounds(176, 224, 250, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(176, 253, 130, 20);
		getContentPane().add(txtCpf);
		txtCpf.setColumns(10);
		
		txtCep = new JTextField();
		txtCep.setBounds(173, 283, 250, 20);
		getContentPane().add(txtCep);
		txtCep.setColumns(10);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(173, 314, 236, 20);
		getContentPane().add(txtEndereco);
		txtEndereco.setColumns(10);
		
		txtNascimento = new JTextField();
		txtNascimento.setBounds(609, 224, 157, 20);
		getContentPane().add(txtNascimento);
		txtNascimento.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(422, 371, 130, 20);
		getContentPane().add(txtTelefone);
		txtTelefone.setColumns(10);
		
		txtSalario = new JTextField();
		txtSalario.setBounds(176, 379, 130, 20);
		getContentPane().add(txtSalario);
		txtSalario.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("Cadastrar Docente*");
		lblNewLabel_13.setFont(new Font("Calibri", Font.PLAIN, 11));
		lblNewLabel_13.setBounds(671, 542, 98, 14);
		getContentPane().add(lblNewLabel_13);
		
		JLabel lblNewLabel_10 = new JLabel("STATUS");
		lblNewLabel_10.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewLabel_10.setBounds(590, 350, 64, 14);
		getContentPane().add(lblNewLabel_10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Calibri", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Desativado", "Ativado"}));
		comboBox.setBounds(646, 347, 120, 20);
		getContentPane().add(comboBox);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(422, 253, 130, 20);
		getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(422, 408, 130, 20);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(176, 410, 130, 20);
		getContentPane().add(textField_2);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(463, 282, 89, 23);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_14 = new JLabel("Pesquisar:");
		lblNewLabel_14.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewLabel_14.setBounds(26, 28, 80, 14);
		getContentPane().add(lblNewLabel_14);
		
		textField_3 = new JTextField();
		textField_3.setBounds(106, 24, 405, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(25, 70, 759, 128);
		getContentPane().add(table);
		
		JLabel lblN = new JLabel("N\u00BA:");
		lblN.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblN.setBounds(491, 317, 21, 14);
		getContentPane().add(lblN);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(518, 314, 33, 20);
		getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(176, 349, 130, 20);
		getContentPane().add(textField_5);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(DocentesCadastro.class.getResource("/br/com/icons/create.png")));
		btnNewButton_1.setBounds(60, 480, 64, 64);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(DocentesCadastro.class.getResource("/br/com/icons/update.png")));
		btnNewButton_2.setBounds(153, 480, 64, 64);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon(DocentesCadastro.class.getResource("/br/com/icons/read.png")));
		btnNewButton_3.setBounds(248, 480, 64, 64);
		getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setIcon(new ImageIcon(DocentesCadastro.class.getResource("/br/com/icons/delete.png")));
		btnNewButton_4.setBounds(344, 480, 64, 64);
		getContentPane().add(btnNewButton_4);
	}
}
