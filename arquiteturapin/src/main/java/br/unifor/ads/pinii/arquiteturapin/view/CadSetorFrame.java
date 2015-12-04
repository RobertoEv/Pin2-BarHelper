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
import br.unifor.ads.pinii.arquiteturapin.entity.Mesas;
import br.unifor.ads.pinii.arquiteturapin.entity.Setores;
import br.unifor.ads.pinii.arquiteturapin.exception.DAOException;
import javax.swing.JTable;
import javax.swing.JComboBox;

public class CadSetorFrame extends AbstractFrame {

	private JPanel contentPane;
	private SetorBO setorBO;
	private JTextField textFieldNome;
	private JTextField textFieldMesa;

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
				if (validaCamposObrigatorios()) {
					Setores setor = new Setores();
					Mesas mesa = new Mesas();
					setor.setNome(textFieldNome.getText());
					setor.setNome(textFieldNome.getText());
					
					try {
						setorBO.salvar(setor);
						home().msgInfo("Setor cadastrado com sucesso!");
					} catch (DAOException e1) {
						msgError(e1.getMessage());
					}
				}
			}

			private boolean validaCamposObrigatorios() {
				if (textFieldNome.getText().trim().isEmpty()) {
					msgError("Campos Obrigatórios");
					return false;
				}
				return true;
			}
			});
		
		btnSalvar.setBounds(289, 232, 89, 23);
		contentPane.add(btnSalvar);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(218, 120, 175, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblNomeSetor = new JLabel("Nome Setor:");
		lblNomeSetor.setBounds(113, 123, 76, 14);
		contentPane.add(lblNomeSetor);
		
		JLabel lblQtdDeMesas = new JLabel("Qtd de Mesas:");
		lblQtdDeMesas.setBounds(113, 148, 96, 14);
		contentPane.add(lblQtdDeMesas);
		
		textFieldMesa = new JTextField();
		textFieldMesa.setBounds(218, 145, 175, 20);
		contentPane.add(textFieldMesa);
		textFieldMesa.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(217, 172, 176, 22);
		contentPane.add(comboBox);
		
		JLabel lblFuncionario = new JLabel("Funcionario:");
		lblFuncionario.setBounds(113, 175, 81, 16);
		contentPane.add(lblFuncionario);
		
		
		
	}
}