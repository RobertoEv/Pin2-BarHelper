package br.unifor.ads.pinii.arquiteturapin.view;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.unifor.ads.pinii.arquiteturapin.bo.SetorBO;
import br.unifor.ads.pinii.arquiteturapin.entity.Funcionarios;
import br.unifor.ads.pinii.arquiteturapin.entity.Setores;
import br.unifor.ads.pinii.arquiteturapin.exception.DAOException;
import javax.swing.JTable;

public class CadSetorFrame extends AbstractFrame {

	private JPanel contentPane;
	private SetorBO setorBO;
	private JTextField textFieldNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadFuncionarioFrame frame = new CadFuncionarioFrame();
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
	public CadSetorFrame() {
		
		this.setorBO = new SetorBO();
		
		setTitle("PIN 2 BarHelper - Cadastro de Setores");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("imagens/logo_unifor.png")));
		setBounds(100, 100, 577, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		messages = new JLabel("");
		messages.setBounds(10, 15, 269, 14);
		contentPane.add(messages);


		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(190, 232, 89, 23);
		contentPane.add(btnCancelar);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Setores setor = new Setores();
				setor.setNome(textFieldNome.getText());}});
		
		btnSalvar.setBounds(289, 232, 89, 23);
		contentPane.add(btnSalvar);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(218, 120, 175, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblNomeSetor = new JLabel("Nome Setor:");
		lblNomeSetor.setBounds(150, 123, 76, 14);
		contentPane.add(lblNomeSetor);
		
		
		
	}
}