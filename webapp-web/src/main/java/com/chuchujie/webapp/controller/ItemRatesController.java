package com.chuchujie.webapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chuchujie.webapp.common.entity.ItemRates;
import com.chuchujie.webapp.common.service.ItemRatesService;

@Controller
@RequestMapping("")
public class ItemRatesController {
	@Resource
	private ItemRatesService itemRatesService;

	/**
	 * 根据productId 查询rate
	 * 
	 * @param productId
	 * @return
	 */
	@RequestMapping("/selectByProductId")
	@ResponseBody
	public Map<String, Object> selectByProductId(
			@RequestParam(value = "productId", required = true) Long productId) {
		Map<String, Object> itemRatesMap = new HashMap<String, Object>();
		List<ItemRates> itemRates = itemRatesService
				.selectByProductId(productId);
		System.out.println(itemRates.size());
		itemRatesMap.put("list", itemRates);
		itemRatesMap.put("count", itemRates.size());
		return itemRatesMap;
	}
}
