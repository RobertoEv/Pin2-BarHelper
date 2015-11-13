package br.unifor.ads.pinii.arquiteturapin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.unifor.ads.pinii.arquiteturapin.dao.EntityManager;
import br.unifor.ads.pinii.arquiteturapin.entity.Funcionarios;
import br.unifor.ads.pinii.arquiteturapin.exception.DAOException;

public class FuncionarioDAO {
	
	private EntityManager em;
	
	public FuncionarioDAO() {
		this.em = new EntityManager() {
			
			@Override
			public Object trataResultSet(ResultSet rs) throws SQLException {
				Funcionarios funcionario = new Funcionarios();
				funcionario.setId(rs.getInt("id"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setCpf(rs.getString("cpf"));
				funcionario.setNascimento(rs.getString("nascimento"));
				funcionario.setEstado(rs.getString("estado"));
				funcionario.setCidade(rs.getString("cidade"));
				funcionario.setRua(rs.getString("rua"));
				funcionario.setNumeroCasa(rs.getString("numeroCasa"));
				funcionario.setTelefone(rs.getString("telefone"));
				return funcionario;
			}
		};
	}
	
	public void salvar(Funcionarios funcionario) throws DAOException {
		em.execute("insert into funcionarios (nome, cpf, nascimento, estado, cidade, rua, numeroCasa, telefone) values (?, ?, ?, ?, ?, ?, ?, ?)", 
				funcionario.getNome(), funcionario.getCpf(), funcionario.getNascimento(), funcionario.getEstado(), funcionario.getCidade(), funcionario.getRua(), 
				funcionario.getNumeroCasa(), funcionario.getTelefone());
	}

}
