import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;


public class EmployeeDomParser {

	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException {
		String path = "employee.xml";
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		Document doc = builder.parse(path);
		Node org = doc.getFirstChild();
		Node emp = org.getFirstChild();
		while (emp != null) {
			if (emp.getNodeType() != Node.TEXT_NODE)
				parseEmp(emp.getFirstChild());
			emp = emp.getNextSibling();
		}
	}

	private static void parseEmp(Node child) {
		while (child != null) {
			if (child.getNodeType() != Node.TEXT_NODE) {
				System.out.print(child.getNodeName() + ": ");
				printValue(child.getFirstChild());
			}
			child = child.getNextSibling();
		}
	}

	private static void printValue(Node child)
	{
		String value = child.getNodeValue();
		if (value.trim().length() > 0)
			System.out.println(value);
	}
}
