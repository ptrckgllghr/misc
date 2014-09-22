package mv.annotation;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="transaction")
@SequenceGenerator(name="txnSeq", sequenceName="TXN_SEQ")
public class Transaction {
    @Id
    @GeneratedValue(generator="txnSeq")
    @Column(name="txn_id")
    private long txnId;
	
    @Column(name="txn_type", length=20)
    private String type;
	
    @Column(name="txn_date")
    @Temporal(TemporalType.DATE)
    private Date txnDate;
	
    private double amount;
    private double balance;
	
    @ManyToOne
    @JoinColumn(name="acnt_no")
    private Account acnt;
	
    // default constructor
    public Transaction() {
    }
	
    // parameterized constructor
    public Transaction(String type, double amount, double balance) {
	this.type = type;
	this.amount = amount;
	this.balance = balance;
        // Storing current date with this method for instantiating transaction date
	this.txnDate = new Date(System.currentTimeMillis());
    }

	public long getTxnId() {
		return txnId;
	}

	public void setTxnId(long txnId) {
		this.txnId = txnId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getTxnDate() {
		return txnDate;
	}

	public void setTxnDate(Date txnDate) {
		this.txnDate = txnDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
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
