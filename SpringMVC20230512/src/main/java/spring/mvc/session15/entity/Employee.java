package spring.mvc.session15.entity;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Employee {
	
	private Integer eid;
	
	@Size(min = 2, max = 50, message = "{employee.ename.size}")
	private String ename;
	
	@NotNull(message = "{employee.salary.empty}")
	@Range(min = 30000, max = 300000, message = "{employee.salary.range}")
	private Integer salary;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd") // 設定返回的日期格式
	@JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8") // 設定接收的日期格式
	private Date createtime;
	
	// 一個員工有多個工作
	private List<Job> jobs;

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", salary=" + salary + ", createtime=" + createtime
				+ ", jobs=" + jobs + "]";
	}
	
	
}
