package com.iris.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Bug_Project")
public class Project {

@Id
@Column(name="Project_Id")
private String projId;

@Column(name="Project_Name")
private String projName;

@ManyToMany(mappedBy="projects",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
private List<User> users=new ArrayList<User>();

public String getProjId() {
	return projId;
}
public void setProjId(String projId) {
	this.projId = projId;
}
public String getProjName() {
	return projName;
}
public void setProjName(String projName) {
	this.projName = projName;
}
public List<User> getUsers() {
	return users;
}
public void setUsers(List<User> users) {
	this.users = users;
}

@Override
public String toString() {
	return "Project [projId=" + projId + ", projName=" + projName + ", users=" + users + "]";
}


}
