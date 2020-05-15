package models;

import java.util.*;

public class Consulta {
	private List<Exame> exames;
	private Date date_con;
	private String historico;
	
	public Consulta(Date date_con, String historico) {
		super();
		this.date_con = date_con;
		this.historico = historico;
		this.exames = new ArrayList<>();
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
