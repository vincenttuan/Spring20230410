package spring.mvc.session15.repository;

public class SQLUtil {
	// employee table
	public static final String ADD_EMPLOYEE_SQL = "insert into employee (ename, salary) values(?, ?)"; 
	public static final String UPT_EMPLOYEE_SQL = "update employee set ename=?, salary=? where eid=?";; 
	public static final String DEL_EMPLOYEE_SQL = "delete from employee where eid=?"; 
	public static final String GET_EMPLOYEE_SQL = "select eid, ename, salary, createtime from employee where eid=?"; 
	public static final String COUNT_EMPLOYEE_SQL = "select count(*) from employee"; 
	public static final String QUERY_EMPLOYEE_SQL = "select e.eid, e.ename, e.salary, e.createtime from employee e";
	public static final String QUERY_PAGE_EMPLOYEE_SQL = "select e.eid, e.ename, e.salary, e.createtime from employee e limit ? offset ?";
	
	// job table
	public static final String ADD_JOB_SQL = "insert into job (jname, eid) values(?, ?)"; 
	public static final String UPT_JOB_SQL = "update job set jname=?, eid=? where jid=?"; 
	public static final String DEL_JOB_SQL = "delete from job where jid=?"; 
	public static final String GET_JOB_SQL = "select jid, jname, eid from job where jid=?"; 
	public static final String COUNT_JOB_SQL = "select count(*) from job"; 
	public static final String QUERY_JOB_SQL = "select j.jid, j.jname, j.eid from job j";
	public static final String QUERY_PAGE_JOB_SQL = "select j.jid, j.jname, j.eid from job j limit ? offset ?";
	
	
}
