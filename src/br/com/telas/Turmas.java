package br.com.telas;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.dal.ModuloConexao;
import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Turmas extends JDialog {
	private JLabel lblNewLabel;
	private JTextField txtPesquisar;
	private JTextField txtEnsino;
	private JTextField txtAnoIni;
	private JTextField txtAnoLet;
	private JTextField txtId;
	private JTable tblTurmas;
	private JTextField txtCurso;
	private JComboBox cboPeriodo;
	private JComboBox cboSigla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Turmas dialog = new Turmas();
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
	public Turmas() {
		setModal(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Turmas.class.getResource("/br/com/icons/logo_colnovagalax-32.png")));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Turmas");
		setBounds(100, 100, 600, 450);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Pesquisar:");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewLabel.setBounds(26, 34, 57, 14);
		getContentPane().add(lblNewLabel);
		
		txtPesquisar = new JTextField();
		txtPesquisar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pesquisarTurmas();
			}
		});
		txtPesquisar.setBounds(123, 30, 437, 20);
		getContentPane().add(txtPesquisar);
		txtPesquisar.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nivel do Ensino");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(58, 286, 89, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ano de Inicio:");
		lblNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(139, 258, 89, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Sigla:");
		lblNewLabel_3.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(101, 353, 36, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Periodo");
		lblNewLabel_4.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(364, 286, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblAnoLet = new JLabel("Ano Letivo:");
		lblAnoLet.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblAnoLet.setBounds(346, 258, 64, 14);
		getContentPane().add(lblAnoLet);
		
		txtEnsino = new JTextField();
		txtEnsino.setBounds(163, 282, 165, 20);
		getContentPane().add(txtEnsino);
		txtEnsino.setColumns(10);
		
		txtAnoIni = new JTextField();
		txtAnoIni.setBounds(238, 253, 89, 20);
		getContentPane().add(txtAnoIni);
		txtAnoIni.setColumns(10);
		
		txtAnoLet = new JTextField();
		txtAnoLet.setBounds(423, 253, 86, 20);
		getContentPane().add(txtAnoLet);
		txtAnoLet.setColumns(10);
		
		cboPeriodo = new JComboBox();
		cboPeriodo.setModel(new DefaultComboBoxModel(new String[] {"", "MANHA", "TARDE", "NOITE"}));
		cboPeriodo.setBounds(420, 282, 89, 20);
		getContentPane().add(cboPeriodo);
		
		cboSigla = new JComboBox();
		cboSigla.setModel(new DefaultComboBoxModel(new String[] {"", "A", "B", "C", "D"}));
		cboSigla.setBounds(163, 349, 36, 20);
		getContentPane().add(cboSigla);
		
		JButton btnAdd = new JButton("");
		btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTurma();
			}
		});
		btnAdd.setIcon(new ImageIcon(Turmas.class.getResource("/br/com/icons/create.png")));
		btnAdd.setBounds(346, 321, 64, 64);
		getContentPane().add(btnAdd);
		
		JButton btnDelete = new JButton("");
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletar();
			}
		});
		btnDelete.setIcon(new ImageIcon(Turmas.class.getResource("/br/com/icons/delete.png")));
		btnDelete.setBounds(517, 321, 64, 64);
		getContentPane().add(btnDelete);
		
		JButton btnEdit = new JButton("");
		btnEdit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterar();
			}
		});
		btnEdit.setIcon(new ImageIcon(Turmas.class.getResource("/br/com/icons/update.png")));
		btnEdit.setBounds(430, 321, 64, 64);
		getContentPane().add(btnEdit);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblId.setBounds(58, 258, 15, 14);
		getContentPane().add(lblId);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(83, 255, 30, 20);
		getContentPane().add(txtId);
		txtId.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 59, 516, 156);
		getContentPane().add(scrollPane);
		
		tblTurmas = new JTable();
		scrollPane.setColumnHeaderView(tblTurmas);
		tblTurmas.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setarCampos();
			}
		});
		
		
		scrollPane.setViewportView(tblTurmas);
		tblTurmas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		
		
		
		
		
		
		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblCurso.setBounds(111, 311, 36, 14);
		getContentPane().add(lblCurso);
		
		txtCurso = new JTextField();
		txtCurso.setColumns(10);
		txtCurso.setBounds(163, 311, 165, 20);
		getContentPane().add(txtCurso);
		
		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setIcon(new ImageIcon(Turmas.class.getResource("/br/com/icons/icons8-limpar-formata\u00E7\u00E3o-48.png")));
		btnLimpar.setBounds(269, 353, 46, 43);
		getContentPane().add(btnLimpar);
		
		JButton btnNewButton = new JButton("Butin");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnNewButton.setBounds(26, 391, 85, 21);
		getContentPane().add(btnNewButton);
		
		
		conexao = ModuloConexao.conector();
	
	}
	
	
	
	
	
	
	private void addTurma() {
		if(txtAnoIni.getText().isEmpty() || txtAnoLet.getText().isEmpty() || txtEnsino.getText().isEmpty() 
				|| txtCurso.getText().isEmpty() || ((String) cboPeriodo.getSelectedItem()).isEmpty() || ((String) cboSigla.getSelectedItem()).isEmpty()){
			//confirmar se essa ultima condição funciona
			JOptionPane.showMessageDialog(null, "Faltou informações sobre a turma.");
		
			
		}else {
			String adicionar = "insert into tb_turmas(anoinic,ensino,curso,sigla,anolet,periodo) values (?,?,?,?,?,?)";
			try {
				pst = conexao.prepareStatement(adicionar);
				pst.setString(1, txtAnoIni.getText());
				pst.setString(2, txtEnsino.getText());
				pst.setString(3, txtCurso.getText());
				pst.setString(4, cboSigla.getSelectedItem().toString());
				pst.setString(5, txtAnoLet.getText());
				pst.setString(6, cboPeriodo.getSelectedItem().toString());
				// quando é feito algo no banco de dados, é gerado um valor binario(0 ou 1) para definir se a conexão estava OK, no exemplo a baixo
				// int adicionado vai ser 1 se a conexao estiver OK e 0 se não!
				int adicionado = pst.executeUpdate();
				
				
				
				
				int on= 1;
				if(on == 1) {
					
				};
				if(adicionado ==1) {
					JOptionPane.showMessageDialog(null, "Turma Cadastrada!");
					limpar();
				}else {
					JOptionPane.showMessageDialog(null, "Turma não cadastrada, por favor, confirme as informações");
				}
				
			} catch (Exception e) {
				System.out.println(e);
				JOptionPane.showMessageDialog(null, e);
			}
			
		}
	
}
	
	
	
	
	private void pesquisarTurmas() {
		String consultar = "select * from tb_turmas where curso like ?";
		try {
			pst = conexao.prepareStatement(consultar);
			
			pst.setString(1,  txtPesquisar.getText() + "%");
			
			rs = pst.executeQuery();
		
			tblTurmas.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);
			
		}
	}
	private void setarCampos() {
		int setar = tblTurmas.getSelectedRow();
		txtId.setText(tblTurmas.getModel().getValueAt(setar, 0).toString());
		txtAnoIni.setText(tblTurmas.getModel().getValueAt(setar, 1).toString());
		txtEnsino.setText(tblTurmas.getModel().getValueAt(setar, 2).toString());
		txtCurso.setText(tblTurmas.getModel().getValueAt(setar, 3).toString());
		cboSigla.setSelectedItem(tblTurmas.getModel().getValueAt(setar, 4).toString());
		txtAnoLet.setText(tblTurmas.getModel().getValueAt(setar, 5).toString());
		cboPeriodo.setSelectedItem(tblTurmas.getModel().getValueAt(setar, 6).toString());
		//cboSigla.setText(tblTurmas.getModel().getValueAt(setar, 4).toString());
		//cboPeriodo.setText(tblTurmas.getModel().getValueAt(setar, 5).toString());
		
		
	}
	private void limpar() {
		txtId.setText(null);
		txtAnoIni.setText(null);
		txtAnoLet.setText(null);
		txtEnsino.setText(null);
		txtCurso.setText(null);
		cboPeriodo.setSelectedItem("");
		cboSigla.setSelectedItem("");
		txtPesquisar.setText(null);
		// falta limpar as planilhas da pesquisa.
		
	}
	private void alterar() {	
		//validação dos campos obrigatórios
		if(txtAnoIni.getText().isEmpty() || txtAnoLet.getText().isEmpty() || txtEnsino.getText().isEmpty() 
				|| txtCurso.getText().isEmpty() || ((String) cboPeriodo.getSelectedItem()).isEmpty() || ((String) cboSigla.getSelectedItem()).isEmpty()){
			//confirmar se essa ultima condição funciona
			JOptionPane.showMessageDialog(null, "Faltou informações sobre a turma.");
		} else {
			//anoinic, ensino, curso, sigla, anolet, periodo
			String update= "update tb_turmas set anoinic=?,ensino=?,curso=?,sigla=?,anolet=?,periodo=? where idturma=?";
			try {
				pst=conexao.prepareStatement(update);
				
		
				
				pst.setString(1, txtAnoIni.getText());
				pst.setString(2, txtEnsino.getText());
				pst.setString(3, txtCurso.getText());
				pst.setString(4, cboSigla.getSelectedItem().toString());
				pst.setString(5, txtAnoLet.getText());
				pst.setString(6, cboPeriodo.getSelectedItem().toString());
				pst.setString(7, txtId.getText());
				
				
				int alterar = pst.executeUpdate();
				
				//System.out.println(adicionado);
				if (alterar == 1) {
					JOptionPane.showMessageDialog(null, "Alterado com sucesso");
					limpar();
				} else {
					JOptionPane.showMessageDialog(null, "Não foi alterar o contato");
				}
				
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}
	}
	private void deletar() {
		//a linha abaixo cria uma caixa de confirmação
		
				int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão deste registro?","ATENÇÃO", JOptionPane.YES_NO_OPTION);
				if (confirma == JOptionPane.YES_OPTION) {
					String delete= "delete from tb_turmas where idturma=?";
					try {
						pst=conexao.prepareStatement(delete);
						pst.setString(1,txtId.getText());
						int removido = pst.executeUpdate();
						if (removido == 1) {
							limpar();
							JOptionPane.showMessageDialog(null, "Turma Removido");
					}
						
					} catch (Exception e) {
							System.out.println(e);
					}
				
				}

	}
}

