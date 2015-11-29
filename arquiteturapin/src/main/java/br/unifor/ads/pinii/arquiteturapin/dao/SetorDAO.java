package br.unifor.ads.pinii.arquiteturapin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.unifor.ads.pinii.arquiteturapin.dao.EntityManager;
import br.unifor.ads.pinii.arquiteturapin.entity.Setores;
import br.unifor.ads.pinii.arquiteturapin.exception.DAOException;

public class SetorDAO {
	
	private EntityManager em;
	
	public SetorDAO() {
		this.em = new EntityManager() {
			
			@Override
			public Object trataResultSet(ResultSet rs) throws SQLException {
				Setores setor = new Setores();
				setor.setId(rs.getInt("id"));
				setor.setNome(rs.getString("nome"));
				return setor;
			}
		};
	}
	
	public void salvar(Setores setor) throws DAOException {
		em.execute("insert into setores (nome) values (?)", setor.getNome());
	}

}