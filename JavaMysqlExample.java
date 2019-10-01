package proiectPractica2019;
import java.sql.*;

import java.util.ArrayList;
import model.*;
public class JavaMysqlExample {
	static String myDriver="org.gjt.mm.mysql.Driver";
    static  String myUrl="jdbc:mysql://localhost:3306/practica2019";
    
	public  JavaMysqlExample(){
		
	}
	
	public static <T> ArrayList<T> AnyTable(String name, ArrayList <T> table) {
		try {
	    Class.forName(myDriver);
	    
		String query = "SELECT * FROM " + name;
		Connection conn = DriverManager.getConnection(myUrl, "root", "");
	    
	      // create the java statement
	      Statement st = conn.createStatement();
	      
	      // execute the query, and get a java resultset
	      ResultSet rs = st.executeQuery(query);
	      
	      // iterate through the java resultset
	      
		 while (rs.next())
	      {
			 if(name.equalsIgnoreCase("books")) {
	    	    Books p1 = new Books(rs.getInt("ID"),rs.getString("name"), rs.getString("author"), rs.getInt("bookYear"));
	            table.add((T) p1);
	            }
			 else if(name.equalsIgnoreCase("product")) {
				 Product p = new Product(rs.getInt("id"),rs.getString("product_name"), rs.getString("quantity"));
				 table.add((T)p);
			 }
			 else if(name.equalsIgnoreCase("comments")) {
				 Comments comms = new Comments(rs.getInt("ID"),rs.getString("myUser"),rs.getString("EMAIL"), 
						 rs.getString("WEBPAGE"),rs.getString("DATUM"),rs.getString("COMMENTS"));
				 table.add((T) comms);
			 }
			 else if(name.equalsIgnoreCase("p")) {
				 TableP tableP1 = new TableP(rs.getInt("ID"),rs.getString("Nume"), rs.getString("Cantitate"));
				 table.add((T)tableP1);
			 }
			 else if(name.equalsIgnoreCase("user")) {
				 user us=new user(rs.getInt("ID"), rs.getString("name"), rs.getString("role"));
				 table.add((T)us);
			 }
			 
	      }
	}catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	
	    }
	  return table;
	}
	
	
	public static void main(String[] args) {
		
		   // create our mysql database connection
	      //PreparedStatement preparedStatement = null;
	      // our SQL SELECT query. 
	      // if you only need a few columns, specify them by name instead of using "*"
	    
	    ArrayList<Comments> us;
	    us=JavaMysqlExample.AnyTable("comments",new ArrayList<Comments>());
	    System.out.println("\n*** Table user : ***");
		for(int i=0; i<us.size();i++)
	      System.out.println("Tabel user id= "+us.get(i).getId()+"nume= "+us.get(i).getDate());
		
		/*ArrayList<Books> books;
		books=JavaMysqlExample.AnyTable("books", new ArrayList<Books>());
		System.out.println("\n *** Table Books: ***");
		for(int i=0; i<books.size(); i++)
			System.out.println("Table books id= " + books.get(i).getId() + " nume= " + books.get(i).getName()
					+ " autor= " + books.get(i).getAuthor());*/
	      
		
	

}
}