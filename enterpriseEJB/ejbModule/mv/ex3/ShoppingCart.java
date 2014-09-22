package mv.ex3;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface ShoppingCart {
	void addItem(String item);
	List<String> getCart();
}
