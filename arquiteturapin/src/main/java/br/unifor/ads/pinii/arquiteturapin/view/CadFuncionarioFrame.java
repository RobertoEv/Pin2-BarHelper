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

import br.unifor.ads.pinii.arquiteturapin.bo.FuncionarioBO;
import br.unifor.ads.pinii.arquiteturapin.entity.Funcionarios;
import br.unifor.ads.pinii.arquiteturapin.exception.DAOException;

public class CadFuncionarioFrame extends AbstractFrame {

	private static final long serialVersionUID = -8247040029349107183L;
	private JPanel contentPane;
	private FuncionarioBO funcionarioBO;
	private JTextField txtFieldNome;
	private JTextField txtFieldCpf;
	private JTextField txtFieldSalario;

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
	public CadFuncionarioFrame() {
		
		this.funcionarioBO = new FuncionarioBO();
		
		setTitle("Arquitetura PIN2 - Cadastro de Funcionário (Prof. Adriano Patrick Cunha)");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("imagens/logo_unifor.png")));
		setBounds(100, 100, 577, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		messages = new JLabel("");
		messages.setBounds(10, 15, 269, 14);
		contentPane.add(messages);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(173, 79, 46, 14);
		contentPane.add(lblNome);

		JLabel lblLogin = new JLabel("CPF:");
		lblLogin.setBounds(173, 104, 46, 14);
		contentPane.add(lblLogin);

		JLabel lblSenha = new JLabel("Salário:");
		lblSenha.setBounds(173, 129, 46, 14);
		contentPane.add(lblSenha);

		txtFieldNome = new JTextField();
		txtFieldNome.setBounds(225, 76, 168, 20);
		contentPane.add(txtFieldNome);
		txtFieldNome.setColumns(10);

		txtFieldCpf = new JTextField();
		txtFieldCpf.setBounds(225, 101, 168, 20);
		contentPane.add(txtFieldCpf);
		txtFieldCpf.setColumns(10);

		txtFieldSalario = new JTextField();
		txtFieldSalario.setBounds(225, 126, 168, 20);
		contentPane.add(txtFieldSalario);
		txtFieldSalario.setColumns(10);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(190, 168, 89, 23);
		contentPane.add(btnCancelar);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validaCamposObrigatorios()) {
					
					Funcionarios funcionario = new Funcionarios();
					funcionario.setNome(txtFieldNome.getText());
					funcionario.setCpf(txtFieldCpf.getText());
//					funcionario.setSalario(Double.parseDouble(txtFieldSalario.getText().replace(",", ".")));
					
					try {
						funcionarioBO.salvar(funcionario);
						home().msgInfo("Funcionário cadastrado com sucesso!");
					} catch (DAOException e1) {
						msgError(e1.getMessage());
					}
				}
			}

			private boolean validaCamposObrigatorios() {
				if (txtFieldNome.getText().trim().isEmpty() || txtFieldCpf.getText().trim().isEmpty()
						|| txtFieldSalario.getText().trim().isEmpty()) {
					msgError("Campos Obrigatórios");
					return false;
				}
				return true;
			}
		});
		btnSalvar.setBounds(289, 168, 89, 23);
		contentPane.add(btnSalvar);

		setContentPane(contentPane);
	}

}
