import java.io.BufferedReader;
import java.io.FileReader;


public class FileReaderDemo {
	public static void main(String[] args) throws Exception {
		String file = "C:/hello.txt";
		
		FileReader fr = new FileReader(file);
		BufferedReader reader = new BufferedReader(fr);
		
		String line = null;
		while (true) {
			line = reader.readLine();
			if(line == null)
				break;
			System.out.println(line);
		}
		reader.close();
	}
}
