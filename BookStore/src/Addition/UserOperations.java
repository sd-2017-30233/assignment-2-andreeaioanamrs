package Addition;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Model.Book;
import Model.User;

public class UserOperations {
	
    public static void addUser(User user) {
        Document doc = null;
        try {
            File xmlFile = new File("User.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(xmlFile);
            Element initialDoc = doc.getDocumentElement();
            Element element = doc.createElement("User");
            initialDoc.appendChild(element);

            Element username = doc.createElement("username");
            username.setTextContent(user.getUsername());
            element.appendChild(username);

            Element password = doc.createElement("password");
            password.setTextContent(user.getPassword());
            element.appendChild(password);
            
            Element name = doc.createElement("name");
            name.setTextContent(user.getName());
            element.appendChild(name);

            Element cnp = doc.createElement("cnp");
            cnp.setTextContent(user.getCNP());
            element.appendChild(cnp);

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource domSource = new DOMSource(doc);
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(domSource, new StreamResult(new File("User.xml")));
        } catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
            e.printStackTrace();
        }

    }

    public static void updateUser(String username,String name,String password) {
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new FileInputStream("User.xml"));

            NodeList nList = document.getElementsByTagName("User");
            for (int i = 0; i < nList.getLength(); i++) {
                if (nList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nList.item(i);
                    if (element.getElementsByTagName("username").item(0).getTextContent().equals(username)) {
                        element.getElementsByTagName("password").item(0).setTextContent(name);
                        element.getElementsByTagName("name").item(0).setTextContent(password);
                    }
                }
            }
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource domSource = new DOMSource(document);
            transformer.transform(domSource, new StreamResult(new File("User.xml")));
        } catch (ParserConfigurationException | IOException | SAXException | TransformerException e) {
            e.printStackTrace();
        }
    }

    public static void deleteUser(String username) {
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new FileInputStream("User.xml"));

            NodeList nList = document.getElementsByTagName("User");
            for (int i = 0; i < nList.getLength(); i++) {
                if (nList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nList.item(i);
                    if (element.getElementsByTagName("username").item(0).getTextContent().equals(username)) {
                        element.getParentNode().removeChild(element);
                    }
                }
            }
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource domSource = new DOMSource(document);
            transformer.transform(domSource, new StreamResult(new File("User.xml")));

        } catch (ParserConfigurationException | IOException | SAXException | TransformerException e) {
            e.printStackTrace();
        }
    }

	public static User getUser(String username) {
		try {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
		builder = builderFactory.newDocumentBuilder();
        Document document;
		document = builder.parse(new FileInputStream("User.xml"));

        NodeList nList = document.getElementsByTagName("User");
        for (int i = 0; i < nList.getLength(); i++) {
            if (nList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nList.item(i);
                if (element.getElementsByTagName("username").item(0).getTextContent().equals(username)) {
                    String p = element.getElementsByTagName("password").item(0).getTextContent();
                    String n = element.getElementsByTagName("name").item(0).getTextContent();
                    String cnp = element.getElementsByTagName("cnp").item(0).getTextContent();
            
           
    }}}} catch (ParserConfigurationException|SAXException | IOException  e) {
		// TODO Auto-generated catch block
		e.printStackTrace();}
	return null;}
	
}
