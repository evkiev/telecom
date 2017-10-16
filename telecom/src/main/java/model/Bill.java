package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Bills")
public class Bill {

	@Id
	private int id;
	@Column(name = "BILL_START_NAME")
	private int bill_start_date;
	@Column(name = "BILL_END_NAME")
	private int bill_end_date;
	@Column(name = "BILL_AMOUNT")
	private int bill_amount;
	@ManyToOne
	@JoinColumn(name = "AbonentsID", foreignKey = @ForeignKey(name = "Bills-Abonents"))
	public Abonent abonent;

	public Bill(int id, int bill_start_date, int bill_end_date, int bill_amount, Abonent abonent) {
		super();
		this.id = id;
		this.bill_start_date = bill_start_date;
		this.bill_end_date = bill_end_date;
		this.bill_amount = bill_amount;
		this.abonent = abonent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBill_start_date() {
		return bill_start_date;
	}

	public void setBill_start_date(int bill_start_date) {
		this.bill_start_date = bill_start_date;
	}

	public int getBill_end_date() {
		return bill_end_date;
	}

	public void setBill_end_date(int bill_end_date) {
		this.bill_end_date = bill_end_date;
	}

	public int getBill_amount() {
		return bill_amount;
	}

	public void setBill_amount(int bill_amount) {
		this.bill_amount = bill_amount;
	}

	public Abonent getAbonent() {
		return abonent;
	}

	public void setAbonent(Abonent abonent) {
		this.abonent = abonent;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", bill_start_date=" + bill_start_date + ", bill_end_date=" + bill_end_date
				+ ", bill_amount=" + bill_amount + ", abonent=" + abonent + "]";
	}

}