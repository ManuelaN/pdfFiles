package domParserXML;
import java.util.ArrayList;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class ParserXML {
	
	public static void ParserXml(Document doc, String name){
		
		 NodeList nList = doc.getElementsByTagName(name.toLowerCase());
	        System.out.println("----------------------------");
		for (int temp = 0; temp < nList.getLength(); temp++) {
	           Node nNode = nList.item(temp);
	           System.out.println("\nCurrent Element :" + nNode.getNodeName());
	           
	           if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	              Element eElement = (Element) nNode;
	              System.out.println("User id: " + eElement.getAttribute("ID"));
	              
	              if(!(name.equalsIgnoreCase("comments"))) {
	                System.out.println("Name : " + eElement.getElementsByTagName("Name").item(0).getTextContent());
	         
	              }if(name.equalsIgnoreCase("user")) {
	                System.out.println("Role : " + eElement.getElementsByTagName("Role").item(0).getTextContent());
	                
	              }if(name.equalsIgnoreCase("books")) {
	                 System.out.println("Author : " + eElement.getElementsByTagName("Author").item(0).getTextContent());
	                
	                 System.out.println("Book Year : " + eElement.getElementsByTagName("Book Year").item(0).getTextContent());
	                 	              }
	              if(name.equalsIgnoreCase("product") || name.equalsIgnoreCase("p")) {
	            	  System.out.println("Quantity: : " + eElement.getElementsByTagName("Quantity").item(0).getTextContent());
	            	  
	              }if(name.equalsIgnoreCase("comments")) {
	            	  System.out.println("MyUser: : " + eElement.getElementsByTagName("MyUser").item(0).getTextContent());
	            	  System.out.println("Email: : " + eElement.getElementsByTagName("Email").item(0).getTextContent());
	            	  System.out.println("Webpage: : " + eElement.getElementsByTagName("Webpage").item(0).getTextContent());
	            	  System.out.println("Date: : " + eElement.getElementsByTagName("Date").item(0).getTextContent());
	            	  System.out.println("Comments: : " + eElement.getElementsByTagName("Comments").item(0).getTextContent());
	            	 
	              }
	           }
	         
	        }
		
		
	}
	
	public static void main(String[] args) {
	try {
        File inputFile = new File("xmlTables.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
        
        ParserXML.ParserXml(doc, "user");
        
        
     } catch (Exception e) {
        e.printStackTrace();
     }
}
}
