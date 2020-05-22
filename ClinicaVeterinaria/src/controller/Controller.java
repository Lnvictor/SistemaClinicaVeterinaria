package controller;

import java.util.List;
import java.util.Map;
import java.util.Observer;

import model.Animal;
import model.AnimalDAO;
import model.Cliente;
import model.ClienteDAO;

/**
 *
 * @author Plinio Vilela
 */
public class Controller {
    public static void setClienteObserver(Observer observer){
        ClienteDAO.getInstance().addObserver(observer);
    }
    
    public static void setAnimalObserver(Observer observer){
        AnimalDAO.getInstance().addObserver(observer);
    }
    
    public static void addAnimal(String nome, Integer idade, Integer sexo){
    	AnimalDAO.getInstance().addAnimal(nome, idade, sexo);
    }
    
    public static Map<Integer, Animal> getAllAnimais(){
        return AnimalDAO.getInstance().getAllAnimais();
    }
    
    public static void addCliente(String nome, String endereco, String telefone, String cep, String email){
        ClienteDAO.getInstance().addCliente(nome, endereco, telefone, cep, email);
    }
    
    public static Map<Integer, Cliente> getAllClientes(){
        return ClienteDAO.getInstance().getAllClientes();
    }
}
