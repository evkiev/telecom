package model;

import java.util.LinkedList;

import javax.persistence.*;

@Entity
@Table(name = "Operations")
public class Operation {

	@Id
	private int id;
	@Column(name = "OPERATION_DESCRIPTION")
	private String operation_description;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "operation")
	public LinkedList<UserAction> userAction = new LinkedList<UserAction>();

	public Operation(int id, String operation_description, LinkedList<UserAction> userAction) {
		super();
		this.id = id;
		this.operation_description = operation_description;
		this.userAction = userAction;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOperation_description() {
		return operation_description;
	}

	public void setOperation_description(String operation_description) {
		this.operation_description = operation_description;
	}

	public LinkedList<UserAction> getUserAction() {
		return userAction;
	}

	public void setUserAction(LinkedList<UserAction> userAction) {
		this.userAction = userAction;
	}

	@Override
	public String toString() {
		return "Operation [id=" + id + ", operation_description=" + operation_description + ", userAction=" + userAction
				+ "]";
	}

}