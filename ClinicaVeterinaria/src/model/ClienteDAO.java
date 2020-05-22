package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class ClienteDAO extends Observable {
	private static ClienteDAO instance;
	private Map<Integer, Cliente> clientes;
	private int id;

	private ClienteDAO() {
		clientes = new HashMap<>();
		id = 0;
	}

	// Singleton
	public static ClienteDAO getInstance() {
		if (instance == null) {
			instance = new ClienteDAO();
		}
		return instance;
	}

// Partial CRUD    
	// Create
	public void addCliente(String nome, String endereco, String telefone, String cep, String email) {
		Cliente cliente = new Cliente(id, nome, endereco, telefone, cep, email);
		id++;
		this.clientes.put(id, cliente);
		setChanged();
		notifyObservers(cliente);
	}	
	
	// RetrieveAll
	public Map<Integer, Cliente> getAllClientes() {
		return clientes;
	}

	// RetrieveById
	// Os grupos devem implementar as modificacoes para permitir que um cliente seja
	// encontrado a partir de um id (inteiro).
	// Sugestao, ao inves de usar um List, usar um Map.
	public Cliente getClienteById(int id) {
		return this.clientes.get(id);
	}

	// RetrieveByName

	// Updade

	// Delete
	public void deleteCliente(Cliente cliente) {
		this.clientes.remove(cliente.getId());
	}
}
