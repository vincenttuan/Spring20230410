package spring.mvc.session15.repository;

import java.util.List;

import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import spring.mvc.session15.entity.Employee;
import spring.mvc.session15.entity.Job;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int add(Employee emp) {
		String sql = SQLUtil.ADD_EMPLOYEE_SQL;
		return jdbcTemplate.update(sql, emp.getEname(), emp.getSalary());
	}

	@Override
	public int update(Employee emp) {
		String sql = SQLUtil.UPT_EMPLOYEE_SQL;
		return jdbcTemplate.update(sql, emp.getEname(), emp.getSalary(), emp.getEid());
	}

	@Override
	public int delete(Integer eid) {
		String sql = SQLUtil.DEL_EMPLOYEE_SQL;
		return jdbcTemplate.update(sql, eid);
	}

	@Override
	public Employee get(Integer eid) {
		String sql = SQLUtil.GET_EMPLOYEE_SQL;
		return jdbcTemplate.queryForObject(sql, new Object[] {eid}, new BeanPropertyRowMapper<Employee>(Employee.class));
	}

	@Override
	public int getCount() {
		String sql = SQLUtil.COUNT_EMPLOYEE_SQL;
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public List<Employee> query() {
		//String sql = SQLUtil.QUERY_EMPLOYEE_SQL; // 不分頁查詢
		String sql = "select e.eid, e.ename, e.salary, e.createtime, " +
					 "j.jid as job_jid, j.jname as job_jname, j.eid as job_eid " +
					 "from employee e left join job j on e.eid = j.eid ";
		
		ResultSetExtractor<List<Employee>> resultSetExtractor = 
				JdbcTemplateMapperFactory.newInstance()
				.addKeys("eid") // 通常就是 Employee 的主鍵
				.newResultSetExtractor(Employee.class); // 主要查詢的資料表
		
		return jdbcTemplate.query(sql, resultSetExtractor);
		
	}

	@Override
	public List<Employee> queryPage(int pageNo) {
		int offset = (pageNo-1) * LIMIT;
		if(offset < 0) return null;
		String sql = SQLUtil.QUERY_PAGE_EMPLOYEE_SQL;
		
		// 自行組合 Employee(一) 與 Job(多) 對應關係
		RowMapper<Employee> rm = (rs, rowNum) -> {
			Employee emp = new Employee();
			emp.setEid(rs.getInt("eid"));
			emp.setEname(rs.getString("ename"));
			emp.setSalary(rs.getInt("salary"));
			emp.setCreatetime(rs.getDate("createtime"));
			String job_sql = "select j.jid, j.jname, j.eid from job j where j.eid=?";
			List<Job> jobs = jdbcTemplate.query(job_sql, new Object[] {emp.getEid()},
					new BeanPropertyRowMapper<Job>(Job.class));
			emp.setJobs(jobs);
			return emp;
		};
		
		Object[] args = {LIMIT, offset};
		return jdbcTemplate.query(sql, args, rm);
	}

}
