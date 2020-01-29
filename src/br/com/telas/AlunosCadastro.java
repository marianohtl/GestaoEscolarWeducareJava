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

public class AlunosCadastro extends JDialog {
	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	private JTextField textNome;
	private JTextField textCpf;
	private JTextField txtRg;
	private JTextField textCep;
	private JTextField txtEnd;
	private JTextField txtNasc;
	private JTextField txtResp;
	private JTextField txtFone;
	private JTextField txtFone2;
	private JTextField txtFoto;
	private JTextField txtStatus;
	private JTextField textEndereco;
	private JTextField textNascimento;
	private JTextField textResponsavel;
	private JTextField textMatricula;
	private JTextField textFone;
	private JTable tblClientes;
	private JTextField txtPesquisar;
	private JLabel lblNewLabel_10;
	private JLabel lblN;
	private JTextField textBairro;
	private JLabel lblStatus;
	private JButton btnBuscar;
	private JLabel lblNewLabel_9;
	private JTextField textNum;
	private JLabel label;
	private JLabel lblNewLabel_13;
	private JTextField textId;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlunosCadastro dialog = new AlunosCadastro();
					dialog.setLocationRelativeTo(null);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	private JTextField txtComplemento;
	private JTextField textCeel;
	private JTextField txtCidade;
	private JComboBox cmbUf;
	private JTextField txtEmail;
	private JTextField textRg;
	private JTextField txtIdTurma;
	private JLabel lblNewLabel_15;
	private JTable tblTurmas;
	private JTextField txtGamb;
	private JScrollPane scrollPane_1;
	private JComboBox cboStatus;
	
	
	public AlunosCadastro() {
		getContentPane().setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		setIconImage(Toolkit.getDefaultToolkit().getImage(AlunosCadastro.class.getResource("/br/com/icons/logo_colnovagalax-32.png")));
		setTitle("Alunos");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 1374, 730);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("*NOME COMPLETO:");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel.setBounds(136, 370, 210, 25);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("*CPF:");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(136, 452, 105, 27);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("*RG:");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(399, 443, 74, 44);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("*CEP:");
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(136, 528, 61, 18);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("*ENDERE\u00C7O:");
		lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(513, 524, 208, 27);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("*DATA DE NASCIMENTO:");
		lblNewLabel_5.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(662, 452, 242, 27);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("CELULAR:");
		lblNewLabel_6.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(1147, 452, 121, 20);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("*MATR\u00CDCULA:");
		lblNewLabel_8.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_8.setBounds(1140, 370, 144, 25);
		getContentPane().add(lblNewLabel_8);
		
		textNome = new JTextField();
		textNome.setForeground(Color.BLACK);
		textNome.setFont(new Font("Verdana", Font.PLAIN, 18));
		textNome.setBounds(136, 392, 309, 30);
		getContentPane().add(textNome);
		textNome.setColumns(10);
		
		textCpf = new JTextField();
		textCpf.setFont(new Font("Verdana", Font.PLAIN, 18));
		textCpf.setBounds(136, 476, 235, 30);
		getContentPane().add(textCpf);
		textCpf.setColumns(10);
		
		textCep = new JTextField();
		textCep.setFont(new Font("Verdana", Font.PLAIN, 18));
		textCep.setBounds(136, 549, 160, 30);
		getContentPane().add(textCep);
		textCep.setColumns(10);
		
		textEndereco = new JTextField();
		textEndereco.setFont(new Font("Verdana", Font.PLAIN, 18));
		textEndereco.setColumns(10);
		textEndereco.setBounds(513, 549, 492, 30);
		getContentPane().add(textEndereco);
		
		textRg = new JTextField();
		textRg.setFont(new Font("Verdana", Font.PLAIN, 18));
		textRg.setColumns(10);
		textRg.setBounds(399, 476, 232, 30);
		getContentPane().add(textRg);
		
		textNascimento = new JTextField();
		textNascimento.setFont(new Font("Verdana", Font.PLAIN, 18));
		textNascimento.setColumns(10);
		textNascimento.setBounds(662, 476, 242, 30);
		getContentPane().add(textNascimento);
		
		textResponsavel = new JTextField();
		textResponsavel.setFont(new Font("Verdana", Font.PLAIN, 18));
		textResponsavel.setColumns(10);
		textResponsavel.setBounds(513, 392, 259, 30);
		getContentPane().add(textResponsavel);
		
		textMatricula = new JTextField();
		textMatricula.setFont(new Font("Verdana", Font.PLAIN, 18));
		textMatricula.setEnabled(false);
		textMatricula.setColumns(10);
		textMatricula.setBounds(1143, 392, 164, 30);
		getContentPane().add(textMatricula);
		
		textFone = new JTextField();
		textFone.setFont(new Font("Verdana", Font.PLAIN, 18));
		textFone.setColumns(10);
		textFone.setBounds(958, 476, 160, 30);
		getContentPane().add(textFone);
		
		txtPesquisar = new JTextField();
		txtPesquisar.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtPesquisar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			pesquisarClientes();
			}
		});
		txtPesquisar.setColumns(10);
		txtPesquisar.setBounds(349, 37, 464, 27);
		getContentPane().add(txtPesquisar);
		
		lblNewLabel_10 = new JLabel("PESQUISAR ALUNOS:");
		lblNewLabel_10.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_10.setBounds(137, 37, 202, 27);
		getContentPane().add(lblNewLabel_10);
		
		lblN = new JLabel("*BAIRRO:");
		lblN.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblN.setBounds(425, 608, 99, 22);
		getContentPane().add(lblN);
		
		textBairro = new JTextField();
		textBairro.setFont(new Font("Verdana", Font.PLAIN, 18));
		textBairro.setColumns(10);
		textBairro.setBounds(425, 630, 267, 30);
		getContentPane().add(textBairro);
		
		lblStatus = new JLabel("*STATUS:");
		lblStatus.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblStatus.setBounds(1179, 608, 105, 18);
		getContentPane().add(lblStatus);
		
		JButton btnAdicionar = new JButton("");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restringirAdd();
				cadastrarUsuario();
				
			}
		});
		btnAdicionar.setToolTipText("ADICIONAR");
		btnAdicionar.setIcon(new ImageIcon(AlunosCadastro.class.getResource("/br/com/icons/create.png")));
		btnAdicionar.setBounds(26, 75, 80, 80);
		getContentPane().add(btnAdicionar);
		
		JButton btnModificar = new JButton("");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarUsuario();
			}
		});
		btnModificar.setToolTipText("MODIFICAR");
		btnModificar.setIcon(new ImageIcon(AlunosCadastro.class.getResource("/br/com/icons/update.png")));
		btnModificar.setBounds(26, 243, 80, 80);
		getContentPane().add(btnModificar);
		
		JButton btnDeletar = new JButton("");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletarClientes();
			}
		});
		btnDeletar.setToolTipText("DELETAR");
		btnDeletar.setIcon(new ImageIcon(AlunosCadastro.class.getResource("/br/com/icons/delete.png")));
		btnDeletar.setBounds(26, 426, 80, 80);
		getContentPane().add(btnDeletar);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setEnabled(false);
		btnBuscar.setForeground(Color.DARK_GRAY);
		btnBuscar.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarCep();
			}
		});
		btnBuscar.setToolTipText("BUSCAR");
		btnBuscar.setBounds(328, 551, 117, 30);
		getContentPane().add(btnBuscar);
		
		lblNewLabel_9 = new JLabel("* Campos Obrigat\u00F3rios");
		lblNewLabel_9.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblNewLabel_9.setBounds(1230, 11, 128, 25);
		getContentPane().add(lblNewLabel_9);
		
		textNum = new JTextField();
		textNum.setFont(new Font("Verdana", Font.PLAIN, 18));
		textNum.setColumns(10);
		textNum.setBounds(328, 630, 54, 30);
		getContentPane().add(textNum);
		
		label = new JLabel("*N\u00BA:");
		label.setFont(new Font("Verdana", Font.PLAIN, 18));
		label.setBounds(328, 603, 55, 30);
		getContentPane().add(label);
		
		lblNewLabel_13 = new JLabel("RESPONS\u00C1VEL:");
		lblNewLabel_13.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_13.setBounds(513, 370, 196, 23);
		getContentPane().add(lblNewLabel_13);
		
		textId = new JTextField();
		textId.setFont(new Font("Verdana", Font.PLAIN, 18));
		textId.setEnabled(false);
		textId.setColumns(10);
		textId.setBounds(821, 392, 41, 30);
		getContentPane().add(textId);
		
		JLabel label_1 = new JLabel("ID:");
		label_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		label_1.setBounds(821, 367, 30, 30);
		getContentPane().add(label_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(138, 75, 1162, 123);
		getContentPane().add(scrollPane);
		
		tblClientes = new JTable();
		tblClientes.setFont(new Font("Verdana", Font.PLAIN, 16));
		scrollPane.setViewportView(tblClientes);
		tblClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setarCampos();
				gamb();
			}
		});
		tblClientes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			limpar();
			}
		});
		button.setIcon(new ImageIcon(AlunosCadastro.class.getResource("/br/com/icons/clean.png")));
		button.setToolTipText("LIMPAR");
		button.setBounds(26, 580, 80, 80);
		getContentPane().add(button);
		
		JLabel lblNewLabel_11 = new JLabel("COMPLEMENTO:");
		lblNewLabel_11.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_11.setBounds(136, 606, 156, 27);
		getContentPane().add(lblNewLabel_11);
		
		txtComplemento = new JTextField();
		txtComplemento.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtComplemento.setBounds(136, 630, 166, 30);
		getContentPane().add(txtComplemento);
		txtComplemento.setColumns(10);
		
		JLabel label_2 = new JLabel("*TELEFONE:");
		label_2.setFont(new Font("Verdana", Font.PLAIN, 18));
		label_2.setBounds(958, 452, 128, 27);
		getContentPane().add(label_2);
		
		textCeel = new JTextField();
		textCeel.setFont(new Font("Verdana", Font.PLAIN, 18));
		textCeel.setBounds(1147, 476, 160, 30);
		getContentPane().add(textCeel);
		textCeel.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("*UF:");
		lblNewLabel_12.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_12.setBounds(1096, 607, 46, 25);
		getContentPane().add(lblNewLabel_12);
		
		JLabel lblNewLabel_14 = new JLabel("*CIDADE:");
		lblNewLabel_14.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_14.setBounds(726, 606, 99, 27);
		getContentPane().add(lblNewLabel_14);
		
		cmbUf = new JComboBox();
		cmbUf.setModel(new DefaultComboBoxModel(new String[] {"SP", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "TO"}));
		cmbUf.setFont(new Font("Verdana", Font.PLAIN, 18));
		cmbUf.setBounds(1096, 630, 50, 30);
		getContentPane().add(cmbUf);
		
		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtCidade.setBounds(726, 630, 347, 30);
		getContentPane().add(txtCidade);
		txtCidade.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtEmail.setBounds(1033, 549, 267, 30);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("E-MAIL:");
		lblNewLabel_7.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(1033, 530, 160, 14);
		getContentPane().add(lblNewLabel_7);
		
		txtIdTurma = new JTextField();
		txtIdTurma.setEditable(false);
		txtIdTurma.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtIdTurma.setBounds(957, 392, 74, 30);
		getContentPane().add(txtIdTurma);
		txtIdTurma.setColumns(10);
		
		lblNewLabel_15 = new JLabel("* ID TURMA:");
		lblNewLabel_15.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_15.setBounds(958, 364, 128, 36);
		getContentPane().add(lblNewLabel_15);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(252, 243, 1048, 97);
		getContentPane().add(scrollPane_1);
		
		tblTurmas = new JTable();
		tblTurmas.setFont(new Font("Verdana", Font.BOLD, 16));
		tblTurmas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setarIdTurma();
			}
		});
		scrollPane_1.setViewportView(tblTurmas);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(AlunosCadastro.class.getResource("/br/com/icons/search.png")));
		btnNewButton.setToolTipText("PESQUISAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarTurmas();
			}
		});
		btnNewButton.setBounds(137, 243, 80, 80);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_16 = new JLabel("TURMAS");
		lblNewLabel_16.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_16.setBounds(252, 208, 148, 26);
		getContentPane().add(lblNewLabel_16);
		
		txtGamb = new JTextField();
		txtGamb.setBounds(384, 549, -6, -2);
		getContentPane().add(txtGamb);
		txtGamb.setColumns(10);
		
		cboStatus = new JComboBox();
		cboStatus.setFont(new Font("Chaparral Pro", Font.PLAIN, 18));
		cboStatus.setModel(new DefaultComboBoxModel(new String[] {"ATIVADO", "DESATIVADO"}));
		cboStatus.setBounds(1179, 629, 121, 30);
		getContentPane().add(cboStatus);
		conexao = ModuloConexao.conector();
		
		if (conexao != null) {
			System.out.println("CONECTADO");
		} else {
			System.out.println("ERRO DE CONEXÃO");
			}	
	}

	private void deletarClientes(){
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão deste aluno? ", " ATENÇÃO ",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
			String delete = "delete from tb_dados_alunos where idal=?";
			try {
				pst = conexao.prepareStatement(delete);
				pst.setString(1, textId.getText());
				int removido = pst.executeUpdate();
				limpar();
				if (removido == 1) {
					JOptionPane.showMessageDialog(null, "Aluno removido da nossa base de dados.");
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	private void gamb2() {
		txtGamb.setText(null);

	}

	private void cadastrarUsuario() {
		if( textNome.getText().isEmpty() || textCpf.getText().isEmpty() || textRg.getText().isEmpty() || textCep.getText().isEmpty() || textEndereco.getText().isEmpty() || textBairro.getText().isEmpty() || txtCidade.getText().isEmpty() || textNum.getText().isEmpty() || textNascimento.getText().isEmpty() || textFone.getText().isEmpty() || txtIdTurma.getText().isEmpty()){ 
		
			JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios");
		} else if (txtGamb.getText().isEmpty()) {
			// insert
			String create = "insert into tb_dados_alunos (nomeal, cpfal, rgal, cepal, endal, bairroal, cidadeal, ufal, complementoal,numal, nascal, responsavel, foneal, celal,statusal,emailal,idturma) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			try {

				pst = conexao.prepareStatement(create);			
									
				
				
				pst.setString(1, textNome.getText());
				pst.setString(2, textCpf.getText());
				pst.setString(3, textRg.getText());
				pst.setString(4, textCep.getText());
				pst.setString(5, textEndereco.getText());
				pst.setString(6, textBairro.getText());
				pst.setString(7,txtCidade.getText());
				pst.setString(8,cmbUf.getSelectedItem().toString());
				pst.setString(9, txtComplemento.getText());
				pst.setString(10, textNum.getText());
				pst.setString(11, textNascimento.getText());				
				pst.setString(12, textResponsavel.getText());
				pst.setString(13, textFone.getText());
				pst.setString(14, textCeel.getText());	
				pst.setString(15, cboStatus.getSelectedItem().toString());
				pst.setString(16,txtEmail.getText());
				pst.setString(17,txtIdTurma.getText());
				int adicionado = pst.executeUpdate();
				System.out.println(adicionado);
				limpar();
				
				if (adicionado == 1) {
					JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso.");
				} else {
					JOptionPane.showMessageDialog(null, "Não foi possível adicionar o usuário.");
				}
			} catch (Exception e) {
				System.out.println("Deu ruim :(  " + e);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Você esta cadastrando um aluno duplicado!");
		}
	}
	
	private void restringirAdd() {
		Double confirmarAlunoDouble = null;
		String confirmarAluno = null;
		//cpfal,rgal,nomeal
		String verificar = "select * from tb_dados_alunos where nomeal = ? or cpfal = ? or rgal = ?";
		
		

		
		try {

			pst = conexao.prepareStatement(verificar);
			pst.setString(1, textNome.getText());
			pst.setString(2, textCpf.getText());
			pst.setString(3, textRg.getText());
			rs = (ResultSet) pst.executeQuery();
			while (rs.next()) {
				//JOptionPane.showMessageDialog(null, rs.getString(2));
				confirmarAluno = rs.getString(1);
				confirmarAlunoDouble = Double.parseDouble(confirmarAluno);

			}
			if (confirmarAlunoDouble != null) {
				txtGamb.setText(confirmarAluno);
			} else {
				txtGamb.setText(null);
					}

				
				} catch (Exception e) {
					System.out.println("Deu ruim :(  " + e);
				}

			}
	
	private void alterarUsuario() {
		if( textNome.getText().isEmpty() || textCpf.getText().isEmpty() || textRg.getText().isEmpty() || textCep.getText().isEmpty() || textEndereco.getText().isEmpty() || textBairro.getText().isEmpty() || txtCidade.getText().isEmpty() || textNum.getText().isEmpty() || textNascimento.getText().isEmpty() || textFone.getText().isEmpty() || txtIdTurma.getText().isEmpty()){ 
			JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios");
		} else {
	
			String update = "update tb_dados_alunos set nomeal=?, cpfal=?, rgal=?, cepal=?, endal=?, bairroal=?, cidadeal=?, ufal=?, complementoal=?,numal=?, nascal=?, responsavel=?, foneal=?, celal=?, statusal=?,emailal=?, idturma =?, matricula=? where idal=?";
			try {
			
				
				pst = conexao.prepareStatement(update);
				
				pst.setString(1, textNome.getText());
				pst.setString(2, textCpf.getText());
				pst.setString(3, textRg.getText());
				pst.setString(4, textCep.getText());
				pst.setString(5, textEndereco.getText());
				pst.setString(6, textBairro.getText());
				pst.setString(7,txtCidade.getText());
				pst.setString(8,cmbUf.getSelectedItem().toString());
				pst.setString(9, txtComplemento.getText());
				pst.setString(10, textNum.getText());
				pst.setString(11, textNascimento.getText());				
				pst.setString(12, textResponsavel.getText());
				pst.setString(13, textFone.getText());
				pst.setString(14, textCeel.getText());	
				pst.setString(15, cboStatus.getSelectedItem().toString());
				pst.setString(16, txtEmail.getText());
				pst.setString(17, txtIdTurma.getText());
				pst.setString(18, textMatricula.getText());
				pst.setString(19, textId.getText());
				int adicionado = pst.executeUpdate();
				limpar();
				
				if (adicionado == 1) {
					JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso.");
				} else {
					JOptionPane.showMessageDialog(null, "Não foi possível adicionar o usuário.");
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}	
	
	private void limpar() {
		textId.setText(null);
		textNome.setText(null);
		textCpf.setText(null);
		textRg.setText(null);
		textCep.setText(null);
		textEndereco.setText(null);
		textBairro.setText(null);
		txtCidade.setText(null);
		cmbUf.setSelectedItem(null);
		txtComplemento.setText(null);
		textNum.setText(null);
		textNascimento.setText(null);				
		textFone.setText(null);
		textCeel.setText(null);
		textResponsavel.setText(null);
		textMatricula.setText(null);
		//rdAtivado.setSelectedIcon(null);
		txtEmail.setText(null);
		txtIdTurma.setText(null);
		limparTabela();
	//	limparTabelaTurmas();
		
		
	}
private void limparTabela() {
	while (tblClientes.getRowCount() > 0) {
		((DefaultTableModel) tblClientes.getModel()).removeRow(0);
	}


	while (tblTurmas.getRowCount() > 0) {
		((DefaultTableModel) tblTurmas.getModel()).removeRow(0);
	}

}

	private void setarCampos() {
		int setar = tblClientes.getSelectedRow();
		textId.setText(tblClientes.getModel().getValueAt(setar, 0).toString());
		textNome.setText(tblClientes.getModel().getValueAt(setar, 1).toString());
		textCpf.setText(tblClientes.getModel().getValueAt(setar, 2).toString());
		textRg.setText(tblClientes.getModel().getValueAt(setar, 3).toString());
		textCep.setText(tblClientes.getModel().getValueAt(setar, 4).toString());
		textEndereco.setText(tblClientes.getModel().getValueAt(setar, 5).toString());
		textBairro.setText(tblClientes.getModel().getValueAt(setar, 6).toString());
		txtCidade.setText(tblClientes.getModel().getValueAt(setar, 7).toString());
		cmbUf.setSelectedItem(tblClientes.getModel().getValueAt(setar, 8).toString());	
		txtComplemento.setText(tblClientes.getModel().getValueAt(setar, 9).toString());
		textNum.setText(tblClientes.getModel().getValueAt(setar, 10).toString());
		textNascimento.setText(tblClientes.getModel().getValueAt(setar, 11).toString());
		textResponsavel.setText(tblClientes.getModel().getValueAt(setar, 12).toString());
		textFone.setText(tblClientes.getModel().getValueAt(setar, 13).toString());
		textCeel.setText(tblClientes.getModel().getValueAt(setar, 14).toString());
		cboStatus.setSelectedItem(tblClientes.getModel().getValueAt(setar, 15).toString());	
		txtEmail.setText(tblClientes.getModel().getValueAt(setar, 16).toString());
		textMatricula.setText(tblClientes.getModel().getValueAt(setar, 17).toString());
		txtIdTurma.setText(tblClientes.getModel().getValueAt(setar,18).toString());
	}
	private void setarIdTurma() {
		int setar = tblTurmas.getSelectedRow();
		txtIdTurma.setText(tblTurmas.getModel().getValueAt(setar,0).toString());
	}	
	private void buscarCep(){
		try {
			String cep = textCep.getText();
			CepWebService cepwebservice = new CepWebService(cep);
			if (cepwebservice.getResultado() == 1) {
				textEndereco.setText(cepwebservice.getTipo_logradouro() + " " + cepwebservice.getLogradouro());																																	
				textBairro.setText(cepwebservice.getBairro());
				cmbUf.setSelectedItem(cepwebservice.getUf());
				txtCidade.setText(cepwebservice.getCidade());
			
			} else {
				JOptionPane.showMessageDialog(null, "Não foi possível obter o CEP.");
			}
			} catch (Exception e) {
			System.out.println(e);
			// exceções, servidores indisponíveis
		}
	}

		private void pesquisarClientes() {
		String consultar = "select * from tb_dados_alunos where nomeal like ?";
		try {
			pst = conexao.prepareStatement(consultar);
			pst.setString(1, txtPesquisar.getText() + "%");
			rs = pst.executeQuery();
			tblClientes.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
		
		private void gamb() {
			String checarAluno = "select * from tb_dados_alunos where cpfal = ? or rgal = ? or nomeal = ?";
			String idaluno = null;
			try {
			//	JOptionPane.showMessageDialog(null, "1");
				pst = conexao.prepareStatement(checarAluno);
				pst.setString(1, textCpf.getText() + "%");
				pst.setString(2, textRg.getText() + "%");
				pst.setString(3, textNome.getText() + "%");
	
				
				rs = (ResultSet) pst.executeQuery();

				while (rs.next()) {
				//	JOptionPane.showMessageDialog(null, "2");
					idaluno = rs.getString("idal");
					JOptionPane.showMessageDialog(null, idaluno);
					txtGamb.setText(idaluno);
	              // JOptionPane.showMessageDialog(null, idprof);
				}

			} catch (Exception e) {
				// TODO: handle exception
			}

		}
	
		private void pesquisarTurmas() {
			String consultarT = "select idturma as 'ID DA TURMA', anoturma as ANO, ensino as ENSINO, sigla as SIGLA, anolet as 'ANO LETIVO', periodo as PERIODO from tb_turmas";
			try {
				pst = conexao.prepareStatement(consultarT);
//				pst.setString(1, txtPesquisarT.getText() + "%");
				rs = pst.executeQuery();
				tblTurmas.setModel(DbUtils.resultSetToTableModel(rs));
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		//método para limpar a tabela
		
}