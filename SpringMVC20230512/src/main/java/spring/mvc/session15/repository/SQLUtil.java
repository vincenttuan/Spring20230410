package spring.mvc.session15.repository;

public class SQLUtil {
	public static final String ADD_EMPLOYEE_SQL = "insert into employee (ename, salary) values(?, ?)"; 
	public static final String UPT_EMPLOYEE_SQL = "update employee set ename=?, salary=? where eid=?";; 
	public static final String DEL_EMPLOYEE_SQL = "delete from employee where eid=?"; 
	public static final String GET_EMPLOYEE_SQL = "select eid, ename, salary, createtime from employee where eid=?"; 
	public static final String COUNT_EMPLOYEE_SQL = "select count(*) from employee"; 
	public static final String QUERY_EMPLOYEE_SQL = "select e.eid, e.ename, e.salary, e.createtime from employee e";
	public static final String QUERY_PAGE_EMPLOYEE_SQL = "select e.eid, e.ename, e.salary, e.createtime from employee e limit ? offset ?";
}
