package br.unifor.ads.pinii.arquiteturapin.bo;

import org.apache.log4j.Logger;

import br.unifor.ads.pinii.arquiteturapin.dao.MesaDAO;
import br.unifor.ads.pinii.arquiteturapin.dao.SetorDAO;
import br.unifor.ads.pinii.arquiteturapin.entity.Mesas;
import br.unifor.ads.pinii.arquiteturapin.entity.Setores;
import br.unifor.ads.pinii.arquiteturapin.exception.DAOException;

public class MesaBO  {
	
	private Logger logger = Logger.getLogger(UsuarioBO.class);
	private MesaDAO mesaDAO;
	
	public MesaBO() {
		this.mesaDAO = new MesaDAO();
	}
	
	public void salvar(Mesas mesa) throws DAOException{
			this.mesaDAO.salvar(mesa);
	}

}
