package com.yltrcc.blog.web.controller.admin;

import java.util.List;
import java.util.Map;

import com.yltrcc.blog.model.domain.Options;
import com.yltrcc.blog.model.dto.BlogConst;
import com.yltrcc.blog.model.dto.JsonResult;
import com.yltrcc.blog.model.enums.BlogEnums;
import com.yltrcc.blog.service.OptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yltrcc
 * @createDate : 2018年10月12日
 */

@Controller
@RequestMapping("/admin/option")
public class OptionsController extends BaseController {
	@Autowired
	private OptionsService optionsService;

	/**
	 * 所有设置选项
	 *
	 * @param model
	 * @return
	 */
	@GetMapping
	public String option(Model model) {
		return "admin/admin_options";
	}

	/**
	 * 保存设置
	 *
	 * @param map
	 * @return
	 */
	@PostMapping(value = "/save")
	@ResponseBody
	public JsonResult save(@RequestParam Map<String, String> map) {
		try {
			optionsService.save(map);
			BlogConst.OPTIONS.clear();
			List<Options> listMap = optionsService.selectMap();
			if (listMap != null && listMap.size() > 0) {
				for (Options options : listMap) {
					if(options.getOptionValue() == null || "".equals(options.getOptionValue()))
						continue;
					BlogConst.OPTIONS.put(options.getOptionName(), options.getOptionValue());
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			return new JsonResult(BlogEnums.PRESERVE_ERROR.isFlag(), BlogEnums.PRESERVE_ERROR.getMessage());
		}
		return new JsonResult(BlogEnums.PRESERVE_SUCCESS.isFlag(), BlogEnums.PRESERVE_SUCCESS.getMessage());
	}
}
