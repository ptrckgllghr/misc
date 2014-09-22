import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PersonReflection {

	public static void main(String args[]) throws ClassNotFoundException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException
	{
		//Person p = new Person();
		//Class pc = p.getClass();
		Class pc = Class.forName("Person");
		Object obj = null;
		
		Constructor[] constructors = pc.getConstructors();
		
		for (int i = 0; i < constructors.length; i++)
		{
			if(constructors[i].getParameterTypes().length > 0)
				obj = constructors[i].newInstance("Dude", 190);
		}
		
		//Object p2 = constructors[1].newInstance("Dude", 120);
		
		Method m = pc.getDeclaredMethod("print", null);
		m.setAccessible(true);
		m.invoke(obj, null);
		
		try {
			Object p3 = Class.forName("Person").getDeclaredMethod("print", null);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(p2.toString());
		
		Method[] methods = pc.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++)
		{
			System.out.println(i + 1 + " " + methods[i]);
		}
		
		Field[] fields = pc.getDeclaredFields();
		for (int i = 0; i < fields.length; i++)
		{
			System.out.println(i + 1 + " " + fields[i]);
		}
	}
}
