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
public class JobDaoImpl implements JobDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int add(Job job) {
		String sql = SQLUtil.ADD_JOB_SQL;
		return jdbcTemplate.update(sql, job.getJname(), job.getEid());
	}

	@Override
	public int update(Job job) {
		String sql = SQLUtil.UPT_JOB_SQL;
		return jdbcTemplate.update(sql, job.getJname(), job.getEid(), job.getJid());

	}

	@Override
	public int delete(Integer jid) {
		String sql = SQLUtil.DEL_JOB_SQL;
		return jdbcTemplate.update(sql, jid);
	}

	@Override
	public Job get(Integer jid) {
		String sql = SQLUtil.GET_JOB_SQL;
		return jdbcTemplate.queryForObject(sql, new Object[] {jid}, new BeanPropertyRowMapper<Job>(Job.class));
	}

	@Override
	public int getCount() {
		String sql = SQLUtil.COUNT_JOB_SQL;
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public List<Job> query() {
		//String sql = SQLUtil.QUERY_JOB_SQL; // 不分頁查詢
		String sql = "select j.jid, j.jname, j.eid, " +
				 "e.eid as employee_eid, e.ename as employee_ename, e.salary as employee_salary, e.createtime as employee_createtime " +
				 "from job j left join employee e on j.eid = e.eid ";
	
		ResultSetExtractor<List<Job>> resultSetExtractor = 
				JdbcTemplateMapperFactory.newInstance()
				.addKeys("jid") // 通常就是 Job 的主鍵
				.newResultSetExtractor(Job.class); // 主要查詢的資料表
		
		return jdbcTemplate.query(sql, resultSetExtractor);
	}

	@Override
	public List<Job> queryPage(int pageNo) {
		int offset = (pageNo-1) * LIMIT;
		if(offset < 0) return null;
		String sql = SQLUtil.QUERY_PAGE_JOB_SQL;
		
		// 自行組合 Job(多) 與 Employee(一) 對應關係
		RowMapper<Job> rm = (rs, rowNum) -> {
			Job job = new Job();
			job.setJid(rs.getInt("jid"));
			job.setJname(rs.getString("jname"));
			
			if(job.getEid() != null) {
				String emp_sql = "select e.eid, e.ename, e.salary, e.createtime from employee e where e.eid=?";
				Employee emp = jdbcTemplate.queryForObject(emp_sql, new Object[] {job.getEid()},
						new BeanPropertyRowMapper<Employee>(Employee.class));
				job.setEmployee(emp);
			}
			return job;
		};
		
		Object[] args = {LIMIT, offset};
		return jdbcTemplate.query(sql, args, rm);
	}
	
}
