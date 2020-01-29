package br.com.telas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.SystemColor;

public class Sobre extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Sobre dialog = new Sobre();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Sobre() {
		setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		setTitle("Sobre");
		setBounds(100, 100, 700, 463);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.controlHighlight);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextPane txtpnAWeducare = new JTextPane();
		txtpnAWeducare.setEditable(false);
		txtpnAWeducare.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtpnAWeducare.setText("A Weducare \u00E9 uma startup desenvolvida em 2019 por tr\u00EAs alunos do Senac, com o foco de desenvolver softwares direcionados a gest\u00E3o escolar, com o objetivo de tornar o processo manual em um processo tecnol\u00F3gico.\r\n\r\nCom apenas alguns clicks voc\u00EA pode cadastrar usu\u00E1rios, alunos, docentes, tornando a gest\u00E3o mais organizada, aumentando a produtividade e utilizando um processo hier\u00E1rquico de uso, tornamos o sistema mais intuitivo para consulta de m\u00E9dias, atividades, turmas e usu\u00E1rios  cadastrados e geramos relat\u00F3rios manipulando estes dados. \r\n\r\nE n\u00E3o esque\u00E7a n\u00F3s podemos aprimorar este sistema de acordo com a necessidade da sua empresa, ent\u00E3o n\u00E3o perca tempo, entre em contato conosco.");
		txtpnAWeducare.setBackground(SystemColor.controlHighlight);
		txtpnAWeducare.setBounds(10, 10, 666, 365);
		contentPanel.add(txtpnAWeducare);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.controlHighlight);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setFont(new Font("Verdana", Font.PLAIN, 18));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
