import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class SerializationDemo {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		String file = "C:/pers.dat";
		
		Person p = new Person("Polo", 21);
		
		//Writing object to File Stream
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream ostream = new ObjectOutputStream(fos);
		
		//Serializng object
		ostream.writeObject(p);
		ostream.close();
		
		//Reading object from file stream
		ObjectInputStream istream = new ObjectInputStream(new FileInputStream(file));
		//deserializing object
		Object obj = istream.readObject();
		System.out.println(obj);
		istream.close();
	}

}
