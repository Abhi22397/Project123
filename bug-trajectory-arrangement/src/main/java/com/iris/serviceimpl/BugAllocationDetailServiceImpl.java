package com.iris.serviceimpl;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iris.daos.BugAllocationDetailDao;
import com.iris.models.BugAllocationDetails;
import com.iris.service.BugAllocationDetailService;

@Transactional
@Service("bugAllocationDetailService")
public class BugAllocationDetailServiceImpl implements BugAllocationDetailService {

	@Autowired
	BugAllocationDetailDao bugAllocationDetailDao;
	@Override
	public boolean saveBugDetails(BugAllocationDetails bugAllocate) {
		return bugAllocationDetailDao.saveBugDetails(bugAllocate);
	}
	
	@Override
	public List<BugAllocationDetails> getAllBugDesc() {
		return bugAllocationDetailDao.getAllBugDesc();
	}

	@Override
	public boolean update(BugAllocationDetails bugAllocate) {
		return bugAllocationDetailDao.update(bugAllocate);
	}

	@Override
	public BugAllocationDetails getBugAllocationById(int bugAllocateId) {
		return bugAllocationDetailDao.getBugAllocationById(bugAllocateId);
	}

	@Override
	public List<BugAllocationDetails> getBugDesc(int id) {
		return bugAllocationDetailDao.getBugDesc(id);
	}

}
