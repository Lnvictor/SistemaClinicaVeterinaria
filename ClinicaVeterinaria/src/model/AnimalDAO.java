package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnimalDAO extends DAO {
	
	private static AnimalDAO instance;

	private AnimalDAO() {
		DAO.getConnection();
	}

	public static AnimalDAO getInstance() {
		if (instance == null) {
			instance = new AnimalDAO();
		}
		return instance;
	}

	// Create
	public void addAnimal(String nome, Integer idCliente, Integer anoNasc, String sexo) {
		try {
            PreparedStatement stmt;
            int newId = lastId("ANIMAL", "id") + 1;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO ANIMAL (id, id_cliente, nome, sexo, ano_nasc) VALUES (?,?,?,?,?)");
            stmt.setInt(1, newId);
            stmt.setInt(2, idCliente);
            stmt.setString(3, nome);
            stmt.setString(4, sexo);
            stmt.setInt(5, anoNasc);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

	public List getAllAnimais() {
		List<Animal> animais = new ArrayList();
        ResultSet rs = getResultSet("SELECT * FROM ANIMAL");
        try {
            while (rs.next()) {
            	animais.add(buildObject(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animais;
	}
	
	 // get Animais of Client
    public List getAnimaisOfClient(Integer idCliente) {
        List<Animal> animais = new ArrayList();
        PreparedStatement stmt;
        try {
        	stmt = DAO.getConnection().prepareStatement("SELECT * FROM ANIMAL WHERE id_cliente = ?");
            stmt.setInt(1, idCliente);
            ResultSet rs = stmt.executeQuery();
        	while (rs.next()) {
            	animais.add(buildObject(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animais;
    }
	
	private Animal buildObject(ResultSet rs) {
		Animal animal = null;
        try {
        	Cliente cliente = null;
        	cliente = ClienteDAO.getInstance().getClienteById(rs.getInt("id_cliente"));
        	
        	animal = new Animal(rs.getInt("id"), rs.getString("nome"), rs.getInt("ano_nasc"), rs.getString("sexo"), cliente);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animal;
    }
}
