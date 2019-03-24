/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.icw.oa.doc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.icw.oa.doc.entity.Doc;
import com.icw.oa.doc.dao.DocDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * OA文档发布Service
 * @author ICW
 * @version 2019-03-24
 */
@Service
@Transactional(readOnly=true)
public class DocService extends CrudService<DocDao, Doc> {
	
	/**
	 * 获取单条数据
	 * @param doc
	 * @return
	 */
	@Override
	public Doc get(Doc doc) {
		return super.get(doc);
	}
	
	/**
	 * 查询分页数据
	 * @param doc 查询条件
	 * @param doc.page 分页对象
	 * @return
	 */
	@Override
	public Page<Doc> findPage(Doc doc) {
		return super.findPage(doc);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param doc
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(Doc doc) {
		super.save(doc);
		// 保存上传附件
		FileUploadUtils.saveFileUpload(doc.getId(), "doc_file");
	}
	
	/**
	 * 更新状态
	 * @param doc
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(Doc doc) {
		super.updateStatus(doc);
	}
	
	/**
	 * 删除数据
	 * @param doc
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(Doc doc) {
		super.delete(doc);
	}
	
}