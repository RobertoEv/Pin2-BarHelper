package br.unifor.ads.pinii.arquiteturapin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.unifor.ads.pinii.arquiteturapin.dao.EntityManager;
import br.unifor.ads.pinii.arquiteturapin.entity.Mesas;
import br.unifor.ads.pinii.arquiteturapin.exception.DAOException;

public class MesaDAO extends SetorDAO{
	
	private EntityManager em;
	
	public MesaDAO() {
		this.em = new EntityManager() {
			
			@Override
			public Object trataResultSet(ResultSet rs) throws SQLException {
				Mesas mesa = new Mesas();
				mesa.setId(rs.getInt("id"));
				mesa.setNome(rs.getString("nome"));
				return mesa;
			}
		};
	}
	
	public void salvar(Mesas mesa) throws DAOException {
		em.execute("insert into mesas () values ();");
	}

}