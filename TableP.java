package model;

public class TableP {
	int id;
	String nume;
	String cantitate;
	
	
	public TableP() {

	}
	public TableP(int id, String nume, String cantitate) {
		this.id=id;
		this.nume=nume;
		this.cantitate=cantitate;
	}
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.nume;
	}
	
	public String getCantitate() {
		return this.cantitate;
	}
	
	public void setNume(String nume)
	{
		this.nume=nume;
	}
	
	public void setCantitate(String cantitate) {
		this.cantitate=cantitate;
	}
	
	public void setId(int id) {
		this.id=id;
	}
}
