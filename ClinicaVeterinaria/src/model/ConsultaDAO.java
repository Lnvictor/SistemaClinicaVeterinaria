package model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

public class ConsultaDAO extends Observable {
	
	private static ConsultaDAO instance;
	private int id;	
	private Map<Integer, Consulta> consultas;


	private ConsultaDAO() {
		consultas = new HashMap<>();
		id = 0;
	}
	
	public void addConsulta(Consulta consulta) {
		this.consultas.put(id, consulta);
		id++;
	}
	
	public Map<Integer, Consulta> getAllConsultas(){
		return consultas;
	}

	public static ConsultaDAO getInstance() {
		if(instance == null) {
			instance = new ConsultaDAO();
		}
		return instance;
	}

	public static void setInstance(ConsultaDAO instance) {
		ConsultaDAO.instance = instance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setConsultas(Map<Integer, Consulta> consultas) {
		this.consultas = consultas;
	}
	
	
	
}
