package com.chuchujie.webapp.provider.dao;

import com.chuchujie.webapp.common.entity.RateStar;



public interface RateStarDao {
	
    int deleteByPrimaryKey(Integer id);

    int insert(RateStar record);

    int insertSelective(RateStar record);

    RateStar selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RateStar record);

    int updateByPrimaryKey(RateStar record);
}