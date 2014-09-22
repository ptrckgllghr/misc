

public final class Stock implements Exchange{
	
	private double quote;
	private String name;
	
	public Stock(String name, double quote)
	{
		this.name = name;
		this.quote = quote;
	}
	
	public void viewQuote()
	{
		System.out.println("Stock Quote:  " + quote);
	}
	
	public double getQuote()
	{
		return quote;
	}
	
	public void setQuote(double newQuote)
	{
		quote = newQuote;
	}
}
