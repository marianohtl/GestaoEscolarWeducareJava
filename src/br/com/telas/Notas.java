package br.com.telas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import br.com.dal.ModuloConexao;
import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;

public class Notas extends JDialog {
	private JTextField txtTurmasP;
	private JTable tblTurmasP;
	private JTextField txtEnsinoN;
	private JTextField txtCursoN;
	private JTextField txtSiglaN;
	private JTextField txtPeriodoN;
	private JTextField txtAnoIniN;
	private JTextField txtAnoLetN;
	private JTable tblAlunosP;
	private JTextField txtAlunosP;
	private JTextField txtIdAluno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Notas dialog = new Notas();
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
	private JTextField txtIDC;
	private JTextField txtAtivN;
	private JTextField txtAtivProf;
	private JTextField txtAtivId;
	private JTable tblAtivNotas;
	private JTextField txtAtivBi;
	private JComboBox cboAtivNota;
	public Notas() {
		conexao = ModuloConexao.conector();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Notas.class.getResource("/br/com/icons/logo_colnovagalax-32.png")));
		setResizable(false);
		setTitle("Notas");
		setBounds(100, 100,800, 795);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Turmas:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblNewLabel.setBounds(29, 11, 65, 32);
		getContentPane().add(lblNewLabel);
		
		txtTurmasP = new JTextField();
		txtTurmasP.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				pesquisarTurmas();
			
			}
		});
		txtTurmasP.setBounds(104, 11, 268, 36);
		getContentPane().add(txtTurmasP);
		txtTurmasP.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 53, 666, 112);
		getContentPane().add(scrollPane);
		
		tblTurmasP = new JTable();
		scrollPane.setColumnHeaderView(tblTurmasP);
		tblTurmasP.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setarCamposT();
			}
		});
		scrollPane.setViewportView(tblTurmasP);
		tblTurmasP.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		
		JLabel lblNewLabel_1 = new JLabel("Ensino:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(35, 175, 56, 20);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblCurso.setBounds(220, 179, 56, 20);
		getContentPane().add(lblCurso);
		
		JLabel lblSigla = new JLabel("Sigla:");
		lblSigla.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblSigla.setBounds(420, 179, 42, 20);
		getContentPane().add(lblSigla);
		
		JLabel lblPeriodo = new JLabel("Periodo:");
		lblPeriodo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPeriodo.setBounds(547, 179, 56, 20);
		getContentPane().add(lblPeriodo);
		
		JLabel lblAnoDeInicio = new JLabel("Ano de Inicio:");
		lblAnoDeInicio.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblAnoDeInicio.setBounds(35, 216, 98, 20);
		getContentPane().add(lblAnoDeInicio);
		
		JLabel lblAnoLetivo = new JLabel("Ano Letivo:");
		lblAnoLetivo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblAnoLetivo.setBounds(274, 216, 98, 20);
		getContentPane().add(lblAnoLetivo);
		
		txtEnsinoN = new JTextField();
		txtEnsinoN.setEditable(false);
		txtEnsinoN.setBounds(88, 176, 122, 20);
		getContentPane().add(txtEnsinoN);
		txtEnsinoN.setColumns(10);
		
		txtCursoN = new JTextField();
		txtCursoN.setEditable(false);
		txtCursoN.setColumns(10);
		txtCursoN.setBounds(268, 176, 122, 20);
		getContentPane().add(txtCursoN);
		
		txtSiglaN = new JTextField();
		txtSiglaN.setEditable(false);
		txtSiglaN.setColumns(10);
		txtSiglaN.setBounds(472, 177, 28, 20);
		getContentPane().add(txtSiglaN);
		
		txtPeriodoN = new JTextField();
		txtPeriodoN.setEditable(false);
		txtPeriodoN.setColumns(10);
		txtPeriodoN.setBounds(613, 180, 87, 20);
		getContentPane().add(txtPeriodoN);
		
		txtAnoIniN = new JTextField();
		txtAnoIniN.setEditable(false);
		txtAnoIniN.setColumns(10);
		txtAnoIniN.setBounds(132, 217, 87, 20);
		getContentPane().add(txtAnoIniN);
		
		txtAnoLetN = new JTextField();
		txtAnoLetN.setEditable(false);
		txtAnoLetN.setColumns(10);
		txtAnoLetN.setBounds(357, 217, 87, 20);
		getContentPane().add(txtAnoLetN);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarAlunos();
				pesquisarAtiv();
			}
		});
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPesquisar.setBounds(530, 210, 192, 35);
		getContentPane().add(btnPesquisar);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(56, 466, 666, 112);
		getContentPane().add(scrollPane_1);
		
		tblAlunosP = new JTable();
		scrollPane_1.setColumnHeaderView(tblAlunosP);
		tblAlunosP.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setarCamposA();
			}
		});
		
		JLabel lblAluno = new JLabel("Aluno:");
		lblAluno.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblAluno.setBounds(88, 602, 56, 20);
		getContentPane().add(lblAluno);
		
		txtAlunosP = new JTextField();
		txtAlunosP.setEditable(false);
		txtAlunosP.setColumns(10);
		txtAlunosP.setBounds(141, 603, 421, 20);
		getContentPane().add(txtAlunosP);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblId.setBounds(583, 605, 36, 20);
		getContentPane().add(lblId);
		
		txtIdAluno = new JTextField();
		txtIdAluno.setEditable(false);
		txtIdAluno.setColumns(10);
		txtIdAluno.setBounds(629, 603, 42, 20);
		getContentPane().add(txtIdAluno);
		
		JLabel lblId_1 = new JLabel("ID:");
		lblId_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblId_1.setBounds(450, 216, 36, 20);
		getContentPane().add(lblId_1);
		
		txtIDC = new JTextField();
		txtIDC.setEditable(false);
		txtIDC.setColumns(10);
		txtIDC.setBounds(490, 217, 28, 20);
		getContentPane().add(txtIDC);
		
		JLabel lblAtividade = new JLabel("Atividade:");
		lblAtividade.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblAtividade.setBounds(29, 385, 77, 20);
		getContentPane().add(lblAtividade);
		
		txtAtivN = new JTextField();
		txtAtivN.setEditable(false);
		txtAtivN.setColumns(10);
		txtAtivN.setBounds(119, 387, 421, 20);
		getContentPane().add(txtAtivN);
		
		JLabel lblProfessor = new JLabel("Professor:");
		lblProfessor.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblProfessor.setBounds(169, 435, 73, 20);
		getContentPane().add(lblProfessor);
		
		txtAtivProf = new JTextField();
		txtAtivProf.setEditable(false);
		txtAtivProf.setColumns(10);
		txtAtivProf.setBounds(259, 436, 122, 20);
		getContentPane().add(txtAtivProf);
		
		JLabel label_2 = new JLabel("ID:");
		label_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label_2.setBounds(420, 432, 36, 20);
		getContentPane().add(label_2);
		
		txtAtivId = new JTextField();
		txtAtivId.setEditable(false);
		txtAtivId.setColumns(10);
		txtAtivId.setBounds(466, 430, 42, 20);
		getContentPane().add(txtAtivId);
		
		JLabel lblNota = new JLabel("Nota:");
		lblNota.setHorizontalAlignment(SwingConstants.CENTER);
		lblNota.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		lblNota.setBounds(515, 400, 98, 56);
		getContentPane().add(lblNota);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_2.setBounds(56, 261, 666, 101);
		getContentPane().add(scrollPane_2);
		
		tblAtivNotas = new JTable();
		tblAtivNotas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setarCamposAtiv();
			}
		});
		scrollPane_2.setColumnHeaderView(tblAtivNotas);
		
		JLabel label = new JLabel("Bimestre:");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label.setBounds(29, 435, 65, 20);
		getContentPane().add(label);
		
		txtAtivBi = new JTextField();
		txtAtivBi.setEditable(false);
		txtAtivBi.setColumns(10);
		txtAtivBi.setBounds(104, 432, 42, 20);
		getContentPane().add(txtAtivBi);
		
		cboAtivNota = new JComboBox();
		cboAtivNota.setModel(new DefaultComboBoxModel(new String[] {"", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		cboAtivNota.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		cboAtivNota.setBounds(613, 430, 73, 22);
		getContentPane().add(cboAtivNota);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarNota();
			}
		});
		btnNewButton.setIcon(new ImageIcon(Notas.class.getResource("/br/com/icons/create.png")));
		btnNewButton.setBounds(135, 661, 98, 82);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(Notas.class.getResource("/br/com/icons/delete.png")));
		btnNewButton_1.setBounds(260, 661, 98, 82);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(Notas.class.getResource("/br/com/icons/icons8-limpar-formata\u00E7\u00E3o-48.png")));
		btnNewButton_2.setBounds(392, 675, 56, 47);
		getContentPane().add(btnNewButton_2);
		
		JButton btnMedia = new JButton("");
		btnMedia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal principal = new Principal();
				// centralizando e abrindo a tela
				RelatoriosAlunosTurmas relatoriosalunosturmas = new RelatoriosAlunosTurmas();
				relatoriosalunosturmas.setLocationRelativeTo(null);
				relatoriosalunosturmas.setVisible(true);
				Modal();
			    
			}
		});
		btnMedia.setIcon(new ImageIcon(Notas.class.getResource("/br/com/icons/report clientes.png")));
		btnMedia.setBounds(515, 635, 115, 122);
		getContentPane().add(btnMedia);
		
		
	}
	
	private void Modal() {
		this.setModal(true);
	}
	
	private void pesquisarTurmas() {
		String consultar = "select * from tb_turmas where curso like ?";
		try {
			pst = conexao.prepareStatement(consultar);
			//atenção ao "%" na passagem do parâmetro
			pst.setString(1,  txtTurmasP.getText() + "%");
			rs = pst.executeQuery();
			//a linha abaixo usa a biblioteca rs2xml.jr para "popular" a tabela
			tblTurmasP.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);
			
		}
	}
	//anoinic, ensino, curso, sigla, anolet, periodo
	private void setarCamposT() {
		int setar = tblTurmasP.getSelectedRow();
	
		txtIDC.setText(tblTurmasP.getModel().getValueAt(setar, 0).toString());
		txtAnoIniN.setText(tblTurmasP.getModel().getValueAt(setar, 1).toString());
		txtEnsinoN.setText(tblTurmasP.getModel().getValueAt(setar, 2).toString());
		txtCursoN.setText(tblTurmasP.getModel().getValueAt(setar, 3).toString());
		txtSiglaN.setText(tblTurmasP.getModel().getValueAt(setar, 4).toString());
		txtAnoLetN.setText(tblTurmasP.getModel().getValueAt(setar, 5).toString());
		txtPeriodoN.setText(tblTurmasP.getModel().getValueAt(setar, 6).toString());
		
	}
	private void pesquisarAlunos() {
		String consultar = "select idal, nomeal  from tb_dados_alunos where idcurso like ?";
		try {
			pst = conexao.prepareStatement(consultar);
			//atenção ao "%" na passagem do parâmetro
			pst.setString(1,  txtIDC.getText() + "%");
			rs = pst.executeQuery();
			//a linha abaixo usa a biblioteca rs2xml.jr para "popular" a tabela
			tblAlunosP.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);
			
		}
	}
	private void setarCamposA() {
		//Seta as informações do aluno selecionado nos campos em branco
		int setar = tblAlunosP.getSelectedRow();
	
		txtIdAluno.setText(tblAlunosP.getModel().getValueAt(setar, 0).toString());
		txtAlunosP.setText(tblAlunosP.getModel().getValueAt(setar, 1).toString());
	//	txtFone1.setText(tblAlunosP.getModel().getValueAt(setar, 2).toString());
		//txtStatus.setText(tblAlunosP.getModel().getValueAt(setar, 3).toString());	
	}
	
	private void pesquisarAtiv() {
		String consultar = "select idativ, ativ, prof, bi from tb_ativ where idtur like ?";
		try {
			pst = conexao.prepareStatement(consultar);
			
			pst.setString(1,  txtIDC.getText() + "%");
			rs = pst.executeQuery();
		
			tblAtivNotas.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);
			
		}
	}
	
	private void setarCamposAtiv() {
		
		int setar = tblAtivNotas.getSelectedRow();
	
		txtAtivId.setText(tblAtivNotas.getModel().getValueAt(setar, 0).toString());
		txtAtivN.setText(tblAtivNotas.getModel().getValueAt(setar, 1).toString());
	 	txtAtivProf.setText(tblAtivNotas.getModel().getValueAt(setar, 2).toString());
		txtAtivBi.setText(tblAtivNotas.getModel().getValueAt(setar, 3).toString());	
	}
	
	
	
	
	
	
	
	
	private void limpar() {
		txtTurmasP.setText(null);
		txtEnsinoN.setText(null);
		txtCursoN.setText(null);
		txtSiglaN.setText(null);
		txtPeriodoN.setText(null);
		txtAnoIniN.setText(null);
		txtAnoLetN.setText(null);
		txtIDC.setText(null);
		txtAtivN.setText(null);
		txtAtivId.setText(null);
		txtAtivProf.setText(null);
		//txtAtivStatus.setText(null);
		txtAtivBi.setText(null);
		cboAtivNota.setSelectedItem("");
		txtAlunosP.setText(null);
		txtIdAluno.setText(null);
		//txtFone1.setText(null);
		//txtStatus.setText(null);
		
		
	}
	
	private void adicionarNota() {
		if(txtEnsinoN.getText().isEmpty() || txtCursoN.getText().isEmpty() 
				|| txtSiglaN.getText().isEmpty() 
				|| txtPeriodoN.getText().isEmpty() || txtAnoIniN.getText().isEmpty() || txtAnoLetN.getText().isEmpty()
				|| txtIDC.getText().isEmpty()){
			//confirmar se essa ultima condição funciona
			JOptionPane.showMessageDialog(null, "Faltou informações sobre a turma!");
		
			
		}else if(txtAtivN.getText().isEmpty() || txtAtivBi.getText().isEmpty() 
				|| txtAtivProf.getText().isEmpty() 
				|| txtAtivId.getText().isEmpty() ) {
			JOptionPane.showMessageDialog(null, "Faltou informações sobre a atividade!");
		}
		else if(txtAlunosP.getText().isEmpty() || txtIdAluno.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Faltou informações sobre o aluno!");
		}
		else if(((String) cboAtivNota.getSelectedItem()).isEmpty()) {
			JOptionPane.showMessageDialog(null, "Faltou a nota");
		}else {
			String adicionar = "insert into tb_notas(ativ,idaluno,idturma,nota,bi) values (?,?,?,?,?)";
			String nome = txtAlunosP.getText();
			try {
				pst = conexao.prepareStatement(adicionar);
				pst.setString(1, txtAtivN.getText());
				pst.setString(2, txtIdAluno.getText());
				pst.setString(3, txtIDC.getText());
				pst.setString(4, cboAtivNota.getSelectedItem().toString());
				pst.setString(5, txtAtivBi.getText());
			//	pst.setString(6, txtIDC.getText());
				
				
				// quando é feito algo no banco de dados, é gerado um valor binario(0 ou 1) para definir se a conexão estava OK, no exemplo a baixo
				// int adicionado vai ser 1 se a conexao estiver OK e 0 se não!
				int adicionado = pst.executeUpdate();
				
				
				
				
				int on= 1;
				if(on == 1) {
					
				};
				if(adicionado ==1) {
					
							JOptionPane.showMessageDialog(null, "Nota do aluno " + nome +  " Cadastrada!");
					limpar();
				}else {
					JOptionPane.showMessageDialog(null, "Nota do aluno " + nome + " não cadastrada, por favor, confirme as informações");
				}
				
			} catch (Exception e) {
				System.out.println(e);
				JOptionPane.showMessageDialog(null, e);
			}
			
		}
	
}
	
	private void alterarNotas() {	
		//validação dos campos obrigatórios
		if(txtEnsinoN.getText().isEmpty() || txtCursoN.getText().isEmpty() 
				|| txtSiglaN.getText().isEmpty() 
				|| txtPeriodoN.getText().isEmpty() || txtAnoIniN.getText().isEmpty() || txtAnoLetN.getText().isEmpty()
				|| txtIDC.getText().isEmpty()){
			//confirmar se essa ultima condição funciona
			JOptionPane.showMessageDialog(null, "Faltou informações sobre a turma!");
		
			
		}else if(txtAtivN.getText().isEmpty() || txtAtivBi.getText().isEmpty() 
				|| txtAtivProf.getText().isEmpty() 
				|| txtAtivId.getText().isEmpty() ) {
			JOptionPane.showMessageDialog(null, "Faltou informações sobre a atividade!");
		}
		else if(txtAlunosP.getText().isEmpty() || txtIdAluno.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Faltou informações sobre o aluno!");
		}
		else if(((String) cboAtivNota.getSelectedItem()).isEmpty()) {
			JOptionPane.showMessageDialog(null, "Faltou a nota");
		}else {
			
			String update = "update tb_notas set ativ=?,idaluno=?,idturma=?,nota=? where =?";
			try {
				pst=conexao.prepareStatement(update);
				
		
				
				
				
				int alterar = pst.executeUpdate();
				
				
				if (alterar == 1) {
					JOptionPane.showMessageDialog(null, "Alterado com sucesso");
					limpar();
				} else {
					JOptionPane.showMessageDialog(null, "Não foi possivel alterar as informações, por favor confirme os dados");
				}
				
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}
	}}
	
	
	

