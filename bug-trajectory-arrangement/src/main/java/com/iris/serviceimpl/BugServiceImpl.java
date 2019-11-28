package com.iris.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iris.daos.BugDao;
import com.iris.models.BugType;
import com.iris.service.BugService;

@Transactional
@Service("bugService")
public class BugServiceImpl implements BugService {
 @Autowired
 BugDao bugDao;
	@Override
	public List<BugType> getAllBug() {
		System.out.println(bugDao.getAllBug());
		return bugDao.getAllBug();
	}
	@Override
	public BugType getBugById(int bId) {
		return bugDao.getBugById(bId);
	}

}
