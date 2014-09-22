import mv.annotation.BankingService;

public class BankAnnotationTest {

	public static void main(String[] args) {
		BankingService service = BankingService.getService();
		service.openAccount("Hank Schraeder", 8000);
		service.depositAmount(4, 300);
		service.withdrawAmount(4, 1000);
	}
}
