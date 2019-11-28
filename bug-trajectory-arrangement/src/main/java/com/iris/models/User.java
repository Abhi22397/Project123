package com.iris.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name="User_2")
public class User {
	
	@Id
	@Column(name="User_Id")
	private int id;
	
	@Column(name="Email_Id")
	private String email;
	

	@Column(name="User_Name")
	private String name;
	
	@Column(name="User_Password")
	private String password;
	
	@Column(name="Designation")
	private String desg;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="Project_Allocation",
	 joinColumns={@JoinColumn(name="User_Id")},
	 inverseJoinColumns= {@JoinColumn(name="Project_Id")})
	 private List<Project> projects=new ArrayList<Project>();
	
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDesg() {
		return desg;
	}
	public void setDesg(String desg) {
		this.desg = desg;
	}
	
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
