/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.icw.oa.doc.entity;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * OA文档发布Entity
 * @author ICW
 * @version 2019-03-24
 */
@Table(name="icw_oa_doc", alias="a", columns={
		@Column(name="id", attrName="id", label="编号", isPK=true),
		@Column(name="doc_title", attrName="docTitle", label="标题", queryType=QueryType.LIKE),
		@Column(name="doc_type", attrName="docType", label="类型"),
		@Column(name="doc_keyword", attrName="docKeyword", label="关键字", queryType=QueryType.LIKE),
		@Column(name="doc_content", attrName="docContent", label="内容", isQuery=false),
		@Column(name="doc_send_username", attrName="docSendUsername", label="发送人", isQuery=false),
		@Column(name="doc_isattac", attrName="docIsattac", label="是否有附件", isQuery=false),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class Doc extends DataEntity<Doc> {
	
	private static final long serialVersionUID = 1L;
	private String docTitle;		// 标题
	private String docType;		// 类型
	private String docKeyword;		// 关键字
	private String docContent;		// 内容
	private String docSendUsername;		// 发送人
	private String docIsattac;		// 是否有附件
	
	public Doc() {
		this(null);
	}

	public Doc(String id){
		super(id);
	}
	
	@NotBlank(message="标题不能为空")
	@Length(min=0, max=200, message="标题长度不能超过 200 个字符")
	public String getDocTitle() {
		return docTitle;
	}

	public void setDocTitle(String docTitle) {
		this.docTitle = docTitle;
	}
	
	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}
	
	@Length(min=0, max=200, message="关键字长度不能超过 200 个字符")
	public String getDocKeyword() {
		return docKeyword;
	}

	public void setDocKeyword(String docKeyword) {
		this.docKeyword = docKeyword;
	}
	
	public String getDocContent() {
		return docContent;
	}

	public void setDocContent(String docContent) {
		this.docContent = docContent;
	}
	
	public String getDocSendUsername() {
		return docSendUsername;
	}

	public void setDocSendUsername(String docSendUsername) {
		this.docSendUsername = docSendUsername;
	}
	
	public String getDocIsattac() {
		return docIsattac;
	}

	public void setDocIsattac(String docIsattac) {
		this.docIsattac = docIsattac;
	}
	
}