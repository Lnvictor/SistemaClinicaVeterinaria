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
		setChanged();
		notifyObservers(consulta);
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
	
	public Consulta getConsultaById(int id) {
		return this.consultas.get(id);
	}
}
