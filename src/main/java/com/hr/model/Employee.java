package com.hr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
public class Employee {

	@Id
	@GeneratedValue
	private Long id;
	private String firstname;
	private String lastname;
	private String position;
	private double salary;
	public Employee() {
	}
	public Employee(Long id, String firstname, String lastname, String position, double salary) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.position = position;
		this.salary = salary;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", position=" + position
				+ ", salary=" + salary + "]";
	}
	
}
