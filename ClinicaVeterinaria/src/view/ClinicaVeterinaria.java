/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import controller.Controller;
import java.util.List;
import java.util.Map;

import model.Animal;
import model.Cliente;
import model.ClienteDAO;

/**
 *
 * @author vilela
 */
public class ClinicaVeterinaria implements Observer{

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Dados Atualizados!!");
        System.out.println(arg);
    }
    
    public void listaClientes(){
        Map<Integer, Cliente> clientes = Controller.getAllClientes();
        for (Map.Entry<Integer, Cliente> cliente : clientes.entrySet()) {
        	System.out.println(cliente.getValue());
        }
    }
    
    public void listaAnimais() {
    	Map<Integer, Animal> animais = Controller.getAllAnimais();
        for (Map.Entry<Integer, Animal> animal : animais.entrySet()) {
        	System.out.println(animal.getValue());
        }
    }
    
    public void menuPrincipal(){
        Scanner in = new Scanner(System.in);
        Controller.setClienteObserver(this);
        while (true){
            System.out.println("1- Insere Cliente");
            System.out.println("2- Lista Clientes");
            System.out.println("3- Insere Animal");
            System.out.println("4- Lista Animal");
            System.out.println("5- Encerra");
            int opcao = in.nextInt();
            switch (opcao){
                case 1:
                    Controller.addCliente("Plinio Vilela", "endereco", "(19)98787-9988", "15675-900", "tste@tewse.com");
                    break;
                case 2:
                    listaClientes();
                    break;
                case 3:
                    Controller.addAnimal("Dog caramelo", 4, 0);
                    break;
                case 4:
                    listaAnimais();
                    break;
                case 5:
                    return;
            }
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ClinicaVeterinaria().menuPrincipal();
    }
    
}
