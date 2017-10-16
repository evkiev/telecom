package model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "UserActions")
public class UserAction {

	@Id
	private int id;
	@Column(name = "ACTION_DATE")
	private Date action_date;
	@Column(name = "ACTION_COMMENT")
	private String action_comment;
	@ManyToOne
	@JoinColumn(name = "UsersID", foreignKey = @ForeignKey(name = "UserActions-Users"))
	public User user;
	@ManyToOne
	@JoinColumn(name = "ServicesID", foreignKey = @ForeignKey(name = "UserActions-Services"))
	public Service service;
	@ManyToOne
	@JoinColumn(name = "OperationsID", foreignKey = @ForeignKey(name = "UserActions-Operations"))
	public Operation operation;

	public UserAction(int id, Date action_date, String action_comment, User user, Service service,
			Operation operation) {
		super();
		this.id = id;
		this.action_date = action_date;
		this.action_comment = action_comment;
		this.user = user;
		this.service = service;
		this.operation = operation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getAction_date() {
		return action_date;
	}

	public void setAction_date(Date action_date) {
		this.action_date = action_date;
	}

	public String getAction_comment() {
		return action_comment;
	}

	public void setAction_comment(String action_comment) {
		this.action_comment = action_comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	@Override
	public String toString() {
		return "UserAction [id=" + id + ", action_date=" + action_date + ", action_comment=" + action_comment
				+ ", user=" + user + ", service=" + service + ", operation=" + operation + "]";
	}

}