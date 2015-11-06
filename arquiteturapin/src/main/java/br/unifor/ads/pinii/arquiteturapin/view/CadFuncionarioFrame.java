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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
		
		setTitle("PIN 2 BarHelper - Cadastro de Funcionário");
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
		lblNome.setBounds(173, 14, 46, 14);
		contentPane.add(lblNome);

		JLabel lblLogin = new JLabel("CPF:");
		lblLogin.setBounds(173, 39, 46, 14);
		contentPane.add(lblLogin);

		JLabel lblSenha = new JLabel("Nascimento:");
		lblSenha.setBounds(160, 64, 59, 14);
		contentPane.add(lblSenha);

		txtFieldNome = new JTextField();
		txtFieldNome.setBounds(225, 11, 168, 20);
		contentPane.add(txtFieldNome);
		txtFieldNome.setColumns(10);

		txtFieldCpf = new JTextField();
		txtFieldCpf.setBounds(225, 36, 168, 20);
		contentPane.add(txtFieldCpf);
		txtFieldCpf.setColumns(10);

		txtFieldSalario = new JTextField();
		txtFieldSalario.setBounds(225, 61, 168, 20);
		contentPane.add(txtFieldSalario);
		txtFieldSalario.setColumns(10);

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
		btnSalvar.setBounds(289, 232, 89, 23);
		contentPane.add(btnSalvar);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(225, 89, 168, 20);
		contentPane.add(textField);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(173, 92, 46, 14);
		contentPane.add(lblEstado);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(225, 114, 168, 20);
		contentPane.add(textField_1);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(173, 117, 46, 14);
		contentPane.add(lblCidade);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(225, 142, 168, 20);
		contentPane.add(textField_2);
		
		JLabel lblNmero = new JLabel("Número:");
		lblNmero.setBounds(173, 145, 46, 14);
		contentPane.add(lblNmero);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(225, 167, 168, 20);
		contentPane.add(textField_3);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(173, 170, 46, 14);
		contentPane.add(lblTelefone);

		//setContentPane(contentPane);
	}
}
