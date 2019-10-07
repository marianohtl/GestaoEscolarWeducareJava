package br.com.telas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.dal.ModuloConexao;
import br.com.cep.CepWebService;
import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DocentesCadastro extends JDialog {
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtCep;
	private JTextField txtNascimento;
	private JTextField txtTelefone;
	private JTextField txtSalario;
	private JTextField txtRg;
	private JTextField txtTelefone2;
	private JTextField txtCargaHoraria;
	private JTextField txtPesquisar;
	private JTextField txtNum;
	private JTable tblClientes;

	/**
	 * Launch the application.
	 */
	
	// classes, objetos e - Variáveis para trabalhar o MySQL)
	// ========================================================================================================================
	Connection conexao = null; // conexão
	PreparedStatement pst = null; // executar uma query(script) SQL
	ResultSet rs = null; // "trazer"os dados
	private JTextField txtId;
	private JComboBox cboStatus;
	private JTextField txtBairro;
	private JTextField txtEndereco;
	// ========================================================================================================================

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
		
		JLabel lblNewLabel = new JLabel("*NOME COMPLETO:");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewLabel.setBounds(270, 224, 107, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("*CPF:");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(106, 257, 33, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("*RG:");
		lblNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(344, 257, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("*CEP:");
		lblNewLabel_3.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(106, 287, 27, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("*ENDERE\u00C7O:");
		lblNewLabel_4.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(75, 318, 64, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("*DATA DE NASCIMENTO:");
		lblNewLabel_5.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(393, 416, 130, 14);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("*TELEFONE:");
		lblNewLabel_6.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(79, 416, 64, 14);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("TELEFONE 2:");
		lblNewLabel_7.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(75, 441, 64, 14);
		getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("*SAL\u00C1RIO:");
		lblNewLabel_8.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewLabel_8.setBounds(85, 350, 53, 14);
		getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("*CARGA HOR\u00C1RIA:");
		lblNewLabel_9.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewLabel_9.setBounds(45, 381, 98, 14);
		getContentPane().add(lblNewLabel_9);
		
		txtNome = new JTextField();
		txtNome.setBounds(380, 220, 250, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(173, 253, 140, 20);
		getContentPane().add(txtCpf);
		txtCpf.setColumns(10);
		
		txtCep = new JTextField();
		txtCep.setBounds(173, 283, 236, 20);
		getContentPane().add(txtCep);
		txtCep.setColumns(10);
		
		txtNascimento = new JTextField();
		txtNascimento.setBounds(530, 412, 100, 20);
		getContentPane().add(txtNascimento);
		txtNascimento.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(173, 408, 140, 20);
		getContentPane().add(txtTelefone);
		txtTelefone.setColumns(10);
		
		txtSalario = new JTextField();
		txtSalario.setBounds(173, 346, 140, 20);
		getContentPane().add(txtSalario);
		txtSalario.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("Campos Obrigat\u00F3rios*");
		lblNewLabel_13.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_13.setBounds(644, 11, 140, 14);
		getContentPane().add(lblNewLabel_13);
		
		JLabel lblNewLabel_10 = new JLabel("*STATUS:");
		lblNewLabel_10.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewLabel_10.setBounds(567, 283, 64, 14);
		getContentPane().add(lblNewLabel_10);
		
		cboStatus = new JComboBox();
		cboStatus.setFont(new Font("Calibri", Font.PLAIN, 12));
		cboStatus.setModel(new DefaultComboBoxModel(new String[] {"Desativado", "Ativado"}));
		cboStatus.setBounds(621, 279, 100, 20);
		getContentPane().add(cboStatus);
		
		txtRg = new JTextField();
		txtRg.setColumns(10);
		txtRg.setBounds(380, 253, 143, 20);
		getContentPane().add(txtRg);
		
		txtTelefone2 = new JTextField();
		txtTelefone2.setColumns(10);
		txtTelefone2.setBounds(173, 439, 140, 20);
		getContentPane().add(txtTelefone2);
		
		txtCargaHoraria = new JTextField();
		txtCargaHoraria.setColumns(10);
		txtCargaHoraria.setBounds(173, 377, 140, 20);
		getContentPane().add(txtCargaHoraria);
		
		JButton btnNewButton = new JButton("BUSCAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarCep();
			}
		});
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnNewButton.setBounds(444, 282, 80, 22);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_14 = new JLabel("PESQUISAR:");
		lblNewLabel_14.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_14.setBounds(21, 27, 80, 14);
		getContentPane().add(lblNewLabel_14);
		
		txtPesquisar = new JTextField();
		txtPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarClientes();
			}
		});
		txtPesquisar.setBounds(106, 24, 405, 20);
		getContentPane().add(txtPesquisar);
		txtPesquisar.setColumns(10);
		
		JLabel lblN = new JLabel("*N\u00BA:");
		lblN.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblN.setBounds(454, 322, 27, 14);
		getContentPane().add(lblN);
		
		txtNum = new JTextField();
		txtNum.setColumns(10);
		txtNum.setBounds(491, 318, 33, 20);
		getContentPane().add(txtNum);
		
		JButton btnCreate = new JButton("");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarUsuario();
			}
		});
		btnCreate.setIcon(new ImageIcon(DocentesCadastro.class.getResource("/br/com/icons/create.png")));
		btnCreate.setBounds(57, 480, 80, 80);
		getContentPane().add(btnCreate);
		
		JButton btnUpdate = new JButton("");
		btnUpdate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			
			}
		});
		btnUpdate.setIcon(new ImageIcon(DocentesCadastro.class.getResource("/br/com/icons/update.png")));
		btnUpdate.setBounds(153, 480, 80, 80);
		getContentPane().add(btnUpdate);
		
		JButton btnRead = new JButton("");
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarClientes();
			}
		});
		btnRead.setIcon(new ImageIcon(DocentesCadastro.class.getResource("/br/com/icons/read.png")));
		btnRead.setBounds(248, 480, 80, 80);
		getContentPane().add(btnRead);
		
		JButton btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletarClientes();
			}
		});
		btnDelete.setIcon(new ImageIcon(DocentesCadastro.class.getResource("/br/com/icons/delete.png")));
		btnDelete.setBounds(344, 480, 80, 80);
		getContentPane().add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
					pesquisarClientes();
			}
		});
		scrollPane.setBounds(21, 57, 745, 135);
		getContentPane().add(scrollPane);
		
		tblClientes = new JTable();
		tblClientes.setFont(new Font("Tahoma", Font.PLAIN, 10));
		scrollPane.setViewportView(tblClientes);
		
		JLabel lblBairro = new JLabel("*BAIRRO:");
		lblBairro.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblBairro.setBounds(465, 389, 53, 14);
		getContentPane().add(lblBairro);
		
		JLabel lblNewLabel_12 = new JLabel("ID:");
		lblNewLabel_12.setBounds(117, 223, 22, 14);
		getContentPane().add(lblNewLabel_12);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setColumns(10);
		txtId.setBounds(172, 220, 20, 20);
		getContentPane().add(txtId);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(530, 383, 100, 20);
		getContentPane().add(txtBairro);
		txtBairro.setColumns(10);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(173, 314, 236, 20);
		getContentPane().add(txtEndereco);
		txtEndereco.setColumns(10);
		
		conexao = ModuloConexao.conector();	
}
	
	
		
private void cadastrarUsuario() {
	if(txtNome.getText().isEmpty() || txtCpf.getText().isEmpty() || txtRg.getText().isEmpty() || txtCep.getText().isEmpty() || txtBairro.getText().isEmpty() || txtEndereco.getText().isEmpty() || txtSalario.getText().isEmpty() || txtNum.getText().isEmpty() || txtNascimento.getText().isEmpty() || txtTelefone.getText().isEmpty() || txtTelefone2.getText().isEmpty() || txtCargaHoraria.getText().isEmpty() || cboStatus.getSelectedItem().equals("")){
				JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios.");
					} else {
				//insert
				String create = "insert into tb_dados_docentes (nomedoc, cpfdoc, rgdoc, cepdoc, enddoc, bairrodoc, numdoc, nascdoc,  fonedoc, fone2doc, salario, cargahoraria, statusdoc) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";				 				
				try {
					pst = conexao.prepareStatement(create);
					pst.setString(1, txtNome.getText());
					pst.setString(2, txtCpf.getText());
					pst.setString(3, txtRg.getText());
					pst.setString(4, txtCep.getText());
					pst.setString(5, txtEndereco.getText());
					pst.setString(6, txtBairro.getText());
					pst.setString(7, txtNum.getText());
					pst.setString(8, txtNascimento.getText());
					pst.setString(9, txtTelefone.getText());
					pst.setString(10, txtTelefone2.getText());
					pst.setString(11, txtSalario.getText());
					pst.setString(12, txtCargaHoraria.getText());
					pst.setString(13, cboStatus.getSelectedItem().toString());
					int adicionado = pst.executeUpdate();
			
					if (adicionado == 1) {
						JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso.");
						limpar();
					} else {
						JOptionPane.showMessageDialog(null, "Não foi possível adicionar o usuário.");
					}
				} catch (Exception e) {
					System.out.println(e);
		}
	}
}

		private void limpar() {
			txtNome.setText(null);
			txtCpf.setText(null);
			txtRg.setText(null);
			txtCep.setText(null);
			txtEndereco.setText(null);
			txtBairro.setText(null);
			txtNum.setText(null);
			txtNascimento.setText(null);
			txtTelefone.setText(null);
			txtTelefone2.setText(null);
			txtSalario.setText(null);
			txtCargaHoraria.setText(null);
			cboStatus.setSelectedItem(null);
			txtPesquisar.setText(null);
			limparTabela();
		}


		private void limparTabela() {
			while (tblClientes.getRowCount() > 0) {
				((DefaultTableModel) tblClientes.getModel()).removeRow(0);
			}
		}
		
		private void pesquisarClientes() {
			String consultar = "select * from tb_docentes where nomedoc like ?";
			try {
				pst = conexao.prepareStatement(consultar);
				// atenção ao "%" na passagem do parâmetro
				pst.setString(1, txtPesquisar.getText() + "%");
				rs = pst.executeQuery();
				// a linha abaixo usa a biblioteca rs2xml.jar para "popular" a tabela
				tblClientes.setModel(DbUtils.resultSetToTableModel(rs));
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		
		private void deletarClientes() {
			int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão deste registro? ", " ATENÇÃO ",
					JOptionPane.YES_NO_OPTION);
			if (confirma == JOptionPane.YES_OPTION) {
				String delete = "delete from tb_docentes where iddoc=?";
				try {
					pst = conexao.prepareStatement(delete);
					pst.setString(1, txtId.getText());
					int removido = pst.executeUpdate();
					if (removido == 1) {
						JOptionPane.showMessageDialog(null, "Usuário removido.");
					}
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
		
		private void buscarCep() {
			try {
				String cep = txtCep.getText();
				CepWebService cepwebservice = new CepWebService(cep);
				if (cepwebservice.getResultado() == 1) {
					txtEndereco.setText(cepwebservice.getTipo_logradouro() + " " + cepwebservice.getLogradouro());																																	
					txtBairro.setText(cepwebservice.getBairro());
				} else {
					JOptionPane.showMessageDialog(null, "Não foi possível obter o CEP.");
				}
				} catch (Exception e) {
				System.out.println(e);
				// exceções, servidores indisponíveis
			}
				
		}
}

