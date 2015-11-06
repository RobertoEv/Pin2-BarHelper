/**
 * 
 */
package br.unifor.ads.pinii.arquiteturapin.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import br.unifor.ads.pinii.arquiteturapin.bo.UsuarioBO;
import br.unifor.ads.pinii.arquiteturapin.entity.Usuarios;
import br.unifor.ads.pinii.arquiteturapin.exception.DAOException;
import br.unifor.ads.pinii.arquiteturapin.seguranca.Criptografia;

/**
 * @author adrianopatrick@gmail.com
 * @since 29 de out de 2015
 */
public class CadUsuarioFrame extends AbstractFrame {

	private static final long serialVersionUID = 7193161330465759812L;
	private JPanel contentPane;
	private JTextField txtFieldLogin;
	private JPasswordField passwordField;
	private UsuarioBO usuarioBO;
	private JTextField txtFieldNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					CadUsuarioFrame frame = new CadUsuarioFrame();
					frame.setLocationRelativeTo(null);
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
	public CadUsuarioFrame() {

		usuarioBO = new UsuarioBO();

		setTitle("PIN 2 - BarHelper - Cadastro de Usuário");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("imagens/logo_unifor.png")));
		setBounds(100, 100, 577, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		messages = new JLabel("");
		messages.setBounds(10, 45, 269, 14);
		contentPane.add(messages);

		JLabel lblCadastroDoUsurio = new JLabel("Cadastro do Usuário > novo usuário");
		lblCadastroDoUsurio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCadastroDoUsurio.setBounds(10, 11, 244, 14);
		contentPane.add(lblCadastroDoUsurio);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 35, 541, 2);
		contentPane.add(separator);

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(173, 104, 46, 14);
		contentPane.add(lblLogin);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(173, 129, 46, 14);
		contentPane.add(lblSenha);

		txtFieldLogin = new JTextField();
		txtFieldLogin.setUI(new HintTextField("Insira seu email. ex@gmail.com", true, Color.LIGHT_GRAY));
		txtFieldLogin.setBounds(217, 101, 168, 20);
		contentPane.add(txtFieldLogin);
		txtFieldLogin.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(217, 126, 168, 20);
		contentPane.add(passwordField);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		btnVoltar.setBounds(190, 168, 89, 23);
		contentPane.add(btnVoltar);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validaCamposObrigatorios()) {
					Usuarios usuario = new Usuarios();
					usuario.setNome(txtFieldNome.getText());
					usuario.setLogin(txtFieldLogin.getText());
					usuario.setSenha(Criptografia.encripta(String.valueOf(passwordField.getPassword())));
					try {
						usuarioBO.salvar(usuario);
						login().msgInfo("Usuário cadastrado com sucesso!");
					} catch (DAOException e1) {
						msgError(e1.getMessage());
					}
				}
			}
		});
		btnSalvar.setBounds(289, 168, 89, 23);
		contentPane.add(btnSalvar);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(173, 79, 46, 14);
		contentPane.add(lblNome);

		txtFieldNome = new JTextField();
		txtFieldNome.setBounds(217, 76, 168, 20);
		contentPane.add(txtFieldNome);
		txtFieldNome.setColumns(10);

	}

	private boolean validaCamposObrigatorios() {
		if (txtFieldNome.getText().trim().isEmpty() || txtFieldLogin.getText().trim().isEmpty()
				|| passwordField.getPassword().toString().trim().isEmpty()) {
			msgError("Campos Obrigatórios não preenchidos.");
			return false;
		}
		return true;
	}
}
