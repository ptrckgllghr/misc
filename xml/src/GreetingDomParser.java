import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;


public class GreetingDomParser {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		String path = "greeting.xml";
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document doc = builder.parse(path);
		Node root = doc.getFirstChild();
		System.out.println(root.getNodeName());
		
		Node person = root.getFirstChild().getNextSibling();
		System.out.println(person.getNodeName());
		System.out.println(person.getFirstChild().getNodeValue());
		
		Node message = person.getNextSibling().getNextSibling();
		System.out.println(message.getNodeName());
		System.out.println(message.getFirstChild().getNodeValue());
	}
}
