package view;

import java.awt.*;
import java.util.*;

import javax.swing.*;

import br.unifor.ads.pinii.arquiteturapin.bo.MesaBO;
import br.unifor.ads.pinii.arquiteturapin.entity.Mesas;
import br.unifor.ads.pinii.arquiteturapin.exception.DAOException;

public class CadMesaFrame extends AbstractList {

	private static final long serialVersionUID = -8247040029349107183L;
	private JPanel contentPane;
	private MesaBO mesaBO;
	private JTextField txtFieldNumeroMesa;
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadMesaFrame frame = new CadMesaFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	protected void setVisible(boolean b) {
		// TODO Auto-generated method stub

	}

	/**
	 * Create the frame.
	 */
	public CadMesaFrame() {

		this.MesaBO = new MesaBO();

		setTitle("Arquitetura PIN2 - Cadastro de Mesas (Prof. Adriano Patrick Cunha)");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				LoginFrame.class.getResource("imagens/logo_unifor.png")));
		setBounds(100, 100, 577, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		messages = new JLabel("");
		messages.setBounds(10, 15, 269, 14);
		contentPane.add(messages);

		JLabel lblNome = new JLabel("Numero da Mesa:");
		lblNome.setBounds(173, 79, 46, 14);
		contentPane.add(lblNome);

		JLabel lblLogin = new JLabel("ID:");
		lblLogin.setBounds(173, 104, 46, 14);
		contentPane.add(lblLogin);

		txtFieldNumeroMesa = new JTextField();
		txtFieldNumeroMesa.setBounds(225, 76, 168, 20);
		contentPane.add(txtFieldNumeroMesa);
		txtFieldNumeroMesa.setColumns(10);

		txtFieldId = new JTextField();
		txtFieldId.setBounds(225, 101, 168, 20);
		contentPane.add(txtFieldId);
		txtFieldId.setColumns(10);

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

					Mesas mesa = new Mesas();
					mesa.setNumeroMesa(txtFieldNumeroMesa.getText());
					mesa.setId(txtFieldId.getText());

					try {
						MesaBO.salvar(mesa);
						home().msgInfo("Mesa cadastrada com sucesso!");
					} catch (DAOException e1) {
						msgError(e1.getMessage());
					}
				}
			}

			private boolean validaCamposObrigatorios() {
				if (txtFieldNumeroMesa.getText().trim().isEmpty()
						|| txtFieldId.getText().trim().isEmpty()) {
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

	public Object get(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
