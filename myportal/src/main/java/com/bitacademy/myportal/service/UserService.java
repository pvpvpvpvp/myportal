package com.bitacademy.myportal.service;

import java.util.List;

import com.bitacademy.myportal.repository.UserVo;
import com.bitacademy.myportal.repository.testCityVo;

public interface UserService {
	public boolean join(UserVo vo);
	public UserVo getUser(String eamil, String password);
	public UserVo getUser(String email);
	public UserVo getUserSet(String email);
	public boolean updateUser(UserVo vo,String email);
	public List<testCityVo>  mysql();
}
