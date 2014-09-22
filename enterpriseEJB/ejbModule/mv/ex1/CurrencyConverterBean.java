package mv.ex1;

import javax.ejb.Stateless;

import org.jboss.ejb3.annotation.RemoteBinding;

@Stateless
@RemoteBinding(jndiBinding="ejb/currency")
public class CurrencyConverterBean implements CurrencyConverter {

	@Override
	public double convert(double amount)
	{
		return amount * 62.50;
	}

}
