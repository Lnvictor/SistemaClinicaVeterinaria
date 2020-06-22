package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;




/**
 * Não sei se vale a pena essa parada
 * @author vh141
 *
 */
public class EspecieDAO extends DAO{
	private static EspecieDAO instance;
	
	private EspecieDAO() {
		DAO.getConnection();
	}
	
	public EspecieDAO getInstance() {
		if (this.instance== null) {
			instance = new EspecieDAO();
		}
		return this.instance;
	}
	
	public int addEspecie(String name_especie, String id_animal) {
		try {
			PreparedStatement stmt;
			int newId = lastId("ESPECIE", "id") + 1;
			stmt = DAO.getConnection().prepareStatement("INSERT INTO ESPECIE (id, id_animal, name_especie) VALUES (?, ?)");
			stmt.setInt(1, newId);
			stmt.setString(2, name_especie);
			executeUpdate(stmt);
			return newId;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public Especie getEspecieById(int id) {
		Especie especie = null;
		try {
			ResultSet rs = getResultSet("SELECT * FROM ESPECIE WHERE id = "+ id);
			
			while(rs.next()) {
				especie = buildObject(rs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return especie;
	}
	
	public List<Especie> getAllEspecies(){
		List<Especie> especies = new ArrayList<>();
		
		try {
			ResultSet rs = getResultSet("SELECT * FROM ESPECIE");
			
			while(rs.next()) {
				especies.add(buildObject(rs));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return especies;
	}

	private Especie buildObject(ResultSet rs) {
		Especie especie = null;
		
		try {
			especie = new Especie(rs.getString("name_especie"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return especie;
	}
	
	public boolean update(Especie especie) {
		return false;
	}
	
	public int delete(int id) {
		return -1;
	}
}
