package mysterypackage;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class LibrarySaxParser {

	public static void main(String[] args) throws Exception {
		String path = "library.xml";
		LibraryHandler handler = new LibraryHandler();
		handler.setAuthor("Kathy", "Sierra");
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		parser.parse(path, handler);
	}
}