package mv.pojo;

public class Transaction {

	private long txnId;
	private String txnType;
	private double txnAmt, balance;

	private Account acnt;

	/**
	 * 
	 */
	public Transaction() {
		super();
	}

	/**
	 * @param txnType
	 * @param txnAmt
	 * @param balance
	 */
	public Transaction(String txnType, double txnAmt, double balance) {
		super();
		this.txnType = txnType;
		this.txnAmt = txnAmt;
		this.balance = balance;
	}

	public long getTxnId() {
		return txnId;
	}

	public void setTxnId(long txnId) {
		this.txnId = txnId;
	}

	public String getTxnType() {
		return txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public double getTxnAmt() {
		return txnAmt;
	}

	public void setTxnAmt(double txnAmt) {
		this.txnAmt = txnAmt;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Account getAcnt() {
		return acnt;
	}

	public void setAcnt(Account acnt) {
		this.acnt = acnt;
	}

}
