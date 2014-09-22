import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import mv.ex1.CurrencyConverter;

public class CurrencyClient {
	public static void main(String[] args) throws NamingException {
		Properties p = new Properties();
		// JBoss specific JND& Protocol details
		p.put(Context.INITIAL_CONTEXT_FACTORY,
				"org.jnp.interfaces.NamingContextFactory");
		p.put(Context.PROVIDER_URL, "jnp://localhost:1099");

		// Weblogic specific JNDI & Protocol details
		// p.put(Context.INITIAL_CONTEXT_FACTORY,
		// "weblogic.jndi.WLInitialContextFactory");
		// p.put(Context.PROVIDER_URL, "t3://localhost:7001");

		Context ctx = new InitialContext(p);
		CurrencyConverter cc = (CurrencyConverter) ctx.lookup("ejb/currency");
		System.out.println("Result: " + cc.convert(100));
	}
}
