package model;

public class Books {
   
	int id;
	String name;
	String author;
	int year;
	public Books() {
		
	}
	
	public Books(int id, String name, String author, int year){
		this.id=id;
		this.name=name;
		this.author=author;
		this.year=year;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	public void setName(String name) {
		this.name=name;
	}
	
	public void setAuthor(String author) {
		this.author=author;
	}
	public void setYear(int year) {
		this.year=year;
		
	}
	
	public int getYear() {
		return this.year;
	}
	
	public String getName() {
		return this.name;
	}
	public String getAuthor() {
		return this.author;
	}
	public int getId() {
		return this.id;
	}
}
