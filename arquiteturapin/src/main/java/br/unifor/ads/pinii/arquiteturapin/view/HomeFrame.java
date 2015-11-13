/**
 * 
 */
package br.unifor.ads.pinii.arquiteturapin.view;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import br.unifor.ads.pinii.arquiteturapin.seguranca.SegurancaTO;

/**
 * @author adrianopatrick@gmail.com
 * @since 29 de out de 2015
 */
public class HomeFrame extends AbstractFrame {

	private static final long serialVersionUID = -8135996574059094800L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					HomeFrame frame = new HomeFrame();
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
	public HomeFrame() {
		setTitle("PIN2 - BarHelper - Index");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("imagens/logo_unifor.png")));
		setBounds(100, 100, 577, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		messages = new JLabel("");
		messages.setBounds(10, 45, 269, 14);
		contentPane.add(messages);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 534, 28);
		contentPane.add(menuBar);
		
		JMenu mnFunc = new JMenu("Cadastros");
		menuBar.add(mnFunc);
		
		JMenuItem mntmFunc = new JMenuItem("Funcionário");
		mntmFunc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cadFuncionario();
			}
		});
		mnFunc.add(mntmFunc);
		
		JMenu mnFunc_1 = new JMenu("Editar");
		menuBar.add(mnFunc_1);
		
		JMenuItem mntmItem = new JMenuItem("Item2");
		mnFunc_1.add(mntmItem);
		
		JMenu mnSair = new JMenu("Config.");
		menuBar.add(mnSair);
		
		JMenuItem mntmConfiguraes = new JMenuItem("Configurações");
		mnSair.add(mntmConfiguraes);
		
		JSeparator separator = new JSeparator();
		mnSair.add(separator);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SegurancaTO.setUsuario(null);
				login();
			}
		});
		mnSair.add(mntmSair);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SegurancaTO.setUsuario(null);
				login();
			}
		});
		btnNewButton.setIcon(new ImageIcon(HomeFrame.class.getResource("/br/unifor/ads/pinii/arquiteturapin/view/imagens/exit1.png")));
		btnNewButton.setBounds(533, 0, 28, 28);
		contentPane.add(btnNewButton);
		
	}
}
