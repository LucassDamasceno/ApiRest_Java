package com.cardapio.model;

import com.cardapio.rest.BancoDeDados;

public class MainTeste {

	public static void main(String[] args) {
		BancoDeDados banco = new BancoDeDados();
		banco.conectar();

		if (banco.estaConectado()) {
			  banco.inserirCardapio("peixe", "Atum");
			//banco.listarCardapio();
			//banco.editarCardapio(10, "porco", "carréSuino");
			//banco.excluirDardapio(12);
		} else {
			System.out.println("não foi possível conectar ao banco de dados");
		}
	}

}
