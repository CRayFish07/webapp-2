package com.chuchujie.webapp.common.service;

import java.util.List;

import com.chuchujie.webapp.common.entity.ItemRates;

public interface ItemRatesService {
	/**
	 * 根据productId查询
	 * @param productId
	 * @return
	 */
	public List<ItemRates> selectByProductId(long productId);
}
