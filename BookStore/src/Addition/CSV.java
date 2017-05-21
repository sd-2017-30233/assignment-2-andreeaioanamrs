package Addition;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import Model.Book;

public class CSV implements Report {

	@Override
	public void generateReport() throws Exception {
		 	FileWriter fileWriter = null;
	        List<Book> booksOutOfStock = BookOperations.outOfStock();
	        final String Delimiter = "---";
	        final String Separator = "\n";
	        final String Header = "title---author---gender";
	        fileWriter = new FileWriter("reportCSV.csv");
	        fileWriter.append(Header);
	        fileWriter.append(Separator);
	            for (Book itr : booksOutOfStock) {
	                fileWriter.append(itr.getTitle());
	                fileWriter.append(Delimiter);
	                fileWriter.append(itr.getAuthor());
	                fileWriter.append(Delimiter);
	                fileWriter.append(itr.getGenre());
	                fileWriter.append(Separator);
	            	}
	            fileWriter.close();
	}
}
