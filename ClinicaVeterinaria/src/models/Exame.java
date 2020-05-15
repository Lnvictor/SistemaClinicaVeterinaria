package models;

public class Exame {
	private String des_exame;

	public Exame(String des_exame) {
		this.des_exame = des_exame;
	}

	public String getDes_exame() {
		return des_exame;
	}

	public void setDes_exame(String des_exame) {
		this.des_exame = des_exame;
	}

	@Override
	public String toString() {
		return "Exame [des_exame=" + des_exame + "]";
	}
}
