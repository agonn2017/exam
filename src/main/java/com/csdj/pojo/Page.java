package com.csdj.pojo;

import java.util.List;

public class Page {
	private int pageSize;//页大小
	private int totalPage; //总页数
	private int curPageNo; //当前页码
	private int totalCount; //总记录数
	private List<Paper> pageList;//显示的数据列表
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurPageNo() {
		return curPageNo;
	}
	public void setCurPageNo(int curPageNo) {
		this.curPageNo = curPageNo;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		//由总记录数算出总页数
		if(totalCount%pageSize==0) {
			this.totalPage=totalCount/pageSize;
		}
		else {
			this.totalPage=totalCount/pageSize+1;
		}
	}
	public List<Paper> getPageList() {
		return pageList;
	}
	public void setPageList(List<Paper> pageList) {
		this.pageList = pageList;
	}
}
