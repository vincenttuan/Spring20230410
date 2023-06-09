package spring.mvc.session15.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import spring.mvc.session15.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int add(Employee emp) {
		String sql = "insert into employee (ename, salary) values(?, ?)";
		return jdbcTemplate.update(sql, emp.getEname(), emp.getSalary());
	}

	@Override
	public int update(Employee emp) {
		String sql = "update employee set ename=?, salary=? where eid=?";
		return jdbcTemplate.update(sql, emp.getEname(), emp.getSalary(), emp.getEid());
	}

	@Override
	public int delete(Integer eid) {
		String sql = "delete from employee where eid=?";
		return jdbcTemplate.update(sql, eid);
	}

	@Override
	public Employee get(Integer eid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Employee> query() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> queryPage(int offset) {
		// TODO Auto-generated method stub
		return null;
	}

}
