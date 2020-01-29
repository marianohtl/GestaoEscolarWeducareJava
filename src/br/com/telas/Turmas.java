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
import javax.swing.ButtonGroup;
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
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.border.CompoundBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.UIManager;

public class Turmas extends JDialog {
	private JLabel lblNewLabel;
	private JTextField txtPesquisar;
	private JTextField txtId;
	private JTable tblTurmas;
	private JComboBox cboPeriodo;
	private JComboBox cboSigla;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Turmas dialog = new Turmas();
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
	PreparedStatement pst, pst2, pst3 = null;
	ResultSet rs = null;
	private JComboBox cboQuimica;
	private JComboBox cboFisica;
	private JComboBox cboBiologia;
	private JTextField txtEnsino;
	private JComboBox cboSociologia;
	private JComboBox cboFilosofia;
	private JComboBox cboAnoTurma;
	private JComboBox cboAnoLet;
	private JComboBox cboMatematica;
	private JComboBox cboEdFisica;
	private JComboBox cboGeografia;
	private JComboBox cboArtes;
	private JComboBox cboPortugues;
	private JComboBox cboHistoria;
	private JComboBox cboIngles;
	private JTextField txtGamb;
	private JButton btnNewButton_1;

	public Turmas() {
		getContentPane().setFont(new Font("Comic Sans MS", Font.BOLD, 10));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				pesquisarProf();
			}
		});
		setModal(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Turmas.class.getResource("/br/com/icons/logo_colnovagalax-32.png")));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Turmas");
		setBounds(100, 100, 1374, 730);
		getContentPane().setLayout(null);

		lblNewLabel = new JLabel("Pesquisar:");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel.setBounds(38, 32, 103, 22);
		getContentPane().add(lblNewLabel);

		txtPesquisar = new JTextField();
		txtPesquisar.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtPesquisar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pesquisarTurmas();
			}
		});
		txtPesquisar.setBounds(151, 29, 467, 30);
		getContentPane().add(txtPesquisar);
		txtPesquisar.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nivel do Ensino:");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(464, 640, 154, 22);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Ano da Turma:");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(164, 643, 145, 24);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Sigla:");
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(822, 628, 55, 30);
		getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Per\u00EDodo:");
		lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(794, 585, 83, 30);
		getContentPane().add(lblNewLabel_4);

		JLabel lblAnoLet = new JLabel("Ano Letivo:");
		lblAnoLet.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblAnoLet.setBounds(505, 588, 119, 24);
		getContentPane().add(lblAnoLet);

		cboPeriodo = new JComboBox();
		cboPeriodo.setFont(new Font("Verdana", Font.PLAIN, 18));
		cboPeriodo.setModel(new DefaultComboBoxModel(new String[] {"", "MANH\u00C3", "TARDE", "NOITE"}));
		cboPeriodo.setBounds(884, 585, 103, 30);
		getContentPane().add(cboPeriodo);

		cboSigla = new JComboBox();
		cboSigla.setModel(new DefaultComboBoxModel(new String[] { "", "A", "B", "C", "D" }));
		cboSigla.setBounds(887, 632, 55, 30);
		getContentPane().add(cboSigla);

		JButton btnAdd = new JButton("");
		btnAdd.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gamb2();
				Gamb();
				addTurma();
				
			}
		});
		btnAdd.setIcon(new ImageIcon(Turmas.class.getResource("/br/com/icons/create.png")));
		btnAdd.setBounds(1122, 588, 90, 90);
		getContentPane().add(btnAdd);

		JButton btnEdit = new JButton("");
		btnEdit.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnEdit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gamb2();
				Gamb();
				alterar();
			}
		});
		btnEdit.setIcon(new ImageIcon(Turmas.class.getResource("/br/com/icons/update.png")));
		btnEdit.setBounds(1236, 588, 90, 90);
		getContentPane().add(btnEdit);

		JLabel lblId = new JLabel("N\u00BA da Turma:");
		lblId.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblId.setBounds(176, 587, 130, 27);
		getContentPane().add(lblId);

		txtId = new JTextField();
		txtId.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtId.setEditable(false);
		txtId.setBounds(320, 587, 36, 30);
		getContentPane().add(txtId);
		txtId.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 85, 1288, 170);
		getContentPane().add(scrollPane);

		tblTurmas = new JTable();
		tblTurmas.setFont(new Font("Verdana", Font.PLAIN, 16));
		tblTurmas.setBackground(new Color(255, 255, 255));
		scrollPane.setColumnHeaderView(tblTurmas);
		tblTurmas.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// pesquisarProf();
				setarCampos();
				setarProf();
				Gamb();
			}
		});

		scrollPane.setViewportView(tblTurmas);
		tblTurmas.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));

		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
				pesquisarProf();
			}
		});
		btnLimpar.setIcon(
				new ImageIcon(Turmas.class.getResource("/br/com/icons/icons8-limpar-formata\u00E7\u00E3o-48.png")));
		btnLimpar.setBounds(1030, 583, 46, 43);
		getContentPane().add(btnLimpar);

		txtEnsino = new JTextField();
		txtEnsino.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnsino.setText("M\u00E9dio");
		txtEnsino.setEditable(false);
		txtEnsino.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtEnsino.setColumns(10);
		txtEnsino.setBounds(628, 637, 166, 30);
		getContentPane().add(txtEnsino);

		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBounds(716, 321, 610, 224);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblFilosofia = new JLabel("Filosofia");
		lblFilosofia.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblFilosofia.setBounds(337, 153, 89, 23);
		panel.add(lblFilosofia);
		lblFilosofia.setHorizontalAlignment(SwingConstants.CENTER);

		cboFilosofia = new JComboBox();
		cboFilosofia.setFont(new Font("Verdana", Font.PLAIN, 16));
		cboFilosofia.setBounds(347, 177, 232, 30);
		panel.add(cboFilosofia);

		JLabel lblSociologia = new JLabel("Sociologia");
		lblSociologia.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblSociologia.setBounds(337, 77, 107, 23);
		panel.add(lblSociologia);
		lblSociologia.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblFisica = new JLabel("F\u00EDsica");
		lblFisica.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblFisica.setBounds(334, 11, 72, 23);
		panel.add(lblFisica);
		lblFisica.setHorizontalAlignment(SwingConstants.CENTER);

		cboFisica = new JComboBox();
		cboFisica.setFont(new Font("Verdana", Font.PLAIN, 16));
		cboFisica.setBounds(348, 36, 232, 30);
		panel.add(cboFisica);

		cboQuimica = new JComboBox();
		cboQuimica.setFont(new Font("Verdana", Font.PLAIN, 16));
		cboQuimica.setBounds(56, 104, 232, 30);
		panel.add(cboQuimica);

		cboSociologia = new JComboBox();
		cboSociologia.setFont(new Font("Verdana", Font.PLAIN, 16));
		cboSociologia.setBounds(348, 104, 232, 30);
		panel.add(cboSociologia);

		cboBiologia = new JComboBox();
		cboBiologia.setFont(new Font("Verdana", Font.PLAIN, 16));
		cboBiologia.setBounds(56, 36, 232, 30);
		panel.add(cboBiologia);

		JLabel lblBiologia = new JLabel("Biologia");
		lblBiologia.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblBiologia.setBounds(50, 11, 80, 23);
		panel.add(lblBiologia);
		lblBiologia.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblQumica = new JLabel("Qu\u00EDmica");
		lblQumica.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblQumica.setBounds(50, 77, 81, 23);
		panel.add(lblQumica);
		lblQumica.setHorizontalAlignment(SwingConstants.CENTER);
		
				JLabel lblNewLabel_6 = new JLabel("L\u00EDngua Portuguesa");
				lblNewLabel_6.setBounds(56, 153, 159, 23);
				panel.add(lblNewLabel_6);
				lblNewLabel_6.setFont(new Font("Verdana", Font.PLAIN, 16));
				lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
				
						cboPortugues = new JComboBox();
						cboPortugues.setFont(new Font("Verdana", Font.PLAIN, 16));
						cboPortugues.setBounds(56, 177, 232, 30);
						panel.add(cboPortugues);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_2.setBounds(38, 321, 635, 224);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
				
						JLabel lblMatemtica = new JLabel("Matem\u00E1tica");
						lblMatemtica.setFont(new Font("Verdana", Font.PLAIN, 16));
						lblMatemtica.setBounds(44, 26, 112, 23);
						panel_2.add(lblMatemtica);
						lblMatemtica.setHorizontalAlignment(SwingConstants.CENTER);
						
								cboEdFisica = new JComboBox();
								cboEdFisica.setFont(new Font("Verdana", Font.PLAIN, 16));
								cboEdFisica.setBounds(344, 48, 232, 30);
								panel_2.add(cboEdFisica);
								
										cboMatematica = new JComboBox();
										cboMatematica.setFont(new Font("Verdana", Font.PLAIN, 16));
										cboMatematica.setBounds(49, 48, 235, 30);
										panel_2.add(cboMatematica);
										
												JLabel lblGeografia = new JLabel("Geografia");
												lblGeografia.setBounds(42, 87, 94, 23);
												panel_2.add(lblGeografia);
												lblGeografia.setFont(new Font("Verdana", Font.PLAIN, 16));
												lblGeografia.setHorizontalAlignment(SwingConstants.CENTER);
												
														cboGeografia = new JComboBox();
														cboGeografia.setFont(new Font("Verdana", Font.PLAIN, 16));
														cboGeografia.setBounds(49, 110, 235, 30);
														panel_2.add(cboGeografia);
														
																cboArtes = new JComboBox();
																cboArtes.setFont(new Font("Verdana", Font.PLAIN, 16));
																cboArtes.setBounds(49, 173, 235, 30);
																panel_2.add(cboArtes);
																		
																				JLabel lblEdfisica = new JLabel("Educa\u00E7\u00E3o F\u00EDsica");
																				lblEdfisica.setBounds(339, 26, 138, 23);
																				panel_2.add(lblEdfisica);
																				lblEdfisica.setFont(new Font("Verdana", Font.PLAIN, 16));
																				lblEdfisica.setHorizontalAlignment(SwingConstants.CENTER);
																				
																						JLabel lblHistoria = new JLabel("Hist\u00F3ria");
																						lblHistoria.setBounds(327, 89, 100, 23);
																						panel_2.add(lblHistoria);
																						lblHistoria.setFont(new Font("Verdana", Font.PLAIN, 16));
																						lblHistoria.setHorizontalAlignment(SwingConstants.CENTER);
																						
																								cboHistoria = new JComboBox();
																								cboHistoria.setFont(new Font("Verdana", Font.PLAIN, 16));
																								cboHistoria.setBounds(344, 110, 232, 30);
																								panel_2.add(cboHistoria);
																								
																										JLabel lblIngles = new JLabel("Ingl\u00EAs");
																										lblIngles.setBounds(339, 151, 64, 23);
																										panel_2.add(lblIngles);
																										lblIngles.setFont(new Font("Verdana", Font.PLAIN, 16));
																										lblIngles.setHorizontalAlignment(SwingConstants.CENTER);
																										
																												cboIngles = new JComboBox();
																												cboIngles.setFont(new Font("Verdana", Font.PLAIN, 16));
																												cboIngles.setBounds(346, 173, 230, 30);
																												panel_2.add(cboIngles);
																												
																														JLabel lblArtes = new JLabel("Artes");
																														lblArtes.setBounds(44, 151, 54, 23);
																														panel_2.add(lblArtes);
																														lblArtes.setFont(new Font("Verdana", Font.PLAIN, 16));
																														lblArtes.setHorizontalAlignment(SwingConstants.CENTER);

		cboAnoTurma = new JComboBox();
		cboAnoTurma.setFont(new Font("Verdana", Font.PLAIN, 18));
		cboAnoTurma.setModel(new DefaultComboBoxModel(new String[] { "", "1", "2", "3" }));
		cboAnoTurma.setBounds(319, 641, 119, 30);
		getContentPane().add(cboAnoTurma);

		cboAnoLet = new JComboBox();
		cboAnoLet.setFont(new Font("Verdana", Font.PLAIN, 18));
		cboAnoLet.setModel(new DefaultComboBoxModel(new String[] { "", "2019" }));
		cboAnoLet.setBounds(628, 587, 89, 30);
		getContentPane().add(cboAnoLet);

		txtGamb = new JTextField();
		txtGamb.setEditable(false);
		txtGamb.setBounds(588, 583, 10, -5);
		getContentPane().add(txtGamb);
		txtGamb.setColumns(10);
		
		JButton btnProfessores = new JButton("");
		btnProfessores.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnProfessores.setIcon(new ImageIcon(Turmas.class.getResource("/br/com/icons/update.png")));
		btnProfessores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarProf();
			}
		});
		btnProfessores.setBounds(38, 588, 90, 90);
		getContentPane().add(btnProfessores);
		
				JLabel lblNewLabel_5 = new JLabel("SELECIONE OS PROFESSORES DA TURMA:");
				lblNewLabel_5.setBounds(33, 276, 371, 23);
				getContentPane().add(lblNewLabel_5);
				lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_5.setFont(new Font("Verdana", Font.PLAIN, 16));
				
						JButton btnNewButton = new JButton("PESQUISAR");
						btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 16));
						btnNewButton.setBounds(464, 275, 145, 25);
						getContentPane().add(btnNewButton);
						
						JLabel lblNewLabel_7 = new JLabel("TURMAS");
						lblNewLabel_7.setFont(new Font("Verdana", Font.PLAIN, 14));
						lblNewLabel_7.setBounds(1246, 555, 70, 14);
						getContentPane().add(lblNewLabel_7);
						
						JLabel lblNewLabel_8 = new JLabel("PROFESSORES");
						lblNewLabel_8.setFont(new Font("Verdana", Font.PLAIN, 14));
						lblNewLabel_8.setBounds(38, 556, 109, 22);
						getContentPane().add(lblNewLabel_8);
						btnNewButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								pesquisarProf();
							}
						});
		
		

		conexao = ModuloConexao.conector();

	}

	// idturma, anoturma, ensino, sigla, anolet, periodo

	private void pesquisarTurmas() {
		String consultar = "select  idturma as Matricula, anoturma as Ano, ensino as Ensino, sigla as Turma, anolet as AnoLetivo, periodo as Periodo from tb_turmas where anoturma like ?";
		try {
			pst = conexao.prepareStatement(consultar);

			pst.setString(1, txtPesquisar.getText() + "%");

			rs = pst.executeQuery();

			tblTurmas.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);

		}
	}

	private void setarCampos() {
		int setar = tblTurmas.getSelectedRow();
		// txtId Pega o idTurma
		txtId.setText(tblTurmas.getModel().getValueAt(setar, 0).toString());
		cboAnoTurma.setSelectedItem(tblTurmas.getModel().getValueAt(setar, 1).toString());
		txtEnsino.setText(tblTurmas.getModel().getValueAt(setar, 2).toString());
		cboSigla.setSelectedItem(tblTurmas.getModel().getValueAt(setar, 3).toString());
		cboAnoLet.setSelectedItem(tblTurmas.getModel().getValueAt(setar, 4).toString());
		cboPeriodo.setSelectedItem(tblTurmas.getModel().getValueAt(setar, 5).toString());

	}
// esta funcionando
	private void setarProf() {
		int qt = 0;
		String qtt;
		String professor = null;
		String profTurmaPortugues = "select * from tb_materia where idturma = ? and materia like 'LINGUA PORTUGUESA'";
		String profTurmaArtes = "select * from tb_materia where idturma = ? and materia like 'ARTES'";
		String profTurmaBiologia = "select * from tb_materia where idturma = ? and materia like 'BIOLOGIA'";
		String profTurmaFisica = "select * from tb_materia where idturma = ? and materia like 'FISICA'";
		String profTurmaQuimica = "select * from tb_materia where idturma = ? and materia like 'QUIMICA'";
		String profTurmaEdFisica = "select * from tb_materia where idturma = ? and materia like 'EDUCACAO FISICA'";
		String profTurmaFilosofia = "select * from tb_materia where idturma = ? and materia like 'FILOSOFIA'";		
		String profTurmaGeografia = "select * from tb_materia where idturma = ? and materia like 'GEOGRAFIA'";
		String profTurmaHistoria = "select * from tb_materia where idturma = ? and materia like 'HISTORIA'";
		String profTurmaIngles = "select * from tb_materia where idturma = ? and materia like 'INGLES'";
		String profTurmaMatematica = "select * from tb_materia where idturma = ? and materia like 'MATEMATICA'";
		String profTurmaSociologia = "select * from tb_materia where idturma = ? and materia like 'SOCIOLOGIA'";

		// ARTES,BIOLOGIA, EDUCACAO FISICA, FILOSOFIA, FISICA, GEOGRAFIA, HISTORIA,
		// INGLES, MATEMATICA, PORTUGUES, QUIMICA, SOCIOLOGIA

		// PORTUGUES
		try {

			pst = conexao.prepareStatement(profTurmaPortugues);
			pst.setString(1, txtId.getText());
			rs = pst.executeQuery();
			while (rs.next()) {
				qt = qt + 1;
				professor = rs.getString("prof");
				cboPortugues.setSelectedItem(professor);
			}
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);

		}
       //MATEMATICA
		try {

			pst = conexao.prepareStatement(profTurmaMatematica);
			pst.setString(1, txtId.getText());
			rs = pst.executeQuery();
			while (rs.next()) {
				qt = qt + 1;
				professor = rs.getString("prof");
				cboMatematica.setSelectedItem(professor);
			}
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);

		}

		try {

			pst = conexao.prepareStatement(profTurmaGeografia);
			pst.setString(1, txtId.getText());
			rs = pst.executeQuery();
			while (rs.next()) {
				qt = qt + 1;
				professor = rs.getString("prof");
				cboGeografia.setSelectedItem(professor);
			}
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);

		}

		try {

			pst = conexao.prepareStatement(profTurmaHistoria);
			pst.setString(1, txtId.getText());
			rs = pst.executeQuery();
			while (rs.next()) {
				qt = qt + 1;
				professor = rs.getString("prof");
				cboHistoria.setSelectedItem(professor);
			}
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);

		}

		try {

			pst = conexao.prepareStatement(profTurmaBiologia);
			pst.setString(1, txtId.getText());
			rs = pst.executeQuery();
			while (rs.next()) {
				qt = qt + 1;
				professor = rs.getString("prof");
				cboBiologia.setSelectedItem(professor);
			}
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);

		}

		try {

			pst = conexao.prepareStatement(profTurmaSociologia);
			pst.setString(1, txtId.getText());
			rs = pst.executeQuery();
			while (rs.next()) {
				qt = qt + 1;
				professor = rs.getString("prof");
				cboSociologia.setSelectedItem(professor);
			}
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);

		}

		try {

			pst = conexao.prepareStatement(profTurmaFilosofia);
			pst.setString(1, txtId.getText());
			rs = pst.executeQuery();
			while (rs.next()) {
				qt = qt + 1;
				professor = rs.getString("prof");
				cboFilosofia.setSelectedItem(professor);
			}
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);

		}

		try {

			pst = conexao.prepareStatement(profTurmaIngles);
			pst.setString(1, txtId.getText());
			rs = pst.executeQuery();
			while (rs.next()) {
				qt = qt + 1;
				professor = rs.getString("prof");
				cboIngles.setSelectedItem(professor);
			}
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);

		}

		try {

			pst = conexao.prepareStatement(profTurmaArtes);
			pst.setString(1, txtId.getText());
			rs = pst.executeQuery();
			while (rs.next()) {
				qt = qt + 1;
				professor = rs.getString("prof");
				cboArtes.setSelectedItem(professor);
			}
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);

		}

		try {

			pst = conexao.prepareStatement(profTurmaEdFisica);
			pst.setString(1, txtId.getText());
			rs = pst.executeQuery();
			while (rs.next()) {
				qt = qt + 1;
				professor = rs.getString("prof");
				cboEdFisica.setSelectedItem(professor);
			}
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);

		}

		try {

			pst = conexao.prepareStatement(profTurmaFisica);
			pst.setString(1, txtId.getText());
			rs = pst.executeQuery();
			while (rs.next()) {
				qt = qt + 1;
				professor = rs.getString("prof");
				cboFisica.setSelectedItem(professor);
			}
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);

		}
		
try {
			
			pst = conexao.prepareStatement(profTurmaQuimica);
			pst.setString(1, txtId.getText());
			rs = pst.executeQuery();
			while(rs.next()) {
				qt = qt +1;
				professor = rs.getString("prof");
				cboQuimica.setSelectedItem(professor);
			}	
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);

		}

	}

	private void limpar() {
		txtGamb.setText(null);
		txtId.setText(null);
		cboAnoTurma.setSelectedItem("");
		// txtEnsino.setText(null);
		cboSigla.setSelectedItem("");
		cboAnoLet.setSelectedItem("");
		cboPeriodo.setSelectedItem("");
		txtPesquisar.setText(null);
		limparTabela();
		// materias

		// falta limpar as planilhas da pesquisa.

	}

	private void limparProf() {
		cboMatematica.removeAllItems();
		cboPortugues.removeAllItems();
		cboGeografia.removeAllItems();
		cboHistoria.removeAllItems();
		cboBiologia.removeAllItems();
		cboFilosofia.removeAllItems();
		cboSociologia.removeAllItems();
		cboQuimica.removeAllItems();
		cboArtes.removeAllItems();
		cboEdFisica.removeAllItems();
		cboFisica.removeAllItems();
		cboIngles.removeAllItems();
		cboMatematica.setSelectedItem("");
		cboPortugues.setSelectedItem("");
		cboGeografia.setSelectedItem("");
		cboHistoria.setSelectedItem("");
		cboFisica.setSelectedItem("");
		cboQuimica.setSelectedItem("");
		cboArtes.setSelectedItem("");
		cboFilosofia.setSelectedItem("");
		cboSociologia.setSelectedItem("");
		cboIngles.setSelectedItem("");
		cboBiologia.setSelectedItem("");
		cboEdFisica.setSelectedItem("");

	}
	private void gamb2() {
		txtGamb.setText(null);

	}
	
	private void alterarProf() {
		// validação dos campos obrigatórios
				if (((String) cboAnoTurma.getSelectedItem()).isEmpty() || txtEnsino.getText().isEmpty()
						|| ((String) cboSigla.getSelectedItem()).isEmpty() || ((String) cboAnoLet.getSelectedItem()).isEmpty()
						|| ((String) cboPeriodo.getSelectedItem()).isEmpty()) {
					// confirmar se essa ultima condição funciona
					JOptionPane.showMessageDialog(null, "Faltou informações sobre a turma.");
				} else  {
					// idturma, anoturma, ensino, sigla, anolet, periodo
					String idProfString = null;
					String update = "update tb_turmas set anoturma=?,ensino=?,sigla=?,anolet=?,periodo=? where idturma=?";
					
					String updatePortugues = "update tb_materia set idprof = ?, prof = ? where idturma=? and materia like 'LINGUA PORTUGUESA'";
					String updateMatematica = "update tb_materia set idprof = ?, prof = ? where idturma=? and materia like 'MATEMATICA'";
				    String updateGeografia = "update tb_materia set idprof = ?, prof = ? where idturma=? and materia like 'GEOGRAFIA'";
				    String updateHistoria = "update tb_materia set idprof = ?, prof = ? where idturma=? and materia like 'HISTORIA'";
				    String updateBiologia = "update tb_materia set idprof=?, prof = ? where idturma=? and materia like 'HISTORIA'";
				    String updateFisica = "update tb_materia set idprof=?, prof = ? where idturma=? and materia like 'FISICA'";
				    String updateQuimica = "update tb_materia set idprof=?, prof = ? where idturma=? and materia like 'QUIMICA'";
				    String updateFilosofia = "update tb_materia set idprof=?, prof =? where idturma=? and materia like 'FILOSOFIA'";
				    String updateSociologia = "update tb_materia set idprof=?, prof =? where idturma=? and materia like 'SOCIOLOGIA'";
				    String updateEdFisica = "update tb_materia set idprof=?, prof=? where idturma=? and materia like 'EDUCACAO FISICA'";
				    String updateIngles = "update tb_materia set idprof=?, prof=? where idturma=? and materia like 'INGLES'";
				    String updateArtes = "update tb_materia set idprof=?, prof=? where idturma=? and materia like 'ARTES'";
					
					String pesquisarIdProf = "select * from tb_dados_funcionarios where nomef like ?";
					
						
						//Atualiza Artes
						try {
							pst2 = conexao.prepareStatement(pesquisarIdProf);
							pst2.setString(1, cboArtes.getSelectedItem().toString());
							rs = (ResultSet) pst2.executeQuery();
							while (rs.next()) {
								idProfString = rs.getString("idf");
							}
							

							pst3 = conexao.prepareStatement(updateArtes);
							pst3.setString(1, idProfString);
							pst3.setString(2, cboArtes.getSelectedItem().toString());
							pst3.setString(3, txtId.getText());
							pst3.executeUpdate();
						
						} catch (Exception e) {
							System.out.println(e);
						

						}
						
						//Atualiza Ingles
						try {
							pst2 = conexao.prepareStatement(pesquisarIdProf);
							pst2.setString(1, cboIngles.getSelectedItem().toString());
							rs = (ResultSet) pst2.executeQuery();
							while (rs.next()) {
								idProfString = rs.getString("idf");
							}
							

							pst3 = conexao.prepareStatement(updateIngles);
							pst3.setString(1, idProfString);
							pst3.setString(2, cboIngles.getSelectedItem().toString());
							pst3.setString(3, txtId.getText());
							pst3.executeUpdate();
						
						} catch (Exception e) {
							System.out.println(e);
						//	JOptionPane.showMessageDialog(null, e);

						}
						
						//Atualiza EdFisica
						try {
							pst2 = conexao.prepareStatement(pesquisarIdProf);
							pst2.setString(1, cboEdFisica.getSelectedItem().toString());
							rs = (ResultSet) pst2.executeQuery();
							while (rs.next()) {
								idProfString = rs.getString("idf");
							}
							

							pst3 = conexao.prepareStatement(updateEdFisica);
							pst3.setString(1, idProfString);
							pst3.setString(2, cboEdFisica.getSelectedItem().toString());
							pst3.setString(3, txtId.getText());
							pst3.executeUpdate();
						
						} catch (Exception e) {
							System.out.println(e);
						//	JOptionPane.showMessageDialog(null, e);

						}
						
						//Atualiza Sociologia
						try {
							pst2 = conexao.prepareStatement(pesquisarIdProf);
							pst2.setString(1, cboSociologia.getSelectedItem().toString());
							rs = (ResultSet) pst2.executeQuery();
							while (rs.next()) {
								idProfString = rs.getString("idf");
							}
							

							pst3 = conexao.prepareStatement(updateSociologia);
							pst3.setString(1, idProfString);
							pst3.setString(2, cboSociologia.getSelectedItem().toString());
							pst3.setString(3, txtId.getText());
							pst3.executeUpdate();
						
						} catch (Exception e) {
							System.out.println(e);
						//	JOptionPane.showMessageDialog(null, e);

						}
						
						//Atualiza Filosofia
						try {
							pst2 = conexao.prepareStatement(pesquisarIdProf);
							pst2.setString(1, cboFilosofia.getSelectedItem().toString());
							rs = (ResultSet) pst2.executeQuery();
							while (rs.next()) {
								idProfString = rs.getString("idf");
							}
							

							pst3 = conexao.prepareStatement(updateFilosofia);
							pst3.setString(1, idProfString);
							pst3.setString(2, cboFilosofia.getSelectedItem().toString());
							pst3.setString(3, txtId.getText());
							pst3.executeUpdate();
						
						} catch (Exception e) {
							System.out.println(e);
						//	JOptionPane.showMessageDialog(null, e);

						}
						
						//Atualiza Biologia 
						try {
							pst2 = conexao.prepareStatement(pesquisarIdProf);
							pst2.setString(1, cboBiologia.getSelectedItem().toString());
							rs = (ResultSet) pst2.executeQuery();
							while (rs.next()) {
								idProfString = rs.getString("idf");
							}
							

							pst3 = conexao.prepareStatement(updateBiologia);
							pst3.setString(1, idProfString);
							pst3.setString(2, cboBiologia.getSelectedItem().toString());
							pst3.setString(3, txtId.getText());
							pst3.executeUpdate();
						
						} catch (Exception e) {
							System.out.println(e);
						//	JOptionPane.showMessageDialog(null, e);

						}
						//Atualiza Portugues
						try {
							pst2 = conexao.prepareStatement(pesquisarIdProf);
							pst2.setString(1, cboPortugues.getSelectedItem().toString());
							rs = (ResultSet) pst2.executeQuery();
							while (rs.next()) {
								idProfString = rs.getString("idf");
							}
							

							pst3 = conexao.prepareStatement(updatePortugues);
							pst3.setString(1, idProfString);
							pst3.setString(2, cboPortugues.getSelectedItem().toString());
							pst3.setString(3, txtId.getText());
							pst3.executeUpdate();
						
						} catch (Exception e) {
							System.out.println(e);

						}
						
						//Atualiza Matematica
						try {
							pst2 = conexao.prepareStatement(pesquisarIdProf);
							pst2.setString(1, cboMatematica.getSelectedItem().toString());
							rs = (ResultSet) pst2.executeQuery();
							while (rs.next()) {
								idProfString = rs.getString("idf");
							}
							

							pst3 = conexao.prepareStatement(updateMatematica);
							pst3.setString(1, idProfString);
							pst3.setString(2, cboMatematica.getSelectedItem().toString());
							pst3.setString(3, txtId.getText());
							pst3.executeUpdate();
						
						} catch (Exception e) {
							System.out.println(e);
						//	JOptionPane.showMessageDialog(null, e);

						}
						
						//Atualiza Geografia
						try {
							pst2 = conexao.prepareStatement(pesquisarIdProf);
							pst2.setString(1, cboGeografia.getSelectedItem().toString());
							rs = (ResultSet) pst2.executeQuery();
							while (rs.next()) {
								idProfString = rs.getString("idf");
							}
							

							pst3 = conexao.prepareStatement(updateGeografia);
							pst3.setString(1, idProfString);
							pst3.setString(2, cboGeografia.getSelectedItem().toString());
							pst3.setString(3, txtId.getText());
							pst3.executeUpdate();
						
						} catch (Exception e) {
							System.out.println(e);
						//	JOptionPane.showMessageDialog(null, e);

						}
						
						//Atualiza Historia
						try {
							pst2 = conexao.prepareStatement(pesquisarIdProf);
							pst2.setString(1, cboHistoria.getSelectedItem().toString());
							rs = (ResultSet) pst2.executeQuery();
							while (rs.next()) {
								idProfString = rs.getString("idf");
							}
							

							pst3 = conexao.prepareStatement(updateHistoria);
							pst3.setString(1, idProfString);
							pst3.setString(2, cboHistoria.getSelectedItem().toString());
							pst3.setString(3, txtId.getText());
							pst3.executeUpdate();
						
						} catch (Exception e) {
							System.out.println(e);
						//	JOptionPane.showMessageDialog(null, e);

						}
						
						//Atualiza Fisica
						try {
							pst2 = conexao.prepareStatement(pesquisarIdProf);
							pst2.setString(1, cboFisica.getSelectedItem().toString());
							rs = (ResultSet) pst2.executeQuery();
							while (rs.next()) {
								idProfString = rs.getString("idf");
							}
							

							pst3 = conexao.prepareStatement(updateFisica);
							pst3.setString(1, idProfString);
							pst3.setString(2, cboFisica.getSelectedItem().toString());
							pst3.setString(3, txtId.getText());
							pst3.executeUpdate();
						
						} catch (Exception e) {
							System.out.println(e);
						//	JOptionPane.showMessageDialog(null, e);

						}
						
						//Atualiza Quimica
						try {
							pst2 = conexao.prepareStatement(pesquisarIdProf);
							pst2.setString(1, cboQuimica.getSelectedItem().toString());
							rs = (ResultSet) pst2.executeQuery();
							while (rs.next()) {
								idProfString = rs.getString("idf");
							}
							

							pst3 = conexao.prepareStatement(updateQuimica);
							pst3.setString(1, idProfString);
							pst3.setString(2, cboQuimica.getSelectedItem().toString());
							pst3.setString(3, txtId.getText());
							pst3.executeUpdate();
						
						} catch (Exception e) {
							System.out.println(e);
						//	JOptionPane.showMessageDialog(null, e);

						}
						
						
						
						
						
						
						int alterar = 1;

						if (alterar == 1) {
							JOptionPane.showMessageDialog(null, "Alterado com sucesso");
							limpar();
						} else {
							JOptionPane.showMessageDialog(null,
									"Não foi possivel alterar as informações, por favor, confirme os dados.");
						}

					} 

				} 
			
private void limparTabela() {
	while (tblTurmas.getRowCount() > 0) {
		((DefaultTableModel) tblTurmas.getModel()).removeRow(0);
	}
}
	

	private void alterar() {
		// validação dos campos obrigatórios
		if (((String) cboAnoTurma.getSelectedItem()).isEmpty() || txtEnsino.getText().isEmpty()
				|| ((String) cboSigla.getSelectedItem()).isEmpty() || ((String) cboAnoLet.getSelectedItem()).isEmpty()
				|| ((String) cboPeriodo.getSelectedItem()).isEmpty()) {
			// confirmar se essa ultima condição funciona
			JOptionPane.showMessageDialog(null, "Faltou informações sobre a turma.");
		} else if(txtGamb.getText().isEmpty()) {
			// idturma, anoturma, ensino, sigla, anolet, periodo
			String idProfString = null;
			String update = "update tb_turmas set anoturma=?,ensino=?,sigla=?,anolet=?,periodo=? where idturma=?";
			
			String updatePortugues = "update tb_materia set idprof = ?, prof = ? where idturma=? and materia like 'LINGUA PORTUGUESA'";
			String updateMatematica = "update tb_materia set idprof = ?, prof = ? where idturma=? and materia like 'MATEMATICA'";
		    String updateGeografia = "update tb_materia set idprof = ?, prof = ? where idturma=? and materia like 'GEOGRAFIA'";
		    String updateHistoria = "update tb_materia set idprof = ?, prof = ? where idturma=? and materia like 'HISTORIA'";
		    String updateBiologia = "update tb_materia set idprof=?, prof = ? where idturma=? and materia like 'HISTORIA'";
		    String updateFisica = "update tb_materia set idprof=?, prof = ? where idturma=? and materia like 'FISICA'";
		    String updateQuimica = "update tb_materia set idprof=?, prof = ? where idturma=? and materia like 'QUIMICA'";
		    String updateFilosofia = "update tb_materia set idprof=?, prof =? where idturma=? and materia like 'FILOSOFIA'";
		    String updateSociologia = "update tb_materia set idprof=?, prof =? where idturma=? and materia like 'SOCIOLOGIA'";
		    String updateEdFisica = "update tb_materia set idprof=?, prof=? where idturma=? and materia like 'EDUCACAO FISICA'";
		    String updateIngles = "update tb_materia set idprof=?, prof=? where idturma=? and materia like 'INGLES'";
		    String updateArtes = "update tb_materia set idprof=?, prof=? where idturma=? and materia like 'ARTES'";
			
			String pesquisarIdProf = "select * from tb_dados_funcionarios where nomef like ?";
			try {
				pst = conexao.prepareStatement(update);
				pst.setString(1, cboAnoTurma.getSelectedItem().toString());
				pst.setString(2, txtEnsino.getText());
				pst.setString(3, cboSigla.getSelectedItem().toString());
				pst.setString(4, cboAnoLet.getSelectedItem().toString());
				pst.setString(5, cboPeriodo.getSelectedItem().toString());
				pst.setString(6, txtId.getText());
				
				//Atualiza Artes
				try {
					pst2 = conexao.prepareStatement(pesquisarIdProf);
					pst2.setString(1, cboArtes.getSelectedItem().toString());
					rs = (ResultSet) pst2.executeQuery();
					while (rs.next()) {
						idProfString = rs.getString("idprof");
					}
					

					pst3 = conexao.prepareStatement(updateArtes);
					pst3.setString(1, idProfString);
					pst3.setString(2, cboArtes.getSelectedItem().toString());
					pst3.setString(3, txtId.getText());
					pst3.executeUpdate();
				
				} catch (Exception e) {
					System.out.println(e);
				

				}
				
				//Atualiza Ingles
				try {
					pst2 = conexao.prepareStatement(pesquisarIdProf);
					pst2.setString(1, cboIngles.getSelectedItem().toString());
					rs = (ResultSet) pst2.executeQuery();
					while (rs.next()) {
						idProfString = rs.getString("idprof");
					}
					

					pst3 = conexao.prepareStatement(updateIngles);
					pst3.setString(1, idProfString);
					pst3.setString(2, cboIngles.getSelectedItem().toString());
					pst3.setString(3, txtId.getText());
					pst3.executeUpdate();
				
				} catch (Exception e) {
					System.out.println(e);
				//	JOptionPane.showMessageDialog(null, e);

				}
				
				//Atualiza EdFisica
				try {
					pst2 = conexao.prepareStatement(pesquisarIdProf);
					pst2.setString(1, cboEdFisica.getSelectedItem().toString());
					rs = (ResultSet) pst2.executeQuery();
					while (rs.next()) {
						idProfString = rs.getString("idprof");
					}
					

					pst3 = conexao.prepareStatement(updateEdFisica);
					pst3.setString(1, idProfString);
					pst3.setString(2, cboEdFisica.getSelectedItem().toString());
					pst3.setString(3, txtId.getText());
					pst3.executeUpdate();
				
				} catch (Exception e) {
					System.out.println(e);
				//	JOptionPane.showMessageDialog(null, e);

				}
				
				//Atualiza Sociologia
				try {
					pst2 = conexao.prepareStatement(pesquisarIdProf);
					pst2.setString(1, cboSociologia.getSelectedItem().toString());
					rs = (ResultSet) pst2.executeQuery();
					while (rs.next()) {
						idProfString = rs.getString("idprof");
					}
					

					pst3 = conexao.prepareStatement(updateSociologia);
					pst3.setString(1, idProfString);
					pst3.setString(2, cboSociologia.getSelectedItem().toString());
					pst3.setString(3, txtId.getText());
					pst3.executeUpdate();
				
				} catch (Exception e) {
					System.out.println(e);
				//	JOptionPane.showMessageDialog(null, e);

				}
				
				//Atualiza Filosofia
				try {
					pst2 = conexao.prepareStatement(pesquisarIdProf);
					pst2.setString(1, cboFilosofia.getSelectedItem().toString());
					rs = (ResultSet) pst2.executeQuery();
					while (rs.next()) {
						idProfString = rs.getString("idprof");
					}
					

					pst3 = conexao.prepareStatement(updateFilosofia);
					pst3.setString(1, idProfString);
					pst3.setString(2, cboFilosofia.getSelectedItem().toString());
					pst3.setString(3, txtId.getText());
					pst3.executeUpdate();
				
				} catch (Exception e) {
					System.out.println(e);
				//	JOptionPane.showMessageDialog(null, e);

				}
				
				//Atualiza Biologia 
				try {
					pst2 = conexao.prepareStatement(pesquisarIdProf);
					pst2.setString(1, cboBiologia.getSelectedItem().toString());
					rs = (ResultSet) pst2.executeQuery();
					while (rs.next()) {
						idProfString = rs.getString("idprof");
					}
					

					pst3 = conexao.prepareStatement(updateBiologia);
					pst3.setString(1, idProfString);
					pst3.setString(2, cboBiologia.getSelectedItem().toString());
					pst3.setString(3, txtId.getText());
					pst3.executeUpdate();
				
				} catch (Exception e) {
					System.out.println(e);
				//	JOptionPane.showMessageDialog(null, e);

				}
				//Atualiza Portugues
				try {
					pst2 = conexao.prepareStatement(pesquisarIdProf);
					pst2.setString(1, cboMatematica.getSelectedItem().toString());
					rs = (ResultSet) pst2.executeQuery();
					while (rs.next()) {
						idProfString = rs.getString("idprof");
					}
					

					pst3 = conexao.prepareStatement(updatePortugues);
					pst3.setString(1, idProfString);
					pst3.setString(2, cboMatematica.getSelectedItem().toString());
					pst3.setString(3, txtId.getText());
					pst3.executeUpdate();
				
				} catch (Exception e) {
					System.out.println(e);

				}
				
				//Atualiza Matematica
				try {
					pst2 = conexao.prepareStatement(pesquisarIdProf);
					pst2.setString(1, cboPortugues.getSelectedItem().toString());
					rs = (ResultSet) pst2.executeQuery();
					while (rs.next()) {
						idProfString = rs.getString("idprof");
					}
					

					pst3 = conexao.prepareStatement(updateMatematica);
					pst3.setString(1, idProfString);
					pst3.setString(2, cboPortugues.getSelectedItem().toString());
					pst3.setString(3, txtId.getText());
					pst3.executeUpdate();
				
				} catch (Exception e) {
					System.out.println(e);
				//	JOptionPane.showMessageDialog(null, e);

				}
				
				//Atualiza Geografia
				try {
					pst2 = conexao.prepareStatement(pesquisarIdProf);
					pst2.setString(1, cboGeografia.getSelectedItem().toString());
					rs = (ResultSet) pst2.executeQuery();
					while (rs.next()) {
						idProfString = rs.getString("idprof");
					}
					

					pst3 = conexao.prepareStatement(updateGeografia);
					pst3.setString(1, idProfString);
					pst3.setString(2, cboGeografia.getSelectedItem().toString());
					pst3.setString(3, txtId.getText());
					pst3.executeUpdate();
				
				} catch (Exception e) {
					System.out.println(e);
				//	JOptionPane.showMessageDialog(null, e);

				}
				
				//Atualiza Historia
				try {
					pst2 = conexao.prepareStatement(pesquisarIdProf);
					pst2.setString(1, cboHistoria.getSelectedItem().toString());
					rs = (ResultSet) pst2.executeQuery();
					while (rs.next()) {
						idProfString = rs.getString("idprof");
					}
					

					pst3 = conexao.prepareStatement(updateHistoria);
					pst3.setString(1, idProfString);
					pst3.setString(2, cboHistoria.getSelectedItem().toString());
					pst3.setString(3, txtId.getText());
					pst3.executeUpdate();
				
				} catch (Exception e) {
					System.out.println(e);
				//	JOptionPane.showMessageDialog(null, e);

				}
				
				//Atualiza Fisica
				try {
					pst2 = conexao.prepareStatement(pesquisarIdProf);
					pst2.setString(1, cboFisica.getSelectedItem().toString());
					rs = (ResultSet) pst2.executeQuery();
					while (rs.next()) {
						idProfString = rs.getString("idprof");
					}
					

					pst3 = conexao.prepareStatement(updateFisica);
					pst3.setString(1, idProfString);
					pst3.setString(2, cboFisica.getSelectedItem().toString());
					pst3.setString(3, txtId.getText());
					pst3.executeUpdate();
				
				} catch (Exception e) {
					System.out.println(e);
				//	JOptionPane.showMessageDialog(null, e);

				}
				
				//Atualiza Quimica
				try {
					pst2 = conexao.prepareStatement(pesquisarIdProf);
					pst2.setString(1, cboQuimica.getSelectedItem().toString());
					rs = (ResultSet) pst2.executeQuery();
					while (rs.next()) {
						idProfString = rs.getString("idprof");
					}
					

					pst3 = conexao.prepareStatement(updateQuimica);
					pst3.setString(1, idProfString);
					pst3.setString(2, cboQuimica.getSelectedItem().toString());
					pst3.setString(3, txtId.getText());
					pst3.executeUpdate();
				
				} catch (Exception e) {
					System.out.println(e);
				//	JOptionPane.showMessageDialog(null, e);

				}
				
				
				
				
				
				
				int alterar = pst.executeUpdate();

				if (alterar == 1) {
					JOptionPane.showMessageDialog(null, "Alterado com sucesso");
					limpar();
				} else {
					JOptionPane.showMessageDialog(null,
							"Não foi possivel alterar as informações, por favor, confirme os dados.");
				}

			} catch (Exception e) {
				System.out.println(e);
			}

		} else {
			JOptionPane.showMessageDialog(null, "Ja existe turma com esses dados!");
			limpar();
			txtGamb.setText(null);
		}
	}

	// idturma, anoturma, ensino, sigla, anolet, periodo

	private void pesquisarProf() {
		String pPortugues = "select * from tb_dados_funcionarios where materia1 = 'lingua portuguesa' or materia2 = 'lingua portuguesa'";
		String pMatematica = "select * from tb_dados_funcionarios where materia1 = 'matematica' or materia2 = 'matematica'";
		String pGeografia = "select * from tb_dados_funcionarios where materia1 = 'geografia' or materia2 = 'geografia'";
		String pHistoria = "select * from tb_dados_funcionarios where materia1 = 'historia' or materia2 = 'historia'";
		String pBiologia = "select * from tb_dados_funcionarios where materia1 = 'biologia' or materia2 = 'biologia'";
		String pFilosofia = "select * from tb_dados_funcionarios where materia1 = 'filosofia' or materia2 = 'filosofia'";
		String pSociologia = "select * from tb_dados_funcionarios where materia1 = 'sociologia' or materia2 = 'sociologia'";
		String pQuimica = "select * from tb_dados_funcionarios where materia1 = 'quimica' or materia2 = 'quimica'";
		String pArtes = "select * from tb_dados_funcionarios where materia1 = 'artes' or materia2 = 'artes'";
		String pEdFisica = "select * from tb_dados_funcionarios where materia1 = 'educacao fisica' or materia2 = 'educacao fisica'";
		String pFisica = "select * from tb_dados_funcionarios where materia1 = 'fisica' or materia2 = 'fisica'";
		String pIngles = "select * from tb_dados_funcionarios where materia1 = 'ingles' or materia2 = 'ingles'";
		// A String abaixo pega o valor da ultima idturma e adiciona +1 para ter a
		// sincronia entre tb_turmas e tb_materias

		try {
			pst = conexao.prepareStatement(pPortugues);
			rs = (ResultSet) pst.executeQuery();
			cboPortugues.removeAllItems();
			
			while (rs.next()) {

				cboPortugues.addItem(rs.getString("nomef"));

			}

		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);

		}
		// Matematica
		try {
			pst = conexao.prepareStatement(pMatematica);
			rs = (ResultSet) pst.executeQuery();
			cboMatematica.removeAllItems();
			while (rs.next()) {

				cboMatematica.addItem(rs.getString("nomef"));

			}
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);

		}
		// geografia
		try {
			pst = conexao.prepareStatement(pGeografia);
			rs = (ResultSet) pst.executeQuery();

			cboGeografia.removeAllItems();
			while (rs.next()) {

				cboGeografia.addItem(rs.getString("nomef"));

			}
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);

		}
		// historia
		try {
			pst = conexao.prepareStatement(pHistoria);
			rs = (ResultSet) pst.executeQuery();

			cboHistoria.removeAllItems();
			while (rs.next()) {

				cboHistoria.addItem(rs.getString("nomef"));

			}
			// biologia
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);

		}
		try {
			pst = conexao.prepareStatement(pBiologia);
			rs = (ResultSet) pst.executeQuery();

			cboBiologia.removeAllItems();
			while (rs.next()) {

				cboBiologia.addItem(rs.getString("nomef"));

			}
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);

		}
		// filosofia
		try {
			pst = conexao.prepareStatement(pFilosofia);
			rs = (ResultSet) pst.executeQuery();

			cboFilosofia.removeAllItems();
			while (rs.next()) {

				cboFilosofia.addItem(rs.getString("nomef"));

			}
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);

		}
		// Sociologia
		try {
			pst = conexao.prepareStatement(pSociologia);
			rs = (ResultSet) pst.executeQuery();

			cboSociologia.removeAllItems();
			while (rs.next()) {

				cboSociologia.addItem(rs.getString("nomef"));

			}
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);

		}
		// Quimica
		try {
			pst = conexao.prepareStatement(pQuimica);
			rs = (ResultSet) pst.executeQuery();

			cboQuimica.removeAllItems();
			while (rs.next()) {

				cboQuimica.addItem(rs.getString("nomef"));

			}
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);

		}
		// artes
		try {
			pst = conexao.prepareStatement(pArtes);
			rs = (ResultSet) pst.executeQuery();

			cboArtes.removeAllItems();
			while (rs.next()) {

				cboArtes.addItem(rs.getString("nomef"));

			}
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);

		}
		// Educação Fisica
		try {
			pst = conexao.prepareStatement(pEdFisica);
			rs = (ResultSet) pst.executeQuery();

			cboEdFisica.removeAllItems();
			while (rs.next()) {

				cboEdFisica.addItem(rs.getString("nomef"));

			}
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);

		}
		// Fisica
		try {
			pst = conexao.prepareStatement(pFisica);
			rs = (ResultSet) pst.executeQuery();

			cboFisica.removeAllItems();
			while (rs.next()) {

				cboFisica.addItem(rs.getString("nomef"));

			}
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);

		}
		// Ingles
		try {
			pst = conexao.prepareStatement(pIngles);
			rs = (ResultSet) pst.executeQuery();

			cboIngles.removeAllItems();
			while (rs.next()) {

				cboIngles.addItem(rs.getString("nomef"));

			}
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);

		}

	}

	private void Gamb() {
		String checarTurma = "select * from tb_turmas where anoturma like ? and sigla like ? and periodo like ?";
		String turma = null;
		try {
			pst = conexao.prepareStatement(checarTurma);
			pst.setString(1, cboAnoTurma.getSelectedItem().toString() + "%");
			pst.setString(2, cboSigla.getSelectedItem().toString() + "%");
			pst.setString(3, cboPeriodo.getSelectedItem().toString() + "%");
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				turma = rs.getString("idturma");
				txtGamb.setText(turma);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	

	private void addTurma() {
		String checar = txtGamb.getText();
		if (((String) cboAnoTurma.getSelectedItem()).isEmpty() || txtEnsino.getText().isEmpty()
				|| ((String) cboSigla.getSelectedItem()).isEmpty() || ((String) cboAnoLet.getSelectedItem()).isEmpty()
				|| ((String) cboPeriodo.getSelectedItem()).isEmpty()
				|| ((String) cboMatematica.getSelectedItem()).isEmpty()) {
			// confirmar se essa ultima condição funciona
			JOptionPane.showMessageDialog(null, "Faltou informações sobre a turma.");

		}

		else if (txtGamb.getText().isEmpty()) {

			// portugues

			// materia/idturma/idprof/prof

			String addTurma = "insert into tb_turmas(anoturma,ensino,sigla,anolet,periodo) values (?,?,?,?,?)";
			String addPortugues = "insert into tb_materia(materia,idturma,idprof,prof) values('LINGUA PORTUGUESA',?,?,?)";
			String addMatematica = "insert into tb_materia(materia,idturma,idprof,prof) values('MATEMATICA',?,?,?)";
			String addGeografia = "insert into tb_materia(materia,idturma,idprof,prof) values('GEOGRAFIA',?,?,?)";
			String addHistoria = "insert into tb_materia(materia,idturma,idprof,prof) values('HISTORIA',?,?,?)";
			String addSociologia = "insert into tb_materia(materia,idturma,idprof,prof) values('SOCIOLOGIA',?,?,?)";
			String addFilosofia = "insert into tb_materia(materia,idturma,idprof,prof) values('FILOSOFIA',?,?,?)";
			String addFisica = "insert into tb_materia(materia,idturma,idprof,prof) values('FISICA',?,?,?)";
			String addQuimica = "insert into tb_materia(materia,idturma,idprof,prof) values('QUIMICA',?,?,?)";
			String addArtes = "insert into tb_materia(materia,idturma,idprof,prof) values('ARTES',?,?,?)";
			String addEdFisica = "insert into tb_materia(materia,idturma,idprof,prof) values('EDUCACAO FISICA',?,?,?)";
			String addBiologia = "insert into tb_materia(materia,idturma,idprof,prof) values('BIOLOGIA',?,?,?)";
			String addIngles = "insert into tb_materia(materia,idturma,idprof,prof) values('INGLES',?,?,?)";
			String sincronizarProf = "select * from tb_dados_funcionarios where nomef like ? order by idf asc";
			String sincronizarIdTurma = "select * from tb_turmas order by idturma desc";

			try {

				// Try - Catch enorme para adicionar
				pst = conexao.prepareStatement(addTurma);
				pst.setString(1, cboAnoTurma.getSelectedItem().toString());
				pst.setString(2, txtEnsino.getText());
				pst.setString(3, cboSigla.getSelectedItem().toString());
				pst.setString(4, cboAnoLet.getSelectedItem().toString());
				pst.setString(5, cboPeriodo.getSelectedItem().toString());
				pst.executeUpdate();

				// faz a sincronia abaixo para conseguir a idTurma
				int idTurmaInt, ct;
				String idTurmaString;

				ct = 0;
				idTurmaString = null;
				idTurmaInt = 0;
				pst = conexao.prepareStatement(sincronizarIdTurma);
				rs = (ResultSet) pst.executeQuery();
				while (rs.next() && ct < 1) {

					ct = ct + 1;

					idTurmaString = rs.getString("idturma");
					idTurmaInt = idTurmaInt + Integer.parseInt(idTurmaString);
					idTurmaString = Integer.toString(idTurmaInt);
				//	txtTeste.setText(idTurmaString);
				}

				// Bloco Portugues

				// faz a sincronia abaixo para conseguir IdProf

				String idProfString = null;
				pst = conexao.prepareStatement(sincronizarProf);
				pst.setString(1, cboMatematica.getSelectedItem().toString());
				rs = (ResultSet) pst.executeQuery();
				rs.next();

				idProfString = rs.getString("idf");

				// adiciona portugues abaixo
				pst = conexao.prepareStatement(addPortugues);
				pst.setString(1, idTurmaString);
				pst.setString(2, idProfString);
				pst.setString(3, cboMatematica.getSelectedItem().toString());
				pst.executeUpdate();
				// Fim do Bloco Portugues!

				// Bloco Matematica

				// faz a sincronia abaixo para conseguir IdProf

				idProfString = null;
				pst = conexao.prepareStatement(sincronizarProf);
				pst.setString(1, cboPortugues.getSelectedItem().toString());
				rs = (ResultSet) pst.executeQuery();
				rs.next();

				idProfString = rs.getString("idf");

				// adiciona matematica abaixo
				pst = conexao.prepareStatement(addMatematica);
				pst.setString(1, idTurmaString);
				pst.setString(2, idProfString);
				pst.setString(3, cboPortugues.getSelectedItem().toString());
				pst.executeUpdate();
				// Fim do Bloco Matematica!

				// Bloco Geografia

				// faz a sincronia abaixo para conseguir IdProf

				idProfString = null;
				pst = conexao.prepareStatement(sincronizarProf);
				pst.setString(1, cboGeografia.getSelectedItem().toString());
				rs = (ResultSet) pst.executeQuery();
				rs.next();

				idProfString = rs.getString("idf");

				// adiciona geografia abaixo
				pst = conexao.prepareStatement(addGeografia);
				pst.setString(1, idTurmaString);
				pst.setString(2, idProfString);
				pst.setString(3, cboGeografia.getSelectedItem().toString());
				pst.executeUpdate();
				// Fim do Bloco Geografia!

				// Bloco Historia

				// faz a sincronia abaixo para conseguir IdProf

				idProfString = null;
				pst = conexao.prepareStatement(sincronizarProf);
				pst.setString(1, cboHistoria.getSelectedItem().toString());
				rs = (ResultSet) pst.executeQuery();
				rs.next();

				idProfString = rs.getString("idf");

				// adiciona historia abaixo
				pst = conexao.prepareStatement(addHistoria);
				pst.setString(1, idTurmaString);
				pst.setString(2, idProfString);
				pst.setString(3, cboHistoria.getSelectedItem().toString());
				pst.executeUpdate();
				// Fim do Bloco Historia!

				// Bloco Sociologia

				// faz a sincronia abaixo para conseguir IdProf

				idProfString = null;
				pst = conexao.prepareStatement(sincronizarProf);
				pst.setString(1, cboSociologia.getSelectedItem().toString());
				rs = (ResultSet) pst.executeQuery();
				rs.next();

				idProfString = rs.getString("idf");

				// adiciona sociologia abaixo
				pst = conexao.prepareStatement(addSociologia);
				pst.setString(1, idTurmaString);
				pst.setString(2, idProfString);
				pst.setString(3, cboSociologia.getSelectedItem().toString());
				pst.executeUpdate();
				// Fim do Bloco Sociologia!

				// Bloco Filosofia

				// faz a sincronia abaixo para conseguir IdProf

				idProfString = null;
				pst = conexao.prepareStatement(sincronizarProf);
				pst.setString(1, cboFilosofia.getSelectedItem().toString());
				rs = (ResultSet) pst.executeQuery();
				rs.next();

				idProfString = rs.getString("idf");

				// adiciona filosofia abaixo
				pst = conexao.prepareStatement(addFilosofia);
				pst.setString(1, idTurmaString);
				pst.setString(2, idProfString);
				pst.setString(3, cboFilosofia.getSelectedItem().toString());
				pst.executeUpdate();
				// Fim do Bloco Filosofia!

				// Bloco Fisica

				// faz a sincronia abaixo para conseguir IdProf

				idProfString = null;
				pst = conexao.prepareStatement(sincronizarProf);
				pst.setString(1, cboFisica.getSelectedItem().toString());
				rs = (ResultSet) pst.executeQuery();
				rs.next();

				idProfString = rs.getString("idf");

				// adiciona fisica abaixo
				pst = conexao.prepareStatement(addFisica);
				pst.setString(1, idTurmaString);
				pst.setString(2, idProfString);
				pst.setString(3, cboFisica.getSelectedItem().toString());
				pst.executeUpdate();
				// Fim do Bloco Fisica!

				// Bloco Quimica

				// faz a sincronia abaixo para conseguir IdProf

				idProfString = null;
				pst = conexao.prepareStatement(sincronizarProf);
				pst.setString(1, cboQuimica.getSelectedItem().toString());
				rs = (ResultSet) pst.executeQuery();
				rs.next();

				idProfString = rs.getString("idf");

				// adiciona quimica abaixo
				pst = conexao.prepareStatement(addQuimica);
				pst.setString(1, idTurmaString);
				pst.setString(2, idProfString);
				pst.setString(3, cboQuimica.getSelectedItem().toString());
				pst.executeUpdate();
				// Fim do Bloco Quimica!

				// Bloco Artes

				// faz a sincronia abaixo para conseguir IdProf

				idProfString = null;
				pst = conexao.prepareStatement(sincronizarProf);
				pst.setString(1, cboArtes.getSelectedItem().toString());
				rs = (ResultSet) pst.executeQuery();
				rs.next();

				idProfString = rs.getString("idf");

				// adiciona artes abaixo
				pst = conexao.prepareStatement(addArtes);
				pst.setString(1, idTurmaString);
				pst.setString(2, idProfString);
				pst.setString(3, cboArtes.getSelectedItem().toString());
				pst.executeUpdate();
				// Fim do Bloco Artes!

				// Bloco Educação Fisica

				// faz a sincronia abaixo para conseguir IdProf

				idProfString = null;
				pst = conexao.prepareStatement(sincronizarProf);
				pst.setString(1, cboEdFisica.getSelectedItem().toString());
				rs = (ResultSet) pst.executeQuery();
				rs.next();

				idProfString = rs.getString("idf");

				// adiciona Educação Fisica abaixo
				pst = conexao.prepareStatement(addEdFisica);
				pst.setString(1, idTurmaString);
				pst.setString(2, idProfString);
				pst.setString(3, cboEdFisica.getSelectedItem().toString());
				pst.executeUpdate();
				// Fim do Bloco Educação Fisica!

				// Bloco Biologia

				// faz a sincronia abaixo para conseguir IdProf

				idProfString = null;
				pst = conexao.prepareStatement(sincronizarProf);
				pst.setString(1, cboBiologia.getSelectedItem().toString());
				rs = (ResultSet) pst.executeQuery();
				rs.next();

				idProfString = rs.getString("idf");

				// adiciona biologia abaixo
				pst = conexao.prepareStatement(addBiologia);
				pst.setString(1, idTurmaString);
				pst.setString(2, idProfString);
				pst.setString(3, cboBiologia.getSelectedItem().toString());
				pst.executeUpdate();
				// Fim do Bloco Biologia!

				// Bloco Ingles

				// faz a sincronia abaixo para conseguir IdProf

				idProfString = null;
				pst = conexao.prepareStatement(sincronizarProf);
				pst.setString(1, cboIngles.getSelectedItem().toString());
				rs = (ResultSet) pst.executeQuery();
				rs.next();

				idProfString = rs.getString("idf");

				// adiciona ingles abaixo
				pst = conexao.prepareStatement(addIngles);
				pst.setString(1, idTurmaString);
				pst.setString(2, idProfString);
				pst.setString(3, cboIngles.getSelectedItem().toString());
				// Fim do Bloco Ingles!

				int adicionado = pst.executeUpdate();

				int on = 1;
				if (on == 1) {

				}
				;
				if (adicionado == 1) {
					JOptionPane.showMessageDialog(null, "Turma Cadastrada!");
					limpar();
					pesquisarTurmas();
				} else {
					JOptionPane.showMessageDialog(null, "Turma não cadastrada, por favor, confirme as informações");
					limpar();
				}

				// Fim do Try/Catch enorme!
			} catch (Exception e) {
				System.out.println(e);
				JOptionPane.showMessageDialog(null, e);

			}

		} else {
			JOptionPane.showMessageDialog(null,
					"Ja existe uma turma com as informações que deseja adicionar, por favor, confirme os dados");
			limpar();
			limparProf();
			

		}

	}
}
