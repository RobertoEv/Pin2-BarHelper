package br.unifor.ads.pinii.arquiteturapin.MesaDAO;


	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.*;
	import br.unifor.ads.pinii.arquiteturapin.entity.Mesas;
	import br.unifor.ads.pinii.arquiteturapin.exception.DAOException;
	
	public class MesaDAO {
		
		private EntityManager em;
		
		public MesaDAO() {
			this.em = new EntityManager() {
				
			
				public Object trataResultSet(ResultSet rs) throws SQLException {
					Mesas mesa = new Mesas(null, null);
					mesa.setId(rs.getString("id"));
					mesa.setNumeroMesa(rs.getString("numero"));
					
					return null;
				}
			};
		}
		
		public void salvar(Mesas mesa) throws DAOException{
			em.execute("insert into mesa (numero, id) values (?, ?)",
					mesa.getNumeroMesa(), mesa.getId() );
		}
	
	}


