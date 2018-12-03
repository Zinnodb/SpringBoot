package com.light.project.system.menu.mapper;

import java.util.List;

import com.light.project.system.menu.domain.Menu;

/**
 * 菜单表 数据层
 *
 * @author innozhang
 *
 */
public interface MenuMapper 
{
		/**
		 * 查询系统所有菜单（含按钮）
		 * @return 菜单列表
		 */
		public List<Menu> selectMenuAll();
		
		/**
		 * 查询系统菜单列表
		 * 
		 * @param menu 菜单信息
		 * @return 菜单列表 
		 */
		public List<Menu> selectMenuList(Menu menu);
}
