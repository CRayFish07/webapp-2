package com.chuchujie.webapp.provider.dao;

import java.util.List;

import com.chuchujie.webapp.common.entity.ItemRates;

public interface ItemRatesDao {
	int deleteByPrimaryKey(Integer id);

	int insert(ItemRates record);

	int insertSelective(ItemRates record);

	ItemRates selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(ItemRates record);

	int updateByPrimaryKeyWithBLOBs(ItemRates record);

	int updateByPrimaryKey(ItemRates record);

	/**
	 * 根据itemId 查找数据
	 * @param itemId
	 * @return
	 */
	List<ItemRates> selectByItemId(Long itemId);
}