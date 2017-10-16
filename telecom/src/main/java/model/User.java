package model;

import java.util.Arrays;
import java.util.LinkedList;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class User {
	@Id
	private int id;
	@Column(name = "USER_NAME")
	private String name;
	@Column(name = "USER_PASSWORD")
	private byte[] password;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
	public LinkedList<UserAction> userActions = new LinkedList<UserAction>();

	public User(int id, String name, byte[] password, LinkedList<UserAction> userActions) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.userActions = userActions;
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

	public byte[] getPassword() {
		return password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}

	public LinkedList<UserAction> getUserActions() {
		return userActions;
	}

	public void setUserActions(LinkedList<UserAction> userActions) {
		this.userActions = userActions;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + Arrays.toString(password) + ", userActions="
				+ userActions + "]";
	}

}