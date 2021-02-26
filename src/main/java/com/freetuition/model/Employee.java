package com.freetuition.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity

@Table(name = "employee", schema="freetuition")

public class Employee {
	
	@Id
	@Column (name="employeeId") //give name to my sequence for column id
	@GeneratedValue(generator = "employee_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(allocationSize = 1, name = "employee_id_seq", sequenceName = "employee_id_seq")
	private int id;
	
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String company;
	@Column
	private String position;
	@Column
	private int managerId;
	@Column
	private String email;
	@Column
	private long contact;
	@Column
	private String address;
	
	public Employee() {}

	public Employee(String firstName, String lastName, String company, String position, int managerId, String email,
			long contact, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
		this.position = position;
		this.managerId = managerId;
		this.email = email;
		this.contact = contact;
		this.address = address;
	}

	public Employee(int id, String firstName, String lastName, String company, String position, int managerId,
			String email, long contact, String address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
		this.position = position;
		this.managerId = managerId;
		this.email = email;
		this.contact = contact;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", company=" + company
				+ ", position=" + position + ", managerId=" + managerId + ", email=" + email + ", contact=" + contact
				+ ", address=" + address + "]";
	}
	
	

}
