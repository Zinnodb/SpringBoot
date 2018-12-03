package com.light.project.system.user.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.light.common.utils.poi.ExcelUtil;
import com.light.framework.page.TableDataInfo;
import com.light.framework.web.controller.BaseController;
import com.light.framework.web.domain.AjaxResult;
import com.light.project.system.user.domain.User;
import com.light.project.system.user.service.IUserService;


/**
 * 用户信息
 * @author asus
 *
 */
@Controller
@RequestMapping("/system/user")
public class UserController extends BaseController {
		private String prefix="/system/user";
		
		@Autowired
		private IUserService userService;
		
		@RequiresPermissions("system:user:view")
		@GetMapping()
		public String User() 
		{
			return prefix+"/user";
		}
		
		/*
		 * shiro框架的核心技术是权限的配置
		 * @RequiresPermissions("system:user:list")
		 */
		@RequiresPermissions("system:user:list")
		@PostMapping("/export")
		@ResponseBody
		public TableDataInfo list(User user)
		{
			//开始页的数据
			startPage();
			//获取用户信息数据
			List<User> list=userService.selectUserList(user);
			return getDataTable(list);
		}
		
		/*
		 * 返回为ajax请求的用户信息
		 */
		@RequiresPermissions("system:user:export")
		@PostMapping("/export")
		@ResponseBody
		public AjaxResult export(User user) 
		{
			//调取业务层方法获取用户信息
			List<User> list= userService.selectUserList(user);
			//Excel的工具类获取对象
			ExcelUtil<User> util=new ExcelUtil<User>(User.class);
			return util.exportExcel(list, "user");
		}
}
