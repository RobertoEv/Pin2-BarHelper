package br.unifor.ads.pinii.arquiteturapin.entity;

import java.io.Serializable;

public class Usuarios implements Serializable{

	private static final long serialVersionUID = 8763978023955561533L;
	
	private Integer id;
	private String nome;
	private String login;
	private String senha;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	 
	public String getSenha() {
		return senha;
	}
	 
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
