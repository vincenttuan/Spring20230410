package spring.mvc.session15.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import spring.mvc.session15.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public int add(Employee emp) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Employee emp) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer eid) {
		// TODO Auto-generated method stub
		return 0;
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
