package mv.ex3;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;

import org.jboss.ejb3.annotation.RemoteBinding;

/**
 * Session Bean implementation class ShoppingCartBean
 */
@Stateful
@RemoteBinding(jndiBinding="ejb/cart")
public class ShoppingCartBean implements ShoppingCart {

    private ArrayList<String> cart;
    
    public ShoppingCartBean()
    {
    	cart = new ArrayList<String>();
    }

	@Override
	public void addItem(String item) {
		cart.add(item);
		
	}

	@Override
	public List<String> getCart() {
		return cart;
	}

}
