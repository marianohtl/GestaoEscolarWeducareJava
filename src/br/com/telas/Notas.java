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
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Notas extends JDialog {
	private JTextField txtTurmasP;
	private JTable tblTurmasP;
	private JTextField txtSiglaN;
	private JTextField txtPeriodoN;
	private JTextField txtAnoTurma;
	private JTable tblAlunosP;
	private JTextField txtAlunosP;
	private JTextField txtIdAluno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Notas dialog = new Notas();
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
	
	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JTextField txtIDC;
	private JTextField txtAtivN;
	JTextField txtProf;
	private JTextField txtAtivId;
	private JTable tblAtivNotas;
	private JTextField txtAtivBi;
	private JTextField txtMateria;
	private JScrollPane scrollPane;
	private JTextField txtNota;
	private JTextField txtIdProf;
	public Notas() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				pesquisarIdProf();
			}
		});
		conexao = ModuloConexao.conector();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Notas.class.getResource("/br/com/icons/logo_colnovagalax-32.png")));
		setResizable(false);
		setTitle("Notas");
		setBounds(100, 100, 1374, 780);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Turmas:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel.setBounds(38, 24, 125, 32);
		getContentPane().add(lblNewLabel);
		
		txtTurmasP = new JTextField();
		txtTurmasP.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtTurmasP.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				pesquisarTurmas();
			
			}
		});
		txtTurmasP.setBounds(163, 22, 458, 30);
		getContentPane().add(txtTurmasP);
		txtTurmasP.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 64, 1276, 101);
		getContentPane().add(scrollPane);
		
		tblTurmasP = new JTable();
		tblTurmasP.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		scrollPane.setColumnHeaderView(tblTurmasP);
		tblTurmasP.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setarCamposT();
				limparTabelaAlunos();
				limparTabelaAtiv();
			}
		});
		scrollPane.setViewportView(tblTurmasP);
		tblTurmasP.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		
		JLabel lblSigla = new JLabel("Sigla:");
		lblSigla.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblSigla.setBounds(434, 179, 65, 30);
		getContentPane().add(lblSigla);
		
		JLabel lblPeriodo = new JLabel("Per\u00EDodo:");
		lblPeriodo.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblPeriodo.setBounds(628, 183, 109, 20);
		getContentPane().add(lblPeriodo);
		
		JLabel lblAnoDeInicio = new JLabel("Ano da Turma:");
		lblAnoDeInicio.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblAnoDeInicio.setBounds(76, 189, 170, 20);
		getContentPane().add(lblAnoDeInicio);
		
		txtSiglaN = new JTextField();
		txtSiglaN.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtSiglaN.setEditable(false);
		txtSiglaN.setColumns(10);
		txtSiglaN.setBounds(499, 179, 42, 30);
		getContentPane().add(txtSiglaN);
		
		txtPeriodoN = new JTextField();
		txtPeriodoN.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtPeriodoN.setEditable(false);
		txtPeriodoN.setColumns(10);
		txtPeriodoN.setBounds(714, 179, 125, 30);
		getContentPane().add(txtPeriodoN);
		
		txtAnoTurma = new JTextField();
		txtAnoTurma.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtAnoTurma.setEditable(false);
		txtAnoTurma.setColumns(10);
		txtAnoTurma.setBounds(225, 184, 156, 30);
		getContentPane().add(txtAnoTurma);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarAlunos();
				pesquisarAtiv();
			}
		});
		btnPesquisar.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnPesquisar.setBounds(1191, 176, 122, 35);
		getContentPane().add(btnPesquisar);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(56, 431, 1276, 143);
		getContentPane().add(scrollPane_1);
		
		tblAlunosP = new JTable();
		tblAlunosP.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		scrollPane_1.setColumnHeaderView(tblAlunosP);
		tblAlunosP.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setarCamposA();
			}
		});
		
		scrollPane_1.setViewportView(tblAlunosP);
		tblAlunosP.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		
		JLabel lblAluno = new JLabel("Aluno:");
		lblAluno.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblAluno.setBounds(289, 664, 100, 20);
		getContentPane().add(lblAluno);
		
		txtAlunosP = new JTextField();
		txtAlunosP.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtAlunosP.setEditable(false);
		txtAlunosP.setColumns(10);
		txtAlunosP.setBounds(380, 662, 421, 28);
		getContentPane().add(txtAlunosP);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblId.setBounds(320, 616, 36, 20);
		getContentPane().add(lblId);
		
		txtIdAluno = new JTextField();
		txtIdAluno.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtIdAluno.setEditable(false);
		txtIdAluno.setColumns(10);
		txtIdAluno.setBounds(380, 616, 42, 28);
		getContentPane().add(txtIdAluno);
		
		JLabel lblId_1 = new JLabel("ID da Turma:");
		lblId_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblId_1.setBounds(909, 183, 130, 20);
		getContentPane().add(lblId_1);
		
		txtIDC = new JTextField();
		txtIDC.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtIDC.setEditable(false);
		txtIDC.setColumns(10);
		txtIDC.setBounds(1049, 179, 28, 30);
		getContentPane().add(txtIDC);
		
		JLabel lblAtividade = new JLabel("Atividade:");
		lblAtividade.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblAtividade.setBounds(66, 348, 143, 20);
		getContentPane().add(lblAtividade);
		
		txtAtivN = new JTextField();
		txtAtivN.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtAtivN.setEditable(false);
		txtAtivN.setColumns(10);
		txtAtivN.setBounds(169, 338, 381, 30);
		getContentPane().add(txtAtivN);
		
		JLabel lblProfessor = new JLabel("Professor:");
		lblProfessor.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblProfessor.setBounds(267, 394, 114, 20);
		getContentPane().add(lblProfessor);
		
		txtProf = new JTextField();
		txtProf.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtProf.setText("Administrador");
		txtProf.setHorizontalAlignment(SwingConstants.CENTER);
		txtProf.setEditable(false);
		txtProf.setColumns(10);
		txtProf.setBounds(366, 390, 186, 30);
		getContentPane().add(txtProf);
		
		JLabel label_2 = new JLabel("ID:");
		label_2.setFont(new Font("Verdana", Font.PLAIN, 18));
		label_2.setBounds(650, 397, 36, 20);
		getContentPane().add(label_2);
		
		txtAtivId = new JTextField();
		txtAtivId.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtAtivId.setEditable(false);
		txtAtivId.setColumns(10);
		txtAtivId.setBounds(695, 394, 42, 30);
		getContentPane().add(txtAtivId);
		
		JLabel lblNota = new JLabel("Nota:");
		lblNota.setHorizontalAlignment(SwingConstants.CENTER);
		lblNota.setFont(new Font("Verdana", Font.PLAIN, 22));
		lblNota.setBounds(769, 390, 98, 36);
		getContentPane().add(lblNota);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_2.setBounds(56, 226, 1276, 101);
		getContentPane().add(scrollPane_2);
		
		tblAtivNotas = new JTable();
		tblAtivNotas.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		tblAtivNotas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setarCamposAtiv();
			}
		});
		//scrollPane_2.setColumnHeaderView(tblAtivNotas);
		scrollPane_2.setViewportView(tblAtivNotas);
		tblAtivNotas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		
		
		JLabel label = new JLabel("Bimestre:");
		label.setFont(new Font("Verdana", Font.PLAIN, 18));
		label.setBounds(68, 396, 100, 20);
		getContentPane().add(label);
		
		txtAtivBi = new JTextField();
		txtAtivBi.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtAtivBi.setEditable(false);
		txtAtivBi.setColumns(10);
		txtAtivBi.setBounds(171, 390, 42, 30);
		getContentPane().add(txtAtivBi);
		
		JButton btnNotas = new JButton("");
		btnNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarNota();
			}
		});
		btnNotas.setIcon(new ImageIcon(Notas.class.getResource("/br/com/icons/create.png")));
		btnNotas.setBounds(56, 600, 90, 90);
		getContentPane().add(btnNotas);
		
		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparTudo();
			}
		});
		btnLimpar.setIcon(new ImageIcon(Notas.class.getResource("/br/com/icons/clean.png")));
		btnLimpar.setBounds(163, 600, 90, 90);
		getContentPane().add(btnLimpar);
		
		JLabel lblMatria = new JLabel("Mat\u00E9ria:");
		lblMatria.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblMatria.setBounds(777, 348, 125, 20);
		getContentPane().add(lblMatria);
		
		txtMateria = new JTextField();
		txtMateria.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtMateria.setEditable(false);
		txtMateria.setColumns(10);
		txtMateria.setBounds(863, 345, 256, 30);
		getContentPane().add(txtMateria);
		
		JButton btnNewButton_3 = new JButton("RELAT\u00D3RIOS");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RelatoriosAlunosTurmas relatorios = new RelatoriosAlunosTurmas();
				relatorios.setVisible(true);
				
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnNewButton_3.setBounds(1021, 629, 223, 55);
		getContentPane().add(btnNewButton_3);
		
		txtNota = new JTextField();
		txtNota.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtNota.setColumns(10);
 		txtNota.setBounds(863, 390, 77, 30);
		getContentPane().add(txtNota);
		
		JLabel lblIdProf = new JLabel("ID Prof:");
		lblIdProf.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblIdProf.setBounds(609, 349, 90, 20);
		getContentPane().add(lblIdProf);
		
		txtIdProf = new JTextField();
		txtIdProf.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtIdProf.setEditable(false);
		txtIdProf.setColumns(10);
		txtIdProf.setBounds(695, 348, 42, 30);
		getContentPane().add(txtIdProf);
		
		
	}
	
	private void pesquisarIdProf() {
		String buscarIdProf = "select * from tb_dados_funcionarios where nomef like ?";
		String idProf = null;
		int qt = 0;
		
		try {

			pst = conexao.prepareStatement(buscarIdProf);
			pst.setString(1, txtProf.getText() + "%");
			rs = (ResultSet) pst.executeQuery();

			while (rs.next() & qt < 1) {
                qt = qt +1;
				idProf = rs.getString("idf");
				txtIdProf.setText(idProf);
				//JOptionPane.showMessageDialog(null, idProf);
				

			}
		} catch (Exception e) {
			System.out.println(e);
			//JOptionPane.showMessageDialog(null, e);

		}

	}
	
	private void Modal() {
		this.setModal(true);
	}
	
	private void pesquisarTurmas() {
		String consultarTurma = "select idturma as MATRICULA, anoturma as ANO, sigla as TURMA, periodo as PERIODO from tb_turmas where anoturma like ?";
		try {
			pst = conexao.prepareStatement(consultarTurma);
			pst.setString(1,  txtTurmasP.getText() + "%");
			rs = pst.executeQuery();	
			
			
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
		txtAnoTurma.setText(tblTurmasP.getModel().getValueAt(setar, 1).toString());
		txtSiglaN.setText(tblTurmasP.getModel().getValueAt(setar, 2).toString());
		txtPeriodoN.setText(tblTurmasP.getModel().getValueAt(setar, 3).toString());
		
	}
	private void pesquisarAlunos() {
		String consultar = "select idal as ID, nomeal as NOME from tb_dados_alunos where idturma = ?";
		try {
			pst = conexao.prepareStatement(consultar);
			pst.setString(1,  txtIDC.getText() + "%");
			rs = pst.executeQuery();	
			tblAlunosP.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);
			
		}
	}
	private void setarCamposA() {
		int setar = tblAlunosP.getSelectedRow();
	
		txtIdAluno.setText(tblAlunosP.getModel().getValueAt(setar, 0).toString());
		txtAlunosP.setText(tblAlunosP.getModel().getValueAt(setar, 1).toString());
	}
	
	private void pesquisarAtiv() {
		String consultar = "select idativ as 'ID DA ATIVIDADE', ativ as ATIVIDADE, prof as PROFESSOR, bi as BIMESTRE, materia as MATERIA from tb_ativ where idturma = ? and idprof like ?";
		try {
			pst = conexao.prepareStatement(consultar);
			pst.setString(1,  txtIDC.getText() + "%");
			pst.setString(2, txtIdProf.getText() + "%");
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
	 	txtProf.setText(tblAtivNotas.getModel().getValueAt(setar, 2).toString());
		txtAtivBi.setText(tblAtivNotas.getModel().getValueAt(setar, 3).toString());	
		txtMateria.setText(tblAtivNotas.getModel().getValueAt(setar,  4).toString());
	}
	
	private void limparTabelaTurmas() {
		while (tblTurmasP.getRowCount() > 0) {
			((DefaultTableModel) tblTurmasP.getModel()).removeRow(0);
		}
	}
	
	private void limparTabelaAlunos() {
		while (tblAlunosP.getRowCount() > 0) {
			((DefaultTableModel) tblAlunosP.getModel()).removeRow(0);
		}
	}
	
	private void limparTabelaAtiv() {
		while (tblAtivNotas.getRowCount() > 0) {
			((DefaultTableModel) tblAtivNotas.getModel()).removeRow(0);
		}
	}
	
	
	
	private void limparAluno() {
		txtAlunosP.setText(null);
		txtIdAluno.setText(null);
		txtNota.setText(null);
		
		

	}
	
	
	private void limparTudo() {
		txtTurmasP.setText(null);	
		txtSiglaN.setText(null);
		txtPeriodoN.setText(null);
		txtAnoTurma.setText(null);
		txtIDC.setText(null);
		txtAtivN.setText(null);
		txtAtivId.setText(null);
		txtProf.setText(null);
		txtAtivBi.setText(null);
		txtNota.setText(null);
		txtAlunosP.setText(null);
		txtIdAluno.setText(null);
		txtMateria.setText(null);
		limparTabelaAlunos();
		limparTabelaTurmas();
		limparTabelaAtiv();
		
	}
	
	
	
	private void adicionarNota() {
		//cria o formatador
				
		
		
		if( 
				 txtSiglaN.getText().isEmpty() 
				|| txtPeriodoN.getText().isEmpty() || txtAnoTurma.getText().isEmpty()
				|| txtIDC.getText().isEmpty() ){
			//confirmar se essa ultima condição funciona
			JOptionPane.showMessageDialog(null, "Faltou informações sobre a turma!");
		
			
		}else if(txtAtivN.getText().isEmpty() || txtAtivBi.getText().isEmpty() 
				|| txtProf.getText().isEmpty() 
				|| txtAtivId.getText().isEmpty() || txtMateria.getText().isEmpty() ) {
			JOptionPane.showMessageDialog(null, "Faltou informações sobre a atividade!");
		}
		else if(txtAlunosP.getText().isEmpty() || txtIdAluno.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Faltou informações sobre o aluno!");
		}
		else if(( txtNota.getText()).isEmpty()) {
			JOptionPane.showMessageDialog(null, "Faltou a nota");
			
		}else {
			DecimalFormat formatador = new DecimalFormat("0.0");	
			Double nota = Double.parseDouble(txtNota.getText().replace(",", "."));
			String notaString = nota.toString();		
		
			
			if(nota > 0 & nota < 11){
				
				String atualizarAtiv = "update tb_notas set nota=? where idativ=? and idaluno = ?";
				String nome = txtAlunosP.getText();
				String ativ = txtAtivN.getText();
				try {
					pst = conexao.prepareStatement(atualizarAtiv);
					//pst.setString(1, txtAtivN.getText());
					//
					//pst.setString(3, txtIDC.getText());
					pst.setString(1, notaString);
					pst.setString(2, txtAtivId.getText());
					pst.setString(3, txtIdAluno.getText());
					//pst.setString(5, txtAtivBi.getText());
					//pst.setString(6, txtMateria.getText());
					int adicionado = pst.executeUpdate();
					
					
					
					
					
					
					
					
					
					
					
					if(adicionado ==1) {
						
								JOptionPane.showMessageDialog(null, "Nota do aluno " + nome +  " na atividade " + ativ + " cadastrada!");
								limparAluno();
					}else {
						JOptionPane.showMessageDialog(null, "Nota do aluno " + nome + " não cadastrada, por favor, confirme as informações");
					}
					
				} catch (Exception e) {
					//System.out.println(e);
				//	JOptionPane.showMessageDialog(null, e);
					JOptionPane.showMessageDialog(null, "O Aluno " + nome + " não fez a atividade " + ativ);
				}
				
			} else {
				JOptionPane.showMessageDialog(null, "Digite um valor válido para a nota!(0 a 10)");
			}
			
			
		}
			
			
	
}
}
	
	
	

