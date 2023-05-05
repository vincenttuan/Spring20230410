package com.spring.core.session06.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.spring.core.session06.entity.Emp;
import com.spring.core.session06.service.EmpService;

@Controller
public class EmpController {
	@Autowired
	private EmpService empService;
	
	public List<Emp> findAll() {
		return empService.queryAll();
	}
	
	public Optional<Emp> getBigOne() {
		return empService.getBigOne();
	}
	
}
