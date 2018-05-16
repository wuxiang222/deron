package com.wux.entity;

import java.util.List;

public class PageData<T> {
	private List<T> rows;
	private Integer total;
	public PageData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageData(List<T> rows, Integer total) {
		super();
		this.rows = rows;
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "PageData [rows=" + rows + ", total=" + total + "]";
	}
}
