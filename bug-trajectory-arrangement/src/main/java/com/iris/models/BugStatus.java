package com.iris.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Bug_Status")
public class BugStatus {
	
	@Id
	@Column(name="Status_Id")
	private String statusId;
	@Column(name="Status_Name")
	private String statusName;
	public String getStatusId() {
		return statusId;
	}
	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	@Override
	public String toString() {
		return "BugStatus [statusId=" + statusId + ", statusName=" + statusName + "]";
	}
	
}
