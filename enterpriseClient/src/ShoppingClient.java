import javax.naming.Context;
import javax.naming.NamingException;

import mv.ex3.ShoppingCart;

public class ShoppingClient {

	public static void main(String[] args) throws NamingException {
		
		Context ctx = JBossContext.getContext();
		ShoppingCart sc = (ShoppingCart) ctx.lookup("ejb/cart");
		sc.addItem("nothing");
		sc.addItem("of");
		sc.addItem("value");
		
		for (String item : sc.getCart())
			System.out.print(item + ", ");
	}
}
