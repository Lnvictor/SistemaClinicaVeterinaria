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

	public static ClienteDAO getInstance() {
		if (instance == null) {
			instance = new ClienteDAO();
		}
		return instance;
	}

	public void addCliente(Cliente cliente) {
		Cliente newCliente = new Cliente(id, cliente.getNome_cli(), cliente.getEnd_cli(), cliente.getTel_cli(),
				cliente.getCep_cli(), cliente.getEmail_cli());
		this.clientes.put(id, newCliente);
		id++;
		setChanged();
		notifyObservers(newCliente);
	}

	public Map<Integer, Cliente> getAllClientes() {
		for (Map.Entry<Integer, Cliente> cliente : clientes.entrySet()) {
        	cliente.getValue().addAnimais(AnimalDAO.getInstance().getAnimalById(cliente.getKey()));
        }
		
		return clientes;
	}

	public Cliente getClienteById(int id) {
		return this.clientes.get(id);
	}

	public void deleteCliente(Cliente cliente) {
		this.clientes.remove(cliente.getId());
	}
}
