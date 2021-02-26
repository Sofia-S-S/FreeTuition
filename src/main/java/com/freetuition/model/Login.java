package com.freetuition.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity

@Table(name = "login", schema="freetuition")


public class Login {

	@Id
	@Column (name="employeeId") //give name to my sequence for column id
	@GeneratedValue(generator = "login_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(allocationSize = 1, name = "login_id_seq", sequenceName = "login_id_seq")
	private int id;
	
	@Column
	private String login;
	@Column
	private String password;
	
	public Login() {}
	
	

	public Login(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public Login(int id, String login, String password) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Login [id=" + id + ", login=" + login + ", password=" + password + "]";
	}
	

}
