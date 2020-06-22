package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsultaDAO extends DAO {
	
	private static ConsultaDAO instance;

	private ConsultaDAO() {
		DAO.getConnection();
	}
	

	public int addConsulta(Tratamento tratamento, List<Exame> exames, Veterinario veterinario, long date, String historico) {
		try {
            PreparedStatement stmt;
            int newId = lastId("CONSULTA", "id") + 1;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO CONSULTA (id, tratamento, Veterinario, date_con, historico) VALUES (?,?,?,?,?)");
            stmt.setInt(1, newId);
            stmt.setInt(2, tratamento.getId());
            stmt.setInt(3, veterinario.getId());
            stmt.setDate(4, new java.sql.Date(date));
            stmt.setString(5, historico);
            
            executeUpdate(stmt);
            return newId;

		} catch (SQLException ex) {
            Logger.getLogger(ConsultaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
		
		return -1;
	}
	
	
	public List<Consulta> getAllConsultas(){
		List<Consulta> consultas = new ArrayList();
        ResultSet rs = getResultSet("SELECT * FROM CONSULTA");
        try {
            while (rs.next()) {
            	consultas.add(buildObject(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consultas;
	}

	private Consulta buildObject(ResultSet rs) {
		Consulta consulta = null;
        try {
        	Tratamento tratamento = null;
        	tratamento = TratamentoDAO.getInstance().getTratamentoById(rs.getInt("tratamento"));
        	
        	Veterinario veterinario = null;
        	veterinario = VeterinarioDAO.getInstance().getVeterinarioById(rs.getInt("Veterinario"));
        	
        	consulta = new 	Consulta(rs.getInt("id"), rs.getDate("date_con"), rs.getString("historico"));
        	consulta.setTratamento(tratamento);
        	consulta.setVeterinario(veterinario);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consulta;
	}

	public static ConsultaDAO getInstance() {
		if(instance == null) {
			instance = new ConsultaDAO();
		}
		return instance;
	}
	
	
	public List<Consulta> getConsultasByTratamento(Tratamento tratamento){
		List<Consulta> consulta = new ArrayList<>();
		int idTratamento = tratamento.getId();
		ResultSet rs = getResultSet("SELECT * FROM CONSULTA where tratamento = " + idTratamento);
		try {
        	if (rs.next())
        		consulta.add(buildObject(rs));
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consulta;
	}
	
	
	public Consulta getConsultaById(int id) {
		Consulta consulta = null;
        ResultSet rs = getResultSet("SELECT * FROM ANIMAL WHERE id = " + id);
        try {
        	if (rs.next())
        		consulta  = buildObject(rs);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consulta;
	}
	
	
	public boolean update(Consulta consulta) {
		try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE CONSULTA SET tratamento=?, Veterinario=?, date_con=?, historico=? WHERE id=?");
            stmt.setInt(1, consulta.getTratamento().getId());
            stmt.setInt(2, consulta.getVeterinario().getId());
            stmt.setDate(3, new java.sql.Date((long) consulta.getDate_con().getDate()));
            stmt.setString(4, consulta.getHistorico());
            stmt.setInt(5, consulta.getId());
            executeUpdate(stmt);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
		return false;
	}
	
	public int delete(int id) {
		try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("DELETE FROM CONSULTA WHERE id=?");
            stmt.setInt(1, id);
            executeUpdate(stmt);
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
		
		return -1;
	}
}
