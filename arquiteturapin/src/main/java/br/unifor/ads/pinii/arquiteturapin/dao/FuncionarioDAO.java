package br.unifor.ads.pinii.arquiteturapin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.unifor.ads.pinii.arquiteturapin.dao.EntityManager;
import br.unifor.ads.pinii.arquiteturapin.entity.Funcionarios;
import br.unifor.ads.pinii.arquiteturapin.entity.Usuarios;
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
		em.execute(
				"insert into funcionarios (nome, cpf, nascimento, estado, cidade, rua, numeroCasa, telefone) "
						+ "values (?, ?, ?, ?, ?, ?, ?, ?)",
				funcionario.getNome(), funcionario.getCpf(), funcionario.getNascimento(), funcionario.getEstado(),
				funcionario.getCidade(), funcionario.getRua(), funcionario.getNumeroCasa(), funcionario.getTelefone());
	}

	public Funcionarios exibir(Funcionarios funcionario, Integer selecionado) throws DAOException {
		Funcionarios exibirFuncionario = null;
		exibirFuncionario = (Funcionarios) em.getSingleResult("select * from usuarios where id = ?", selecionado);
		return exibirFuncionario;
	}

	public void editar(Funcionarios funcionario, Integer valorEditado) throws DAOException {
		em.execute(
				"update funcionarios set nome = ?, cpf = ?, nascimento = ?, estado = ?, cidade = ?,"
						+ " rua = ?, numeroCasa = ?, telefone = ? where id = ?",
				funcionario.getNome(), funcionario.getCpf(), funcionario.getNascimento(), funcionario.getEstado(),
				funcionario.getCidade(), funcionario.getRua(), funcionario.getNumeroCasa(), funcionario.getTelefone(),
				valorEditado);
	}

	public void excluir(Funcionarios funcionario, Integer valorDeletado) throws DAOException {
		em.execute("DELETE FROM funcionario WHERE = ?", valorDeletado);
	}
}
