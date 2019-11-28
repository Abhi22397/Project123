package com.iris.service;

import java.util.List;


import com.iris.models.BugAllocationDetails;

public interface BugAllocationDetailService {
	public boolean saveBugDetails(BugAllocationDetails bugAllocate);
	public List<BugAllocationDetails> getAllBugDesc();
	public BugAllocationDetails getBugAllocationById(int bugAllocateId);
	public boolean update(BugAllocationDetails bugAllocate);
	public List<BugAllocationDetails> getBugDesc(int id);
}
