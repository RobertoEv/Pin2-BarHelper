package br.unifor.ads.pinii.arquiteturapin.bo;

import org.apache.log4j.Logger;

import br.unifor.ads.pinii.arquiteturapin.dao.FuncionarioDAO;
import br.unifor.ads.pinii.arquiteturapin.entity.Funcionarios;
import br.unifor.ads.pinii.arquiteturapin.exception.DAOException;

public class FuncionarioBO {
	
	private Logger logger = Logger.getLogger(UsuarioBO.class);
	private FuncionarioDAO funcionarioDAO;
	
	public FuncionarioBO() {
		this.funcionarioDAO = new FuncionarioDAO();
	}
	
	public void salvar(Funcionarios funcionario) throws DAOException{
		this.funcionarioDAO.salvar(funcionario);
	}
	
	public void editar(Funcionarios funcionario) throws DAOException{
		this.funcionarioDAO.editar(funcionario);
	}
	
	public void excluir(Funcionarios funcionario) throws DAOException{
		this.funcionarioDAO.excluir(funcionario);
	}
}
