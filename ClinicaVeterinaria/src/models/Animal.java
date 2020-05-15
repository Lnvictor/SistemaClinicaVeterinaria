package models;

import java.util.ArrayList;

public class Animal {

	private String nome_animal;
	
	private Integer idade_animal;
	
	private Integer sexo_animal;
	
	private ArrayList<Cliente> clientes;
	
	private ArrayList<Tratamento> tratamentos;
	
	public Animal(String nome, Integer idade, Integer sexo) {
		this.nome_animal = nome;
		this.idade_animal = idade;
		this.sexo_animal = sexo;
	}
	
	public ArrayList<Tratamento> getTratamentos() {
		return tratamentos;
	}

	public void setTratamentos(ArrayList<Tratamento> tratamentos) {
		this.tratamentos = tratamentos;
	}



	public String getNome_animal() {
		return nome_animal;
	}

	public void setNome_animal(String nome_animal) {
		this.nome_animal = nome_animal;
	}

	public Integer getIdade_animal() {
		return idade_animal;
	}

	public void setIdade_animal(Integer idade_animal) {
		this.idade_animal = idade_animal;
	}

	public Integer getSexo_animal() {
		return sexo_animal;
	}

	public void setSexo_animal(Integer sexo_animal) {
		this.sexo_animal = sexo_animal;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
}
