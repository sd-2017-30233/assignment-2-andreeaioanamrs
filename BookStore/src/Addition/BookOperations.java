package Addition;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

public class BookOperations {
    public static void addBook(Book book) {
        try {
        	 DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
             DocumentBuilder builder = builderFactory.newDocumentBuilder();
             Document document = builder.parse(new FileInputStream("Book.xml"));
            Element initialDoc = document.getDocumentElement();
            Element element = document.createElement("Book");
            initialDoc.appendChild(element);

            Element t = document.createElement("title");
            t.setTextContent(book.getTitle());
            element.appendChild(t);

            Element a = document.createElement("author");
            a.setTextContent(book.getAuthor());
            element.appendChild(a);

            Element g = document.createElement("genre");
            g.setTextContent(book.getGenre());
            element.appendChild(g);

            Element q = document.createElement("quantity");
            q.setTextContent(String.valueOf(book.getQuantity()));
            element.appendChild(q);

            Element p = document.createElement("price");
            p.setTextContent(String.valueOf(book.getPrice()));
            element.appendChild(p);

            Transformer tr = TransformerFactory.newInstance().newTransformer();
            DOMSource domSource = new DOMSource(document);;
            tr.transform(domSource, new StreamResult(new File("Book.xml")));
        } catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
            e.printStackTrace();
        }
    }
    
    public static void deleteBook(String title) {
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new FileInputStream("Book.xml"));

            NodeList nList = document.getElementsByTagName("Book");
            for (int i = 0; i < nList.getLength(); i++) {
                if (nList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nList.item(i);
                    if (element.getElementsByTagName("title").item(0).getTextContent().equals(title)) {
                        element.getParentNode().removeChild(element);
                    }
                }
            }
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource domSource = new DOMSource(document);
            transformer.transform(domSource, new StreamResult(new File("Book.xml")));

        } catch (ParserConfigurationException | IOException | SAXException | TransformerException e) {
            e.printStackTrace();
        }
    }

    public static void updateBook(String title,String author,String quantity,String price) {
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new FileInputStream("Book.xml"));

            NodeList nList = document.getElementsByTagName("Book");
            for (int i = 0; i < nList.getLength(); i++) {
                if (nList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nList.item(i);
                    if (element.getElementsByTagName("title").item(0).getTextContent().equals(title) && element.getElementsByTagName("author").item(0).getTextContent().equals(author)) {
                        element.getElementsByTagName("quantity").item(0).setTextContent(quantity);
                        element.getElementsByTagName("price").item(0).setTextContent(price);
                    }
                }
            }
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource domSource = new DOMSource(document);
            transformer.transform(domSource, new StreamResult(new File("Book.xml")));

        } catch (ParserConfigurationException | IOException | SAXException | TransformerException e) {
            e.printStackTrace();
        }

    }
  
    public static List<Book> searchByGenre(String genre) {
        List<Book> booksGenre = new ArrayList<>();
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new FileInputStream("Book.xml"));
            NodeList nList = document.getElementsByTagName("Book");
            for (int i = 0; i < nList.getLength(); i++) {
                if (nList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nList.item(i);
                    if (element.getElementsByTagName("genre").item(0).getTextContent().equals(genre)) {
                        String t = element.getElementsByTagName("title").item(0).getTextContent();
                        String a = element.getElementsByTagName("author").item(0).getTextContent();
                        String g = element.getElementsByTagName("genre").item(0).getTextContent();
                        String q = element.getElementsByTagName("quantity").item(0).getTextContent();
                        String p = element.getElementsByTagName("price").item(0).getTextContent();
                        int quantity = Integer.parseInt(q);
                        double price = Double.parseDouble(p);
                        booksGenre.add(new Book(t,a,g,quantity,price));
                    }
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return booksGenre;
    }
    
    public static ArrayList<Book> searchByTitle(String title) {
        ArrayList<Book> books = new ArrayList<>();
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new FileInputStream("Book.xml"));
            NodeList nList = document.getElementsByTagName("Book");
            for (int i = 0; i < nList.getLength(); i++) {
                if (nList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nList.item(i);
                    if (element.getElementsByTagName("title").item(0).getTextContent().equals(title)) {
                        String t = element.getElementsByTagName("title").item(0).getTextContent();
                        String a = element.getElementsByTagName("author").item(0).getTextContent();
                        String g = element.getElementsByTagName("genre").item(0).getTextContent();
                        String q = element.getElementsByTagName("quantity").item(0).getTextContent();
                        String p = element.getElementsByTagName("price").item(0).getTextContent();
                        int quantity = Integer.parseInt(q);
                        double price = Double.parseDouble(p);
                        books.add(new Book(t,a,g,quantity,price));
                    }
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return books;
    }

    public static ArrayList<Book> searchByAuthor(String author) {
        ArrayList<Book> books = new ArrayList<>();
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new FileInputStream("Book.xml"));
            NodeList nList = document.getElementsByTagName("Book");
            for (int i = 0; i < nList.getLength(); i++) {
                if (nList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nList.item(i);
                    if (element.getElementsByTagName("author").item(0).getTextContent().equals(author)) {
                        String t = element.getElementsByTagName("title").item(0).getTextContent();
                        String a = element.getElementsByTagName("author").item(0).getTextContent();
                        String g = element.getElementsByTagName("genre").item(0).getTextContent();
                        String q = element.getElementsByTagName("quantity").item(0).getTextContent();
                        String p = element.getElementsByTagName("price").item(0).getTextContent();
                        int quantity = Integer.parseInt(q);
                        double price = Double.parseDouble(p);
                       
                        books.add(new Book(t,a,g,quantity,price));
                    }
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return books;
    }
    
    public static void sell(Book book,int quantity,String username) {
        try {
            List<Book> books = searchByTitle(book.getTitle());
            for (Book itr : books) {
                if (itr.getQuantity() >= quantity) {
                    itr.setQuantity(itr.getQuantity() - quantity);
                    updateBook(itr.getAuthor(),itr.getAuthor(),String.valueOf(itr.getQuantity()),String.valueOf(itr.getPrice()));

                    DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder builder = builderFactory.newDocumentBuilder();
                    Document document = builder.parse(new FileInputStream("For sale.xml"));
                    Element initialDoc = document.getDocumentElement();
                    Element element = document.createElement("Sell");
                    initialDoc.appendChild(element);

                    Element t = document.createElement("title");
                    t.setTextContent(itr.getTitle());
                    element.appendChild(t);

                    Element a = document.createElement("author");
                    a.setTextContent(itr.getAuthor());
                    element.appendChild(a);

                    Element g = document.createElement("genre");
                    g.setTextContent(itr.getGenre());
                    element.appendChild(g);

                    Element q = document.createElement("quantity");
                    q.setTextContent(String.valueOf(quantity));
                    element.appendChild(q);

                    Element p = document.createElement("price");
                    p.setTextContent(String.valueOf(itr.getPrice()));
                    element.appendChild(p);

                    Element s = document.createElement("soldBy");
                    s.setTextContent(username);
                    element.appendChild(p);
                    
                    Transformer transformer = TransformerFactory.newInstance().newTransformer();
                    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                    transformer.transform(new DOMSource(document), new StreamResult(new File("For sale.xml")));
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException | TransformerException e) {
            e.printStackTrace();
        }
    }
    
    public static ArrayList<Book> outOfStock(){
        ArrayList<Book> books = new ArrayList<>();
        try
        {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new FileInputStream("Book.xml"));

            NodeList nodeList = document.getElementsByTagName("Book");

            for (int i = 0; i < nodeList.getLength(); i++) {
                if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodeList.item(i);
                    if(element.getElementsByTagName("quantity").item(0).getTextContent().equals("0"))
                    {
                        String t = element.getElementsByTagName("title").item(0).getTextContent();
                        String a = element.getElementsByTagName("author").item(0).getTextContent();
                        String g = element.getElementsByTagName("genre").item(0).getTextContent();
                        String q = element.getElementsByTagName("quantity").item(0).getTextContent();
                        String p = element.getElementsByTagName("price").item(0).getTextContent();
                        int quantity = Integer.parseInt(q);
                        double price = Double.parseDouble(p);
                        books.add(new Book(t,a,g,quantity,price));
                    }
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return books;
    }
	public static ArrayList<Book> getBooks() {
	       ArrayList<Book> books = new ArrayList<>();
	        try
	        {
	            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder builder = builderFactory.newDocumentBuilder();
	            Document document = builder.parse(new FileInputStream("Book.xml"));

	            NodeList nodeList = document.getElementsByTagName("Book");

	            for (int i = 0; i < nodeList.getLength(); i++) {
	                if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
	                    Element element = (Element) nodeList.item(i);
	                        String t = element.getElementsByTagName("title").item(0).getTextContent();
	                        String a = element.getElementsByTagName("author").item(0).getTextContent();
	                        String g = element.getElementsByTagName("genre").item(0).getTextContent();
	                        String q = element.getElementsByTagName("quantity").item(0).getTextContent();
	                        String p = element.getElementsByTagName("price").item(0).getTextContent();
	                        int quantity = Integer.parseInt(q);
	                        double price = Double.parseDouble(p);
	                        books.add(new Book(t,a,g,quantity,price));
	                }
	            }
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	        return books;
	}
}
