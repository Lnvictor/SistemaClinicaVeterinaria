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
	public void addAnimal(String nome, Integer idade, Integer sexo) {
		Animal animal = new Animal(id, nome, idade, sexo);
		id++;
		this.animais.put(id, animal);
		setChanged();
		notifyObservers(animal);
	}

	public Map<Integer, Animal> getAllAnimais() {
		return animais;
	}

	public Animal getAnimalById(int id) {
		return this.animais.get(id);
	}

	public void deleteAnimal(Animal animal) {
		this.animais.remove(animal.getId());
	}
}
