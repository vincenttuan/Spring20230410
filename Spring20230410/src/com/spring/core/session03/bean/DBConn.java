package com.spring.core.session03.bean;

public class DBConn {
	
	public void init() {
		System.out.println("開啟資料庫連線...");
	}
	
	public void create() {
		System.out.println("新增程序...");
	}
	
	public void update() {
		System.out.println("修改程序...");
	}
	
	public void delete() {
		System.out.println("刪除程序...");
	}
	
	public void read() {
		System.out.println("查詢程序...");
	}
	
	public void destory() {
		System.out.println("關閉資料庫連線...");
	}
	
}
