package mysterypackage;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class EmployeeHandler extends DefaultHandler {
	private boolean isSalary;
	private double totalSalary;
	private int countEmp;

	@Override
	public void endDocument() throws SAXException {
		System.out.println("Employee Count: " + countEmp);
		System.out.println("Total Salary: " + totalSalary);
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if (qName.equalsIgnoreCase("employee"))
			countEmp++;
		if (qName.equalsIgnoreCase("salary"))
			isSalary = true;
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if (isSalary) {
			String sal = new String(ch, start, length);
			totalSalary += Double.parseDouble(sal);
			isSalary = false;
		}
	}
}
