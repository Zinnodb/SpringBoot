package com.light.project.system.menu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.light.project.system.menu.domain.Menu;
import com.light.project.system.menu.mapper.MenuMapper;

/**
 * 菜单  业务层处理
 *
 * @author innozhang
 *
 */
@Service
public class MenuServiceImpl implements IMenuService 
{
	
	private MenuMapper MenuMapper;
	
	/**
	 * 查询菜单集合
	 * 
	 *  @return 所有菜单信息
	 */
	@Override
	public List<Menu> selectMenuAll() {
		return MenuMapper.selectMenuAll();
	}
	
	/**
	 * 查询系统菜单列表
	 * 
	 * @param menu 菜单信息
	 * @return 菜单列表 
	 */
	public List<Menu> selectMenuList(Menu menu) 
	{
		return null;
	}
}
