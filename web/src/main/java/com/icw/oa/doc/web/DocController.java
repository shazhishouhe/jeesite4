/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.icw.oa.doc.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.icw.oa.doc.entity.Doc;
import com.icw.oa.doc.service.DocService;

/**
 * OA文档发布Controller
 * @author ICW
 * @version 2019-03-24
 */
@Controller
@RequestMapping(value = "${adminPath}/doc/doc")
public class DocController extends BaseController {

	@Autowired
	private DocService docService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public Doc get(String id, boolean isNewRecord) {
		return docService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("doc:doc:view")
	@RequestMapping(value = {"list", ""})
	public String list(Doc doc, Model model) {
		model.addAttribute("doc", doc);
		return "oa/doc/docList";
	}
	
	/**
	 * 查询我的发送列表
	 */
	@RequiresPermissions("doc:doc:view")
	@RequestMapping(value = {"mylist", ""})
	public String myList(Doc doc, Model model) {
		doc.setCreateBy(doc.getCurrentUser().getUserCode());
		model.addAttribute("doc", doc);
		return "oa/doc/myDocList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("doc:doc:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Doc> listData(Doc doc, HttpServletRequest request, HttpServletResponse response) {
		doc.setPage(new Page<>(request, response));
		Page<Doc> page = docService.findPage(doc);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("doc:doc:view")
	@RequestMapping(value = "form")
	public String form(Doc doc, Model model) {
		model.addAttribute("doc", doc);
		return "oa/doc/docForm";
	}

	/**
	 * 保存OA文档发布
	 */
	@RequiresPermissions("doc:doc:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated Doc doc) {
		doc.setDocSendUsername(doc.getCurrentUser().getUserName());
		docService.save(doc);
		return renderResult(Global.TRUE, text("保存成功！"));
	}
	
	/**
	 * 删除OA文档发布
	 */
	@RequiresPermissions("doc:doc:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Doc doc) {
		docService.delete(doc);
		return renderResult(Global.TRUE, text("删除成功！"));
	}
	
}