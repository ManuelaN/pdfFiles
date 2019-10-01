package domCreateXML;
import javax.xml.parsers.DocumentBuilderFactory;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import model.*;

import java.io.File;
import java.util.ArrayList;

import proiectPractica2019.*;

public class CreateXMLFile {
   public CreateXMLFile() {
    
   }
   
   public static <T> void XMLFile(Document doc, Element rootElement, String name, ArrayList<T> us) {
	   try
	   {
		   int str=0;
		   for(int i=0; i<us.size(); i++) {
		         
		         Element superelem = doc.createElement(name.toLowerCase());
		         rootElement.appendChild(superelem);

		         // setting attribute to element
		         Attr attr = doc.createAttribute("ID");
		         if(name.equalsIgnoreCase("user")) 
		           str=((user) us.get(i)).getId();
		         else if(name.equalsIgnoreCase("product"))
		        	 str=((Product) us.get(i)).getId();
		         else if(name.equalsIgnoreCase("p"))
		        	 str=((TableP) us.get(i)).getId();
		         else if(name.equalsIgnoreCase("books"))
		        	 str=((Books) us.get(i)).getId();
		         else if(name.equalsIgnoreCase("comments"))
		        	 str=((Comments) us.get(i)).getId();
		        
		         attr.setValue(String.valueOf(str));
		         superelem.setAttributeNode(attr);

		         // carname element
		         if(!(name.equalsIgnoreCase("comments"))) {
		         Element elemname = doc.createElement("Name");
		         if(name.equalsIgnoreCase("user"))
		           elemname.appendChild(doc.createTextNode(((user) us.get(i)).getName()));
		         else if(name.equalsIgnoreCase("books"))
		        	 elemname.appendChild(doc.createTextNode(( (Books) us.get(i)).getName()));
		         else if(name.equalsIgnoreCase("product"))
		        	 elemname.appendChild(doc.createTextNode(( (Product) us.get(i)).getName()));
		         else if(name.equalsIgnoreCase("p"))
		        	 elemname.appendChild(doc.createTextNode(( (TableP) us.get(i)).getName()));
		         superelem.appendChild(elemname);
		         }
		         
		         if(name.equalsIgnoreCase("user")) {
		         Element elemname1 = doc.createElement("Role");
		         elemname1.appendChild(doc.createTextNode(((user) us.get(i)).getRole()));
		         superelem.appendChild(elemname1);
		         }
		         
		         if(name.equalsIgnoreCase("product") || name.equalsIgnoreCase("p")) {
		        	 Element elemname2 = doc.createElement("Quantity");
		        	 if(name.equalsIgnoreCase("product"))
			           elemname2.appendChild(doc.createTextNode(((Product) us.get(i)).getCantitate()));
		        	 else elemname2.appendChild(doc.createTextNode(((TableP) us.get(i)).getCantitate()));
			         superelem.appendChild(elemname2);
		         }
		         if(name.equalsIgnoreCase("books")) {
		        	 Element elemname2 = doc.createElement("Author");
			         elemname2.appendChild(doc.createTextNode(((Books) us.get(i)).getAuthor()));
			         superelem.appendChild(elemname2);
			         
			         Element elemname3 = doc.createElement("bookYear");
			         elemname3.appendChild(doc.createTextNode(String.valueOf(((Books) us.get(i)).getYear())));
			         superelem.appendChild(elemname3);
		         }
		         if(name.equalsIgnoreCase("comments")) {
		        	 Element elemname2 = doc.createElement("MyUser");
			         elemname2.appendChild(doc.createTextNode(((Comments) us.get(i)).getUser()));
			         superelem.appendChild(elemname2);
			         
			         Element elemname3 = doc.createElement("Email");
			         elemname3.appendChild(doc.createTextNode(((Comments) us.get(i)).getEmail()));
			         superelem.appendChild(elemname3);
			         
			         Element elemname4 = doc.createElement("Webpage");
			         elemname4.appendChild(doc.createTextNode(((Comments) us.get(i)).getWebpage()));
			         superelem.appendChild(elemname4);
			         
			         Element elemname5 = doc.createElement("Date");
			         elemname5.appendChild(doc.createTextNode(((Comments) us.get(i)).getDate()));
			         superelem.appendChild(elemname5);
			         
			         Element elemname6 = doc.createElement("Comments");
			         elemname6.appendChild(doc.createTextNode(((Comments) us.get(i)).getComm()));
			         superelem.appendChild(elemname6);
			         
		         }
		       
		   }
	   }catch (Exception e) {
	         e.printStackTrace();
	      }
   }
	public static void main(String[] args) {
	    
	    ArrayList<Product> prod;
	    prod=JavaMysqlExample.AnyTable("product", new ArrayList<Product>());
	    
	    ArrayList<user> us;
	    us=JavaMysqlExample.AnyTable("user", new ArrayList<user>());
	    
	    ArrayList<Books> bk;
	    bk=JavaMysqlExample.AnyTable("books", new ArrayList<Books>());
	    
	    ArrayList<TableP> tabP;
	    tabP=JavaMysqlExample.AnyTable("p", new ArrayList<TableP>());
	    
	    ArrayList<Comments> comm;
	    comm=JavaMysqlExample.AnyTable("comments", new ArrayList<Comments>());
	      try {
	         DocumentBuilderFactory dbFactory =
	         DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.newDocument();
	         
	         // root element
	         Element rootElement = doc.createElement("Tables");
	         doc.appendChild(rootElement);
	         
	         CreateXMLFile.XMLFile(doc, rootElement, "product", prod);
	         CreateXMLFile.XMLFile(doc, rootElement, "user", us);
	         CreateXMLFile.XMLFile(doc, rootElement, "p",tabP );
	         CreateXMLFile.XMLFile(doc, rootElement, "comments", comm);
	         CreateXMLFile.XMLFile(doc, rootElement, "books", bk);
	        
	         // write the content into xml file
	         TransformerFactory transformerFactory = TransformerFactory.newInstance();
	         Transformer transformer = transformerFactory.newTransformer();
	         DOMSource source = new DOMSource(doc);
	         StreamResult result = new StreamResult(new File("xmlTables.xml"));
	         transformer.transform(source, result);
	         
	         // Output to console for testing
	         StreamResult consoleResult = new StreamResult(System.out);
	         transformer.transform(source, consoleResult);
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }

	
}
