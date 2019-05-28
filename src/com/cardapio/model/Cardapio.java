package com.cardapio.model;

public class Cardapio {
	
	int id;
	String tipo;
	String nome;
	
	public Cardapio() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cardapio(int id, String tipo, String nome) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
