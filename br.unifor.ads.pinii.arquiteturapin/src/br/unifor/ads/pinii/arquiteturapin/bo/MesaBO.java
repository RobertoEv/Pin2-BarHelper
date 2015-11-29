package br.unifor.ads.pinii.arquiteturapin.bo;

import java.util.*;
import java.util.logging.Logger;

public class MesaBO {

	private Logger logger = Logger.getLogger(UsuarioBO.class);
	private MesaDAO MesaDAO;

	public MesaBO() {
		this.MesaDAO = new MesaDAO();
	}

	public void salvar(Mesas mesa) throws DAOException {
		this.mesaDAO.salvar(mesa);
	}

}