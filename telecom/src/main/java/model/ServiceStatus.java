package model;

import java.util.LinkedList;


import javax.persistence.*;

@Entity
@Table(name = "ServiceStatus")
public class ServiceStatus {
	@Id
	private int id;
	@Column(name = "SERVICE_STATUSNAME")
	private String service_statusname;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "serviceStatus")
	public LinkedList<CustomerService> customerServices = new LinkedList<CustomerService>();

	public ServiceStatus(int id, String service_statusname, LinkedList<CustomerService> customerServices) {
		super();
		this.id = id;
		this.service_statusname = service_statusname;
		this.customerServices = customerServices;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getService_statusname() {
		return service_statusname;
	}

	public void setService_statusname(String service_statusname) {
		this.service_statusname = service_statusname;
	}

	public LinkedList<CustomerService> getCustomerServices() {
		return customerServices;
	}

	public void setCustomerServices(LinkedList<CustomerService> customerServices) {
		this.customerServices = customerServices;
	}

	@Override
	public String toString() {
		return "ServiceStatus [id=" + id + ", service_statusname=" + service_statusname + ", customerServices="
				+ customerServices + "]";
	}

}