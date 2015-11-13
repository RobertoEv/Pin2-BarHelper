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
	private JTextField txtFieldNascimento;
	private JTextField txtFieldCidade;
	private JTextField txtFieldRua;
	private JTextField txtFieldNumeroCasa;
	private JTextField txtFieldTelefone;
	private JTextField txtFieldEstado;

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
		lblNome.setBounds(142, 12, 46, 14);
		contentPane.add(lblNome);

		JLabel lblLogin = new JLabel("CPF:");
		lblLogin.setBounds(142, 39, 46, 14);
		contentPane.add(lblLogin);

		JLabel lblSenha = new JLabel("Nascimento:");
		lblSenha.setBounds(140, 65, 71, 16);
		contentPane.add(lblSenha);

		txtFieldNome = new JTextField();
		txtFieldNome.setBounds(225, 11, 168, 20);
		contentPane.add(txtFieldNome);
		txtFieldNome.setColumns(10);

		txtFieldCpf = new JTextField();
		txtFieldCpf.setBounds(225, 36, 168, 20);
		contentPane.add(txtFieldCpf);
		txtFieldCpf.setColumns(10);

		txtFieldNascimento = new JTextField();
		txtFieldNascimento.setBounds(225, 61, 168, 20);
		contentPane.add(txtFieldNascimento);
		txtFieldNascimento.setColumns(10);
		

		txtFieldEstado = new JTextField();
		txtFieldEstado.setColumns(10);
		txtFieldEstado.setBounds(225, 89, 168, 20);
		contentPane.add(txtFieldEstado);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(142, 92, 46, 14);
		contentPane.add(lblEstado);
		
		txtFieldCidade = new JTextField();
		txtFieldCidade.setColumns(10);
		txtFieldCidade.setBounds(225, 114, 168, 20);
		contentPane.add(txtFieldCidade);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(142, 117, 46, 14);
		contentPane.add(lblCidade);
		
		txtFieldRua = new JTextField();
		txtFieldRua.setColumns(10);
		txtFieldRua.setBounds(225, 142, 168, 20);
		contentPane.add(txtFieldRua);
		
		JLabel lblNmero = new JLabel("Rua:");
		lblNmero.setBounds(142, 145, 46, 14);
		contentPane.add(lblNmero);
		
		txtFieldNumeroCasa = new JTextField();
		txtFieldNumeroCasa.setColumns(10);
		txtFieldNumeroCasa.setBounds(225, 167, 168, 20);
		contentPane.add(txtFieldNumeroCasa);
		
		JLabel lblTelefone = new JLabel("Numero:");
		lblTelefone.setBounds(142, 170, 50, 16);
		contentPane.add(lblTelefone);
		
		JLabel label = new JLabel("Telefone:");
		label.setBounds(142, 197, 55, 16);
		contentPane.add(label);
		
		txtFieldTelefone = new JTextField();
		txtFieldTelefone.setColumns(10);
		txtFieldTelefone.setBounds(225, 195, 168, 20);
		contentPane.add(txtFieldTelefone);


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
					funcionario.setNascimento(txtFieldNascimento.getText());					
					funcionario.setEstado(txtFieldEstado.getText());
					funcionario.setCidade(txtFieldCidade.getText());
					funcionario.setRua(txtFieldRua.getText());
					funcionario.setNumeroCasa(txtFieldNumeroCasa.getText());
					funcionario.setTelefone(txtFieldTelefone.getText());
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
						|| txtFieldNascimento.getText().trim().isEmpty()
						|| txtFieldEstado.getText().trim().isEmpty()
						|| txtFieldCidade.getText().trim().isEmpty()
						|| txtFieldRua.getText().trim().isEmpty()
						|| txtFieldNumeroCasa.getText().trim().isEmpty()
						|| txtFieldTelefone.getText().trim().isEmpty()) {
					msgError("Campos Obrigatórios");
					return false;
				}
				return true;
			}
		});
		btnSalvar.setBounds(289, 232, 89, 23);
		contentPane.add(btnSalvar);
	}
}
