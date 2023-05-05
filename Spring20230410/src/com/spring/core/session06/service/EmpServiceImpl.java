package com.spring.core.session06.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.core.session06.dao.EmpDao;
import com.spring.core.session06.entity.Emp;

@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpDao empDao;
	
	@Override
	public List<Emp> queryAll() {
		return empDao.queryEmps();
	}

	@Override
	public Optional<Emp> getBigOne() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
