package com.light.project.system.menu.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.light.framework.web.controller.BaseController;
import com.light.framework.web.domain.AjaxResult;
import com.light.project.system.menu.domain.Menu;
import com.light.project.system.menu.service.IMenuService;

/**
 * 菜单信息
 *
 * @author innozhang
 *
 */
@Controller
@RequestMapping("/system/menu")
public class MenuController extends BaseController
{
		private String prefix="system/menu";
		
		@Autowired
		private IMenuService menuService;
		/*
		 * 验证用户登录记忆，以及初始页面跳转
		 */
		@RequiresPermissions("system:menu:view")
		@GetMapping()
		public String menu()
		{
			return prefix+"/menu";
		}
		
		/*
		 * 页面数据展示
		 */
		@RequiresPermissions("system:menu:list")
		@GetMapping("/list")
		@ResponseBody
		public List<Menu> menuList(Menu menu)
		{
			//调用业务层获取数据
			return menuService.selectMenuList(menu);
		}
}
