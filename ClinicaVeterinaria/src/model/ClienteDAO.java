package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO extends DAO {
	
	private static ClienteDAO instance;

	private ClienteDAO() {
		DAO.getConnection();
	}

	public static ClienteDAO getInstance() {
		if (instance == null) {
			instance = new ClienteDAO();
		}
		return instance;
	}

	public int addCliente(String nome, String endereco, String email, String telefone, String cep) {
		try {
            PreparedStatement stmt;
            int newId = lastId("CLIENTE", "id") + 1;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO CLIENTE (id,nome,endereco,cep,email,telefone) VALUES (?,?,?,?,?,?)");
            stmt.setInt(1, newId);
            stmt.setString(2, nome);
            stmt.setString(3, endereco);
            stmt.setString(4, cep);
            stmt.setString(5, email);
            stmt.setString(6, telefone);
            executeUpdate(stmt);
            return newId;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
		
		return -1;
	}
	
	public int delete(Integer id) {
		try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("DELETE FROM CLIENTE WHERE id=?");
            stmt.setInt(1, id);
            executeUpdate(stmt);
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
		
		return -1;
    }
	
	private Cliente buildObject(ResultSet rs) {
        Cliente cliente = null;
        try {
            cliente = new Cliente(rs.getInt("id"), rs.getString("nome"), rs.getString("endereco"), rs.getString("telefone"), rs.getString("cep"), rs.getString("email"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }

	// RetrieveAll
    public List getAllClientes() {
        List<Cliente> clientes = new ArrayList();
        ResultSet rs = getResultSet("SELECT * FROM CLIENTE");
        try {
            while (rs.next()) {
                clientes.add(buildObject(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    // RetrieveById
    // Os grupos devem implementar as modificacoes para permitir que um cliente seja
    // encontrado a partir de um id (inteiro).
    // Sugestao, ao inves de usar um List, usar um Map.
    public Cliente getClienteById(int id) {
        Cliente cliente = null;
        ResultSet rs = getResultSet("SELECT * FROM CLIENTE WHERE id = " + id);
        try {
            if (rs.next()) {
                cliente = buildObject(rs);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }

    // RetrieveByName
    // Updade
    public void update(Cliente cliente) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE CLIENTE SET nome=?, endereco=?, cep=?, email=?, telefone=? WHERE id=?");
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEndereco());
            stmt.setString(3, cliente.getCep());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getTelefone());
            stmt.setInt(6, cliente.getId());
            executeUpdate(stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
        // Delete   
    public void deleteCliente(Cliente cliente) {
        PreparedStatement stmt;
        try {
            stmt = DAO.getConnection().prepareStatement("DELETE FROM CLIENTE WHERE id = ?");
            stmt.setInt(1, cliente.getId());
            executeUpdate(stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
