package model;

public class Especie {
	
	private String name_spe;
	
	public Especie(String name_spe) {
		this.name_spe = name_spe;
	}

	public String getName_spe() {
		return name_spe;
	}

	public void setName_spe(String name_spe) {
		this.name_spe = name_spe;
	}

	@Override
	public String toString() {
		return "Especie [name_spe=" + name_spe + "]";
	}
}
