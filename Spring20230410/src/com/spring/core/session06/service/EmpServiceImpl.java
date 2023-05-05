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
		List<Emp> emps = queryAll();
		Integer maxOfAge = emps.stream().mapToInt(Emp::getAge).max().getAsInt();
		return emps.stream().filter(emp -> emp.getAge().equals(maxOfAge)).findAny();
	}
	
}
