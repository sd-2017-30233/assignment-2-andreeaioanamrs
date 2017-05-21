package Addition;

public class ReportFactory {
public static Report makeReport(String type){
	if (type.equalsIgnoreCase("PDF")) return new PDF();
	if (type.equalsIgnoreCase("CSV")) return new CSV();
	return null;
}
}
