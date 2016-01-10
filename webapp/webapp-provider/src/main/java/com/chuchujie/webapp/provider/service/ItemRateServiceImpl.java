package com.chuchujie.webapp.provider.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.chuchujie.webapp.common.entity.ItemRates;
import com.chuchujie.webapp.common.service.ItemRatesService;
import com.chuchujie.webapp.provider.dao.ItemRatesDao;

@Service("itemRatesService")
public class ItemRateServiceImpl implements ItemRatesService {

	@Resource
	private ItemRatesDao itemRatesDao;

	public List<ItemRates> selectByProductId(long productId) {
		List<ItemRates> itemRates = itemRatesDao.selectByItemId(productId);
		for (int i = 0; i < itemRates.size(); i++) {
			Map<String, Object> map = (Map<String, Object>) itemRates.get(i);
			String str = (String) map.get("rate_imgs");
			if (!StringUtils.isEmpty(str)) {
				List<String> sttrs = new ArrayList<String>();
				JSONArray jsonArray = JSONArray.fromObject(str);
				for (int j = 0; j < jsonArray.size(); j++) {
					String stt = (String) jsonArray.get(j);
					if (!StringUtils.isEmpty(stt)) {
						stt += "?imageView2/0/w/400/h/400";
						sttrs.add(stt);
					}
				}
				map.put("rate_imgs", sttrs);
			}
		}
		return itemRates;
	}
}
