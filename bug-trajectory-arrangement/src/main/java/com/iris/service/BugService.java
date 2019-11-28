package com.iris.service;

import java.util.List;

import com.iris.models.BugType;

public interface BugService {
	public List<BugType> getAllBug();
	public BugType getBugById(int bId);
}
