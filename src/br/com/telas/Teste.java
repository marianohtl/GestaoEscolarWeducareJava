package br.com.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;

import br.com.dal.ModuloConexao;
import net.proteanit.sql.DbUtils;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JEditorPane;
import javax.swing.JList;
import javax.swing.Box;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Teste extends JFrame {

	private JPanel contentPane;
	private JTextField txtPort1;
	private JTextField txtMat1;
	private JTextField txtPort2;
	private JTextField txtMat2;
	private JTextField txtPort3;
	private JTextField txtMat3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teste frame = new Teste();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JButton btnGerarMdia;
	private JComboBox cboTurmas;
	private JButton btnTeste;
	private JTextField txtAluno;

	public Teste() {
		conexao = ModuloConexao.conector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 762, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("M\u00E9dia por Bimestre");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(227, 153, 277, 31);
		contentPane.add(lblNewLabel);

		JLabel label = new JLabel("1\u00BA");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(209, 194, 112, 31);
		contentPane.add(label);

		JLabel label_1 = new JLabel("2\u00BA");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(331, 194, 112, 31);
		contentPane.add(label_1);

		JLabel lblPortugues = new JLabel("Portugues");
		lblPortugues.setHorizontalAlignment(SwingConstants.CENTER);
		lblPortugues.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPortugues.setBounds(88, 234, 112, 31);
		contentPane.add(lblPortugues);

		JLabel lblMatematica = new JLabel("Matematica");
		lblMatematica.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatematica.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMatematica.setBounds(88, 274, 112, 31);
		contentPane.add(lblMatematica);

		JLabel lblAnoLetivo = new JLabel("Ano Letivo");
		lblAnoLetivo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnoLetivo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAnoLetivo.setBounds(453, 194, 112, 31);
		contentPane.add(lblAnoLetivo);

		txtPort1 = new JTextField();
		txtPort1.setEditable(false);
		txtPort1.setHorizontalAlignment(SwingConstants.CENTER);
		txtPort1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPort1.setBounds(209, 240, 96, 19);
		contentPane.add(txtPort1);
		txtPort1.setColumns(10);

		txtMat1 = new JTextField();
		txtMat1.setHorizontalAlignment(SwingConstants.CENTER);
		txtMat1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMat1.setEditable(false);
		txtMat1.setColumns(10);
		txtMat1.setBounds(209, 282, 96, 19);
		contentPane.add(txtMat1);

		txtPort2 = new JTextField();
		txtPort2.setHorizontalAlignment(SwingConstants.CENTER);
		txtPort2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPort2.setEditable(false);
		txtPort2.setColumns(10);
		txtPort2.setBounds(341, 235, 96, 19);
		contentPane.add(txtPort2);

		txtMat2 = new JTextField();
		txtMat2.setHorizontalAlignment(SwingConstants.CENTER);
		txtMat2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMat2.setEditable(false);
		txtMat2.setColumns(10);
		txtMat2.setBounds(341, 282, 96, 19);
		contentPane.add(txtMat2);

		txtPort3 = new JTextField();
		txtPort3.setHorizontalAlignment(SwingConstants.CENTER);
		txtPort3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPort3.setEditable(false);
		txtPort3.setColumns(10);
		txtPort3.setBounds(469, 234, 96, 19);
		contentPane.add(txtPort3);

		txtMat3 = new JTextField();
		txtMat3.setHorizontalAlignment(SwingConstants.CENTER);
		txtMat3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMat3.setEditable(false);
		txtMat3.setColumns(10);
		txtMat3.setBounds(469, 282, 96, 19);
		contentPane.add(txtMat3);

		btnGerarMdia = new JButton("Gerar M\u00E9dia");
		btnGerarMdia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerarMedia();
			}
		});
		btnGerarMdia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGerarMdia.setBounds(275, 354, 204, 56);
		contentPane.add(btnGerarMdia);

		cboTurmas = new JComboBox();
		cboTurmas.setBounds(62, 31, 79, 21);
		contentPane.add(cboTurmas);

		btnTeste = new JButton("Teste");
		btnTeste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preencherTurmas();
			}
		});
		btnTeste.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTeste.setBounds(196, 20, 204, 56);
		contentPane.add(btnTeste);

		txtAluno = new JTextField();
		txtAluno.setBounds(160, 108, 96, 19);
		contentPane.add(txtAluno);
		txtAluno.setColumns(10);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	private void preencherTurmas() {
		int letino = 2019;
		// String preencherT = "select * from tb_turmas where anoletivo order by curso";
		String preencherT = "select * from tb_turmas where anolet =2019 order by curso";
		try {

			pst = conexao.prepareStatement(preencherT);
			rs = (ResultSet) pst.executeQuery();
			cboTurmas.removeAllItems();

			while (rs.next()) {

				cboTurmas.addItem(rs.getString("idturma"));

			}
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);

		}

	}

	private void gerarMedia() {
		
		String tSomaPort1 = "select * from tb_teste where idaluno like ? and bi = 1 AND materia = 'PORTUGUES'";
		String tSomaPort2 = "select * from tb_teste where idaluno like ? and bi = 2 AND materia = 'PORTUGUES'";
		String tSomaPort3 = "select * from tb_teste where idaluno like ? AND materia = 'PORTUGUES'";
		String tSomaMat1 = "select * from tb_teste where idaluno like ? and bi = 1 AND materia = 'MATEMATICA'";
		String tSomaMat2 = "select * from tb_teste where idaluno like ? and bi = 2 AND materia = 'MATEMATICA'";
		String tSomaMat3 = "select * from tb_teste where idaluno like ? AND materia = 'MATEMATICA'";
		cboTurmas.removeAllItems();
		try {
			int notaInt, qt, mediaInt;
			String notaString, mediaString;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaPort1);
			pst.setString(1, txtAluno.getText() + "%");

			

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaInt = notaInt + Integer.parseInt(notaString);
				cboTurmas.addItem(rs.getString("nota"));

			}
			mediaInt = notaInt / qt;

			mediaString = Integer.toString(mediaInt);
			txtPort1.setText(mediaString);
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);

		}
		
		try {
			int notaInt, qt, mediaInt;
			String notaString, mediaString;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaPort2);
			pst.setString(1, txtAluno.getText() + "%");

			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaInt = notaInt + Integer.parseInt(notaString);
				cboTurmas.addItem(rs.getString("nota"));

			}
			mediaInt = notaInt / qt;

			mediaString = Integer.toString(mediaInt);
			txtPort2.setText(mediaString);
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);

		}
		try {
			int notaInt, qt, mediaInt;
			String notaString, mediaString;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaPort3);
			pst.setString(1, txtAluno.getText() + "%");

			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaInt = notaInt + Integer.parseInt(notaString);
				cboTurmas.addItem(rs.getString("nota"));

			}
			mediaInt = notaInt / qt;

			mediaString = Integer.toString(mediaInt);
			txtPort3.setText(mediaString);
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);

		}
		try {
			int notaInt, qt, mediaInt;
			String notaString, mediaString;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaMat1);
			pst.setString(1, txtAluno.getText() + "%");

			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaInt = notaInt + Integer.parseInt(notaString);
				cboTurmas.addItem(rs.getString("nota"));

			}
			mediaInt = notaInt / qt;

			mediaString = Integer.toString(mediaInt);
			txtMat1.setText(mediaString);
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);

		}
		try {
			int notaInt, qt, mediaInt;
			String notaString, mediaString;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaMat2);
			pst.setString(1, txtAluno.getText() + "%");

			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaInt = notaInt + Integer.parseInt(notaString);
				cboTurmas.addItem(rs.getString("nota"));

			}
			mediaInt = notaInt / qt;

			mediaString = Integer.toString(mediaInt);
			txtMat2.setText(mediaString);
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);

		}
		try {
			int notaInt, qt, mediaInt;
			String notaString, mediaString;
			qt = 0;
			notaInt = 0;
			mediaInt = 0;
			pst = conexao.prepareStatement(tSomaMat3);
			pst.setString(1, txtAluno.getText() + "%");

			rs = (ResultSet) pst.executeQuery();

			while (rs.next()) {
				qt = qt + 1;
				notaString = rs.getString("nota");
				notaInt = notaInt + Integer.parseInt(notaString);
				cboTurmas.addItem(rs.getString("nota"));

			}
			mediaInt = notaInt / qt;

			mediaString = Integer.toString(mediaInt);
			txtMat3.setText(mediaString);
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);

		}

	}
}
