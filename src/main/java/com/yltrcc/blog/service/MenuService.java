package com.yltrcc.blog.service;

import java.util.List;

import com.yltrcc.blog.model.domain.Menu;

/**
 * @author yltrcc
 * @createDate : 2018年12月18日
 */
public interface MenuService {
	/**
	 * @return 所有菜单
	 */
	List<Menu> findMenus();

	/**
	 * 根据id查询
	 *
	 * @param menuId
	 * @return
	 */
	Menu findByMenuId(Integer menuId);

	/**
	 * 添加
	 *
	 * @param menu
	 */
	void save(Menu menu);

	/**
	 * 修改
	 *
	 * @param menu
	 */
	void edit(Menu menu);

	/**
	 * 移除
	 *
	 * @param menuId
	 */
	void remove(Integer menuId);

}
