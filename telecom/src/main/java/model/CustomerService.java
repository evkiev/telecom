package model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "customerservices")
public class CustomerService {

	@Id
	private int id;
	@Column(name = "SERVICE_START_DATE")
	private Date service_start_date;
	@Column(name = "SERVICE_END_DATE")
	private Date service_end_date;
	@ManyToOne
	@JoinColumn(name = "ServicesID", foreignKey = @ForeignKey(name = "CustomerServices-Services"))
	public Service service;
	@ManyToOne
	@JoinColumn(name = "AbonentsID", foreignKey = @ForeignKey(name = "CustomerServices-Abonents"))
	public Abonent abonent;
	@ManyToOne
	@JoinColumn(name = "ServiceStatusID", foreignKey = @ForeignKey(name = "CustomerServices-ServiceStatus"))
	public ServiceStatus serviceStatus;

	public CustomerService(int id, Date service_start_date, Date service_end_date, Service service, Abonent abonent,
			ServiceStatus serviceStatus) {
		super();
		this.id = id;
		this.service_start_date = service_start_date;
		this.service_end_date = service_end_date;
		this.service = service;
		this.abonent = abonent;
		this.serviceStatus = serviceStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getService_start_date() {
		return service_start_date;
	}

	public void setService_start_date(Date service_start_date) {
		this.service_start_date = service_start_date;
	}

	public Date getService_end_date() {
		return service_end_date;
	}

	public void setService_end_date(Date service_end_date) {
		this.service_end_date = service_end_date;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Abonent getAbonent() {
		return abonent;
	}

	public void setAbonent(Abonent abonent) {
		this.abonent = abonent;
	}

	public ServiceStatus getServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(ServiceStatus serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

	@Override
	public String toString() {
		return "CustomerService [id=" + id + ", service_start_date=" + service_start_date + ", service_end_date="
				+ service_end_date + ", service=" + service + ", abonent=" + abonent + ", serviceStatus="
				+ serviceStatus + "]";
	}

}