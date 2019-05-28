package com.cardapio.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BancoDeDados {
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultset = null;
	
	public void conectar() {
		String servidor = "jdbc:mysql://localhost:3306/restaurante";
		String usuario = "root";
		String senha = "";
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor,usuario,senha);
			this.statement = this.connection.createStatement();
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao tentar conectar : "+ e.getMessage());
		}
	}
	
	public boolean estaConectado() {
		if (this.connection != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public void listarCardapio() {
		try {
			String query = "SELECT * FROM cardapio ORDER BY ID";
			this.resultset = this.statement.executeQuery(query);
			this.statement =  this.connection.createStatement();
			while(this.resultset.next()) {
				System.out.println(this.resultset.getString("nome"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void inserirCardapio(String tipo, String nome) {
		try {
			String query = "INSERT INTO cardapio (TIPO, NOME) VALUES ('"+tipo+"','"+ nome +"')";
			this.statement.executeUpdate(query);
			
		} catch (Exception e) {
			System.out.println("Ocorreu um erro" + e.getMessage());
		}
	}
	public void editarCardapio(int id, String tipo, String nome) {
		try {
			String query = "UPDATE cardapio SET tipo ='"+tipo+"', nome ='"+ nome +"' WHERE id="+id;
			System.out.println(query);
			this.statement.executeUpdate(query);
			
		} catch (Exception e) {
			System.out.println("Ocorreu um erro" + e.getMessage());
		}
	}
	public void excluirDardapio(int id) {
		try {
			String query = "DELETE FROM cardapio WHERE id="+id;
			System.out.println(query);
			this.statement.executeUpdate(query);
			
		} catch (Exception e) {
			System.out.println("Ocorreu um erro" + e.getMessage());
		}
	}
	
}
