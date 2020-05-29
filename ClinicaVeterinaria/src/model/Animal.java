package model;

import java.util.ArrayList;

public class Animal {

	private Integer id;

	private String nome;

	private Integer ano_nasc;

	private String sexo;

	private Cliente cliente;

	private ArrayList<Tratamento> tratamentos;

	private Especie especie;

	public Animal(Integer id, String nome, Integer ano_nasc, String sexo, Cliente cliente) {
		super();
		this.id = id;
		this.nome = nome;
		this.ano_nasc = ano_nasc;
		this.sexo = sexo;
		this.cliente = cliente;
	}

	public Animal(Integer id, String nome, Integer ano_nasc, String sexo, Cliente cliente,
			ArrayList<Tratamento> tratamentos, Especie especie) {
		super();
		this.id = id;
		this.nome = nome;
		this.ano_nasc = ano_nasc;
		this.sexo = sexo;
		this.cliente = cliente;
		this.tratamentos = tratamentos;
		this.especie = especie;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getAno_nasc() {
		return ano_nasc;
	}

	public void setAno_nasc(Integer ano_nasc) {
		this.ano_nasc = ano_nasc;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
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

	public void setTratamentos(ArrayList<Tratamento> tratamentos) {
		this.tratamentos = tratamentos;
	}

	public Especie getEspecie() {
		return especie;
	}

	public void setEspecie(Especie especie) {
		this.especie = especie;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", nome=" + nome + ", idade=" + ano_nasc + ", sexo=" + sexo + ", cliente=" + cliente
				+ ", tratamentos=" + tratamentos + ", especie=" + especie + "]";
	}

}
