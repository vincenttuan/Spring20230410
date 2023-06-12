package spring.mvc.session15.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import spring.mvc.session15.entity.Job;

@Repository
public class JobDaoImpl implements JobDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int add(Job job) {
		return 0;
	}

	@Override
	public int update(Job job) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer jid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Job get(Integer jid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Job> query() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Job> queryPage(int offset) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
