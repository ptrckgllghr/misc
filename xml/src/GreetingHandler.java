import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class GreetingHandler extends DefaultHandler {

	@Override
	public void startDocument() throws SAXException {
		System.out.println("Document started...");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("Document ends...");
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println(qName + "starts");
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		System.out.println(qName + " ends");
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		String str = new String(ch, start, length);
		if(str.trim().length() > 0)
			System.out.println(str);
	}
	
	

}
