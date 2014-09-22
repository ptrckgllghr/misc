package mysterypackage;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class LibraryHandler extends DefaultHandler {

	private String fName;
	private String lname;

	private boolean isInsideTitle;
	private boolean isInsideFirstName;
	private boolean isInsideLastName;

	private String titleName;
	private String firstName;
	private String lastName;

	@Override
	public void startDocument() throws SAXException {
		
	}

	@Override
	public void endDocument() throws SAXException {
		

	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if (qName.equalsIgnoreCase("title"))
			isInsideTitle = true;
		if (qName.equalsIgnoreCase("first-name"))
			isInsideFirstName = true;
		if (qName.equalsIgnoreCase("last-name"))
			isInsideLastName = true;
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		
		if (qName.equalsIgnoreCase("book"))
		{
			if (fName.equalsIgnoreCase(firstName) && lname.equalsIgnoreCase(lastName))
				System.out.println(titleName + " by " + firstName + " " + lastName);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if (isInsideTitle) {
			titleName = new String(ch, start, length);
			isInsideTitle = false;
		}
		if (isInsideFirstName) {
			firstName = new String(ch, start, length);
			isInsideFirstName = false;
		}
		if (isInsideLastName) {
			lastName = new String(ch, start, length);
			isInsideLastName = false;
		}
	}

	public void setAuthor(String fName, String lname) {
		this.fName = fName;
		this.lname = lname;
	}

}
