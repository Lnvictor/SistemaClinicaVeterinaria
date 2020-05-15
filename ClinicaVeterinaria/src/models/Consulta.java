package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Consulta {

	private Tratamento tratamento;

	private List<Exame> exames;

	private Veterinario veterinario;

	private Date date_con;

	private String historico;

	public Consulta(Date date_con, String historico) {
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

	public void setExames(List<Exame> exames) {
		this.exames = exames;
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

	public void setDate_con(Date date_con) {
		this.date_con = date_con;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}
}
