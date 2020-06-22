package controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Observer;

import model.Animal;
import model.AnimalDAO;
import model.Cliente;
import model.ClienteDAO;
import model.Consulta;
import model.ConsultaDAO;
import model.Exame;
import model.Tratamento;
import model.TratamentoDAO;
import model.Veterinario;
import model.VeterinarioDAO;

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
    
    
    //TODO: Veterinario
    public static int addVeterinario(String nom_vet, String end_vet, String tel_vet) {
    	return VeterinarioDAO.getInstance().addVeterinario(nom_vet, end_vet, tel_vet);
    }
    
    public static List<Veterinario> getAllVeterinarios() {
    	return VeterinarioDAO.getInstance().getAllVeterinarios();
    }
    
    public static Veterinario getVeterinarioById(int id) {
    	return VeterinarioDAO.getInstance().getVeterinarioById(id);
    }
    
    
    //Consultas
    public static int addConsulta(Tratamento tratamento, List<Exame> exames, Veterinario veterianrio, long date, String historico) {
    	return ConsultaDAO.getInstance().addConsulta(tratamento, exames, veterianrio, date, historico);
    }
    
    public  static Consulta getConsultaById(int id) {
    	return ConsultaDAO.getInstance().getConsultaById(id);
    }
    
    public static List<Consulta> getConsultasByTratamento(Tratamento tratamento){
    	return ConsultaDAO.getInstance().getConsultasByTratamento(tratamento);
    }
    
    public static boolean updateConsulta(Consulta consulta) {
    	return ConsultaDAO.getInstance().update(consulta);
    }
    
    //Tratamento
    public static int addTratamento(long dat_ini, long dat_fim, Animal animal) {
    	return TratamentoDAO.getInstance().addTratamento(dat_ini, dat_fim, animal);
    }
}
