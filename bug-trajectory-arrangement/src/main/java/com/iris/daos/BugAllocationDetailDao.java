package com.iris.daos;

import java.util.List;

import com.iris.models.BugAllocationDetails;

public interface BugAllocationDetailDao {
public boolean saveBugDetails(BugAllocationDetails bugAllocate);
public List<BugAllocationDetails> getAllBugDesc();
public BugAllocationDetails getBugAllocationById(int bugAllocateId);
public boolean update(BugAllocationDetails bugAllocate);
public List<BugAllocationDetails> getBugDesc(int id);
}
