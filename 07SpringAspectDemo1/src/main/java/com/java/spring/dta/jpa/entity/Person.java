package com.java.spring.dta.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {
	
	@Id
	public int pid;
	
	public String pname;

	
	//need one default constructor
	
	public Person() {
		//super();
	
	}
	
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	@Override
	public String toString() {
		return "Person [pname=" + pname + ", pid=" + pid + "]";
	}

	
	
	
	
	
	
	
}
