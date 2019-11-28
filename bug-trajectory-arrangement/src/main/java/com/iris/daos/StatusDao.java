package com.iris.daos;

import java.util.List;

import com.iris.models.BugStatus;


public interface StatusDao {
	public List<BugStatus> getAllStatus();
	public boolean updateStatus();
	
}
