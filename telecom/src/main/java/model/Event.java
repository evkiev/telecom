package model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Events")
public class Event {

	@Id
	private int id;
	@Column(name = "EVENT_DATE")
	private Date event_date;
	@Column(name = "EVENT_COST")
	private float event_cost;
	@ManyToOne
	@JoinColumn(name = "AbonentsID", foreignKey = @ForeignKey(name = "Events-Abonents"))
	public Abonent abonent;
	@ManyToOne
	@JoinColumn(name = "ServicesID", foreignKey = @ForeignKey(name = "Events-Services"))
	public Service service;

	public Event(int id, Date event_date, float event_cost, Abonent abonent, Service service) {
		super();
		this.id = id;
		this.event_date = event_date;
		this.event_cost = event_cost;
		this.abonent = abonent;
		this.service = service;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getEvent_date() {
		return event_date;
	}

	public void setEvent_date(Date event_date) {
		this.event_date = event_date;
	}

	public float getEvent_cost() {
		return event_cost;
	}

	public void setEvent_cost(float event_cost) {
		this.event_cost = event_cost;
	}

	public Abonent getAbonent() {
		return abonent;
	}

	public void setAbonent(Abonent abonent) {
		this.abonent = abonent;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", event_date=" + event_date + ", event_cost=" + event_cost + ", abonent=" + abonent
				+ ", service=" + service + "]";
	}

}