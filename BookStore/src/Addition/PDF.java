package Addition;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import Model.Book;

public class PDF implements Report {

	@Override
	public void generateReport() throws FileNotFoundException, DocumentException {
		System.out.println("bdksjfhea");
		Document document = new Document();
        List<Book> booksOutOfStock = BookOperations.outOfStock();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("pdfReport.pdf"));
        document.open();
        document.add(new Paragraph("Books Out of stock"));
        for(int i=0;i<booksOutOfStock.size();i++) 
            document.add(new Paragraph(booksOutOfStock.get(i).getTitle()+" by "+booksOutOfStock.get(i).getAuthor()));
        document.close();
        writer.close();
	}

}
