package com.iris.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iris.daos.SeverityDao;
import com.iris.models.Severity;
import com.iris.service.SeverityService;

@Transactional
@Service("severityService")
public class SeverityServiceImpl implements SeverityService {
@Autowired
SeverityDao severityDao;
	@Override
	public List<Severity> getAllSeverity() {
		return severityDao.getAllSeverity();
	}

}
