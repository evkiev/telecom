package model;

import java.util.LinkedList;

import javax.persistence.*;


@Entity
@Table(name = "Abonents")
public class Abonent {
 
	@Id
	private int id;
	@Column(name = "NAME")
	protected String name;
	@Column(name = "ABONENT_INN")
	private int inn;
	@Column(name = "ABONENT_BALANCE")
	private int balance;
	@Column(name = "ABONENT_ACTIVATED")
	private int activated;
	@Column(name = "ABONENT_DEACTIVATED")
	private int deactivated;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "abonent")
	public LinkedList<Payment> payments = new LinkedList<Payment>();
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "abonent")
	public LinkedList<Bill> bills = new LinkedList<Bill>();
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "abonent")
	public LinkedList<Event> events = new LinkedList<Event>();
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "abonent")
	public LinkedList<CustomerService> customerServices = new LinkedList<CustomerService>();

	public Abonent(int id, String name, int abonent_inn, int abonent_balance, int abonent_activated,
			int abonent_deactivated) {
		super();
		this.id = id;
		this.name = name;
		this.inn = abonent_inn;
		this.balance = abonent_balance;
		this.activated = abonent_activated;
		this.deactivated = abonent_deactivated;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getInn() {
		return inn;
	}

	public void setInn(int inn) {
		this.inn = inn;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getActivated() {
		return activated;
	}

	public void setActivated(int activated) {
		this.activated = activated;
	}

	public int getDeactivated() {
		return deactivated;
	}

	public void setDeactivated(int deactivated) {
		this.deactivated = deactivated;
	}

	public LinkedList<Payment> getPayments() {
		return payments;
	}

	public void setPayments(LinkedList<Payment> payments) {
		this.payments = payments;
	}

	public LinkedList<Bill> getBills() {
		return bills;
	}

	public void setBills(LinkedList<Bill> bills) {
		this.bills = bills;
	}

	public LinkedList<Event> getEvents() {
		return events;
	}

	public void setEvents(LinkedList<Event> events) {
		this.events = events;
	}

	public LinkedList<CustomerService> getCustomerServices() {
		return customerServices;
	}

	public void setCustomerServices(LinkedList<CustomerService> customerServices) {
		this.customerServices = customerServices;
	}

	@Override
	public String toString() {
		return "Abonent [id=" + id + ", name=" + name + ", inn=" + inn + ", balance=" + balance + ", activated="
				+ activated + ", deactivated=" + deactivated + ", payments=" + payments + ", bills=" + bills
				+ ", events=" + events + ", customerServices=" + customerServices + "]";
	}

}