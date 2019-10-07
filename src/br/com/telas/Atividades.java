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

public class Atividades extends JDialog {
	private JTextField txtAtiv;
	private JTextField txtTurmasAtiv;
	private JTextField txtProfAtiv;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable tblAtiv;
	private JTable tblTurmasAtiv;
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
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JComboBox cboBi;
	private JDateChooser txtData;
	public Atividades() {
		setModal(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Atividades.class.getResource("/br/com/icons/logo_colnovagalax-32.png")));
		setTitle("Atividades");
		setBounds(100, 100, 678, 700);
		getContentPane().setLayout(null);
		
		txtAtiv = new JTextField();
		txtAtiv.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pesquisarAtividades();
				limparPesquisaTurm();
			}
		});
		txtAtiv.setColumns(10);
		txtAtiv.setBounds(99, 21, 249, 33);
		getContentPane().add(txtAtiv);
		
		JLabel label_2 = new JLabel("Atividade:");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		label_2.setBounds(10, 23, 79, 31);
		getContentPane().add(label_2);
		
		JLabel lblNewLabel_1 = new JLabel("Turmas:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(20, 358, 79, 33);
		getContentPane().add(lblNewLabel_1);
		
		txtTurmasAtiv = new JTextField();
		
		txtTurmasAtiv.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		txtTurmasAtiv.setColumns(10);
		txtTurmasAtiv.setBounds(99, 359, 202, 33);
		getContentPane().add(txtTurmasAtiv);
		
		txtProfAtiv = new JTextField();
		txtProfAtiv.setText("Teste");
		txtProfAtiv.setEditable(false);
		txtProfAtiv.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		txtProfAtiv.setColumns(10);
		txtProfAtiv.setBounds(447, 22, 202, 33);
		getContentPane().add(txtProfAtiv);
		
		JLabel lblProfessor = new JLabel("Professor:");
		lblProfessor.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfessor.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblProfessor.setBounds(358, 21, 79, 33);
		getContentPane().add(lblProfessor);
		
		JButton btnAddAtiv = new JButton("");
		btnAddAtiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarAtiv();
			}
		});
		btnAddAtiv.setIcon(new ImageIcon(Atividades.class.getResource("/br/com/icons/botao_atividade.png")));
		btnAddAtiv.setBounds(447, 347, 106, 98);
		getContentPane().add(btnAddAtiv);
		
		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletarAtiv();
			}
		});
		btnLimpar.setIcon(new ImageIcon(Atividades.class.getResource("/br/com/icons/delete.png")));
		btnLimpar.setBounds(570, 93, 79, 68);
		getContentPane().add(btnLimpar);
		
		JLabel lblBimestre = new JLabel("Bimestre:*");
		lblBimestre.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblBimestre.setHorizontalAlignment(SwingConstants.CENTER);
		lblBimestre.setBounds(10, 72, 79, 20);
		getContentPane().add(lblBimestre);
		
		cboBi = new JComboBox();
		cboBi.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		cboBi.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4"}));
		cboBi.setBounds(99, 71, 86, 22);
		getContentPane().add(cboBi);
		
		JButton btnAlterarAtiv = new JButton("");
		btnAlterarAtiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarAtiv();
			}
		});
		btnAlterarAtiv.setIcon(new ImageIcon(Atividades.class.getResource("/br/com/icons/update.png")));
		btnAlterarAtiv.setBounds(482, 93, 79, 68);
		getContentPane().add(btnAlterarAtiv);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(20, 171, 625, 166);
		getContentPane().add(scrollPane_1);
		
		tblAtiv = new JTable();
		tblAtiv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setarCampos();
			}
		});
		scrollPane_1.setColumnHeaderView(tblAtiv);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(20, 471, 625, 166);
		getContentPane().add(scrollPane);
		
		tblTurmasAtiv = new JTable();
		tblTurmasAtiv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setarCamposTurmas();
			}
		});
		scrollPane.setColumnHeaderView(tblTurmasAtiv);
		
		JLabel lblId = new JLabel("N\u00BA da Turma:");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblId.setBounds(10, 401, 149, 33);
		getContentPane().add(lblId);
		
		txtIdTurma = new JTextField();
		txtIdTurma.setEditable(false);
		txtIdTurma.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		txtIdTurma.setColumns(10);
		txtIdTurma.setBounds(156, 402, 95, 33);
		getContentPane().add(txtIdTurma);
		
		JLabel lblNewLabel = new JLabel("**Sempre clique duas vezes na turma/atividade que deseja alterar\"");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblNewLabel.setBounds(31, 448, 473, 13);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNDaAtividade = new JLabel("N\u00BA da Atividade:");
		lblNDaAtividade.setHorizontalAlignment(SwingConstants.CENTER);
		lblNDaAtividade.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblNDaAtividade.setBounds(195, 65, 153, 33);
		getContentPane().add(lblNDaAtividade);
		
		txtIdAtiv = new JTextField();
		txtIdAtiv.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		txtIdAtiv.setEditable(false);
		txtIdAtiv.setColumns(10);
		txtIdAtiv.setBounds(358, 66, 95, 33);
		getContentPane().add(txtIdAtiv);
		
		txtData = new JDateChooser();
		txtData.setBounds(156, 117, 170, 44);
		getContentPane().add(txtData);
		
		JLabel lblNewLabel_2 = new JLabel("Data da Atividade:");
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 121, 153, 23);
		getContentPane().add(lblNewLabel_2);
		
		JButton btnPesquisarT = new JButton("PESQUISAR");
		btnPesquisarT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarTurmas();
				
				limparPesquisaAtiv();
			}
		});
		btnPesquisarT.setBounds(325, 358, 112, 30);
		getContentPane().add(btnPesquisarT);
		
		JButton btnLimpar1 = new JButton("");
		btnLimpar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar1.setIcon(new ImageIcon(Atividades.class.getResource("/br/com/icons/icons8-limpar-formata\u00E7\u00E3o-48.png")));
		btnLimpar1.setBounds(387, 109, 50, 52);
		getContentPane().add(btnLimpar1);
		conexao = ModuloConexao.conector();
	}
	
	
	private void pesquisarAtividades() {
		String consultar = "select * from tb_ativ where ativ like ?";
		try {
			pst = conexao.prepareStatement(consultar);
			
			pst.setString(1,  txtTurmasAtiv.getText() + "%");
			
			rs = pst.executeQuery();
		
			tblAtiv.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);
			
		}
	}
	private void setarCampos() {
		int setar = tblAtiv.getSelectedRow();
		txtIdAtiv.setText(tblAtiv.getModel().getValueAt(setar, 0).toString());
		txtAtiv.setText(tblAtiv.getModel().getValueAt(setar, 1).toString());
		txtProfAtiv.setText(tblAtiv.getModel().getValueAt(setar, 2).toString());
		cboBi.setSelectedItem(tblAtiv.getModel().getValueAt(setar, 3).toString());
		//txtIdTurma.setText(tblAtiv.getModel().getValueAt(setar, 4).toString());
	//	txtData.getDateEditor(tblAtiv.getModel().getValueAt(setar, 5).toString());
		

	}
	private void setarCamposTurmas() {
		int setar = tblTurmasAtiv.getSelectedRow();
		txtIdTurma.setText(tblTurmasAtiv.getModel().getValueAt(setar, 0).toString());
				

	}
	private void pesquisarTurmas() {
		String consultar = "select * from tb_turmas where curso like ?";
		try {
			pst = conexao.prepareStatement(consultar);
			
			pst.setString(1,  txtAtiv.getText() + "%");
			
			rs = pst.executeQuery();
		
			tblTurmasAtiv.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);
			
		}
	}
	private void limparNumTurma() {
		txtIdTurma.setText(null);

	}
	private void limparPesquisaAtiv() {
		txtAtiv.setText(null);

	}
	private void limparPesquisaTurm() {
		txtTurmasAtiv.setText(null);

	}
	private void limpar() {
		txtAtiv.setText(null);
		txtProfAtiv.setText(null);
		cboBi.setSelectedItem("");
		txtIdAtiv.setText(null);
		txtTurmasAtiv.setText(null);
		txtIdTurma.setText(null);
	}
	private void adicionarAtiv() {
		if(txtAtiv.getText().isEmpty() || txtProfAtiv.getText().isEmpty() 
				 || ((String) cboBi.getSelectedItem()).isEmpty() 
				|| txtIdTurma.getText().isEmpty()){
			//confirmar se essa ultima condição funciona
			JOptionPane.showMessageDialog(null, "Faltou informações sobre a atividade/turma.");
		
			
		}else {
			String adicionar = "insert into tb_ativ(ativ,prof,bi,idtur) values (?,?,?,?)";
			try {
				pst = conexao.prepareStatement(adicionar);
				pst.setString(1, txtAtiv.getText());
				pst.setString(2, txtProfAtiv.getText());
				pst.setString(3, cboBi.getSelectedItem().toString());
				pst.setString(4, txtIdTurma.getText());
				
				
				// quando é feito algo no banco de dados, é gerado um valor binario(0 ou 1) para definir se a conexão estava OK, no exemplo a baixo
				// int adicionado vai ser 1 se a conexao estiver OK e 0 se não!
				int adicionado = pst.executeUpdate();
				
				
				
				
				int on= 1;
				if(on == 1) {
					
				};
				if(adicionado ==1) {
					JOptionPane.showMessageDialog(null, "Atividade Cadastrada!");
					limpar();
				}else {
					JOptionPane.showMessageDialog(null, "Atividade não cadastrada, por favor, confirme as informações");
				}
				
			} catch (Exception e) {
				System.out.println(e);
				JOptionPane.showMessageDialog(null, e);
			}
			
		}
	
}
	private void alterarAtiv() {	
		//validação dos campos obrigatórios
		if(txtAtiv.getText().isEmpty() || txtProfAtiv.getText().isEmpty() 
				 || ((String) cboBi.getSelectedItem()).isEmpty() 
				|| txtIdTurma.getText().isEmpty()){
			//confirmar se essa ultima condição funciona
            JOptionPane.showMessageDialog(null, "Faltou informações sobre a atividade/turma.");
		
			
		}else {
			
			String update = "update tb_ativ set ativ=?,prof=?,bi=?,idtur=? where idativ=?";
			try {
				pst=conexao.prepareStatement(update);
				
		
				
				pst.setString(1, txtAtiv.getText());
				pst.setString(2, txtProfAtiv.getText());
				pst.setString(3, cboBi.getSelectedItem().toString());
				pst.setString(4, txtIdTurma.getText());
				pst.setString(5, txtIdAtiv.getText());
				
				
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
	}
	private void deletarAtiv() {
		//a linha abaixo cria uma caixa de confirmação
		
				int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão deste registro?","ATENÇÃO", JOptionPane.YES_NO_OPTION);
				if (confirma == JOptionPane.YES_OPTION) {
					String delete= "delete from tb_ativ where idativ=?";
					try {
						pst=conexao.prepareStatement(delete);
						pst.setString(1,txtIdAtiv.getText());
						int removido = pst.executeUpdate();
						if (removido == 1) {
							limpar();
							JOptionPane.showMessageDialog(null, "Atividade Removida");
					}
						
					} catch (Exception e) {
							System.out.println(e);
					}
				
				}

	}
}
