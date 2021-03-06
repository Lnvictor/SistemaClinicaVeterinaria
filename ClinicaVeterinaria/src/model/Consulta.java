package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Consulta {
	
	private int id;
	
	private Tratamento tratamento;

	private List<Exame> exames;

	private Veterinario veterinario;

	private Date date_con;

	private String historico;

	public Consulta(int id, Date date_con, String historico) {
		this.id = id;
		this.date_con = date_con;
		this.historico = historico;
		this.exames = new ArrayList<>();
	}

	public Tratamento getTratamento() {
		return tratamento;
	}

	public void setTratamento(Tratamento tratamento) {
		this.tratamento = tratamento;
	}

	public List<Exame> getExames() {
		return exames;
	}

	public void addExames(Exame exame) {
		this.exames.add(exame);
	}

	public Veterinario getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}

	public Date getDate_con() {
		return date_con;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDate_con(Date date_con) {
		this.date_con = date_con;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	@Override
	public String toString() {
		return "Consulta [tratamento=" + tratamento + ", exames=" + exames + ", veterinario=" + veterinario
				+ ", date_con=" + date_con + ", historico=" + historico + "]";
	}
}