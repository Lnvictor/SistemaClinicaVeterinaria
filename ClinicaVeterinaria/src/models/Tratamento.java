package models;

import java.util.ArrayList;
import java.util.Date;

public class Tratamento {

	private Date dat_ini;

	private Date dat_fim;

	private Animal animal;

	private ArrayList<Consulta> consultas;

	public Tratamento(Date inicio, Date fim) {
		this.dat_ini = inicio;
		this.dat_fim = fim;
		this.consultas = new ArrayList<>();
	}

	public Tratamento(Date inicio, Date fim, ArrayList<Consulta> consultas) {
		this.dat_ini = inicio;
		this.dat_fim = fim;
		this.consultas = consultas;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public ArrayList<Consulta> getConsultas() {
		return consultas;
	}

	public void addConsultas(Consulta consulta) {
		this.consultas.add(consulta);
	}

	public Date getDat_ini() {
		return dat_ini;
	}

	public void setDat_ini(Date dat_ini) {
		this.dat_ini = dat_ini;
	}

	public Date getDat_fim() {
		return dat_fim;
	}

	public void setDat_fim(Date dat_fim) {
		this.dat_fim = dat_fim;
	}

	@Override
	public String toString() {
		return "Tratamento [dat_ini=" + dat_ini + ", dat_fim=" + dat_fim + ", consultas=" + consultas + "]";
	}
}
