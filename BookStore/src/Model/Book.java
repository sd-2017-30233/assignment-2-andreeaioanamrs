package Model;
public class Book {
	String title,author,genre;
	int quantity;
	double price;
	public Book (String Title,String Author, String Genre,int Quantity,double Price){
		this.title = Title;
		this.author = Author;
		this.genre = Genre;
		this.quantity = Quantity;
		this.price = Price;
	}
	
    public String getTitle() {
        return title;
    }

    public void setTitle(String Title) {
        this.title = Title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String Author) {
        this.author = Author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String Genre) {
        this.genre = Genre;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int Quantity) {
        this.quantity = Quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double Price) {
        this.price = Price;
    }
	
    public String prettyPrint(){
    	return title+" "+author+" "+genre+" "+quantity+" "+price;
    }
  
}
