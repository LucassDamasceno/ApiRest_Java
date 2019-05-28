package com.cardapio.rest;

import com.cardapio.model.Cardapio;

public  class CardapioController {
	BancoDeDados banco = new BancoDeDados();
	
	public void salvar(Cardapio cardapio) {
		banco.conectar();
		banco.inserirCardapio(cardapio.getTipo(), cardapio.getNome());
	}
}
