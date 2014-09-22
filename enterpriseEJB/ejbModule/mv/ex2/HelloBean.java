package mv.ex2;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.jboss.ejb3.annotation.RemoteBinding;

@Stateless
@RemoteBinding(jndiBinding="ejb/hello")
@Remote(Hello.class)
public class HelloBean implements Hello {

	@Override
	public String sayHello(String name)
	{
		return "Hello " + name;
	}
}
 