package com.spring.mvc.single.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.mvc.single.entity.User;

/*
 * 方法命名規則
 * 1. 查詢方法以 find | read | get 開頭
 * 2. 涉及條件查詢時，條件的屬性（首字母大寫）用條件關鍵字（例如：And、Or）連結
 * */
@Repository
public interface UserRepository extends JpaRepository<User, Long>  {
	// 預設會有 CRUD
	// 根據 name 來取得 User: Where name = ?
	List<User> getByName(String name);
	
	// 名字是 OO.. 開頭 and id >= ?
	// Where name Like ? and id >= ?
	List<User> getByNameStartingWithAndIdGreaterThanEqual(String name, Long id);
	
	// Where id in (?, ? ...)
	List<User> getByIdIn(List<Long> ids);
	
	// Where birth < ?
	List<User> getByBirthLessThan(Date birth);
	
	// Where birth >= ? and birth <= ?
	// Where birth between ?(含) and ?(含)
	List<User> getByBirthBetween(Date birthBegin, Date birthEnd);
	
	@Query(value = "select id, name, password, birth from user where id >= ?1 and id <= ?2", nativeQuery = true)
	List<User> findUser(Long beginId, Long endId);
	
}
