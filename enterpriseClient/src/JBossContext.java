import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JBossContext {
	public static Context getContext() throws NamingException {
		Properties p = new Properties();
		// JBoss specific JND& Protocol details
		p.put(Context.INITIAL_CONTEXT_FACTORY,
				"org.jnp.interfaces.NamingContextFactory");
		p.put(Context.PROVIDER_URL, "jnp://localhost:1099");

		return new InitialContext(p);
	}
}
