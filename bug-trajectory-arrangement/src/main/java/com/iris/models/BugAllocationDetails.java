package com.iris.models;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Bug_Desc")
public class BugAllocationDetails {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="BUG_ALLOCATE_ID")
private int bugAllocateId;

@Column(name="Planned_Start_Date")
private Date plannedStartdate;

@Column(name="Planned_End_Date")
private Date plannedEndDate;

@Column(name="Actual_Start_Date")
private Date actualStartDate;

@Column(name="Actual_End_Date")
private Date actualEndDate;

@Column(name="Description")
private String desc;

@Column(name="User_Id")
private int userId;

@Column(name="Project_Id")
private String projectId;


@Column(name="Bug_Type_Id")
private String bugTypeId;

@Column(name="Sev_Id")
private String severityId;

@Column(name="Status_Id")
private String statusId;


@OneToOne
@JoinColumn(name="User_Id",insertable=false,updatable=false)
private User userObj;

@OneToOne
@JoinColumn(name="Sev_Id",insertable=false,updatable=false)
private Severity severityObj;

@OneToOne
@JoinColumn(name="Bug_Type_Id",insertable=false,updatable=false)
private BugType bugTypeObj;


@OneToOne
@JoinColumn(name="Status_Id",insertable=false,updatable=false)
private BugStatus bugStatusObj;

@ManyToOne
@JoinColumn(name="Project_Id",insertable=false,updatable=false)
private Project projObj;

public Project getProjObj() {
	return projObj;
}

public void setProjObj(Project projObj) {
	this.projObj = projObj;
}

public int getBugAllocateId() {
	return bugAllocateId;
}

public void setBugAllocateId(int bugAllocateId) {
	this.bugAllocateId = bugAllocateId;
}

public Date getPlannedStartdate() {
	return plannedStartdate;
}

public void setPlannedStartdate(Date plannedStartdate) {
	this.plannedStartdate = plannedStartdate;
}

public Date getPlannedEndDate() {
	return plannedEndDate;
}

public void setPlannedEndDate(Date plannedEndDate) {
	this.plannedEndDate = plannedEndDate;
}

public Date getActualStartDate() {
	return actualStartDate;
}

public void setActualStartDate(Date actualStartDate) {
	this.actualStartDate = actualStartDate;
}

public Date getActualEndDate() {
	return actualEndDate;
}

public void setActualEndDate(Date actualEndDate) {
	this.actualEndDate = actualEndDate;
}

public String getDesc() {
	return desc;
}

public void setDesc(String desc) {
	this.desc = desc;
}

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public String getProjectId() {
	return projectId;
}

public void setProjectId(String projectId) {
	this.projectId = projectId;
}

public String getBugTypeId() {
	return bugTypeId;
}

public void setBugTypeId(String bugTypeId) {
	this.bugTypeId = bugTypeId;
}

public String getSeverityId() {
	return severityId;
}

public void setSeverityId(String severityId) {
	this.severityId = severityId;
}

public String getStatusId() {
	return statusId;
}

public void setStatusId(String statusId) {
	this.statusId = statusId;
}



public User getUserObj() {
	return userObj;
}

public void setUserObj(User userObj) {
	this.userObj = userObj;
}

public Severity getSeverityObj() {
	return severityObj;
}

public void setSeverityObj(Severity severityObj) {
	this.severityObj = severityObj;
}

public BugType getBugTypeObj() {
	return bugTypeObj;
}

public void setBugTypeObj(BugType bugTypeObj) {
	this.bugTypeObj = bugTypeObj;
}

public BugStatus getBugStatusObj() {
	return bugStatusObj;
}

public void setBugStatusObj(BugStatus bugStatusObj) {
	this.bugStatusObj = bugStatusObj;
}

@Override
public String toString() {
	return "BugAllocationDetails [bugAllocateId=" + bugAllocateId + ", plannedStartdate=" + plannedStartdate
			+ ", plannedEndDate=" + plannedEndDate + ", actualStartDate=" + actualStartDate + ", actualEndDate="
			+ actualEndDate + ", desc=" + desc + ", userId=" + userId + ", projectId=" + projectId + ", bugTypeId="
			+ bugTypeId + ", severityId=" + severityId + ", statusId=" + statusId + ", userObj=" + userObj
			+ ", severityObj=" + severityObj + ", bugTypeObj=" + bugTypeObj + ", bugStatusObj=" + bugStatusObj
			+ ", projObj=" + projObj + "]";
}


	
}
