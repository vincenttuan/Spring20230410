package spring.mvc.session15.repository;

import java.util.List;

import spring.mvc.session15.entity.Employee;

public interface EmployeeDao {
	// 每頁筆數 
	int LIMIT = 5;
	
	// 新增單筆 employee 資料
	public int add(Employee emp);
	
	// 修改單筆 employee 資料
	public int update(Employee emp);
	
	// 修改刪除 employee 資料
	public int delete(Integer eid);
	
	// 單筆查詢 employee 資料
	public Employee get(Integer eid);
	
	// 單筆查詢 employee 所有筆數資料
	public int getCount();
	
	// 多筆查詢 employee: 不分頁
	public List<Employee> query();
	
	// 多筆查詢 employee: 分頁
	// offset: 從哪一筆紀錄開始查
	public List<Employee> queryPage(int pageNo);
	
}
