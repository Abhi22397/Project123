package com.iris.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Bug_Type")
public class BugType {
	@Id
	@Column(name="Bug_Type_Id")
	private String bId;
	@Column(name="Bug_Type_Name ")
	private String bType;
	
	public String getbId() {
		return bId;
	}
	public void setbId(String bId) {
		this.bId = bId;
	}
	public String getbType() {
		return bType;
	}
	public void setbType(String bType) {
		this.bType = bType;
	}
	@Override
	public String toString() {
		return "BugStatus [bId=" + bId + ", bType=" + bType + "]";
	}
}
