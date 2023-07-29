package com.ht.yfbc.service;

import java.util.List;
import java.util.Map;

import com.ht.yfbc.pojo.Users;

public interface UsersService {
	/**
	 * 	用于登录时验证用户
	 * @param map
	 * @return Users
	 */
	public Users selUserByNameAndPwd(Map<String, Object> map);
	/**
	 * 分页查询用户
	 * @param map
	 * @return
	 */
	public List<Users> selUserListPage(Map<String, Object> map);
	/**
	 * 查询全部用户
	 * @return
	 */
	public List<Users> selUserList();
	/**
	 * 查询部分用户
	 * @param map
	 * @return
	 */
	public List<Users> selUserListByMap(Map<String, Object> map);
	/**
	 * 查询用户数量
	 * @return
	 */
	public int selCount();
	/**
	 * 添加用户
	 * @param user
	 */
	public void addUsers(Users user);
	/**
	 * 删除用户
	 * @param userid
	 * @return
	 */
	public int delUsers(String userid);
	/**
	 * 根据用户id查询用户
	 * @param id
	 * @return
	 */
	public Users selUsersById(String id);
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	public int updUsers(Users user);
	/**
	 * 根据用户id查询用户姓名
	 * @param userid
	 * @return
	 */
	public String selUsernameById(String userid);
}
