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
    public static void setClienteObserver(Observer observer){
        ClienteDAO.getInstance().addObserver(observer);
    }
    
    public static void addCliente(Cliente cliente){
        ClienteDAO.getInstance().addCliente(cliente);
    }
    
    public static Map<Integer, Cliente> getAllClientes(){
        return ClienteDAO.getInstance().getAllClientes();
    }
    
    public static void setAnimalObserver(Observer observer){
        AnimalDAO.getInstance().addObserver(observer);
    }
    
    public static void addAnimal(Animal animal){
    	AnimalDAO.getInstance().addAnimal(animal);
    }
    
    public static Map<Integer, Animal> getAllAnimais(){
        return AnimalDAO.getInstance().getAllAnimais();
    }
    
    public static void setConsultaObserver(Observer observer){
        ConsultaDAO.getInstance().addObserver(observer);
    }
    
    public static void addConsulta(Consulta consulta){
    	ConsultaDAO.getInstance().addConsulta(consulta);
    }
    
    public static Map<Integer, Consulta> getAllConsultas(){
        return ConsultaDAO.getInstance().getAllConsultas();
    }
}
