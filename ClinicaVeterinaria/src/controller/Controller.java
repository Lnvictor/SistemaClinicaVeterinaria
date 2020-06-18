package controller;

import java.util.List;
import java.util.Map;
import java.util.Observer;

import model.Animal;
import model.AnimalDAO;
import model.Cliente;
import model.ClienteDAO;
import model.Consulta;
import model.ConsultaDAO;

/**
 *
 * @author Plinio Vilela
 */
public class Controller {
	
	//Clientes
	public static void addCliente(String nome, String endereco, String email, String telefone, String cep){
        ClienteDAO.getInstance().addCliente(nome, endereco, email, telefone, cep);
    }
    
    public static List getAllClientes(){
        return ClienteDAO.getInstance().getAllClientes();
    }
    
    public static Cliente getClienteById(int id){
        return ClienteDAO.getInstance().getClienteById(id);
    }
    
    public static void deleteCliente(Cliente cliente){
        ClienteDAO.getInstance().deleteCliente(cliente);
    }
    
    // ANIMAL
    public static int addAnimal(String nome, String sexo, Integer idade, Integer id_cliente){
    	return AnimalDAO.getInstance().addAnimal(nome, id_cliente, idade, sexo);
    }
    
    public static Animal getAnimalById(Integer id){
    	return AnimalDAO.getInstance().getAnimalById(id);
    }
    
    public static List getAllAnimais(){
        return AnimalDAO.getInstance().getAllAnimais();
    }
    
    public static List getAnimaisOfClient(Integer idCliente){
        return AnimalDAO.getInstance().getAnimaisOfClient(idCliente);
    }
}
