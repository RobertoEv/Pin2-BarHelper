/**
 * 
 */
package br.unifor.ads.pinii.arquiteturapin.view;

import java.awt.Color;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * @author adrianopatrick@gmail.com
 * @since 30 de out de 2015
 */
public class AbstractFrame extends JFrame {

	private static final long serialVersionUID = -1741824681516387046L;

	protected JLabel messages;

	public void msgInfo(String msg) {
		messages.setText(msg);
		messages.setForeground(Color.BLUE);
		repaint();
	}

	public void msgWarn(String msg) {
		messages.setText(msg);
		messages.setForeground(Color.YELLOW);
		repaint();
	}

	public void msgError(String msg) {
		messages.setText(msg);
		messages.setForeground(Color.RED);
		repaint();
	}

	public AbstractFrame() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				if (e.getID() == WindowEvent.WINDOW_CLOSING) {
					int selectedOption = JOptionPane.showConfirmDialog(null,
							"Deseja Sair Realmente?", "Sistema informa:",
							JOptionPane.YES_NO_OPTION);
					if (selectedOption == JOptionPane.YES_OPTION) {
						System.exit(0);
					}
				}
			}
		});
	}

	/** --Navegabilidade-- */

	/**
	 * Tela de Login
	 */
	public AbstractFrame login() {
		LoginFrame frame = new LoginFrame();
		try {
			UIManager.setLookAndFeel(
					"com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return frame;
	}

	/**
	 * Tela Home da aplicação
	 */
	public AbstractFrame home() {
		HomeFrame frame = new HomeFrame();
		try {
			UIManager.setLookAndFeel(
					"com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			dispose();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return frame;
	}

	/**
	 * Tela de Cadastro do usuário
	 */
	public AbstractFrame cadUsuario() {
		CadUsuarioFrame frame = new CadUsuarioFrame();
		try {
			UIManager.setLookAndFeel(
					"com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			dispose();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return frame;
	}
	
	/**
	 * Tela de Cadastro do usuário
	 */
	public AbstractFrame cadFuncionario() {
		CadFuncionarioFrame frame = new CadFuncionarioFrame();
		try {
			UIManager.setLookAndFeel(
					"com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return frame;
	}
	
	/**
	 * Tela de Cadastro do Setor
	 */
	public AbstractFrame cadSetor() {
		CadSetorFrame frame = new CadSetorFrame();
		try {
			UIManager.setLookAndFeel(
					"com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return frame;
	}

}
