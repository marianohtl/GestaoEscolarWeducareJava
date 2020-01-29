package br.com.telas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.dal.ModuloConexao;
//import br.com.sistema.JRException;
//import br.com.sistema.JasperReport;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;

import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;

public class RelatoriosAlunosTurmas extends JDialog {
	private final ButtonGroup buttonGroup1 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RelatoriosAlunosTurmas dialog = new RelatoriosAlunosTurmas();
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
	PreparedStatement pst,pst2 = null;
	ResultSet rs = null;
	private JTextField txtMath1;
	private JTextField txtMath2;
	private JTextField txtMath3;
	private JTextField txtMath4;
	private JTextField txtMath5;
	private JTextField txtGeo1;
	private JTextField txtGeo2;
	private JTextField txtGeo3;
	private JTextField txtGeo4;
	private JTextField txtGeo5;
	private JTextField txtHist1;
	private JTextField txtHist2;
	private JTextField txtHist3;
	private JTextField txtHist4;
	private JTextField txtHist5;
	private JTextField txtFis1;
	private JTextField txtFis2;
	private JTextField txtFis3;
	private JTextField txtFis4;
	private JTextField txtFis5;
	private JTextField txtBio1;
	private JTextField txtBio2;
	private JTextField txtBio3;
	private JTextField txtBio4;
	private JTextField txtBio5;
	private JTextField txtQuim1;
	private JTextField txtQuim2;
	private JTextField txtQuim3;
	private JTextField txtQuim4;
	private JTextField txtQuim5;
	private JTextField txtSoc1;
	private JTextField txtSoc2;
	private JTextField txtSoc3;
	private JTextField txtSoc4;
	private JTextField txtSoc5;
	private JTextField txtPort1;
	private JTextField txtPort2;
	private JTextField txtPort3;
	private JTextField txtPort4;
	private JTextField txtPort5;
	private JTextField txtFil1;
	private JTextField txtFil2;
	private JTextField txtFil3;
	private JTextField txtFil4;
	private JTextField txtFil5;
	private JTextField txtEd1;
	private JTextField txtEd2;
	private JTextField txtEd3;
	private JTextField txtEd4;
	private JTextField txtEd5;
	private JTextField txtIng1;
	private JTextField txtIng2;
	private JTextField txtIng3;
	private JTextField txtIng4;
	private JTextField txtIng5;
	private JTextField txtArt1;
	private JTextField txtArt2;
	private JTextField txtArt3;
	private JTextField txtArt4;
	private JTextField txtArt5;
	private JTable tblTeste;
	private JComboBox cboSigla;
	private JComboBox cboAno;
	private JTextField txtId2;
	private JTextField lblAluno;
	private JTextField txtId;
	private JComboBox cboPeriodo;

	public RelatoriosAlunosTurmas() {
		addWindowListener(new WindowAdapter() {

			public void windowOpened(WindowEvent e) {
				// preencherTurmas();
			}
		});

		setTitle("Relatorios");
		setBounds(100, 100, 1374, 730);
		getContentPane().setLayout(null);

		cboAno = new JComboBox();
		cboAno.setFont(new Font("Verdana", Font.PLAIN, 16));
		cboAno.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3" }));
		cboAno.setBounds(232, 85, 47, 30);
		getContentPane().add(cboAno);

		JLabel lblEscolhaOAno = new JLabel("Escolha o Ano:");
		lblEscolhaOAno.setHorizontalAlignment(SwingConstants.CENTER);
		lblEscolhaOAno.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblEscolhaOAno.setBounds(30, 85, 141, 28);
		getContentPane().add(lblEscolhaOAno);

		JButton btnNewButton_1 = new JButton("Listar Alunos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarTurmas();
			}
		});
		btnNewButton_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnNewButton_1.setBounds(332, 32, 161, 30);
		getContentPane().add(btnNewButton_1);

		cboSigla = new JComboBox();
		cboSigla.setFont(new Font("Verdana", Font.PLAIN, 16));
		cboSigla.setModel(new DefaultComboBoxModel(new String[] { "A", "B", "C", "D" }));
		cboSigla.setBounds(232, 136, 47, 30);
		getContentPane().add(cboSigla);

		JLabel lblEscolhaASigla = new JLabel("Escolha a Sigla:");
		lblEscolhaASigla.setHorizontalAlignment(SwingConstants.CENTER);
		lblEscolhaASigla.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblEscolhaASigla.setBounds(30, 136, 151, 28);
		getContentPane().add(lblEscolhaASigla);

		JLabel lblNewLabel = new JLabel("Matem\u00E1tica:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNewLabel.setBounds(717, 176, 95, 28);
		getContentPane().add(lblNewLabel);

		txtMath1 = new JTextField();
		txtMath1.setHorizontalAlignment(SwingConstants.CENTER);
		txtMath1.setEditable(false);
		txtMath1.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtMath1.setBounds(869, 174, 47, 25);
		getContentPane().add(txtMath1);
		txtMath1.setColumns(10);

		txtMath2 = new JTextField();
		txtMath2.setHorizontalAlignment(SwingConstants.CENTER);
		txtMath2.setEditable(false);
		txtMath2.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtMath2.setColumns(10);
		txtMath2.setBounds(961, 174, 47, 25);
		getContentPane().add(txtMath2);

		txtMath3 = new JTextField();
		txtMath3.setHorizontalAlignment(SwingConstants.CENTER);
		txtMath3.setEditable(false);
		txtMath3.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtMath3.setColumns(10);
		txtMath3.setBounds(1043, 176, 47, 25);
		getContentPane().add(txtMath3);

		txtMath4 = new JTextField();
		txtMath4.setHorizontalAlignment(SwingConstants.CENTER);
		txtMath4.setEditable(false);
		txtMath4.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtMath4.setColumns(10);
		txtMath4.setBounds(1126, 176, 47, 25);
		getContentPane().add(txtMath4);

		txtMath5 = new JTextField();
		txtMath5.setHorizontalAlignment(SwingConstants.CENTER);
		txtMath5.setEditable(false);
		txtMath5.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtMath5.setColumns(10);
		txtMath5.setBounds(1216, 176, 47, 25);
		getContentPane().add(txtMath5);

		JLabel lblGeografia = new JLabel("Geografia:");
		lblGeografia.setHorizontalAlignment(SwingConstants.CENTER);
		lblGeografia.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblGeografia.setBounds(727, 215, 78, 28);
		getContentPane().add(lblGeografia);

		txtGeo1 = new JTextField();
		txtGeo1.setHorizontalAlignment(SwingConstants.CENTER);
		txtGeo1.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtGeo1.setEditable(false);
		txtGeo1.setColumns(10);
		txtGeo1.setBounds(869, 210, 47, 25);
		getContentPane().add(txtGeo1);

		txtGeo2 = new JTextField();
		txtGeo2.setHorizontalAlignment(SwingConstants.CENTER);
		txtGeo2.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtGeo2.setEditable(false);
		txtGeo2.setColumns(10);
		txtGeo2.setBounds(961, 210, 47, 25);
		getContentPane().add(txtGeo2);

		txtGeo3 = new JTextField();
		txtGeo3.setHorizontalAlignment(SwingConstants.CENTER);
		txtGeo3.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtGeo3.setEditable(false);
		txtGeo3.setColumns(10);
		txtGeo3.setBounds(1043, 212, 47, 25);
		getContentPane().add(txtGeo3);

		txtGeo4 = new JTextField();
		txtGeo4.setHorizontalAlignment(SwingConstants.CENTER);
		txtGeo4.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtGeo4.setEditable(false);
		txtGeo4.setColumns(10);
		txtGeo4.setBounds(1126, 212, 47, 25);
		getContentPane().add(txtGeo4);

		txtGeo5 = new JTextField();
		txtGeo5.setHorizontalAlignment(SwingConstants.CENTER);
		txtGeo5.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtGeo5.setEditable(false);
		txtGeo5.setColumns(10);
		txtGeo5.setBounds(1216, 212, 47, 25);
		getContentPane().add(txtGeo5);

		JLabel lblHistoria = new JLabel("Hist\u00F3ria:");
		lblHistoria.setHorizontalAlignment(SwingConstants.CENTER);
		lblHistoria.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblHistoria.setBounds(740, 249, 69, 28);
		getContentPane().add(lblHistoria);

		txtHist1 = new JTextField();
		txtHist1.setHorizontalAlignment(SwingConstants.CENTER);
		txtHist1.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtHist1.setEditable(false);
		txtHist1.setColumns(10);
		txtHist1.setBounds(869, 247, 47, 25);
		getContentPane().add(txtHist1);

		txtHist2 = new JTextField();
		txtHist2.setHorizontalAlignment(SwingConstants.CENTER);
		txtHist2.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtHist2.setEditable(false);
		txtHist2.setColumns(10);
		txtHist2.setBounds(961, 247, 47, 25);
		getContentPane().add(txtHist2);

		txtHist3 = new JTextField();
		txtHist3.setHorizontalAlignment(SwingConstants.CENTER);
		txtHist3.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtHist3.setEditable(false);
		txtHist3.setColumns(10);
		txtHist3.setBounds(1043, 249, 47, 25);
		getContentPane().add(txtHist3);

		txtHist4 = new JTextField();
		txtHist4.setHorizontalAlignment(SwingConstants.CENTER);
		txtHist4.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtHist4.setEditable(false);
		txtHist4.setColumns(10);
		txtHist4.setBounds(1126, 249, 47, 25);
		getContentPane().add(txtHist4);

		txtHist5 = new JTextField();
		txtHist5.setHorizontalAlignment(SwingConstants.CENTER);
		txtHist5.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtHist5.setEditable(false);
		txtHist5.setColumns(10);
		txtHist5.setBounds(1216, 249, 47, 25);
		getContentPane().add(txtHist5);

		JLabel lblFisica = new JLabel("F\u00EDsica:");
		lblFisica.setHorizontalAlignment(SwingConstants.CENTER);
		lblFisica.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblFisica.setBounds(748, 285, 64, 28);
		getContentPane().add(lblFisica);

		txtFis1 = new JTextField();
		txtFis1.setHorizontalAlignment(SwingConstants.CENTER);
		txtFis1.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtFis1.setEditable(false);
		txtFis1.setColumns(10);
		txtFis1.setBounds(869, 283, 47, 25);
		getContentPane().add(txtFis1);

		txtFis2 = new JTextField();
		txtFis2.setHorizontalAlignment(SwingConstants.CENTER);
		txtFis2.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtFis2.setEditable(false);
		txtFis2.setColumns(10);
		txtFis2.setBounds(961, 283, 47, 25);
		getContentPane().add(txtFis2);

		txtFis3 = new JTextField();
		txtFis3.setHorizontalAlignment(SwingConstants.CENTER);
		txtFis3.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtFis3.setEditable(false);
		txtFis3.setColumns(10);
		txtFis3.setBounds(1043, 285, 47, 25);
		getContentPane().add(txtFis3);

		txtFis4 = new JTextField();
		txtFis4.setHorizontalAlignment(SwingConstants.CENTER);
		txtFis4.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtFis4.setEditable(false);
		txtFis4.setColumns(10);
		txtFis4.setBounds(1126, 285, 47, 25);
		getContentPane().add(txtFis4);

		txtFis5 = new JTextField();
		txtFis5.setHorizontalAlignment(SwingConstants.CENTER);
		txtFis5.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtFis5.setEditable(false);
		txtFis5.setColumns(10);
		txtFis5.setBounds(1216, 285, 47, 25);
		getContentPane().add(txtFis5);

		JLabel lblBiologia = new JLabel("Biologia:");
		lblBiologia.setHorizontalAlignment(SwingConstants.CENTER);
		lblBiologia.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblBiologia.setBounds(740, 324, 68, 28);
		getContentPane().add(lblBiologia);

		txtBio1 = new JTextField();
		txtBio1.setHorizontalAlignment(SwingConstants.CENTER);
		txtBio1.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtBio1.setEditable(false);
		txtBio1.setColumns(10);
		txtBio1.setBounds(869, 319, 47, 25);
		getContentPane().add(txtBio1);

		txtBio2 = new JTextField();
		txtBio2.setHorizontalAlignment(SwingConstants.CENTER);
		txtBio2.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtBio2.setEditable(false);
		txtBio2.setColumns(10);
		txtBio2.setBounds(961, 319, 47, 25);
		getContentPane().add(txtBio2);

		txtBio3 = new JTextField();
		txtBio3.setHorizontalAlignment(SwingConstants.CENTER);
		txtBio3.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtBio3.setEditable(false);
		txtBio3.setColumns(10);
		txtBio3.setBounds(1043, 321, 47, 25);
		getContentPane().add(txtBio3);

		txtBio4 = new JTextField();
		txtBio4.setHorizontalAlignment(SwingConstants.CENTER);
		txtBio4.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtBio4.setEditable(false);
		txtBio4.setColumns(10);
		txtBio4.setBounds(1126, 321, 47, 25);
		getContentPane().add(txtBio4);

		txtBio5 = new JTextField();
		txtBio5.setHorizontalAlignment(SwingConstants.CENTER);
		txtBio5.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtBio5.setEditable(false);
		txtBio5.setColumns(10);
		txtBio5.setBounds(1216, 321, 47, 25);
		getContentPane().add(txtBio5);

		JLabel lblQuimica = new JLabel("Qu\u00EDmica:");
		lblQuimica.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuimica.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblQuimica.setBounds(735, 357, 78, 28);
		getContentPane().add(lblQuimica);

		txtQuim1 = new JTextField();
		txtQuim1.setHorizontalAlignment(SwingConstants.CENTER);
		txtQuim1.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtQuim1.setEditable(false);
		txtQuim1.setColumns(10);
		txtQuim1.setBounds(869, 355, 47, 25);
		getContentPane().add(txtQuim1);

		txtQuim2 = new JTextField();
		txtQuim2.setHorizontalAlignment(SwingConstants.CENTER);
		txtQuim2.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtQuim2.setEditable(false);
		txtQuim2.setColumns(10);
		txtQuim2.setBounds(961, 355, 47, 25);
		getContentPane().add(txtQuim2);

		txtQuim3 = new JTextField();
		txtQuim3.setHorizontalAlignment(SwingConstants.CENTER);
		txtQuim3.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtQuim3.setEditable(false);
		txtQuim3.setColumns(10);
		txtQuim3.setBounds(1043, 357, 47, 25);
		getContentPane().add(txtQuim3);

		txtQuim4 = new JTextField();
		txtQuim4.setHorizontalAlignment(SwingConstants.CENTER);
		txtQuim4.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtQuim4.setEditable(false);
		txtQuim4.setColumns(10);
		txtQuim4.setBounds(1126, 357, 47, 25);
		getContentPane().add(txtQuim4);

		txtQuim5 = new JTextField();
		txtQuim5.setHorizontalAlignment(SwingConstants.CENTER);
		txtQuim5.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtQuim5.setEditable(false);
		txtQuim5.setColumns(10);
		txtQuim5.setBounds(1216, 357, 47, 25);
		getContentPane().add(txtQuim5);

		JLabel lblSociologia = new JLabel("Sociologia:");
		lblSociologia.setHorizontalAlignment(SwingConstants.CENTER);
		lblSociologia.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblSociologia.setBounds(725, 396, 87, 28);
		getContentPane().add(lblSociologia);

		txtSoc1 = new JTextField();
		txtSoc1.setHorizontalAlignment(SwingConstants.CENTER);
		txtSoc1.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtSoc1.setEditable(false);
		txtSoc1.setColumns(10);
		txtSoc1.setBounds(869, 393, 47, 25);
		getContentPane().add(txtSoc1);

		txtSoc2 = new JTextField();
		txtSoc2.setHorizontalAlignment(SwingConstants.CENTER);
		txtSoc2.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtSoc2.setEditable(false);
		txtSoc2.setColumns(10);
		txtSoc2.setBounds(961, 393, 47, 25);
		getContentPane().add(txtSoc2);

		txtSoc3 = new JTextField();
		txtSoc3.setHorizontalAlignment(SwingConstants.CENTER);
		txtSoc3.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtSoc3.setEditable(false);
		txtSoc3.setColumns(10);
		txtSoc3.setBounds(1043, 395, 47, 25);
		getContentPane().add(txtSoc3);

		txtSoc4 = new JTextField();
		txtSoc4.setHorizontalAlignment(SwingConstants.CENTER);
		txtSoc4.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtSoc4.setEditable(false);
		txtSoc4.setColumns(10);
		txtSoc4.setBounds(1126, 395, 47, 25);
		getContentPane().add(txtSoc4);

		txtSoc5 = new JTextField();
		txtSoc5.setHorizontalAlignment(SwingConstants.CENTER);
		txtSoc5.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtSoc5.setEditable(false);
		txtSoc5.setColumns(10);
		txtSoc5.setBounds(1216, 395, 47, 25);
		getContentPane().add(txtSoc5);

		JLabel lblPortugus = new JLabel("L\u00EDngua Portuguesa:");
		lblPortugus.setHorizontalAlignment(SwingConstants.CENTER);
		lblPortugus.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblPortugus.setBounds(670, 138, 141, 28);
		getContentPane().add(lblPortugus);

		txtPort1 = new JTextField();
		txtPort1.setHorizontalAlignment(SwingConstants.CENTER);
		txtPort1.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtPort1.setEditable(false);
		txtPort1.setColumns(10);
		txtPort1.setBounds(869, 136, 47, 25);
		getContentPane().add(txtPort1);

		txtPort2 = new JTextField();
		txtPort2.setHorizontalAlignment(SwingConstants.CENTER);
		txtPort2.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtPort2.setEditable(false);
		txtPort2.setColumns(10);
		txtPort2.setBounds(961, 136, 47, 25);
		getContentPane().add(txtPort2);

		txtPort3 = new JTextField();
		txtPort3.setHorizontalAlignment(SwingConstants.CENTER);
		txtPort3.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtPort3.setEditable(false);
		txtPort3.setColumns(10);
		txtPort3.setBounds(1043, 138, 47, 25);
		getContentPane().add(txtPort3);

		txtPort4 = new JTextField();
		txtPort4.setHorizontalAlignment(SwingConstants.CENTER);
		txtPort4.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtPort4.setEditable(false);
		txtPort4.setColumns(10);
		txtPort4.setBounds(1126, 138, 47, 25);
		getContentPane().add(txtPort4);

		txtPort5 = new JTextField();
		txtPort5.setHorizontalAlignment(SwingConstants.CENTER);
		txtPort5.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtPort5.setEditable(false);
		txtPort5.setColumns(10);
		txtPort5.setBounds(1216, 136, 47, 25);
		getContentPane().add(txtPort5);

		JLabel lblFilosofia = new JLabel("Filosofia:");
		lblFilosofia.setHorizontalAlignment(SwingConstants.CENTER);
		lblFilosofia.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblFilosofia.setBounds(728, 436, 83, 28);
		getContentPane().add(lblFilosofia);

		txtFil1 = new JTextField();
		txtFil1.setHorizontalAlignment(SwingConstants.CENTER);
		txtFil1.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtFil1.setEditable(false);
		txtFil1.setColumns(10);
		txtFil1.setBounds(869, 434, 47, 25);
		getContentPane().add(txtFil1);

		txtFil2 = new JTextField();
		txtFil2.setHorizontalAlignment(SwingConstants.CENTER);
		txtFil2.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtFil2.setEditable(false);
		txtFil2.setColumns(10);
		txtFil2.setBounds(961, 434, 47, 25);
		getContentPane().add(txtFil2);

		txtFil3 = new JTextField();
		txtFil3.setHorizontalAlignment(SwingConstants.CENTER);
		txtFil3.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtFil3.setEditable(false);
		txtFil3.setColumns(10);
		txtFil3.setBounds(1043, 436, 47, 25);
		getContentPane().add(txtFil3);

		txtFil4 = new JTextField();
		txtFil4.setHorizontalAlignment(SwingConstants.CENTER);
		txtFil4.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtFil4.setEditable(false);
		txtFil4.setColumns(10);
		txtFil4.setBounds(1126, 436, 47, 25);
		getContentPane().add(txtFil4);

		txtFil5 = new JTextField();
		txtFil5.setHorizontalAlignment(SwingConstants.CENTER);
		txtFil5.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtFil5.setEditable(false);
		txtFil5.setColumns(10);
		txtFil5.setBounds(1216, 436, 47, 25);
		getContentPane().add(txtFil5);

		JLabel lblEdFisica = new JLabel("Ed. F\u00EDsica:");
		lblEdFisica.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdFisica.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblEdFisica.setBounds(725, 475, 78, 28);
		getContentPane().add(lblEdFisica);

		txtEd2 = new JTextField();
		txtEd2.setHorizontalAlignment(SwingConstants.CENTER);
		txtEd2.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtEd2.setEditable(false);
		txtEd2.setColumns(10);
		txtEd2.setBounds(961, 473, 47, 25);
		getContentPane().add(txtEd2);

		txtEd3 = new JTextField();
		txtEd3.setHorizontalAlignment(SwingConstants.CENTER);
		txtEd3.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtEd3.setEditable(false);
		txtEd3.setColumns(10);
		txtEd3.setBounds(1043, 475, 47, 25);
		getContentPane().add(txtEd3);

		txtEd4 = new JTextField();
		txtEd4.setHorizontalAlignment(SwingConstants.CENTER);
		txtEd4.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtEd4.setEditable(false);
		txtEd4.setColumns(10);
		txtEd4.setBounds(1126, 475, 47, 25);
		getContentPane().add(txtEd4);

		txtEd5 = new JTextField();
		txtEd5.setHorizontalAlignment(SwingConstants.CENTER);
		txtEd5.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtEd5.setEditable(false);
		txtEd5.setColumns(10);
		txtEd5.setBounds(1216, 475, 47, 25);
		getContentPane().add(txtEd5);

		JLabel lblIngles = new JLabel("Ingl\u00EAs:");
		lblIngles.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngles.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblIngles.setBounds(736, 515, 78, 28);
		getContentPane().add(lblIngles);

		txtIng1 = new JTextField();
		txtIng1.setHorizontalAlignment(SwingConstants.CENTER);
		txtIng1.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtIng1.setEditable(false);
		txtIng1.setColumns(10);
		txtIng1.setBounds(869, 515, 47, 25);
		getContentPane().add(txtIng1);

		txtIng2 = new JTextField();
		txtIng2.setHorizontalAlignment(SwingConstants.CENTER);
		txtIng2.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtIng2.setEditable(false);
		txtIng2.setColumns(10);
		txtIng2.setBounds(961, 515, 47, 25);
		getContentPane().add(txtIng2);

		txtIng3 = new JTextField();
		txtIng3.setHorizontalAlignment(SwingConstants.CENTER);
		txtIng3.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtIng3.setEditable(false);
		txtIng3.setColumns(10);
		txtIng3.setBounds(1043, 515, 47, 25);
		getContentPane().add(txtIng3);

		txtIng4 = new JTextField();
		txtIng4.setHorizontalAlignment(SwingConstants.CENTER);
		txtIng4.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtIng4.setEditable(false);
		txtIng4.setColumns(10);
		txtIng4.setBounds(1126, 515, 47, 25);
		getContentPane().add(txtIng4);

		txtIng5 = new JTextField();
		txtIng5.setHorizontalAlignment(SwingConstants.CENTER);
		txtIng5.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtIng5.setEditable(false);
		txtIng5.setColumns(10);
		txtIng5.setBounds(1216, 515, 47, 25);
		getContentPane().add(txtIng5);

		JLabel lblArtes = new JLabel("Artes:");
		lblArtes.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtes.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblArtes.setBounds(734, 555, 78, 28);
		getContentPane().add(lblArtes);

		txtArt1 = new JTextField();
		txtArt1.setHorizontalAlignment(SwingConstants.CENTER);
		txtArt1.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtArt1.setEditable(false);
		txtArt1.setColumns(10);
		txtArt1.setBounds(869, 555, 47, 25);
		getContentPane().add(txtArt1);

		txtArt2 = new JTextField();
		txtArt2.setHorizontalAlignment(SwingConstants.CENTER);
		txtArt2.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtArt2.setEditable(false);
		txtArt2.setColumns(10);
		txtArt2.setBounds(961, 555, 47, 25);
		getContentPane().add(txtArt2);

		txtArt3 = new JTextField();
		txtArt3.setHorizontalAlignment(SwingConstants.CENTER);
		txtArt3.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtArt3.setEditable(false);
		txtArt3.setColumns(10);
		txtArt3.setBounds(1043, 555, 47, 25);
		getContentPane().add(txtArt3);

		txtArt4 = new JTextField();
		txtArt4.setHorizontalAlignment(SwingConstants.CENTER);
		txtArt4.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtArt4.setEditable(false);
		txtArt4.setColumns(10);
		txtArt4.setBounds(1126, 555, 47, 25);
		getContentPane().add(txtArt4);

		txtArt5 = new JTextField();
		txtArt5.setHorizontalAlignment(SwingConstants.CENTER);
		txtArt5.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtArt5.setEditable(false);
		txtArt5.setColumns(10);
		txtArt5.setBounds(1216, 555, 47, 25);
		getContentPane().add(txtArt5);

		txtId2 = new JTextField();
		txtId2.setEditable(false);
		txtId2.setBounds(544, 32, -2, -2);
		getContentPane().add(txtId2);
		txtId2.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 255, 493, 362);
		getContentPane().add(scrollPane);

		tblTeste = new JTable();
		scrollPane.setViewportView(tblTeste);

		JLabel lblbi = new JLabel("1\u00BABim.");
		lblbi.setHorizontalAlignment(SwingConstants.CENTER);
		lblbi.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblbi.setBounds(869, 99, 47, 28);
		getContentPane().add(lblbi);

		JLabel lblbi_1 = new JLabel("2\u00BABim.");
		lblbi_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblbi_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblbi_1.setBounds(961, 99, 47, 28);
		getContentPane().add(lblbi_1);

		JLabel lblbi_2 = new JLabel("3\u00BABim.");
		lblbi_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblbi_2.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblbi_2.setBounds(1043, 99, 47, 28);
		getContentPane().add(lblbi_2);

		JLabel lblbi_3 = new JLabel("4\u00BABim.");
		lblbi_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblbi_3.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblbi_3.setBounds(1126, 99, 47, 28);
		getContentPane().add(lblbi_3);

		JLabel lblNewLabel_1 = new JLabel("Aluno:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(30, 195, 64, 19);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("ID:");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(372, 90, 47, 19);
		getContentPane().add(lblNewLabel_2);

		JButton btnNewButton = new JButton("Relat\u00F3rio");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerarRelatorios();
				gerarRelatorio1();

			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnNewButton.setBounds(890, 628, 200, 50);
		getContentPane().add(btnNewButton);
		
		lblAluno = new JTextField();
		lblAluno.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblAluno.setEditable(false);
		lblAluno.setBounds(232, 190, 221, 30);
		getContentPane().add(lblAluno);
		lblAluno.setColumns(10);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtId.setEditable(false);
		txtId.setBounds(429, 85, 64, 30);
		getContentPane().add(txtId);
		txtId.setColumns(10);
		
		cboPeriodo = new JComboBox();
		cboPeriodo.setFont(new Font("Verdana", Font.PLAIN, 16));
		cboPeriodo.setModel(new DefaultComboBoxModel(new String[] {"MANH\u00C3", "TARDE", "NOITE"}));
		cboPeriodo.setBounds(145, 34, 120, 30);
		getContentPane().add(cboPeriodo);
		
		JLabel lblNewLabel_3 = new JLabel("Per\u00EDodo:");
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(34, 34, 101, 19);
		getContentPane().add(lblNewLabel_3);
		
				JLabel lblTotal = new JLabel("TOTAL");
				lblTotal.setBounds(1206, 103, 57, 21);
				getContentPane().add(lblTotal);
				lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
				lblTotal.setFont(new Font("Verdana", Font.PLAIN, 12));
						
								txtEd1 = new JTextField();
								txtEd1.setBounds(869, 470, 47, 29);
								getContentPane().add(txtEd1);
								txtEd1.setHorizontalAlignment(SwingConstants.CENTER);
								txtEd1.setFont(new Font("Verdana", Font.PLAIN, 18));
								txtEd1.setEditable(false);
								txtEd1.setColumns(10);
						
								JPanel panel = new JPanel();
								panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
								panel.setBounds(609, 85, 688, 532);
								getContentPane().add(panel);
		tblTeste.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setarId();
			}
		});
		conexao = ModuloConexao.conector();
	}

	private void gerarRelatorios() {
		Double confirmarAlunoDouble = null;
		String confirmarAluno = null;
		String verificar = "select * from tb_media where idal = ?";
		String status = null;
		String atualizarMedia = "update tb_media set status=?,portugues=?,matematica=?,geografia=?,historia=?,filosofia=?,sociologia=?,biologia=?,quimica=?,fisica=?,ingles=?,artes=?,edfisica=?,media=? where idal=?";
		String adicionarMedia = "insert into tb_media(idal,nomeal,status,portugues, matematica, geografia, historia, filosofia, sociologia, biologia, quimica, fisica, ingles, artes, edfisica,media) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Double media = null;
		Double n1,n2,n3,n4,n5,n6,n7,n8,n9,n10,n11,n12;
		DecimalFormat formatador = new DecimalFormat("0.0");
		String mediaString = null;
		n1 = Double.parseDouble(txtPort5.getText().replace(",", "."));
		n2 = Double.parseDouble(txtMath5.getText().replace(",", "."));
		n3 = Double.parseDouble(txtGeo5.getText().replace(",", "."));
		n4 = Double.parseDouble(txtHist5.getText().replace(",", "."));
		n5 = Double.parseDouble(txtFil5.getText().replace(",", "."));
		n6 = Double.parseDouble(txtSoc5.getText().replace(",", "."));
		n7 = Double.parseDouble(txtBio5.getText().replace(",", "."));
		n8 = Double.parseDouble(txtQuim5.getText().replace(",", "."));
		n9 = Double.parseDouble(txtFis5.getText().replace(",", "."));
		n10 = Double.parseDouble(txtIng5.getText().replace(",", "."));
		n11 = Double.parseDouble(txtArt5.getText().replace(",", "."));
		n12 = Double.parseDouble(txtEd5.getText().replace(",", "."));
		media = (n1+n2+n3+n4+n5+n6+n7+n8+n9+n10+n11+n12) / 12;
		if(media < 5) {
			status = "REPROVADO";
		}else {
			status = "APROVADO";
		}
		try {
	
			pst = conexao.prepareStatement(verificar);
			pst.setString(1, txtId.getText());
			rs = (ResultSet) pst.executeQuery();
			while (rs.next()) {
				confirmarAluno = rs.getString(2);
				confirmarAlunoDouble = Double.parseDouble(confirmarAluno);

			}
			if (confirmarAlunoDouble != null) {
			//	JOptionPane.showMessageDialog(null, "Não é Nulo");
				// tem media
				mediaString = formatador.format(media);
				
				try {
					pst = conexao.prepareStatement(atualizarMedia);
					
					pst.setString(1, status);
					pst.setString(2, txtPort5.getText());
					pst.setString(3, txtMath5.getText());
					pst.setString(4, txtGeo5.getText());
					pst.setString(5, txtHist5.getText());
					pst.setString(6, txtFil5.getText());
					pst.setString(7, txtSoc5.getText());
					pst.setString(8, txtBio5.getText());
					pst.setString(9, txtQuim5.getText());
					pst.setString(10, txtFis5.getText());
					pst.setString(11, txtIng5.getText());
					pst.setString(12, txtArt5.getText());
					pst.setString(13, txtEd5.getText());
					pst.setString(14, mediaString);
					pst.setString(15, txtId.getText());
					
					int adicionado = pst.executeUpdate();
//
//					if (adicionado == 1) {
//
//					
//					
//					} else {
//						
//							
//					}

				} catch (Exception e) {
					// System.out.println(e);
					// JOptionPane.showMessageDialog(null, e);
				
				}
			} else {
				//JOptionPane.showMessageDialog(null, "É Nulo");
				// nao tem media
				mediaString = formatador.format(media);
				try {
					pst = conexao.prepareStatement(adicionarMedia);
					pst.setString(1, txtId.getText());
					pst.setString(2, lblAluno.getText());
					pst.setString(3, status);
					pst.setString(4, txtPort5.getText());
					pst.setString(5, txtMath5.getText());
					pst.setString(6, txtGeo5.getText());
					pst.setString(7, txtHist5.getText());
					pst.setString(8, txtFil5.getText());
					pst.setString(9, txtSoc5.getText());
					pst.setString(10, txtBio5.getText());
					pst.setString(11, txtQuim5.getText());
					pst.setString(12, txtFis5.getText());
					pst.setString(13, txtIng5.getText());
					pst.setString(14, txtArt5.getText());
					pst.setString(15, txtEd5.getText());
					pst.setString(16, mediaString);
					
					int adicionado = pst.executeUpdate();
					System.out.println(adicionado);
					
					
					if (adicionado == 1) {
						//System.out.println(media);
						//JOptionPane.showMessageDialog(null, "Funcionário adicionado com sucesso.");
					} else {
						//JOptionPane.showMessageDialog(null, "Não foi possível adicionar este funcionário.");
					}
				} catch (Exception e) {
					System.out.println("Deu ruim :(  " + e);
				}
				
				
				
				
			}

		} catch (Exception e) {
			System.out.println(e);
			//JOptionPane.showMessageDialog(null, e);
		}

	}

	private void pesquisarTurmas() {
		String idTurmaString = null;
		String consultarTurma = "select * from tb_turmas where anoturma like ? and sigla like ? and periodo like ?";
		// String consultarAlunos = "select idal as ID, nomeal as Nome, cpfal as CPF
		// ,rgal as RG , statusal as Status_Atual , emailal as E_Mail, idturma as
		// ID_Turma from tb_dados_alunos where idturma like ?";
		String consultarAlunos = "select idal as 'ID do ALUNO', nomeal as NOME from tb_dados_alunos where idturma = ?";
		try {

			pst = conexao.prepareStatement(consultarTurma);

			pst.setString(1, cboAno.getSelectedItem().toString() + "%");
			pst.setString(2, cboSigla.getSelectedItem().toString() + "%");
			pst.setString(3, cboPeriodo.getSelectedItem().toString() + "%");
			rs = pst.executeQuery();

			rs.next();

			idTurmaString = rs.getString("idturma");
			pst = conexao.prepareStatement(consultarAlunos);
			pst.setString(1, idTurmaString);
			rs = pst.executeQuery();
			tblTeste.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception e) {
			System.out.println(e);
			limparTabela();
			// JOptionPane.showMessageDialog(null, e);

		}

	}

	private void limparTabela() {
		while (tblTeste.getRowCount() > 0) {
			((DefaultTableModel) tblTeste.getModel()).removeRow(0);
		}
	}

	private void setarCamposA() {
		int setar = tblTeste.getSelectedRow();

		txtId.setText(tblTeste.getModel().getValueAt(setar, 0).toString());
		lblAluno.setText(tblTeste.getModel().getValueAt(setar, 1).toString());
	}

	private void gerarMedia() {

		String tSomaPort1 = "select * from tb_notas where idaluno = ? and bi = 1 AND materia = 'LINGUA PORTUGUESA'";
		String tSomaPort2 = "select * from tb_notas where idaluno = ? AND bi = 2 AND materia = 'LINGUA PORTUGUESA'";
		String tSomaPort3 = "select * from tb_notas where idaluno = ? AND bi = 3 AND materia = 'LINGUA PORTUGUESA'";
		String tSomaPort4 = "select * from tb_notas where idaluno = ? AND bi = 4 AND materia = 'LINGUA PORTUGUESA'";
		String tSomaPort5 = "SELECT * from tb_notas WHERE idaluno = ? and materia = 'LINGUA PORTUGUESA'";

		String tSomaMath1 = "select * from tb_notas where idaluno = ? and bi = 1 AND materia = 'MATEMATICA'";
		String tSomaMath2 = "select * from tb_notas where idaluno = ? AND bi = 2 AND materia = 'MATEMATICA'";
		String tSomaMath3 = "select * from tb_notas where idaluno = ? AND bi = 3 AND materia = 'MATEMATICA'";
		String tSomaMath4 = "select * from tb_notas where idaluno = ? AND bi = 4 AND materia = 'MATEMATICA'";
		String tSomaMath5 = "SELECT * from tb_notas WHERE idaluno = ? and materia = 'MATEMATICA'";

		String tSomaGeo1 = "select * from tb_notas where idaluno = ? and bi = 1 AND materia = 'GEOGRAFIA'";
		String tSomaGeo2 = "select * from tb_notas where idaluno = ? AND bi = 2 AND materia = 'GEOGRAFIA'";
		String tSomaGeo3 = "select * from tb_notas where idaluno = ? AND bi = 3 AND materia = 'GEOGRAFIA'";
		String tSomaGeo4 = "select * from tb_notas where idaluno = ? AND bi = 4 AND materia = 'GEOGRAFIA'";
		String tSomaGeo5 = "SELECT * from tb_notas WHERE idaluno = ? and materia = 'GEOGRAFIA'";

		String tSomaHist1 = "select * from tb_notas where idaluno = ? and bi = 1 AND materia = 'HISTORIA'";
		String tSomaHist2 = "select * from tb_notas where idaluno = ? AND bi = 2 AND materia = 'HISTORIA'";
		String tSomaHist3 = "select * from tb_notas where idaluno = ? AND bi = 3 AND materia = 'HISTORIA'";
		String tSomaHist4 = "select * from tb_notas where idaluno = ? AND bi = 4 AND materia = 'HISTORIA'";
		String tSomaHist5 = "SELECT * from tb_notas WHERE idaluno = ? and materia = 'HISTORIA'";

		String tSomaFis1 = "select * from tb_notas where idaluno = ? and bi = 1 AND materia = 'FISICA'";
		String tSomaFis2 = "select * from tb_notas where idaluno = ? AND bi = 2 AND materia = 'FISICA'";
		String tSomaFis3 = "select * from tb_notas where idaluno = ? AND bi = 3 AND materia = 'FISICA'";
		String tSomaFis4 = "select * from tb_notas where idaluno = ? AND bi = 4 AND materia = 'FISICA'";
		String tSomaFis5 = "SELECT * from tb_notas WHERE idaluno = ? and materia = 'FISICA'";

		String tSomaBio1 = "select * from tb_notas where idaluno = ? and bi = 1 AND materia = 'BIOLOGIA'";
		String tSomaBio2 = "select * from tb_notas where idaluno = ? AND bi = 2 AND materia = 'BIOLOGIA'";
		String tSomaBio3 = "select * from tb_notas where idaluno = ? AND bi = 3 AND materia = 'BIOLOGIA'";
		String tSomaBio4 = "select * from tb_notas where idaluno = ? AND bi = 4 AND materia = 'BIOLOGIA'";
		String tSomaBio5 = "SELECT * from tb_notas WHERE idaluno = ? and materia = 'BIOLOGIA'";

		String tSomaQuim1 = "select * from tb_notas where idaluno = ? and bi = 1 AND materia = 'QUIMICA'";
		String tSomaQuim2 = "select * from tb_notas where idaluno = ? AND bi = 2 AND materia = 'QUIMICA'";
		String tSomaQuim3 = "select * from tb_notas where idaluno = ? AND bi = 3 AND materia = 'QUIMICA'";
		String tSomaQuim4 = "select * from tb_notas where idaluno = ? AND bi = 4 AND materia = 'QUIMICA'";
		String tSomaQuim5 = "SELECT * from tb_notas WHERE idaluno = ? and materia = 'QUIMICA'";

		String tSomaSoc1 = "select * from tb_notas where idaluno = ? and bi = 1 AND materia = 'SOCIOLOGIA'";
		String tSomaSoc2 = "select * from tb_notas where idaluno = ? AND bi = 2 AND materia = 'SOCIOLOGIA'";
		String tSomaSoc3 = "select * from tb_notas where idaluno = ? AND bi = 3 AND materia = 'SOCIOLOGIA'";
		String tSomaSoc4 = "select * from tb_notas where idaluno = ? AND bi = 4 AND materia =  'SOCIOLOGIA'";
		String tSomaSoc5 = "SELECT * from tb_notas WHERE idaluno = ? and materia = 'SOCIOLOGIA'";

		String tSomaFil1 = "select * from tb_notas where idaluno = ? and bi = 1 AND materia = 'FILOSOFIA'";
		String tSomaFil2 = "select * from tb_notas where idaluno = ? AND bi = 2 AND materia = 'FILOSOFIA'";
		String tSomaFil3 = "select * from tb_notas where idaluno = ? AND bi = 3 AND materia = 'FILOSOFIA'";
		String tSomaFil4 = "select * from tb_notas where idaluno = ? AND bi = 4 AND materia =  'FILOSOFIA'";
		String tSomaFil5 = "SELECT * from tb_notas WHERE idaluno = ? and materia = 'FILOSOFIA'";

		String tSomaEd1 = "select * from tb_notas where idaluno = ? and bi = 1 AND materia = 'EDUCACAO FISICA'";
		String tSomaEd2 = "select * from tb_notas where idaluno = ? AND bi = 2 AND materia = 'EDUCACAO FISICA'";
		String tSomaEd3 = "select * from tb_notas where idaluno = ? AND bi = 3 AND materia = 'EDUCACAO FISICA'";
		String tSomaEd4 = "select * from tb_notas where idaluno = ? AND bi = 4 AND materia = 'EDUCACAO FISICA'";
		String tSomaEd5 = "SELECT * from tb_notas WHERE idaluno = ? and materia = 'EDUCACAO FISICA'";

		String tSomaIng1 = "select * from tb_notas where idaluno = ? and bi = 1 AND materia = 'INGLES'";
		String tSomaIng2 = "select * from tb_notas where idaluno = ? AND bi = 2 AND materia = 'INGLES'";
		String tSomaIng3 = "select * from tb_notas where idaluno = ? AND bi = 3 AND materia = 'INGLES'";
		String tSomaIng4 = "select * from tb_notas where idaluno = ? AND bi = 4 AND materia =  'INGLES'";
		String tSomaIng5 = "SELECT * from tb_notas WHERE idaluno = ? and materia = 'INGLES'";

		String tSomaArt1 = "select * from tb_notas where idaluno = ? and bi = 1 AND materia = 'ARTES'";
		String tSomaArt2 = "select * from tb_notas where idaluno = ? AND bi = 2 AND materia = 'ARTES'";
		String tSomaArt3 = "select * from tb_notas where idaluno = ? AND bi = 3 AND materia = 'ARTES'";
		String tSomaArt4 = "select * from tb_notas where idaluno = ? AND bi = 4 AND materia =  'ARTES'";
		String tSomaArt5 = "SELECT * from tb_notas WHERE idaluno = ? and materia = 'ARTES'";
		DecimalFormat formatador = new DecimalFormat("0.0");

		try {
			Double notaDouble, mediaDouble;
			int notaInt, qt, mediaInt;
			String notaString, mediaString;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			mediaDouble = 0.0;
			notaDouble = 0.0;
			pst = conexao.prepareStatement(tSomaPort1);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}

			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtPort1.setText(mediaString);

			} else {
				mediaString = "ND";
				txtPort1.setText(mediaString);
			}

			// Portugues Bi 2
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaPort2);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);
			}

			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtPort2.setText(mediaString);

			} else {
				mediaString = "ND";
				txtPort2.setText(mediaString);
			}

			// Portugues Bi 3
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaPort3);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtPort3.setText(mediaString);
			} else {
				mediaString = "ND";
				txtPort3.setText(mediaString);
			}

			// Portugues Bi 4
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaPort4);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtPort4.setText(mediaString);

			} else {
				mediaString = "ND";
				txtPort4.setText(mediaString);
			}

			// Portugues Final
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaPort5);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtPort5.setText(mediaString);

			} else {
				mediaString = "0.0";
				txtPort5.setText(mediaString);
			}

			// Math Bi 1
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaMath1);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtMath1.setText(mediaString);

			} else {
				mediaString = "ND";
				txtMath1.setText(mediaString);
			}

			// Math Bi 2
			mediaDouble = 0.0;
			notaDouble = 0.0;

			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaMath2);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtMath2.setText(mediaString);

			} else {
				mediaString = "ND";
				txtMath2.setText(mediaString);
			}

			// Math Bi 3
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaMath3);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtMath3.setText(mediaString);

			} else {
				mediaString = "ND";
				txtMath3.setText(mediaString);
			}

			// Math Bi 4
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaMath4);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtMath4.setText(mediaString);

			} else {
				mediaString = "ND";
				txtMath4.setText(mediaString);
			}

			// Math final
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaMath5);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtMath5.setText(mediaString);

			} else {
				mediaString = "0.0";
				txtMath5.setText(mediaString);
			}
// continuar a partir daqui
			// Geografia Bi 1

			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaGeo1);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtGeo1.setText(mediaString);

			} else {
				mediaString = "ND";
				txtGeo1.setText(mediaString);
			}

			// Geografia Bi 2
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaGeo2);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtGeo2.setText(mediaString);

			} else {
				mediaString = "ND";
				txtGeo2.setText(mediaString);
			}

			// Geografia Bi 3
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaGeo3);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtGeo3.setText(mediaString);

			} else {
				mediaString = "ND";
				txtGeo3.setText(mediaString);
			}

			// Geografia Bi 4
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaGeo4);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtGeo4.setText(mediaString);

			} else {
				mediaString = "ND";
				txtGeo4.setText(mediaString);
			}

			// Geografia Final
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaGeo5);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtGeo5.setText(mediaString);

			} else {
				mediaString = "0.0";
				txtGeo5.setText(mediaString);
			}

			// Hist BI 1
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaHist1);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtHist1.setText(mediaString);

			} else {
				mediaString = "ND";
				txtHist1.setText(mediaString);
			}

			// Hist BI 2
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaHist2);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtHist2.setText(mediaString);

			} else {
				mediaString = "ND";
				txtHist2.setText(mediaString);
			}

			// Hist BI 3
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaHist3);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtHist3.setText(mediaString);

			} else {
				mediaString = "ND";
				txtHist3.setText(mediaString);
			}

			// Hist BI 4
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaHist4);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtHist4.setText(mediaString);

			} else {
				mediaString = "ND";
				txtHist4.setText(mediaString);
			}

			// Hist Final
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaHist5);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtHist5.setText(mediaString);

			} else {
				mediaString = "0.0";
				txtHist5.setText(mediaString);
			}

			// FÍSICA BI 1
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaFis1);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtFis1.setText(mediaString);

			} else {
				mediaString = "ND";
				txtFis1.setText(mediaString);
			}

			// FÍSICA BI 2
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaFis2);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtFis2.setText(mediaString);

			} else {
				mediaString = "ND";
				txtFis2.setText(mediaString);
			}

			// FÍSICA BI 3
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaFis3);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtFis3.setText(mediaString);

			} else {
				mediaString = "ND";
				txtFis3.setText(mediaString);
			}

			// FÍSICA BI 4
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaFis4);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtFis4.setText(mediaString);

			} else {
				mediaString = "ND";
				txtFis4.setText(mediaString);
			}

			// FÍSICA FINAL
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaFis5);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtFis5.setText(mediaString);

			} else {
				mediaString = "0.0";
				txtFis5.setText(mediaString);
			}

			// BIOLOGIA BI1
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaBio1);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtBio1.setText(mediaString);

			} else {
				mediaString = "ND";
				txtBio1.setText(mediaString);
			}

			// BIOLOGIA BI2
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaBio2);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtBio2.setText(mediaString);

			} else {
				mediaString = "ND";
				txtBio2.setText(mediaString);
			}
			// BIOLOGIA BI3
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaBio3);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtBio3.setText(mediaString);

			} else {
				mediaString = "ND";
				txtBio3.setText(mediaString);
			}
			// BIOLOGIA BI4
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaBio4);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtBio4.setText(mediaString);

			} else {
				mediaString = "ND";
				txtBio4.setText(mediaString);
			}

			// BIOLOGIA Final
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaBio5);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtBio5.setText(mediaString);

			} else {
				mediaString = "0.0";
				txtBio5.setText(mediaString);
			}

			/// CONTINUAR A PARTIR DAQUI

			// QUÍMICA BI 1
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaQuim1);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtQuim1.setText(mediaString);

			} else {
				mediaString = "ND";
				txtQuim1.setText(mediaString);
			}

			// QUÍMICA BI 2
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaQuim2);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtQuim2.setText(mediaString);

			} else {
				mediaString = "ND";
				txtQuim2.setText(mediaString);
			}

			// QUÍMICA BI 3
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaQuim3);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtQuim3.setText(mediaString);

			} else {
				mediaString = "ND";
				txtQuim3.setText(mediaString);
			}

			// QUÍMICA BI 4
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaQuim4);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtQuim4.setText(mediaString);

			} else {
				mediaString = "ND";
				txtQuim4.setText(mediaString);
			}

			// QUÍMICA Final
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaQuim5);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtQuim5.setText(mediaString);

			} else {
				mediaString = "0.0";
				txtQuim5.setText(mediaString);
			}

			// 'SOCIOLOGIA' BI 1
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaSoc1);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtSoc1.setText(mediaString);

			} else {
				mediaString = "ND";
				txtSoc1.setText(mediaString);
			}

			// 'SOCIOLOGIA' BI 2
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaSoc2);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtSoc2.setText(mediaString);

			} else {
				mediaString = "ND";
				txtSoc2.setText(mediaString);
			}

			// 'SOCIOLOGIA' BI 3
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaSoc3);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtSoc3.setText(mediaString);

			} else {
				mediaString = "ND";
				txtSoc3.setText(mediaString);
			}

			// 'SOCIOLOGIA' BI 4
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaSoc4);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtSoc4.setText(mediaString);

			} else {
				mediaString = "ND";
				txtSoc4.setText(mediaString);
			}

			// 'SOCIOLOGIA' FINAL
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaSoc5);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtSoc5.setText(mediaString);

			} else {
				mediaString = "0.0";
				txtSoc5.setText(mediaString);
			}

			// 'FILOSOFIA' BI 1
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaFil1);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtFil1.setText(mediaString);

			} else {
				mediaString = "ND";
				txtFil1.setText(mediaString);
			}

			// 'FILOSOFIA' BI2
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaFil2);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtFil2.setText(mediaString);

			} else {
				mediaString = "ND";
				txtFil2.setText(mediaString);
			}
			// 'FILOSOFIA' BI 3
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaFil3);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtFil3.setText(mediaString);

			} else {
				mediaString = "ND";
				txtFil3.setText(mediaString);
			}
			// 'FILOSOFIA' BI 4
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaFil4);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtFil4.setText(mediaString);

			} else {
				mediaString = "ND";
				txtFil4.setText(mediaString);
			}

			// 'FILOSOFIA' FINAL
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaFil5);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtFil5.setText(mediaString);

			} else {
				mediaString = "0.0";
				txtFil5.setText(mediaString);
			}

			// 'ED.FÍSICA' BI 1
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaEd1);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtEd1.setText(mediaString);

			} else {
				mediaString = "ND";
				txtEd1.setText(mediaString);
			}

			// 'ED.FÍSICA' BI 2
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaEd2);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtEd2.setText(mediaString);

			} else {
				mediaString = "ND";
				txtEd2.setText(mediaString);
			}

			// 'ED.FÍSICA' BI 3
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaEd3);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtEd3.setText(mediaString);

			} else {
				mediaString = "ND";
				txtEd3.setText(mediaString);
			}

			// 'ED.FÍSICA' BI 4
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaEd4);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtEd4.setText(mediaString);

			} else {
				mediaString = "ND";
				txtEd4.setText(mediaString);
			}

			// 'ED.FÍSICA' FINAL
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaEd5);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtEd5.setText(mediaString);

			} else {
				mediaString = "0.0";
				txtEd5.setText(mediaString);
			}

			// INGLÊS BI 1
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaIng1);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtIng1.setText(mediaString);

			} else {
				mediaString = "ND";
				txtIng1.setText(mediaString);
			}

			// INGLÊS BI 2
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaIng2);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtIng2.setText(mediaString);

			} else {
				mediaString = "ND";
				txtIng2.setText(mediaString);
			}

			// INGLÊS BI 3
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaIng3);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtIng3.setText(mediaString);

			} else {
				mediaString = "ND";
				txtIng3.setText(mediaString);
			}

			// INGLÊS BI 4
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaIng4);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtIng4.setText(mediaString);

			} else {
				mediaString = "ND";
				txtIng4.setText(mediaString);
			}

			// INGLÊS FINAL
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaIng5);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtIng5.setText(mediaString);

			} else {
				mediaString = "0.0";
				txtIng5.setText(mediaString);
			}

			// ARTES BI
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaArt1);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtArt1.setText(mediaString);

			} else {
				mediaString = "ND";
				txtArt1.setText(mediaString);
			}
			// ARTES BI 2
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaArt2);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtArt2.setText(mediaString);

			} else {
				mediaString = "ND";
				txtArt2.setText(mediaString);
			}

			// ARTES BI 3
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaArt3);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtArt3.setText(mediaString);

			} else {
				mediaString = "ND";
				txtArt3.setText(mediaString);
			}

			// ARTES BI 4
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaArt4);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtArt4.setText(mediaString);

			} else {
				mediaString = "ND";
				txtArt4.setText(mediaString);
			}

			// ARTES FINAL
			mediaDouble = 0.0;
			notaDouble = 0.0;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaArt5);
			pst.setString(1, txtId.getText().toString());
			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaDouble = notaDouble + Double.parseDouble(notaString);

			}
			if (notaDouble != 0) {
				mediaDouble = notaDouble / qt;
				mediaString = formatador.format(mediaDouble);
				txtArt5.setText(mediaString);

			} else {
				mediaString = "0.0";
				txtArt5.setText(mediaString);
			}

		} catch (Exception e) {
			System.out.println(e);
			// JOptionPane.showMessageDialog(null, e);

		}
	}
	
	private void gerarRelatorio1() {
		String erro = null;
		String jasper = "C:\\JavaEstudo\\WeducareGestao\\src\\br\\com\\PDF\\Blank_A4_Landscape_1.jasper";
		
		byte[] bytes = null;
		
		try {
			JasperReport relatorio = (JasperReport) JRLoader.loadObjectFromFile(jasper);
			bytes = JasperRunManager.runReportToPdf(relatorio, null, conexao);
			File arq = new File("C:\\JavaEstudo\\WeducareGestao\\src\\br\\com\\PDF","relatorio.pdf");

			//JOptionPane.showMessageDialog(null,bytes);
			if(arq.exists()){
				arq.delete();
				}
					
			FileOutputStream fos = new FileOutputStream(arq);
			fos.write(bytes);
			fos.flush();
			fos.close();
			
			Desktop desk = Desktop.getDesktop();
			desk.open(arq); 
		
		} catch (JRException | IOException e) {
			erro = e.getMessage();
			JOptionPane.showMessageDialog(null,erro);
		}
	}

	private void setarId() {
		int setar = tblTeste.getSelectedRow();
		txtId.setText(tblTeste.getModel().getValueAt(setar, 0).toString());
		lblAluno.setText(tblTeste.getModel().getValueAt(setar, 1).toString());
		gerarMedia();
	}
}
