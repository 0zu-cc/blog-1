package com.yltrcc.blog.config;

import java.util.List;

import com.yltrcc.blog.model.domain.Options;
import com.yltrcc.blog.model.dto.BlogConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import com.yltrcc.blog.service.MenuService;
import com.yltrcc.blog.service.OptionsService;
import com.yltrcc.blog.service.ThemeService;

/**
 * @author yltrcc
 * @createDate : 2018年10月30日
 */
@Configuration
public class StartupConfig implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private OptionsService optionsService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private ThemeService themeService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		this.loadOptions();
		this.loadMenus();
		this.loadThemeName();
	}

	/**
	 * 加载设置选项
	 */
	private void loadOptions() {
		List<Options> listMap = optionsService.selectMap();
		if (listMap == null)
			return;
		if (listMap.size() == 0)
			return;
		for (Options options : listMap) {
			if(options.getOptionValue() == null || "".equals(options.getOptionValue()))
				continue;
			BlogConst.OPTIONS.put(options.getOptionName(), options.getOptionValue());
		}
	}

	/**
	 * 加载菜单
	 */
	private void loadMenus() {
		BlogConst.MENUS = menuService.findMenus();
	}
	/**
	 * 加载主题
	 */
	private void loadThemeName() {
		BlogConst.THEME_NAME=themeService.getEnabledTheme();
	}

}
