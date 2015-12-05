package br.unifor.ads.pinii.arquiteturapin.bo;

import org.apache.log4j.Logger;

import br.unifor.ads.pinii.arquiteturapin.dao.SetorDAO;
import br.unifor.ads.pinii.arquiteturapin.entity.Setores;
import br.unifor.ads.pinii.arquiteturapin.exception.DAOException;

public class SetorBO {
	
	private Logger logger = Logger.getLogger(UsuarioBO.class);
	private SetorDAO setorDAO;
	
	public SetorBO() {
		this.setorDAO = new SetorDAO();
	}
	
	public void salvar(Setores setor) throws DAOException{
		this.setorDAO.salvar(setor);
	}
}
