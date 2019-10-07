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
		setIconImage(Toolkit.getDefaultToolkit().getImage(FuncionariosCadastrados.class.getResource("/br/com/icons/logo_colnovagalax-32.png")));
		setTitle("Funcion\u00E1rios");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 1000, 490);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("*NOME COMPLETO:");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel.setBounds(146, 220, 128, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("*CPF:");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(146, 268, 40, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("*RG:");
		lblNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(289, 268, 34, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("*CEP:");
		lblNewLabel_3.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(146, 320, 34, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("*ENDERE\u00C7O:");
		lblNewLabel_4.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(434, 320, 74, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("*DATA DE NASCIMENTO:");
		lblNewLabel_5.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(434, 268, 156, 14);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("CELULAR:");
		lblNewLabel_6.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(837, 268, 74, 14);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("*CONTRATO:");
		lblNewLabel_8.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(685, 320, 92, 14);
		getContentPane().add(lblNewLabel_8);
		
		textNomef = new JTextField();
		textNomef.setForeground(Color.BLACK);
		textNomef.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textNomef.setBounds(146, 238, 208, 20);
		getContentPane().add(textNomef);
		textNomef.setColumns(10);
		
		textCpff = new JTextField();
		textCpff.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textCpff.setBounds(146, 285, 119, 20);
		getContentPane().add(textCpff);
		textCpff.setColumns(10);
		
		textCepf = new JTextField();
		textCepf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textCepf.setBounds(146, 337, 119, 20);
		getContentPane().add(textCepf);
		textCepf.setColumns(10);
		
		textEnderecof = new JTextField();
		textEnderecof.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textEnderecof.setColumns(10);
		textEnderecof.setBounds(432, 337, 229, 20);
		getContentPane().add(textEnderecof);
		
		textRgf = new JTextField();
		textRgf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textRgf.setColumns(10);
		textRgf.setBounds(287, 285, 119, 20);
		getContentPane().add(textRgf);
		
		textNascimentof = new JTextField();
		textNascimentof.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textNascimentof.setColumns(10);
		textNascimentof.setBounds(434, 285, 144, 20);
		getContentPane().add(textNascimentof);
		
		textContratof = new JTextField();
		textContratof.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textContratof.setEnabled(false);
		textContratof.setColumns(10);
		textContratof.setBounds(685, 337, 132, 20);
		getContentPane().add(textContratof);
		
		textFonef = new JTextField();
		textFonef.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFonef.setColumns(10);
		textFonef.setBounds(685, 285, 132, 20);
		getContentPane().add(textFonef);
		
		txtPesquisar = new JTextField();
		txtPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPesquisar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			pesquisarClientes();
			}
		});
		txtPesquisar.setColumns(10);
		txtPesquisar.setBounds(352, 38, 284, 20);
		getContentPane().add(txtPesquisar);
		
		lblNewLabel_10 = new JLabel("PESQUISAR FUNCION\u00C1RIOS:");
		lblNewLabel_10.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(137, 37, 176, 27);
		getContentPane().add(lblNewLabel_10);
		
		lblN = new JLabel("*BAIRRO:");
		lblN.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblN.setBounds(381, 377, 56, 14);
		getContentPane().add(lblN);
		
		textBairrof = new JTextField();
		textBairrof.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textBairrof.setColumns(10);
		textBairrof.setBounds(379, 395, 99, 20);
		getContentPane().add(textBairrof);
		
		lblStatus = new JLabel("*PERFIL:");
		lblStatus.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblStatus.setBounds(761, 377, 56, 14);
		getContentPane().add(lblStatus);
		
		JButton btnAdicionar = new JButton("");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarUsuario();
			}
		});
		btnAdicionar.setToolTipText("ADICIONAR");
		btnAdicionar.setIcon(new ImageIcon(FuncionariosCadastrados.class.getResource("/br/com/icons/create.png")));
		btnAdicionar.setBounds(26, 27, 70, 70);
		getContentPane().add(btnAdicionar);
		
		JButton btnModificar = new JButton("");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarUsuario();
			}
		});
		btnModificar.setToolTipText("MODIFICAR");
		btnModificar.setIcon(new ImageIcon(FuncionariosCadastrados.class.getResource("/br/com/icons/update.png")));
		btnModificar.setBounds(26, 140, 70, 70);
		getContentPane().add(btnModificar);
		
		JButton btnDeletar = new JButton("");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletarClientes();
			}
		});
		btnDeletar.setToolTipText("DELETAR");
		btnDeletar.setIcon(new ImageIcon(FuncionariosCadastrados.class.getResource("/br/com/icons/delete.png")));
		btnDeletar.setBounds(26, 247, 70, 70);
		getContentPane().add(btnDeletar);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setForeground(Color.DARK_GRAY);
		btnBuscar.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarCep();
			}
		});
		btnBuscar.setToolTipText("BUSCAR");
		btnBuscar.setBounds(289, 337, 92, 25);
		getContentPane().add(btnBuscar);
		
		lblNewLabel_9 = new JLabel("Campos Obrigat\u00F3rios*");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_9.setBounds(837, 11, 128, 14);
		getContentPane().add(lblNewLabel_9);
		
		textNumf = new JTextField();
		textNumf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textNumf.setColumns(10);
		textNumf.setBounds(289, 395, 34, 20);
		getContentPane().add(textNumf);
		
		label = new JLabel("*N\u00BA:");
		label.setFont(new Font("Calibri", Font.PLAIN, 14));
		label.setBounds(289, 377, 34, 14);
		getContentPane().add(label);
		
		textIdf = new JTextField();
		textIdf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textIdf.setEnabled(false);
		textIdf.setColumns(10);
		textIdf.setBounds(382, 238, 26, 20);
		getContentPane().add(textIdf);
		
		JLabel label_1 = new JLabel("ID:");
		label_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		label_1.setBounds(384, 220, 21, 14);
		getContentPane().add(label_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(138, 75, 822, 123);
		getContentPane().add(scrollPane);
		
		tblClientes = new JTable();
		scrollPane.setViewportView(tblClientes);
		tblClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setarCampos();
			}
		});
		tblClientes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		
		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			limpar();
			}
		});
		btnLimpar.setIcon(new ImageIcon(FuncionariosCadastrados.class.getResource("/br/com/icons/clean.png")));
		btnLimpar.setToolTipText("LIMPAR");
		btnLimpar.setBounds(26, 347, 70, 70);
		getContentPane().add(btnLimpar);
		
		JLabel lblNewLabel_11 = new JLabel("COMPLEMENTO:");
		lblNewLabel_11.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_11.setBounds(146, 377, 109, 19);
		getContentPane().add(lblNewLabel_11);
		
		txtComplementof = new JTextField();
		txtComplementof.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtComplementof.setBounds(146, 395, 119, 20);
		getContentPane().add(txtComplementof);
		txtComplementof.setColumns(10);
		
		JLabel label_2 = new JLabel("*TELEFONE:");
		label_2.setFont(new Font("Calibri", Font.PLAIN, 14));
		label_2.setBounds(687, 268, 74, 14);
		getContentPane().add(label_2);
		
		textCelf = new JTextField();
		textCelf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textCelf.setBounds(833, 285, 128, 20);
		getContentPane().add(textCelf);
		textCelf.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("*UF:");
		lblNewLabel_12.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_12.setBounds(685, 377, 46, 14);
		getContentPane().add(lblNewLabel_12);
		
		JLabel lblNewLabel_14 = new JLabel("*CIDADE:");
		lblNewLabel_14.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_14.setBounds(509, 377, 64, 16);
		getContentPane().add(lblNewLabel_14);
		
		cmbUff = new JComboBox();
		cmbUff.setModel(new DefaultComboBoxModel(new String[] {"SP", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "TO"}));
		cmbUff.setFont(new Font("Calibri", Font.PLAIN, 14));
		cmbUff.setBounds(683, 395, 46, 22);
		getContentPane().add(cmbUff);
		
		txtCidadef = new JTextField();
		txtCidadef.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCidadef.setBounds(511, 395, 99, 20);
		getContentPane().add(txtCidadef);
		txtCidadef.setColumns(10);
		
		txtEmailf = new JTextField();
		txtEmailf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmailf.setBounds(434, 238, 227, 20);
		getContentPane().add(txtEmailf);
		txtEmailf.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("* E-MAIL:");
		lblNewLabel_7.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(434, 220, 55, 14);
		getContentPane().add(lblNewLabel_7);
		
		cmbPerfilf = new JComboBox();
		cmbPerfilf.setModel(new DefaultComboBoxModel(new String[] {"ADMIN", "PROFESSOR", "DIRETOR"}));
		cmbPerfilf.setBounds(764, 395, 119, 22);
		getContentPane().add(cmbPerfilf);
		
		lblNewLabel_13 = new JLabel("*SENHA:");
		lblNewLabel_13.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_13.setBounds(685, 220, 64, 14);
		getContentPane().add(lblNewLabel_13);
		
		txtSenhaf = new JPasswordField();
		txtSenhaf.setBounds(683, 238, 132, 20);
		getContentPane().add(txtSenhaf);
		conexao = ModuloConexao.conector();
		
		if (conexao != null) {
			System.out.println("CONECTADO");
		} else {
			System.out.println("ERRO DE CONEXÃO");
			}	
	}

	private void deletarClientes(){
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

	private void cadastrarUsuario() {
		if( textNomef.getText().isEmpty() || textCpff.getText().isEmpty() || textRgf.getText().isEmpty() || textCepf.getText().isEmpty() || textEnderecof.getText().isEmpty() || textBairrof.getText().isEmpty() || txtCidadef.getText().isEmpty() || textNumf.getText().isEmpty() || textNascimentof.getText().isEmpty() || textFonef.getText().isEmpty() || txtEmailf.getText().isEmpty() ||txtSenhaf.getText().isEmpty()){ 
			JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios");
		} else {
			// insert
			String create = "insert into tb_dados_funcionarios ( nomef, cpff, rgf, cepf, endf, bairrof, cidadef, uff, complementof, numf, nascf, fonef, celf, perfilf, emailf, senhaf) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			try {
				pst = conexao.prepareStatement(create);
				pst.setString(1,textNomef.getText());
				pst.setString(2,textCpff.getText());
				pst.setString(3,textRgf.getText());
				pst.setString(4,textCepf.getText());
				pst.setString(5,textEnderecof.getText());
				pst.setString(6,textBairrof.getText());
				pst.setString(7,txtCidadef.getText());
				pst.setString(8,cmbUff.getSelectedItem().toString());
				pst.setString(9,txtComplementof.getText());
				pst.setString(10,textNumf.getText());
				pst.setString(11,textNascimentof.getText());
				pst.setString(12,textFonef.getText());
				pst.setString(13,textCelf.getText());
				pst.setString(14,cmbPerfilf.getSelectedItem().toString());
				pst.setString(15,txtEmailf.getText());
				pst.setString(16,txtSenhaf.getText());
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
		}
	}
	private void alterarUsuario() {
		if( textNomef.getText().isEmpty() || textCpff.getText().isEmpty() || textRgf.getText().isEmpty() || textCepf.getText().isEmpty() || textEnderecof.getText().isEmpty() || textBairrof.getText().isEmpty() || txtCidadef.getText().isEmpty() || textNumf.getText().isEmpty() || textNascimentof.getText().isEmpty() || textFonef.getText().isEmpty() || txtEmailf.getText().isEmpty() ||txtSenhaf.getText().isEmpty()){ 
			JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios");
		} else {

		String update = "update tb_dados_funcionarios set nomef=?, cpff=?, rgf=?, cepf=?, endf=?, bairrof=?, cidadef=?, uff=?, complementof=?, numf=?, nascf=?, fonef=?, celf=?, perfilf=?, emailf=?, senhaf=? where idf=?";
		try {
			pst = conexao.prepareStatement(update);
			pst.setString(1,textNomef.getText());
			pst.setString(2,textCpff.getText());
			pst.setString(3,textRgf.getText());
			pst.setString(4,textCepf.getText());
			pst.setString(5,textEnderecof.getText());
			pst.setString(6,textBairrof.getText());
			pst.setString(7,txtCidadef.getText());
			pst.setString(8,cmbUff.getSelectedItem().toString());
			pst.setString(9,txtComplementof.getText());
			pst.setString(10,textNumf.getText());
			pst.setString(11,textNascimentof.getText());
			pst.setString(12,textFonef.getText());
			pst.setString(13,textCelf.getText());
			pst.setString(14,cmbPerfilf.getSelectedItem().toString());
			pst.setString(15,txtEmailf.getText());
			pst.setString(16,txtSenhaf.getText());
			pst.setString(17,textIdf.getText());
			
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
		textFonef.setText(tblClientes.getModel().getValueAt(setar,12).toString());
		textCelf.setText(tblClientes.getModel().getValueAt(setar, 13).toString());
		cmbPerfilf.setSelectedItem(tblClientes.getModel().getValueAt(setar, 14).toString());
		txtEmailf.setText(tblClientes.getModel().getValueAt(setar, 15).toString());
		txtSenhaf.setText(tblClientes.getModel().getValueAt(setar, 16).toString());
		textContratof.setText(tblClientes.getModel().getValueAt(setar, 17).toString());
	}
	
	private void buscarCep(){
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
			//exceções, servidores indisponíveis
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

		//método para limpar a tabela
		private void limparTabela() {
			while (tblClientes.getRowCount() > 0) {
				((DefaultTableModel) tblClientes.getModel()).removeRow(0);
			}
		}
}