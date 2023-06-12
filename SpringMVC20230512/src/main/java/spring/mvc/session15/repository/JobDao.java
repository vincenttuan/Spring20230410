package spring.mvc.session15.repository;

import java.util.List;

import spring.mvc.session15.entity.Job;

public interface JobDao {
	// 每頁筆數
	int LIMIT = 5;

	// 新增單筆 job 資料
	public int add(Job job);

	// 修改單筆 job 資料
	public int update(Job job);

	// 修改刪除 job 資料
	public int delete(Integer jid);

	// 單筆查詢 job 資料
	public Job get(Integer jid);

	// 單筆查詢 job 所有筆數資料
	public int getCount();

	// 多筆查詢 job: 不分頁
	public List<Job> query();

	// 多筆查詢 job: 分頁
	// offset: 從哪一筆紀錄開始查
	public List<Job> queryPage(int pageNo);
}
