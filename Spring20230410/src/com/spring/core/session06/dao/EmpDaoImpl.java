package com.spring.core.session06.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.core.session06.entity.Emp;

@Repository
public class EmpDaoImpl implements EmpDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Map<String, Object>> query() {
		String sql = "select eid, ename, age, createtime from emp";
		List<Map<String, Object>> emps = jdbcTemplate.queryForList(sql);
		return emps;
	}

	@Override
	public List<Emp> queryEmps() {
		String sql = "select eid, ename, age, createtime from emp";
		// 利用 BeanPropertyRowMapper 將資料逐筆注入到指定物件中
		List<Emp> emps = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));
		return emps;
	}

	@Override
	public Optional<Emp> getOne(Integer eid) {
		String sql = "select eid, ename, age, createtime from emp where eid=?";
		Object[] args = {eid};
		Emp emp = jdbcTemplate.queryForObject(sql, args, new BeanPropertyRowMapper<>(Emp.class));
		Optional<Emp> optEmp = Optional.ofNullable(emp);
		return optEmp;
	}

	@Override
	public Integer count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int create(String ename, Integer age) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int[] batchCreate(List<Object[]> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Integer eid, String ename, Integer age) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer eid) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
