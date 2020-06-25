package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import controller.Controller;
import java.sql.Date;

public class TratamentoDAO extends DAO {

	private static TratamentoDAO instance;

	
	private TratamentoDAO() {
		DAO.getConnection();
	}
	
	public static TratamentoDAO getInstance() {
		// TODO Auto-generated method stub
		if (instance == null) {
			instance = new TratamentoDAO();
		}
		return instance;
	}
	
	public  List<Tratamento> getAllTratamentos(){
		List<Tratamento> tratamento = new ArrayList<>();
        ResultSet rs = getResultSet("SELECT * FROM TRATAMENTO");
        try {
        	if (rs.next())
        		tratamento.add(buildObject(rs));
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tratamento;
	}

	public Tratamento getTratamentoById(int id) {
		Tratamento tratamento = null;
        ResultSet rs = getResultSet("SELECT * FROM TRATAMENTO WHERE id = " + id);
        try {
        	if (rs.next())
        		tratamento  = buildObject(rs);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tratamento;
	}
        
        public List<Tratamento> getTratamentosOfAnimal(int id) {
            List<Tratamento> tratamento = new ArrayList<>();
            ResultSet rs = getResultSet("SELECT * FROM TRATAMENTO WHERE id_animal = " + id);
            try {
        	if (rs.next())
        		tratamento.add(buildObject(rs));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            return tratamento;
        }

	private Tratamento buildObject(ResultSet rs) {
		
            try {
                Tratamento tratamento = new Tratamento(rs.getDate("dat_ini"), rs.getDate("dat_fim"));
                tratamento.setAnimal(Controller.getAnimalById(rs.getInt("id_animal")));

                for (Consulta c : Controller.getConsultasByTratamento(tratamento)) {
                        tratamento.addConsultas(c);
                }

                return  tratamento;
            }catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
	}
	
	public int addTratamento(Date dat_ini, Date dat_fim, Animal animal) {
            try {
		PreparedStatement stmt;
                int newId = lastId("TRATAMENTO", "id") + 1;
                stmt = DAO.getConnection().prepareStatement("INSERT INTO TRATAMENTO (id, dat_ini, dat_fim, id_animal) VALUES (?,?,?,?)");
                stmt.setInt(1, newId);
                stmt.setDate(2, dat_ini);
                stmt.setDate(3, dat_fim);
                stmt.setInt(4, animal.getId());
            
                executeUpdate(stmt);
                return newId;
            } catch (SQLException e) {
		Logger.getLogger(TratamentoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
            return -1;
	}

	public boolean update(Tratamento tratamento) {
            try {
                PreparedStatement stmt;
                stmt = DAO.getConnection().prepareStatement("UPDATE TRATAMENTO SET dat_ini=?, dat_fim=?, id_animal=?,  WHERE id=?");
                stmt.setDate(1, new java.sql.Date((long)tratamento.getDat_ini().getDate()));
                stmt.setDate(2, new java.sql.Date((long)tratamento.getDat_fim().getDate()));
                stmt.setInt(3, tratamento.getAnimal().getId());
                stmt.setInt(4, tratamento.getId());
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
            stmt = DAO.getConnection().prepareStatement("DELETE FROM TRATAMENTO WHERE id=?");
            stmt.setInt(1, id);
            executeUpdate(stmt);
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(TratamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
		
		return -1;
	}
}
