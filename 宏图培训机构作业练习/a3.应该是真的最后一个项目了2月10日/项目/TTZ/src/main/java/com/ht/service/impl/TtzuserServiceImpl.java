package com.ht.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.dao.TtzuserDao;
import com.ht.pojo.Ttzuser;
import com.ht.service.TtzuserService;

@Service
public class TtzuserServiceImpl implements TtzuserService {
	@Resource
	private TtzuserDao ttzuserDao;

	@Override
	public void Zhuce(Ttzuser ttzuser) {
		// TODO Auto-generated method stub
		ttzuserDao.Zhuce(ttzuser);
	}

	@Override
	public Ttzuser Login(String username, String pwd) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", username);
		map.put("pwd", pwd);
		return ttzuserDao.Login(map);
	}

	@Override
	public List<Ttzuser> selectAllTtzUser() {
		// TODO Auto-generated method stub
		return ttzuserDao.selectAllTtzUser();
	}

	@Override
	public List UserList() {
		// TODO Auto-generated method stub
		return ttzuserDao.UserList();
	}

	@Override
	public int updateTel(String tel, String tid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tel", tel);
		map.put("tid", tid);
		int i = ttzuserDao.updateTel(map);
		return i;
	}

	@Override
	public int updateZsname(String zsname, String pcard, String tid) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zsname", zsname);
		map.put("tid", tid);
		map.put("pcard", pcard);
		return ttzuserDao.updateZsname(map);
	}

	@Override
	public int updateZpwd(String zpwd, String tid) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zpwd", zpwd);
		map.put("tid", tid);

		return ttzuserDao.updateZpwd(map);
	}

	@Override
	public int updateemail(String email, String tid) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("email", email);
		map.put("tid", tid);
		return ttzuserDao.updateemail(map);
	}

	@Override
	public int updatepwd(String pwd, String tid) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pwd", pwd);
		map.put("tid", tid);
		return ttzuserDao.updatepwd(map);
	}

	// 满标之后通过复审得到借款金额
	public int updateTtzBorrowMoney(Map<String, Object> map) {

		return ttzuserDao.updateTtzBorrowMoney(map);
	}

	@Override
	public List<Ttzuser> selectNewuser() {
		// TODO Auto-generated method stub
		return ttzuserDao.selectNewuser();
	}

	@Override
	public int updatenewuser(String shren, String tid) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("shren", shren);
		map.put("tid", tid);
		return ttzuserDao.updatenewuser(map);
	}

	@Override
	public int selUserMoney() {
		// TODO Auto-generated method stub
		return ttzuserDao.selUserMoney();
	}

	@Override
	public int selUserCount() {
		// TODO Auto-generated method stub
		return ttzuserDao.selUserCount();
	}

	@Override
	public List<Ttzuser> UsrtlistPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return ttzuserDao.UsrtlistPage(map);
	}

	@Override
	public Ttzuser selmyuserid2(String tid) {
		// TODO Auto-generated method stub
		return ttzuserDao.selmyuserid2(tid);
	}

	@Override
	public int updateSYED(String userid, Integer xinyong) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userid", userid);
		map.put("syed", xinyong);
		return ttzuserDao.updateSYED(map);
	}

	@Override
	public int uploadhead(String head, String tid) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("head", head);
		map.put("tid", tid);
		return ttzuserDao.uploadhead(map);
	}

	@Override
	public List<Ttzuser> seluserbyname(String yonghuming) {
		// TODO Auto-generated method stub
		return ttzuserDao.seluserbyname(yonghuming);
	}

	@Override
	public List<Ttzuser> selUserForbank(String username) {
		// TODO Auto-generated method stub
		return ttzuserDao.selUserForbank(username);
	}

	// 验证用户名是否存在
	public int YanZhengUsername(String username) {

		return ttzuserDao.YanZhengUsername(username);
	}
}
