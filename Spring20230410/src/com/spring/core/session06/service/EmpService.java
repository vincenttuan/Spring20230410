package com.spring.core.session06.service;

import java.util.List;
import java.util.Optional;

import com.spring.core.session06.entity.Emp;

public interface EmpService {
	List<Emp> queryAll();
	Optional<Emp> findOne();
}
