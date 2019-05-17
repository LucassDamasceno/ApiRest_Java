package com.cardapio.model;

public class Usuario {
	private String nomeCompleto;
	private String nomeDeUsuaio;
	private String email;
	private String senha;
	
	Usuario(){
	}
	
	Usuario(String nomeCompleto, String nomeDeUsuario, String email, String senha){
		this.nomeCompleto = nomeCompleto;
		this.nomeDeUsuario = nomeDeUsuario;
		this.email = email;
		this.senha = senha;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public String getNomeDeUsuario() {
		return nomeDeUsuario;
	}
	public void setNomeDeUsuario(String nomeDeUsuario) {
		this.nomeDeUsuario = nomeDeUsuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
