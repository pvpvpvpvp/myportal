package com.bitacademy.myportal.repository;

import java.util.List;

public interface UserDao {
	public int insert(UserVo vo);
	public UserVo selectUser(String email);
	public UserVo selectUser(String email, String password);
	public UserVo selectUserSet(String email);
	public int UpdateUser(UserVo vo,String email);
	public List<testCityVo>  mysqlTest();
}
