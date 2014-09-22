package mv.annotation;

public class BalanceException extends Exception {
    private static final long serialVersionUID = 1L;

    public BalanceException() {
    }

    public BalanceException(String message) {
	super(message);
    }
}