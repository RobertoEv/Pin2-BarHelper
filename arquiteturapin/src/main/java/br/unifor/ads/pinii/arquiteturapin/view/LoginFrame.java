/**
 * 
 */
package br.unifor.ads.pinii.arquiteturapin.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import br.unifor.ads.pinii.arquiteturapin.bo.UsuarioBO;
import br.unifor.ads.pinii.arquiteturapin.entity.Usuarios;
import br.unifor.ads.pinii.arquiteturapin.exception.DAOException;
import br.unifor.ads.pinii.arquiteturapin.seguranca.Criptografia;
import br.unifor.ads.pinii.arquiteturapin.seguranca.SegurancaTO;

/**
 * @author adrianopatrick@gmail.com
 * @since 29 de out de 2015
 */
public class LoginFrame extends AbstractFrame {

	private static final long serialVersionUID = 7751746052695191088L;
	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField passwordField;
	private JLabel lblNewLabel;
	private JButton btnCadastrar;
	private UsuarioBO usuarioBO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		
		this.usuarioBO = new UsuarioBO();
		
		setTitle("PIN2 - BarHelper - Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("imagens/logo_unifor.png")));
		setBounds(100, 100, 577, 349);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		messages = new JLabel("");
		messages.setBounds(10, 15, 269, 14);
		contentPane.add(messages);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(398, 101, 153, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(342, 104, 46, 14);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(342, 135, 46, 14);
		contentPane.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(398, 132, 153, 20);
		contentPane.add(passwordField);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validaCamposObrigatorios()){
					Usuarios usuario = new Usuarios();
					usuario.setLogin(txtLogin.getText());
					usuario.setSenha(Criptografia.encripta(String.valueOf(passwordField.getPassword())));
					try {
						if(usuarioBO.loggar(usuario)){
							home().msgInfo("Bem vindo "+SegurancaTO.getUsuario().getNome()+"!");
						}
					} catch (DAOException e1) {
						msgError(e1.getMessage());
					}
				}
			}
		});
		btnEntrar.setBounds(352, 169, 76, 23);
		contentPane.add(btnEntrar);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("imagens/unifor.gif")));
		lblNewLabel.setBounds(10, 29, 336, 257);
		contentPane.add(lblNewLabel);
		
		btnCadastrar = new JButton("Cadastrar-se");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadUsuario();
			}
		});
		btnCadastrar.setBounds(438, 169, 101, 23);
		contentPane.add(btnCadastrar);
	}
	
	private boolean validaCamposObrigatorios() {
		if(txtLogin.getText().trim().isEmpty() || passwordField.getPassword().toString().trim().isEmpty()){
			msgError("Campos Obrigatórios não preenchidos.");
			return false;
		}	
		return true;
	}
}
