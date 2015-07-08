package com.yang.framework.util;

import java.util.List;

@SuppressWarnings("rawtypes")
public class Pager {

	public static final long DEFAULT_PAGE_SIZE = 10l;

	public static final long DEFAULT_BIG_PAGE_SIZE = 10000l;

	private long rowCount = 0; // 记录总数

	private long pageCount = 1; // 分页总数

	private long pageSize = 10; // 每页记录数

	private long pageNum = 1; // 当前页数

	private long startIndex = 1; // 起始记录数

	private long endIndex = 1; // 结束记录数

    private List list;// 记录列表

	public Pager() {
	}

	public long getRowCount() {
		return rowCount;
	}

	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
	}

	public long getPageCount() {
		pageCount = rowCount / pageSize;
		if (rowCount % pageSize > 0) {
			pageCount++;
		}
		return pageCount;
	}

	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}

	public long getPageSize() {
		return pageSize;
	}

	public void setPageSize(long pageSize) {
		if (pageSize < 1) {
			pageSize = 1;
		}
		this.pageSize = pageSize;
	}

	public long getPageNum() {
		return pageNum;
	}

	public void setPageNum(long pageNum) {
		if (pageNum < 1) {
			pageNum = 1;
		}
		this.pageNum = pageNum;
	}

	public long getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(long startIndex) {
		this.startIndex = startIndex;
	}

	public long getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(long endIndex) {
		this.endIndex = endIndex;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
}
