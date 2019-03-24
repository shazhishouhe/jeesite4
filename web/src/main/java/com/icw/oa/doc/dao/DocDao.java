/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.icw.oa.doc.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.icw.oa.doc.entity.Doc;

/**
 * OA文档发布DAO接口
 * @author ICW
 * @version 2019-03-24
 */
@MyBatisDao
public interface DocDao extends CrudDao<Doc> {
	
}