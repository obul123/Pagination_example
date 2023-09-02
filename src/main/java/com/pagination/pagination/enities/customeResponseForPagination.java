package com.pagination.pagination.enities;

import java.util.List;

public class customeResponseForPagination<T> {

	private int pageSize;
	private int pageNum;
	private int noOfPages;
	public int totalNoOfRecords;
	private String hasNext;
	private List<T> list;

	public customeResponseForPagination() {
		super();
		// TODO Auto-generated constructor stub
	}

	public customeResponseForPagination(int pageSize, int pageNum, int noOfPages, int totalNoOfRecords, String hasNext,
			List<T> list) {
		super();
		this.pageSize = pageSize;
		this.pageNum = pageNum;
		this.noOfPages = noOfPages;
		this.totalNoOfRecords = totalNoOfRecords;
		this.hasNext = hasNext;
		this.list = list;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getNoOfPages() {
		return noOfPages;
	}

	public void setNoOfPages(int noOfPages) {
		this.noOfPages = noOfPages;
	}

	public int getTotalNoOfRecords() {
		return totalNoOfRecords;
	}

	public void setTotalNoOfRecords(int totalNoOfRecords) {
		this.totalNoOfRecords = totalNoOfRecords;
	}

	public String getHasNext() {
		return hasNext;
	}

	public void setHasNext(String hasNext) {
		this.hasNext = hasNext;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "customeResponseForPagination [pageSize=" + pageSize + ", pageNum=" + pageNum + ", noOfPages="
				+ noOfPages + ", totalNoOfRecords=" + totalNoOfRecords + ", hasNext=" + hasNext + ", list=" + list
				+ "]";
	}

}
