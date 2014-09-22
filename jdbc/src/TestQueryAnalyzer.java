
public class TestQueryAnalyzer {

	public static void main(String[] args) {
		QueryAnalyzer.executeQuery("select * from person");
		
		QueryAnalyzer.executeQuery("select * from dept");
		
		QueryAnalyzer.executeQuery("select * from emp");
		
		QueryAnalyzer.executeQuery("select * from customer");
		
	}
}
