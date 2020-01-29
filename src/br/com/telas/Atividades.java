package br.com.telas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.ScrollPaneConstants;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;
import com.toedter.components.JSpinField;

import br.com.dal.ModuloConexao;
import net.proteanit.sql.DbUtils;

import com.toedter.calendar.JDateChooser;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class Atividades extends JDialog {
	private JTextField txtAtiv;
	static JTextField txtProfAtiv;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable tblAtiv;
	private JTextField txtIdTurma;
	private JTextField txtIdAtiv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Atividades dialog = new Atividades();
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
	PreparedStatement pst,pst2,pst3,pst4 = null;
	ResultSet rs = null;
	
	
	
	
	
	private JComboBox cboBi;
	private JComboBox cboMateria;
	private JTextField txtIdProf;
	private JTextField txtPesquisar;
	private JScrollPane scrollPane;
	private JTable tblTurmas;
	public Atividades() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				cboMaterias();
				//setarLogin();
				//pesquisarIdProf();
			}
		});
		setModal(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Atividades.class.getResource("/br/com/icons/logo_colnovagalax-32.png")));
		setTitle("Atividades");
		setBounds(100, 100, 1374, 730);
		//700 anterior
		getContentPane().setLayout(null);
		
		txtAtiv = new JTextField();
		txtAtiv.setFont(new Font("Verdana", Font.BOLD, 18));
		txtAtiv.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				pesquisarAtividades();
				limparTabelas();
			}
		});
		txtAtiv.setColumns(10);
		txtAtiv.setBounds(173, 335, 249, 33);
		getContentPane().add(txtAtiv);
		
		JLabel label_2 = new JLabel("Atividade:");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Verdana", Font.PLAIN, 18));
		label_2.setBounds(38, 336, 125, 31);
		getContentPane().add(label_2);
		
		JLabel lblNewLabel_1 = new JLabel("Ano:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(24, 33, 79, 33);
		getContentPane().add(lblNewLabel_1);
		
		txtProfAtiv = new JTextField();
		txtProfAtiv.setText("Administrador");
		txtProfAtiv.setHorizontalAlignment(SwingConstants.CENTER);
		txtProfAtiv.setEditable(false);
		txtProfAtiv.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtProfAtiv.setColumns(10);
		txtProfAtiv.setBounds(619, 414, 264, 30);
		getContentPane().add(txtProfAtiv);
		
		JLabel lblProfessor = new JLabel("Professor:");
		lblProfessor.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfessor.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblProfessor.setBounds(449, 412, 160, 33);
		getContentPane().add(lblProfessor);
		
		JButton btnAddAtiv = new JButton("");
		btnAddAtiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarAtiv();
			}
		});
		
		
		btnAddAtiv.setIcon(new ImageIcon(Atividades.class.getResource("/br/com/icons/create.png")));
		btnAddAtiv.setBounds(1256, 33, 79, 79);
		getContentPane().add(btnAddAtiv);
		
		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletarAtiv();
			}
		});
		btnLimpar.setIcon(new ImageIcon(Atividades.class.getResource("/br/com/icons/delete.png")));
		btnLimpar.setBounds(1204, 398, 79, 68);
		getContentPane().add(btnLimpar);
		
		JLabel lblBimestre = new JLabel("*Bimestre:");
		lblBimestre.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblBimestre.setHorizontalAlignment(SwingConstants.CENTER);
		lblBimestre.setBounds(792, 341, 118, 20);
		getContentPane().add(lblBimestre);
		
		cboBi = new JComboBox();
		cboBi.setFont(new Font("Verdana", Font.PLAIN, 18));
		cboBi.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4"}));
		cboBi.setBounds(920, 336, 86, 30);
		getContentPane().add(cboBi);
		
		JButton btnAlterarAtiv = new JButton("");
		btnAlterarAtiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarAtiv();
			}
		});
		btnAlterarAtiv.setIcon(new ImageIcon(Atividades.class.getResource("/br/com/icons/update.png")));
		btnAlterarAtiv.setBounds(1142, 36, 79, 76);
		getContentPane().add(btnAlterarAtiv);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(38, 522, 1297, 156);
		getContentPane().add(scrollPane_1);
		
		tblAtiv = new JTable();
		tblAtiv.setFont(new Font("Verdana", Font.BOLD, 16));
		tblAtiv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setarCampos();
			
				
			}
		});
		//scrollPane_1.setColumnHeaderView();
		scrollPane_1.setViewportView(tblAtiv);
		tblAtiv.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		
		
		JLabel lblId = new JLabel("N\u00BA da Turma:");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblId.setBounds(34, 79, 142, 33);
		getContentPane().add(lblId);
		
		txtIdTurma = new JTextField();
		txtIdTurma.setHorizontalAlignment(SwingConstants.CENTER);
		txtIdTurma.setEditable(false);
		txtIdTurma.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtIdTurma.setColumns(10);
		txtIdTurma.setBounds(300, 79, 95, 33);
		getContentPane().add(txtIdTurma);
		
		JLabel lblNDaAtividade = new JLabel("N\u00BA da Atividade:");
		lblNDaAtividade.setHorizontalAlignment(SwingConstants.CENTER);
		lblNDaAtividade.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNDaAtividade.setBounds(456, 335, 153, 33);
		getContentPane().add(lblNDaAtividade);
		
		txtIdAtiv = new JTextField();
		txtIdAtiv.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtIdAtiv.setEditable(false);
		txtIdAtiv.setColumns(10);
		txtIdAtiv.setBounds(619, 335, 95, 33);
		getContentPane().add(txtIdAtiv);
		
		JButton btnPesquisarT = new JButton("PESQUISAR");
		btnPesquisarT.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnPesquisarT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarAtividades();
				pesquisarTurmas1();
				
			}
		});
		btnPesquisarT.setBounds(1123, 339, 171, 30);
		getContentPane().add(btnPesquisarT);
		
		JButton btnLimpar1 = new JButton("");
		btnLimpar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar1.setIcon(new ImageIcon(Atividades.class.getResource("/br/com/icons/clean.png")));
		btnLimpar1.setBounds(1070, 398, 79, 68);
		getContentPane().add(btnLimpar1);
		
		cboMateria = new JComboBox();
		cboMateria.setFont(new Font("Verdana", Font.PLAIN, 18));
		cboMateria.setBounds(143, 413, 296, 30);
		getContentPane().add(cboMateria);
		
		JButton btnNewButton_2 = new JButton("Pesquisar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				pesquisarIdProf();
				pesquisarAtividades(); 
			}
		});
		btnNewButton_2.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnNewButton_2.setBounds(469, 34, 171, 30);
		getContentPane().add(btnNewButton_2);
		
		txtIdProf = new JTextField();
		txtIdProf.setBounds(619, 467, -18, -24);
		getContentPane().add(txtIdProf);
		txtIdProf.setColumns(10);
		
		JLabel lblMateria = new JLabel("*Materia:");
		lblMateria.setHorizontalAlignment(SwingConstants.CENTER);
		lblMateria.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblMateria.setBounds(38, 418, 118, 20);
		getContentPane().add(lblMateria);
		
		
		
		txtPesquisar = new JTextField();
		txtPesquisar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pesquisarIdProf();
				pesquisarTurmas1();
			}
		});
		txtPesquisar.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtPesquisar.setBounds(113, 35, 278, 29);
		getContentPane().add(txtPesquisar);
		txtPesquisar.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(34, 141, 1306, 166);
		getContentPane().add(scrollPane);
		
		tblTurmas =  new JTable();
		tblTurmas.setFont(new Font("Verdana", Font.PLAIN, 16));
		tblTurmas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				limpar();
				setarCamposT();
				pesquisarAtividades();
				
			}
		});
		//scrollPane.setColumnHeaderView(tblTurmas);
		scrollPane.setViewportView(tblTurmas);
		tblTurmas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		
		JLabel lblCamposObrigatrios = new JLabel("* Campos Obrigat\u00F3rios");
		lblCamposObrigatrios.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblCamposObrigatrios.setBounds(1202, 498, 133, 20);
		getContentPane().add(lblCamposObrigatrios);
		conexao = ModuloConexao.conector();
		
		
		
	}
	private void limparTabelas() {
		// TODO Auto-generated method stub
     
	}
	
	private void pesquisarAtividades() {
		
		//txtTurmasAtiv.setText(null);
		String consultar = "select idativ as NumAtiv, ativ as Atividade, prof as Professor, bi as Bimestre, materia as Materia from tb_ativ where ativ like ? and idturma = ? and idprof like ?";
		try {
			pst = conexao.prepareStatement(consultar);

			//pst.setString(1, txtIdProf.getText() + "%");
			pst.setString(1, txtAtiv.getText() + "%");
			pst.setString(2, txtIdTurma.getText() + "%");
			pst.setString(3, txtIdProf.getText() + "%");

			rs = pst.executeQuery();

			tblAtiv.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			System.out.println(e);
			//JOptionPane.showMessageDialog(null, e);

		}
	}
	
	private void pesquisarTurmas1() {
		
		int qt = 0;
		String idTurmaString = null;
		String consultarTurma = "select idturma as MATRICULA, anoturma as ANO, sigla as TURMA from tb_turmas where anoturma like ?";
	//	String checarTurmaProf = "select * from tb_materia where idturma = ? and prof like ?";
		try {
			
			pst = conexao.prepareStatement(consultarTurma);
          
		
			
			pst.setString(1, txtPesquisar.getText() + "%");

		    	rs = pst.executeQuery();
		    	
         	
			     tblTurmas.setModel(DbUtils.resultSetToTableModel(rs));
			
			
			
			//
			
			
			
		} catch (Exception e) {
			System.out.println(e);
			//JOptionPane.showMessageDialog(null, e);

		}
	}
	
	private void pesquisarIdProf() {
		String buscarIdProf = "select * from tb_dados_funcionarios where nomef like ?";
		String idProf = null;
		int qt = 0;
		
		try {

			pst = conexao.prepareStatement(buscarIdProf);
			pst.setString(1, txtProfAtiv.getText() + "%");
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
	private void setarCamposT(){
		int setar = tblTurmas.getSelectedRow();
		txtIdTurma.setText(tblTurmas.getModel().getValueAt(setar, 0).toString());
	}
	
	private void setarCampos() {
		int setar = tblAtiv.getSelectedRow();
		txtIdAtiv.setText(tblAtiv.getModel().getValueAt(setar, 0).toString());
		txtAtiv.setText(tblAtiv.getModel().getValueAt(setar, 1).toString());
		txtProfAtiv.setText(tblAtiv.getModel().getValueAt(setar, 2).toString());
		cboBi.setSelectedItem(tblAtiv.getModel().getValueAt(setar, 3).toString());
		cboMateria.setSelectedItem(tblAtiv.getModel().getValueAt(setar, 4).toString());
	//	txtData.getDateEditor(tblAtiv.getModel().getValueAt(setar, 5).toString());
		

	}
	

	
	private void limpar() {
		txtAtiv.setText(null);
		cboBi.setSelectedItem("");
		//txtIdTurma.setText(null);
		txtIdAtiv.setText(null);
		txtAtiv.setText(null);
		//txtIdAtiv, txtAtiv
		
			
		
	}
private void limparAtiv() {
	while (tblAtiv.getRowCount() > 0) {
		((DefaultTableModel) tblAtiv.getModel()).removeRow(0);
	}


	

}



	private void adicionarAtiv() {
		if(txtAtiv.getText().isEmpty() || txtProfAtiv.getText().isEmpty() 
				 || ((String) cboBi.getSelectedItem()).isEmpty() 
				|| txtIdTurma.getText().isEmpty() || ((String) cboMateria.getSelectedItem()).isEmpty() ){
			//confirmar se essa ultima condição funciona
			JOptionPane.showMessageDialog(null, "Faltou informações sobre a atividade/turma.");
		
			
		}else {
		
			String idAlunoString = null;
			String idProfString = null;
			String nota = "0.0";
			String adicionarAtiv = "insert into tb_ativ(ativ,prof,bi,idturma,materia,idprof) values (?,?,?,?,?,?)";
			String adicionarAtivAlunos = "insert into tb_notas(ativ,idaluno,idturma,idprof,nota,bi,materia,idativ) values (?,?,?,?,?,?,?,?)";
			String pesquisarAluno = "select * from tb_dados_alunos where idturma = ?";
			String pesquisarProf = "select * from tb_dados_funcionarios where nomef = ? order by idf desc";
			String sincronizarIdAtiv = "select * from tb_ativ order by idativ desc";
			int qt = 0;
			
			try {
				
				//adicionar atividade
				pst = conexao.prepareStatement(adicionarAtiv);
				pst.setString(1, txtAtiv.getText());
				pst.setString(2, txtProfAtiv.getText());
				pst.setString(3, cboBi.getSelectedItem().toString());
				pst.setString(4, txtIdTurma.getText());
				pst.setString(5, cboMateria.getSelectedItem().toString());
				pst.setString(6, txtIdProf.getText());
				int adicionado = pst.executeUpdate();
				//
				
				
				//Pesquisa o Id do professor que logou
				pst2 = conexao.prepareStatement(pesquisarProf);
				pst2.setString(1, txtProfAtiv.getText());
				rs = (ResultSet) pst2.executeQuery();
				while (rs.next()) {
					idProfString = rs.getString("idf");
				}
				
				
				int idAtivInt, ct;
				String idAtivString;

				ct = 0;
				idAtivString = null;
				idAtivInt = 0;
				pst4 = conexao.prepareStatement(sincronizarIdAtiv);
				rs = (ResultSet) pst4.executeQuery();
				while (rs.next() && ct < 1) {

			            ct = ct + 1;
   
					idAtivString = rs.getString("idativ");
					idAtivInt = idAtivInt + Integer.parseInt(idAtivString);
					idAtivString = Integer.toString(idAtivInt);
				
				}
				
				
				
				
				
				
				
				//Adiciona a atividade na tb_notas para cada aluno da turma
				pst3 = conexao.prepareStatement(pesquisarAluno);
				pst3.setString(1, txtIdTurma.getText());
				rs = (ResultSet) pst3.executeQuery();
				while (rs.next()) {
					
					idAlunoString = rs.getString("idal");
					
					pst3 = conexao.prepareStatement(adicionarAtivAlunos);
					pst3.setString(1, txtAtiv.getText());
					pst3.setString(2, idAlunoString);
					pst3.setString(3, txtIdTurma.getText());
					pst3.setString(4, idProfString);
					pst3.setString(5, nota);
					pst3.setString(6, cboBi.getSelectedItem().toString());
					pst3.setString(7, cboMateria.getSelectedItem().toString());
					pst3.setString(8, idAtivString);
						
					pst3.executeUpdate();
				}
				
				
				
				
				
				if(adicionado ==1) {
					JOptionPane.showMessageDialog(null, "Atividade Cadastrada!");
					limpar();
					pesquisarAtividades();
				}else {
					JOptionPane.showMessageDialog(null, "Atividade não cadastrada, por favor, confirme as informações");
				}
				
			} catch (Exception e) {
				System.out.println(e);
				//JOptionPane.showMessageDialog(null, e);
			}
			
		}
	
}
	private void alterarAtiv() {	
		//validação dos campos obrigatórios
		if(txtAtiv.getText().isEmpty() || txtProfAtiv.getText().isEmpty() 
				 || ((String) cboBi.getSelectedItem()).isEmpty() 
				|| txtIdTurma.getText().isEmpty() || ((String) cboMateria.getSelectedItem()).isEmpty()){
			//confirmar se essa ultima condição funciona
            JOptionPane.showMessageDialog(null, "Faltou informações sobre a atividade/turma.");
		
			
		}else {
			String idAlunoString = null;
			String idAtivString = null;
			
			//ativ,bi,materia
			String atualizarAtiv = "update tb_ativ set ativ=?,prof=?,bi=?,idturma=?,materia=? where idativ=?";
			String atualizarAtivNotas = "update tb_notas set ativ=?,bi=?,materia=? where idativ=? and idaluno=?";
			String pesquisarAluno = "select * from tb_notas where idativ = ?";
			int qt = 0;
			try {
				
				
				//Altera a atividade
				pst=conexao.prepareStatement(atualizarAtiv);
				pst.setString(1, txtAtiv.getText());
				pst.setString(2, txtProfAtiv.getText());
				pst.setString(3, cboBi.getSelectedItem().toString());
				pst.setString(4, txtIdTurma.getText());
				pst.setString(5, cboMateria.getSelectedItem().toString());
				pst.setString(6, txtIdAtiv.getText());
			
				
				
				
				
				
				

				pst3 = conexao.prepareStatement(pesquisarAluno);
				pst3.setString(1, txtIdAtiv.getText());
				rs = (ResultSet) pst3.executeQuery();
				while (rs.next()) {
					idAlunoString = rs.getString("idaluno");
				
					
					pst2=conexao.prepareStatement(atualizarAtivNotas);
					pst2.setString(1, txtAtiv.getText());
					pst2.setString(2, cboBi.getSelectedItem().toString());
					pst2.setString(3, cboMateria.getSelectedItem().toString());
					pst2.setString(4, txtIdAtiv.getText());
					pst2.setString(5, idAlunoString);
					pst2.executeUpdate();
				}
						
				int alterar = pst.executeUpdate();
				
				
				
				if (alterar == 1 ) {
					JOptionPane.showMessageDialog(null, "Alterado com sucesso");
					
					limpar();
					pesquisarAtividades();
				} else {
					JOptionPane.showMessageDialog(null, "Não foi possivel alterar as informações, por favor confirme os dados");
				}
				
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}
	}
	
	//Deletar feito no SENAC
		private void deletarAtiv() {
			//a linha abaixo cria uma caixa de confirmação
			    
					int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão desta atividade?","ATENÇÃO", JOptionPane.YES_NO_OPTION);
					if (confirma == JOptionPane.YES_OPTION) {
						
						String deletarAtiv= "delete from tb_ativ where idativ = ?";
						String deletarAtivNotas = "delete from tb_notas where idativ = ?";
						String pesquisarAtivNotas = "select * from tb_notas where idativ = ?";
						String idAtivString;
						try {
							pst=conexao.prepareStatement(deletarAtiv);
							pst.setString(1,txtIdAtiv.getText());
							
							pst3 = conexao.prepareStatement(pesquisarAtivNotas);
							pst3.setString(1, txtIdAtiv.getText());
							rs = (ResultSet) pst3.executeQuery();
							while (rs.next()) {

							    idAtivString = rs.getString("idativ");
								//JOptionPane.showMessageDialog(null, idAtivString);
								pst2=conexao.prepareStatement(deletarAtivNotas);
								pst2.setString(1, txtIdAtiv.getText());
								pst2.executeUpdate();
								
								
							}
										
							
											
							
							
							
							
							int removido = pst.executeUpdate();
							if (removido == 1) {
								limpar();
								pesquisarAtividades();
								JOptionPane.showMessageDialog(null, "Atividade Removida");
						}
							
						} catch (Exception e) {
								System.out.println(e);
						}
					
					}

		}
		//Deletar feito no SENAC
	
	private void cboMaterias() {
		
		String preencherMaterias = "select * from tb_dados_funcionarios where nomef = ?";
		try {

			pst = conexao.prepareStatement(preencherMaterias);
			pst.setString(1,txtProfAtiv.getText());
			rs = (ResultSet) pst.executeQuery();
			cboMateria.removeAllItems();
			
			while (rs.next()) {

				cboMateria.addItem(rs.getString("materia1"));
				cboMateria.addItem(rs.getString("materia2"));

			}
		} catch (Exception e) {
			System.out.println(e);
			//JOptionPane.showMessageDialog(null, e);

		}

	}
	
	private void setarAnoSigla() {
		int qt = 0;
		String idTurmaString = null;
		String consultarProfessor1 = "select * from tb_materia where prof like ?";
		String consultarAlunos = "select * from tb_dados_alunos where idturma like ?";
		try {
			
			pst = conexao.prepareStatement(consultarProfessor1);			
			pst.setString(1, txtProfAtiv.getText() + "%");
		    	rs = pst.executeQuery();
		    	
         
		    	rs.next();
            	
                 idTurmaString = rs.getString("idturma");
            	//txtPesquisar.setText(idTurmaString);
         
            
            pst = conexao.prepareStatement(consultarAlunos);
            pst.setString(1, idTurmaString);
            
            
			
			
			rs = pst.executeQuery();

			//tblTeste.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);

		}
	}
}
