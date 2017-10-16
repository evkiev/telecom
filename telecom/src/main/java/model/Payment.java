package model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Payments")
public class Payment {

	@Id
	public int id;
	@Column(name = "PAYMENT_DATE")
	protected float amount;
	@Column(name = "PAYMENT_DATE")
	protected Date date;
	@ManyToOne
	@JoinColumn(name = "AbonentsID", foreignKey = @ForeignKey(name = "Payments-Abonents"))
	public Abonent abonent;

	public Payment(int id, Abonent abonent, float amount, Date date) {
		super();
		this.id = id;
		this.abonent = abonent;
		this.amount = amount;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Abonent getAbonent() {
		return abonent;
	}

	public void setAbonent(Abonent abonent) {
		this.abonent = abonent;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", amount=" + amount + ", date=" + date + ", abonent=" + abonent + "]";
	}

}