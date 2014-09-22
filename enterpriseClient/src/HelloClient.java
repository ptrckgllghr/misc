import javax.naming.Context;
import javax.naming.NamingException;

import mv.ex2.Hello;

public class HelloClient {
	
	public static void main(String[] args) throws NamingException {

		Context ctx = JBossContext.getContext();
		Hello h = (Hello) ctx.lookup("ejb/hello");
		System.out.println(h.sayHello("Kitty"));
	}

}
