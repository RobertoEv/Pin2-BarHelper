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
		menuBar.setBounds(0, 0, 561, 28);
		contentPane.add(menuBar);
		
		JMenu mnFunc = new JMenu("Funcionario");
		menuBar.add(mnFunc);
		
		JMenuItem mntmFunc = new JMenuItem("Adicionar");
		mntmFunc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cadFuncionario();
			}
		
		});
		mnFunc.add(mntmFunc);
		
		JMenuItem mntmEditar = new JMenuItem("Editar");
		mnFunc.add(mntmEditar);
		
		JMenuItem mntmRemover = new JMenuItem("Remover");
		mnFunc.add(mntmRemover);
		
		JMenu mnSetor = new JMenu("Setor");
		menuBar.add(mnSetor);
		
		JMenuItem mntmSetor = new JMenuItem("Adicionar");
		mntmSetor.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cadSetor();				
			}
		});
		mnSetor.add(mntmSetor);
		
		JMenuItem mntmEditar_1 = new JMenuItem("Editar");
		mnSetor.add(mntmEditar_1);
		
		JMenuItem mntmRemover_1 = new JMenuItem("Remover");
		mnSetor.add(mntmRemover_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SegurancaTO.setUsuario(null);
				login();
			}
		});
//		btnNewButton.setIcon(new ImageIcon(HomeFrame.class.getResource("/br/unifor/ads/pinii/arquiteturapin/view/imagens/exit1.png")));
//		btnNewButton.setBounds(533, 0, 28, 28);
//		contentPane.add(btnNewButton);
		
	}
}
