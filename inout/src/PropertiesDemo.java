import java.io.FileInputStream;
import java.util.Properties;
import java.util.Set;


public class PropertiesDemo {

	public static void main (String[] args) throws Exception{
		FileInputStream fstream = new FileInputStream("src/test.properties");
		Properties p = new Properties();
		p.load(fstream);
		
		Set props = p.keySet();
		for (Object prop : props)
			System.out.println(prop.toString());
		
//		System.out.println(p.getProperty("name"));
//		System.out.println(p.getProperty("city"));
	}
}