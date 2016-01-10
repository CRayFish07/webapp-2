package com.chuchujie.webapp.provider.dao;

import java.util.List;

import com.chuchujie.webapp.common.entity.User;

public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User>listAll();
    
}