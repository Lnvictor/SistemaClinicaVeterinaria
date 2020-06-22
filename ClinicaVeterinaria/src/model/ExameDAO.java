package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ExameDAO extends DAO{
	
	private static ExameDAO instance;
	
	
	private ExameDAO() {
		DAO.getConnection();
	}
	
	public ExameDAO getInstance() {
		if (this.instance == null) {
			instance = new ExameDAO();
		}
		return instance;
	}
	
	
	public int addExame(Consulta consulta, String des_exame) {
		try {
			PreparedStatement stmt;
			int newId = lastId("EXAME", "id") + 1;
			stmt = DAO.getConnection().prepareStatement("INSERT INTO EXAME (id, id_consulta, des_exame) VALUES (?, ?, ?)");
			stmt.setInt(1, newId);
			stmt.setInt(2, consulta.getId());
			stmt.setString(3, des_exame);
			executeUpdate(stmt);
			return newId;
		} catch (SQLException e) {
			// 
			e.printStackTrace();
		}
		return -1;
	}
	
	public Exame getExameById(int id) {
		Exame exame = null;
		try {
			ResultSet rs = getResultSet("SELECT * FROM EXAME WHERE id = " + id);
			
			while(rs.next()) {
				
				exame = buildObject(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exame;
	}
	
	public List<Exame> getAlLExames(){
		return null;
	}

	private Exame buildObject(ResultSet rs) {
		Exame exame = null;
		try {
			Consulta consulta = ConsultaDAO.getInstance().getConsultaById(rs.getInt("id_consulta"));
			exame = new Exame(rs.getInt("id"), rs.getString("des_exame"));
			exame.setConsulta(consulta);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return exame;
	}
	
	public boolean update(Exame exame) {
		try {
			PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE EXAME SET id_consulta, des_exame  WHERE id=?");
            stmt.setInt(1, exame.getConsulta().getId());
            stmt.setString(2, exame.getDes_exame());
            stmt.setInt(3, exame.getId());
            return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public int delete(int id) {
		try {
			PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("DELETE * FROM EXAME WHERE id = " + id);
            stmt.setInt(1, id);
            return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
