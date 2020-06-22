package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VeterinarioDAO extends DAO{
	private static VeterinarioDAO instance;
	
	private VeterinarioDAO() {
		DAO.getConnection();
	}
	
	public static VeterinarioDAO getInstance() {
		if (instance == null) {
			instance = new VeterinarioDAO();
		}
		return instance;
	}
	
	public int addVeterinario(String nom_vet, String end_vet, String tel_vet) {
		try {
			PreparedStatement stmt;
            int newId = lastId("VETERINARIO", "id") + 1;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO VETERINARIO (id, nom_vet, end_vet, tel_Vet) VALUES (?,?,?,?,?)");
            stmt.setInt(1, newId);
            stmt.setString(2, nom_vet);
            stmt.setString(3, end_vet);
            stmt.setString(4, tel_vet);
            
            executeUpdate(stmt);
            return newId;
		} catch (SQLException e) {
			Logger.getLogger(VeterinarioDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return -1;
	}

	public Veterinario getVeterinarioById(int id) {
		Veterinario veterinario = null;
        ResultSet rs = getResultSet("SELECT * FROM VETERINARIO WHERE id = " + id);
        try {
        	if (rs.next())
        		veterinario  = buildObject(rs);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return veterinario;
	}
	
	public List<Veterinario> getAllVeterinarios(){
		List<Veterinario> veterinario = new ArrayList<>();
        ResultSet rs = getResultSet("SELECT * FROM VETERINARIO");
        try {
        	if (rs.next())
        		veterinario.add(buildObject(rs));
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return veterinario;	
    }

	private Veterinario buildObject(ResultSet rs) {
		Veterinario veterinario = null;
		try {
			veterinario = new Veterinario(rs.getInt("id"), rs.getString("nom_vet"), rs.getString("end_vet"), rs.getString("tel_vet"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return veterinario;
	}
	
	public boolean update(Veterinario veterinario) {
		try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE VETERINARIO SET nom_vet=?, end_vet=?, tel_vet=?,  WHERE id=?");
            stmt.setString(1, veterinario.getNom_vet());
            stmt.setString(2, veterinario.getEnd_vet());
            stmt.setString(3, veterinario.getTel_vet());
            stmt.setInt(4, veterinario.getId());
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
            stmt = DAO.getConnection().prepareStatement("DELETE FROM VETERINARIO WHERE id=?");
            stmt.setInt(1, id);
            executeUpdate(stmt);
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(VeterinarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
		
		return -1;
	}
}
