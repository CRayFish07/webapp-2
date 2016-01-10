package com.chuchujie.webapp.common.service;

import java.util.List;

import com.chuchujie.webapp.common.entity.User;

public interface UserService {
	/**
	 * 根据主键删除
	 * 
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * 插入元素 并返回主键
	 * 
	 * @param record
	 * @return
	 */
	int insert(User record);

	/**
	 * 插入部分数据
	 * 
	 * @param record
	 * @return
	 */
	int insertSelective(User record);

	/**
	 * 根据主键查询
	 * 
	 * @param id
	 * @return
	 */
	User selectByPrimaryKey(Integer id);

	/**
	 * 根据主键更新部分数据
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(User record);

	/**
	 * 根据主键更新
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKey(User record);

	/**
	 * 列出所有数据
	 * 
	 * @return
	 */
	List<User> listAll();
}
