package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class AnimalDAO extends Observable {
	private static AnimalDAO instance;
	private Map<Integer, Animal> animais;
	private int id;

	private AnimalDAO() {
		this.animais = new HashMap<>();
		this.id = 0;
	}

	public static AnimalDAO getInstance() {
		if (instance == null) {
			instance = new AnimalDAO();
		}
		return instance;
	}

	// Create
	public void addAnimal(Animal animal) {
		Animal newAnimal = new Animal(id, animal.getNome_animal(), animal.getIdade_animal(), animal.getSexo_animal(),
				animal.getCliente());
		this.animais.put(id, newAnimal);
		id++;
		setChanged();
		notifyObservers(newAnimal);
	}

	public Map<Integer, Animal> getAllAnimais() {
		for (Map.Entry<Integer, Animal> animal : animais.entrySet()) {
			animal.getValue().setCliente((ClienteDAO.getInstance().getClienteById(animal.getKey())));
        }
		return animais;
	}

	public Animal getAnimalById(int id) {
		return this.animais.get(id);
	}

	public void deleteAnimal(Animal animal) {
		this.animais.remove(animal.getId());
	}
}
