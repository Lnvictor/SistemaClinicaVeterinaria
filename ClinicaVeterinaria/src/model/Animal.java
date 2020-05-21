package model;

import java.util.ArrayList;

public class Animal {

	private String nome_animal;

	private Integer idade_animal;

	private Integer sexo_animal;

	private Cliente cliente;

	private ArrayList<Tratamento> tratamentos;

	private Especie especie;

	public Animal(String nome, Integer idade, Integer sexo) {
		this.nome_animal = nome;
		this.idade_animal = idade;
		this.sexo_animal = sexo;
		this.tratamentos = new ArrayList<>();
	}

	public Especie getEspecie() {
		return especie;
	}

	public void setEspecie(Especie especie) {
		this.especie = especie;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<Tratamento> getTratamentos() {
		return tratamentos;
	}

	public void addTratamentos(Tratamento tratamento) {
		this.tratamentos.add(tratamento);
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
}
