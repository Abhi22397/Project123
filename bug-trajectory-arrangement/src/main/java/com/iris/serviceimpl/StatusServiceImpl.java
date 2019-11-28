package com.iris.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iris.daos.StatusDao;
import com.iris.models.BugStatus;
import com.iris.service.StatusService;

@Transactional
@Service("statusService")
public class StatusServiceImpl implements StatusService{
@Autowired
StatusDao statusDao;
	@Override
	public List<BugStatus> getAllStatus() {
			return statusDao.getAllStatus();
	}

}
