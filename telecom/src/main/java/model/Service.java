package model;

import java.util.LinkedList;

import javax.persistence.*;

@Entity
@Table(name = "Services")
public class Service {

	@Id
	private int id;
	@Column(name = "SERVICE_NAME")
	private String service_name;
	@Column(name = "SERVICE_PAYROLL")
	private float service_payroll;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "service")
	public LinkedList<Event> events = new LinkedList<Event>();
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "service")
	public LinkedList<CustomerService> customerServices = new LinkedList<CustomerService>();
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "service")
	public LinkedList<UserAction> userAction = new LinkedList<UserAction>();

	public Service(int id, String service_name, float service_payroll, LinkedList<Event> events,
			LinkedList<CustomerService> customerServices, LinkedList<UserAction> userAction) {
		super();
		this.id = id;
		this.service_name = service_name;
		this.service_payroll = service_payroll;
		this.events = events;
		this.customerServices = customerServices;
		this.userAction = userAction;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getService_name() {
		return service_name;
	}

	public void setService_name(String service_name) {
		this.service_name = service_name;
	}

	public float getService_payroll() {
		return service_payroll;
	}

	public void setService_payroll(float service_payroll) {
		this.service_payroll = service_payroll;
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

	public LinkedList<UserAction> getUserAction() {
		return userAction;
	}

	public void setUserAction(LinkedList<UserAction> userAction) {
		this.userAction = userAction;
	}

	@Override
	public String toString() {
		return "Service [id=" + id + ", service_name=" + service_name + ", service_payroll=" + service_payroll
				+ ", events=" + events + ", customerServices=" + customerServices + ", userAction=" + userAction + "]";
	}

}