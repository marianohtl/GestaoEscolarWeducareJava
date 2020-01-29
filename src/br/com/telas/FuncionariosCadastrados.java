package br.com.telas;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.cep.CepWebService;
import br.com.dal.ModuloConexao;
import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JRadioButton;

public class FuncionariosCadastrados extends JDialog {
	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	private JTextField textIdf;
	private JTextField textNomef;
	private JTextField textCpff;
	private JTextField textRgf;
	private JTextField textCepf;
	private JTextField textEnderecof;
	private JTextField textBairrof;
	private JTextField txtCidadef;
	private JComboBox cmbUff;
	private JTextField txtComplementof;
	private JTextField textNumf;
	private JTextField textNascimentof;
	private JTextField textFonef;
	private JTextField textCelf;
	private JComboBox cmbPerfilf;
	private JTextField txtEmailf;
	private JPasswordField txtSenhaf;
	private JTextField textContratof;
	private JTable tblClientes;
	private JTextField txtPesquisar;
	private JLabel lblNewLabel_10;
	private JLabel lblN;
	private JLabel lblStatus;
	private JButton btnBuscar;
	private JLabel lblNewLabel_9;
	private JLabel label;
	private JLabel lblNewLabel_13;
	private JComboBox cboMateria1;
	private JLabel a;
	private JComboBox cboMateria2;
	private JTextField txtGamb;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FuncionariosCadastrados dialog = new FuncionariosCadastrados();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FuncionariosCadastrados() {
		getContentPane().setFont(new Font("Calibri", Font.PLAIN, 14));
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(FuncionariosCadastrados.class.getResource("/br/com/icons/logo_colnovagalax-32.png")));
		setTitle("Funcion\u00E1rios");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 1218, 751);
		getContentPane().setLayout(null);
		

		JLabel lblNewLabel = new JLabel("*NOME COMPLETO:");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel.setBounds(147, 354, 274, 20);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("*CPF:");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(147, 438, 64, 20);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("*RG:");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(456, 438, 85, 17);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("*CEP:");
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(149, 532, 82, 20);
		getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("*ENDERE\u00C7O:");
		lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(570, 532, 128, 20);
		getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("*DATA DE NASCIMENTO:");
		lblNewLabel_5.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(648, 354, 260, 22);
		getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("CELULAR:");
		lblNewLabel_6.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(973, 433, 106, 19);
		getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel_8 = new JLabel("*CONTRATO:");
		lblNewLabel_8.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_8.setBounds(965, 533, 132, 18);
		getContentPane().add(lblNewLabel_8);

		textNomef = new JTextField();
		textNomef.setForeground(Color.BLACK);
		textNomef.setFont(new Font("Verdana", Font.PLAIN, 18));
		textNomef.setBounds(147, 378, 461, 30);
		getContentPane().add(textNomef);
		textNomef.setColumns(10);

		textCpff = new JTextField();
		textCpff.setFont(new Font("Verdana", Font.PLAIN, 18));
		textCpff.setBounds(146, 458, 292, 30);
		getContentPane().add(textCpff);
		textCpff.setColumns(10);

		textCepf = new JTextField();
		textCepf.setFont(new Font("Verdana", Font.PLAIN, 18));
		textCepf.setBounds(146, 553, 260, 30);
		getContentPane().add(textCepf);
		textCepf.setColumns(10);

		textEnderecof = new JTextField();
		textEnderecof.setFont(new Font("Verdana", Font.PLAIN, 18));
		textEnderecof.setColumns(10);
		textEnderecof.setBounds(570, 553, 363, 30);
		getContentPane().add(textEnderecof);

		textRgf = new JTextField();
		textRgf.setFont(new Font("Verdana", Font.PLAIN, 18));
		textRgf.setColumns(10);
		textRgf.setBounds(456, 458, 261, 30);
		getContentPane().add(textRgf);

		textNascimentof = new JTextField();
		textNascimentof.setFont(new Font("Verdana", Font.PLAIN, 18));
		textNascimentof.setColumns(10);
		textNascimentof.setBounds(655, 378, 226, 30);
		getContentPane().add(textNascimentof);

		textContratof = new JTextField();
		textContratof.setFont(new Font("Verdana", Font.PLAIN, 18));
		textContratof.setEnabled(false);
		textContratof.setColumns(10);
		textContratof.setBounds(965, 553, 172, 30);
		getContentPane().add(textContratof);

		textFonef = new JTextField();
		textFonef.setFont(new Font("Verdana", Font.PLAIN, 18));
		textFonef.setColumns(10);
		textFonef.setBounds(746, 460, 187, 30);
		getContentPane().add(textFonef);

		txtPesquisar = new JTextField();
		txtPesquisar.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtPesquisar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pesquisarClientes();
			}
		});
		txtPesquisar.setColumns(10);
		txtPesquisar.setBounds(477, 36, 499, 30);
		getContentPane().add(txtPesquisar);

		lblNewLabel_10 = new JLabel("PESQUISAR FUNCION\u00C1RIOS:");
		lblNewLabel_10.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_10.setBounds(152, 37, 274, 27);
		getContentPane().add(lblNewLabel_10);

		lblN = new JLabel("*BAIRRO:");
		lblN.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblN.setBounds(551, 621, 106, 20);
		getContentPane().add(lblN);

		textBairrof = new JTextField();
		textBairrof.setFont(new Font("Verdana", Font.PLAIN, 18));
		textBairrof.setColumns(10);
		textBairrof.setBounds(551, 643, 226, 30);
		getContentPane().add(textBairrof);

		lblStatus = new JLabel("*PERFIL:");
		lblStatus.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblStatus.setBounds(975, 352, 104, 20);
		getContentPane().add(lblStatus);

		JButton btnAdicionar = new JButton("");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restringirAdd();
				cadastrarUsuario();
			}
		});
		btnAdicionar.setToolTipText("ADICIONAR");
		btnAdicionar.setIcon(new ImageIcon(FuncionariosCadastrados.class.getResource("/br/com/icons/create.png")));
		btnAdicionar.setBounds(26, 75, 80, 80);
		getContentPane().add(btnAdicionar);

		JButton btnModificar = new JButton("");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//restringirAdd();
				alterarUsuario();
			}
		});
		btnModificar.setToolTipText("MODIFICAR");
		btnModificar.setIcon(new ImageIcon(FuncionariosCadastrados.class.getResource("/br/com/icons/update.png")));
		btnModificar.setBounds(26, 253, 80, 80);
		getContentPane().add(btnModificar);

		JButton btnDeletar = new JButton("");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletarClientes();
			}
		});
		btnDeletar.setToolTipText("DELETAR");
		btnDeletar.setIcon(new ImageIcon(FuncionariosCadastrados.class.getResource("/br/com/icons/delete.png")));
		btnDeletar.setBounds(26, 434, 80, 80);
		getContentPane().add(btnDeletar);

		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setEnabled(false);
		btnBuscar.setForeground(Color.DARK_GRAY);
		btnBuscar.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarCep();
			}
		});
		btnBuscar.setToolTipText("BUSCAR");
		btnBuscar.setBounds(412, 552, 129, 30);
		getContentPane().add(btnBuscar);

		lblNewLabel_9 = new JLabel("*Campos Obrigat\u00F3rios");
		lblNewLabel_9.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblNewLabel_9.setBounds(938, 10, 139, 20);
		getContentPane().add(lblNewLabel_9);

		textNumf = new JTextField();
		textNumf.setFont(new Font("Verdana", Font.PLAIN, 18));
		textNumf.setColumns(10);
		textNumf.setBounds(473, 643, 46, 30);
		getContentPane().add(textNumf);

		label = new JLabel("*N\u00BA:");
		label.setFont(new Font("Verdana", Font.PLAIN, 18));
		label.setBounds(473, 621, 46, 20);
		getContentPane().add(label);

		textIdf = new JTextField();
		textIdf.setFont(new Font("Verdana", Font.PLAIN, 18));
		textIdf.setEnabled(false);
		textIdf.setColumns(10);
		textIdf.setBounds(147, 293, 37, 30);
		getContentPane().add(textIdf);

		JLabel label_1 = new JLabel("ID:");
		label_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		label_1.setBounds(149, 267, 37, 20);
		getContentPane().add(label_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(147, 77, 1025, 170);
		getContentPane().add(scrollPane);

		tblClientes = new JTable();
		tblClientes.setFont(new Font("Verdana", Font.PLAIN, 16));
		scrollPane.setViewportView(tblClientes);
		tblClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setarCampos();
				// gamb();
			}
		});
		tblClientes.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));

		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setIcon(new ImageIcon(FuncionariosCadastrados.class.getResource("/br/com/icons/clean.png")));
		btnLimpar.setToolTipText("LIMPAR");
		btnLimpar.setBounds(26, 593, 80, 80);
		getContentPane().add(btnLimpar);

		JLabel lblNewLabel_11 = new JLabel("COMPLEMENTO:");
		lblNewLabel_11.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_11.setBounds(146, 622, 156, 19);
		getContentPane().add(lblNewLabel_11);

		txtComplementof = new JTextField();
		txtComplementof.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtComplementof.setBounds(146, 643, 292, 30);
		getContentPane().add(txtComplementof);
		txtComplementof.setColumns(10);

		JLabel label_2 = new JLabel("*TELEFONE:");
		label_2.setFont(new Font("Verdana", Font.PLAIN, 18));
		label_2.setBounds(750, 434, 132, 20);
		getContentPane().add(label_2);

		textCelf = new JTextField();
		textCelf.setFont(new Font("Verdana", Font.PLAIN, 18));
		textCelf.setBounds(969, 458, 168, 30);
		getContentPane().add(textCelf);
		textCelf.setColumns(10);

		JLabel lblNewLabel_12 = new JLabel("*UF:");
		lblNewLabel_12.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_12.setBounds(1077, 622, 46, 20);
		getContentPane().add(lblNewLabel_12);

		JLabel lblNewLabel_14 = new JLabel("*CIDADE:");
		lblNewLabel_14.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_14.setBounds(813, 623, 187, 16);
		getContentPane().add(lblNewLabel_14);

		cmbUff = new JComboBox();
		cmbUff.setModel(new DefaultComboBoxModel(
				new String[] { "SP", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA",
						"PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "TO" }));
		cmbUff.setFont(new Font("Verdana", Font.PLAIN, 18));
		cmbUff.setBounds(1073, 642, 64, 30);
		getContentPane().add(cmbUff);

		txtCidadef = new JTextField();
		txtCidadef.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtCidadef.setBounds(813, 643, 220, 30);
		getContentPane().add(txtCidadef);
		txtCidadef.setColumns(10);

		txtEmailf = new JTextField();
		txtEmailf.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtEmailf.setBounds(211, 293, 319, 30);
		getContentPane().add(txtEmailf);
		txtEmailf.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("* E-MAIL:");
		lblNewLabel_7.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(210, 270, 128, 17);
		getContentPane().add(lblNewLabel_7);

		cmbPerfilf = new JComboBox();
		cmbPerfilf.setFont(new Font("Verdana", Font.PLAIN, 18));
		cmbPerfilf.setModel(new DefaultComboBoxModel(new String[] { "ADMIN", "PROFESSOR", "DIRETOR" }));
		cmbPerfilf.setBounds(973, 377, 164, 30);
		getContentPane().add(cmbPerfilf);

		lblNewLabel_13 = new JLabel("*SENHA:");
		lblNewLabel_13.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_13.setBounds(552, 267, 114, 17);
		getContentPane().add(lblNewLabel_13);

		txtSenhaf = new JPasswordField();
		txtSenhaf.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtSenhaf.setBounds(551, 290, 185, 30);
		getContentPane().add(txtSenhaf);

		cboMateria1 = new JComboBox();
		cboMateria1.setModel(new DefaultComboBoxModel(new String[] {"", "LINGUA PORTUGUESA", "MATEMATICA", "GEOGRAFIA", "HISTORIA", "FILOSOFIA", "SOCIOLOGIA", "FISICA", "QUIMICA", "ARTES", "EDUCACAO FISICA", "INGLES", "BIOLOGIA"}));
		cboMateria1.setFont(new Font("Verdana", Font.PLAIN, 15));
		cboMateria1.setBounds(765, 288, 185, 30);
		getContentPane().add(cboMateria1);

		JLabel lblmateria = new JLabel("1\u00BA MAT\u00C9RIA:");
		lblmateria.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblmateria.setBounds(765, 267, 128, 19);
		getContentPane().add(lblmateria);

		cboMateria2 = new JComboBox();
		cboMateria2.setModel(new DefaultComboBoxModel(new String[] {"", "LINGUA PORTUGUESA", "MATEMATICA", "GEOGRAFIA", "HISTORIA", "FILOSOFIA", "SOCIOLOGIA", "FISICA", "QUIMICA", "ARTES", "EDUCACAO FISICA", "INGLES", "BIOLOGIA"}));
		cboMateria2.setFont(new Font("Verdana", Font.PLAIN, 15));
		cboMateria2.setBounds(973, 289, 188, 30);
		getContentPane().add(cboMateria2);

		a = new JLabel("2\u00BA MAT\u00C9RIA:");
		a.setFont(new Font("Verdana", Font.PLAIN, 18));
		a.setBounds(973, 267, 124, 20);
		getContentPane().add(a);

		txtGamb = new JTextField();
		txtGamb.setBounds(206, 446, -20, 6);
		getContentPane().add(txtGamb);
		txtGamb.setColumns(10);
		conexao = ModuloConexao.conector();

		if (conexao != null) {
			System.out.println("CONECTADO");
		} else {
			System.out.println("ERRO DE CONEXÃO");
		}
	}
	private void gamb2() {
		txtGamb.setText(null);

	}

	private void gamb() {
		String checarProf = "select * from tb_dados_funcionarios where Cpff like ? or Rgf like ? or nomef = ?";
		String idprof = null;
		try {
			pst = conexao.prepareStatement(checarProf);
			pst.setString(1, textCpff.getText() + "%");
			pst.setString(2, textRgf.getText() + "%");
			pst.setString(3, textNomef.getText() + "%");
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				idprof = rs.getString("idf");
				txtGamb.setText(idprof);
				// JOptionPane.showMessageDialog(null, idprof);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private void deletarClientes() {
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão deste funcionário? ", " ATENÇÃO ",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
			String delete = "delete from tb_dados_funcionarios where idf=?";
			try {
				pst = conexao.prepareStatement(delete);
				pst.setString(1, textIdf.getText());
				int removido = pst.executeUpdate();
				limpar();
				if (removido == 1) {
					JOptionPane.showMessageDialog(null, "Funcionário removido da nossa base de dados.");
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	private void restringirAdd() {
		Double confirmarProfDouble = null;
		String confirmarProf = null;
		// nomef,cpff,rgf,email
		String verificar = "select * from tb_dados_funcionarios where nomef = ? or cpff = ? or rgf = ? or emailf = ?";
		
		

		
		try {

			pst = conexao.prepareStatement(verificar);
			pst.setString(1, textNomef.getText());
			pst.setString(2, textCpff.getText());
			pst.setString(3, textRgf.getText());
			pst.setString(4, txtEmailf.getText());
			rs = (ResultSet) pst.executeQuery();
			while (rs.next()) {
				confirmarProf = rs.getString(1);
				confirmarProfDouble = Double.parseDouble(confirmarProf);

			}
			if (confirmarProfDouble != null) {
				txtGamb.setText(confirmarProf);
			} else {
				txtGamb.setText(null);
					}

				
				} catch (Exception e) {
					System.out.println("Deu ruim :(  " + e);
				}

			}

		

	

	private void cadastrarUsuario() {
		if (((String) cboMateria1.getSelectedItem()).isEmpty() || textNomef.getText().isEmpty()
				|| textCpff.getText().isEmpty() || textRgf.getText().isEmpty() || textCepf.getText().isEmpty()
				|| textEnderecof.getText().isEmpty() || textBairrof.getText().isEmpty()
				|| txtCidadef.getText().isEmpty() || textNumf.getText().isEmpty() || textNascimentof.getText().isEmpty()
				|| textFonef.getText().isEmpty() || txtEmailf.getText().isEmpty() || txtSenhaf.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios");
		} else if (txtGamb.getText().isEmpty()) {
			// insert
			String create = "insert into tb_dados_funcionarios ( nomef, cpff, rgf, cepf, endf, bairrof, cidadef, uff, complementof, numf, nascf, fonef, celf, perfilf, emailf, senhaf,materia1,materia2) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			try {
				pst = conexao.prepareStatement(create);
				pst.setString(1, textNomef.getText());
				pst.setString(2, textCpff.getText());
				pst.setString(3, textRgf.getText());
				pst.setString(4, textCepf.getText());
				pst.setString(5, textEnderecof.getText());
				pst.setString(6, textBairrof.getText());
				pst.setString(7, txtCidadef.getText());
				pst.setString(8, cmbUff.getSelectedItem().toString());
				pst.setString(9, txtComplementof.getText());
				pst.setString(10, textNumf.getText());
				pst.setString(11, textNascimentof.getText());
				pst.setString(12, textFonef.getText());
				pst.setString(13, textCelf.getText());
				pst.setString(14, cmbPerfilf.getSelectedItem().toString());
				pst.setString(15, txtEmailf.getText());
				pst.setString(16, txtSenhaf.getText());
				pst.setString(17, cboMateria1.getSelectedItem().toString());
				pst.setString(18, cboMateria2.getSelectedItem().toString());
				int adicionado = pst.executeUpdate();
				System.out.println(adicionado);
				limpar();

				if (adicionado == 1) {
					JOptionPane.showMessageDialog(null, "Funcionário adicionado com sucesso.");
				} else {
					JOptionPane.showMessageDialog(null, "Não foi possível adicionar este funcionário.");
				}
			} catch (Exception e) {
				System.out.println("Deu ruim :(  " + e);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Ja existe um funcionario cadastrado com esses dados!");
			limpar();
		}
	}

	private void alterarUsuario() {
		if (((String) cboMateria1.getSelectedItem()).isEmpty() || textNomef.getText().isEmpty()
				|| textCpff.getText().isEmpty() || textRgf.getText().isEmpty() || textCepf.getText().isEmpty()
				|| textEnderecof.getText().isEmpty() || textBairrof.getText().isEmpty()
				|| txtCidadef.getText().isEmpty() || textNumf.getText().isEmpty() || textNascimentof.getText().isEmpty()
				|| textFonef.getText().isEmpty() || txtEmailf.getText().isEmpty() || txtSenhaf.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios");
		} else {

			String update = "update tb_dados_funcionarios set nomef=?, cpff=?, rgf=?, cepf=?, endf=?, bairrof=?, cidadef=?, uff=?, complementof=?, numf=?, nascf=?, fonef=?, celf=?, perfilf=?, emailf=?, senhaf=?,materia1=?, materia2=? where idf=?";
			try {
				pst = conexao.prepareStatement(update);
				pst.setString(1, textNomef.getText());
				pst.setString(2, textCpff.getText());
				pst.setString(3, textRgf.getText());
				pst.setString(4, textCepf.getText());
				pst.setString(5, textEnderecof.getText());
				pst.setString(6, textBairrof.getText());
				pst.setString(7, txtCidadef.getText());
				pst.setString(8, cmbUff.getSelectedItem().toString());
				pst.setString(9, txtComplementof.getText());
				pst.setString(10, textNumf.getText());
				pst.setString(11, textNascimentof.getText());
				pst.setString(12, textFonef.getText());
				pst.setString(13, textCelf.getText());
				pst.setString(14, cmbPerfilf.getSelectedItem().toString());
				pst.setString(15, txtEmailf.getText());
				pst.setString(16, txtSenhaf.getText());
				pst.setString(17, cboMateria1.getSelectedItem().toString());
				pst.setString(18, cboMateria2.getSelectedItem().toString());
				pst.setString(19, textIdf.getText());

				int adicionado = pst.executeUpdate();
				limpar();

				if (adicionado == 1) {
					JOptionPane.showMessageDialog(null, "Funcionário alterado com sucesso.");
				} else {
					JOptionPane.showMessageDialog(null, "Não foi possível adicionar o funcionário.");
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	private void limpar() {
		textIdf.setText(null);
		textNomef.setText(null);
		textCpff.setText(null);
		textRgf.setText(null);
		textCepf.setText(null);
		textEnderecof.setText(null);
		textBairrof.setText(null);
		txtCidadef.setText(null);
		cmbUff.setSelectedItem(null);
		txtComplementof.setText(null);
		textNumf.setText(null);
		textNascimentof.setText(null);
		textFonef.setText(null);
		textCelf.setText(null);
		cmbPerfilf.setSelectedItem(null);
		txtEmailf.setText(null);
		txtSenhaf.setText(null);
		textContratof.setText(null);
		cboMateria1.setSelectedItem(null);
		cboMateria2.setSelectedItem(null);
		txtGamb.setText(null);
		limparTabela();
	}

	private void setarCampos() {
		int setar = tblClientes.getSelectedRow();
		textIdf.setText(tblClientes.getModel().getValueAt(setar, 0).toString());
		textNomef.setText(tblClientes.getModel().getValueAt(setar, 1).toString());
		textCpff.setText(tblClientes.getModel().getValueAt(setar, 2).toString());
		textRgf.setText(tblClientes.getModel().getValueAt(setar, 3).toString());
		textCepf.setText(tblClientes.getModel().getValueAt(setar, 4).toString());
		textEnderecof.setText(tblClientes.getModel().getValueAt(setar, 5).toString());
		textBairrof.setText(tblClientes.getModel().getValueAt(setar, 6).toString());
		txtCidadef.setText(tblClientes.getModel().getValueAt(setar, 7).toString());
		cmbUff.setSelectedItem(tblClientes.getModel().getValueAt(setar, 8).toString());
		txtComplementof.setText(tblClientes.getModel().getValueAt(setar, 9).toString());
		textNumf.setText(tblClientes.getModel().getValueAt(setar, 10).toString());
		textNascimentof.setText(tblClientes.getModel().getValueAt(setar, 11).toString());
		textFonef.setText(tblClientes.getModel().getValueAt(setar, 12).toString());
		textCelf.setText(tblClientes.getModel().getValueAt(setar, 13).toString());
		cmbPerfilf.setSelectedItem(tblClientes.getModel().getValueAt(setar, 14).toString());
		txtEmailf.setText(tblClientes.getModel().getValueAt(setar, 15).toString());
		txtSenhaf.setText(tblClientes.getModel().getValueAt(setar, 16).toString());
		textContratof.setText(tblClientes.getModel().getValueAt(setar, 17).toString());
		cboMateria1.setSelectedItem(tblClientes.getModel().getValueAt(setar, 18).toString());
		cboMateria2.setSelectedItem(tblClientes.getModel().getValueAt(setar, 19).toString());
	}

	private void buscarCep() {
		try {
			String cep = textCepf.getText();
			CepWebService cepwebservice = new CepWebService(cep);
			if (cepwebservice.getResultado() == 1) {
				textEnderecof.setText(cepwebservice.getTipo_logradouro() + " " + cepwebservice.getLogradouro());
				textBairrof.setText(cepwebservice.getBairro());
				cmbUff.setSelectedItem(cepwebservice.getUf());
				txtCidadef.setText(cepwebservice.getCidade());

			} else {
				JOptionPane.showMessageDialog(null, "Não foi possível obter o CEP.");
			}
		} catch (Exception e) {
			System.out.println(e);
			// exceções, servidores indisponíveis
		}
	}

	private void pesquisarClientes() {
		String consultar = "select * from tb_dados_funcionarios where nomef like ?";
		try {
			pst = conexao.prepareStatement(consultar);
			pst.setString(1, txtPesquisar.getText() + "%");
			rs = pst.executeQuery();
			tblClientes.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// método para limpar a tabela
	private void limparTabela() {
		while (tblClientes.getRowCount() > 0) {
			((DefaultTableModel) tblClientes.getModel()).removeRow(0);
		}
	}
}