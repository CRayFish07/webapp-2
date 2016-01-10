package com.chuchujie.webapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.chuchujie.webapp.common.entity.User;
import com.chuchujie.webapp.common.service.UserService;

@Controller
@RequestMapping("")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 保存数据
	 * 
	 * @param model
	 * @param user
	 * @return
	 */
	@RequestMapping("/save")
	public ModelAndView save(ModelAndView model, User user) {
		System.out.println(user);
		int result = userService.insert(user);
		model.addObject("result", result);
		model.addObject("user", user);
		model.setViewName("index/success");
		return model;
	}

	/**
	 * 查询数据
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/select")
	public ModelAndView select(ModelAndView model, Integer id) {
		User user = userService.selectByPrimaryKey(id);
		model.addObject("user", user);
		model.setViewName("index/success");
		return model;
	}

	/**
	 * 转向保存界面
	 * 
	 * @return
	 */
	@RequestMapping("/toSavePage")
	public String toSavePage() {
		return "index/save";
	}

	/**
	 * 转向删除界面
	 * 
	 * @return
	 */
	@RequestMapping("/toDeletePage")
	public String toDeletePage() {
		return "index/delete";
	}

	/**
	 * 转向查询界面
	 * 
	 * @return
	 */
	@RequestMapping("/toSelectPage")
	public String toSelectPage() {
		return "index/select";
	}

	/**
	 * 刪除数据
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	public ModelAndView delete(ModelAndView model, Integer id) {
		int result = userService.deleteByPrimaryKey(id);
		if (result > 0)
			model.addObject("result", "删除数据成功!");
		else
			model.addObject("result", "删除数据失败");
		model.setViewName("index/success");
		return model;
	}

	/**
	 * 转向update界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/toUpdatePage")
	public ModelAndView toUpdatePage(ModelAndView model) {
		List<User> users = userService.listAll();
		model.addObject("users", users);
		model.setViewName("index/update");
		return model;
	}

	/**
	 * 更新数据
	 * 
	 * @param model
	 * @param user
	 * @return
	 */
	@RequestMapping("/update")
	public ModelAndView update(ModelAndView model, User user) {
		int result = 0;
		if (user.getId() != null)
			result = userService.updateByPrimaryKeySelective(user);

		if (result != 0)
			model.addObject("result", "success");
		else {
			model.addObject("result", "error");
		}
		model.setViewName("index/success");
		return model;
	}

	@RequestMapping("/selectByUserId")
	@ResponseBody
	public Map<String, Object> selectByUserId(Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (id != null)
			map.put("user", userService.selectByPrimaryKey(id));
		else
			map.put("user", "error");
		return map;
	}
}
