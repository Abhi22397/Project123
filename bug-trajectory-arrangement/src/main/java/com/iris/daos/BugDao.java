package com.iris.daos;

import java.util.List;

import com.iris.models.BugType;
import com.iris.models.User;



public interface BugDao {
	public List<BugType> getAllBug();
	public BugType getBugById(int bId);
}
