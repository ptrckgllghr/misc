package mv.ex1;
import javax.ejb.Remote;

@Remote
public interface CurrencyConverter {
	
	double convert(double amount);

}
