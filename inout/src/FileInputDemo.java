import java.io.FileInputStream;
import java.io.IOException;

public class FileInputDemo {

	public static void main(String[] args) throws IOException {
		String path = "C:/hello.txt";

		FileInputStream istream = new FileInputStream(path);
//		int ch = 0;
//		while (true) {
//			ch = istream.read();
//			if (ch == -1)
//				break;
//			System.out.print((char)ch);
//		}
		
		byte[] bar = new byte[istream.available()];
		istream.read(bar);
		String output = new String(bar);
		System.out.println(output);
		istream.close();
	}
}
