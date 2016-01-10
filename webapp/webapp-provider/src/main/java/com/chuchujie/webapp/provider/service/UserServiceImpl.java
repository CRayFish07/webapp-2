package com.chuchujie.webapp.provider.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chuchujie.webapp.common.entity.User;
import com.chuchujie.webapp.common.service.UserService;
import com.chuchujie.webapp.provider.dao.UserDao;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;

	public int deleteByPrimaryKey(Integer id) {
		return userDao.deleteByPrimaryKey(id);
	}

	public int insert(User record) {
		userDao.insert(record);
		return record == null ? 0 : record.getId();
	}

	public int insertSelective(User record) {
		return userDao.insertSelective(record);
	}

	public User selectByPrimaryKey(Integer id) {
		User user = userDao.selectByPrimaryKey(id);
		return user == null ? null : user;

	}

	public int updateByPrimaryKeySelective(User record) {
		return userDao.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(User record) {
		return userDao.updateByPrimaryKey(record);
	}

	public List<User> listAll() {
		return userDao.listAll();
	}

}
