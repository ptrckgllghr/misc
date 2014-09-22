import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {

	public static void main(String[] args) throws IOException {

		String file = "C:/sample.txt";

		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		writer.write("This is a sample file");
		writer.newLine();
		writer.write("I hope you enjoy this");
		writer.newLine();
		writer.write("Show me how can you append this file");
		
		writer.close();
	}
}
