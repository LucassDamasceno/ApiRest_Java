package com.cardapio.model;

import com.cardapio.rest.BancoDeDados;

public class MainTeste {

	public static void main(String[] args) {
		BancoDeDados banco = new BancoDeDados();
		banco.conectar();

		if (banco.estaConectado()) {
			  banco.inserirCardapio("peixe", "Atum");
			//banco.listarCardapio();
			//banco.editarCardapio(10, "porco", "carr�Suino");
			//banco.excluirDardapio(12);
		} else {
			System.out.println("n�o foi poss�vel conectar ao banco de dados");
		}
	}

}
