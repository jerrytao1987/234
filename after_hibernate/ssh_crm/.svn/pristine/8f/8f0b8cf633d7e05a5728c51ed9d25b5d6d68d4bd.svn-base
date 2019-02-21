package cn.itcast.utils;

import java.util.List;

public class PageBean<T> {
	
	private Integer currentPage;
	private Integer totalCount;
	private Integer pageSize;
	private Integer totalPage;
	private List<T> list;
	public PageBean(Integer currentPage, Integer totalCount, Integer pageSize) {
		if(currentPage == null || currentPage<1){
			this.currentPage=1;
		}else{
			this.currentPage = currentPage;
		}
		if(totalCount==null||totalCount<0){
			this.totalCount=0;
		}else{
			this.totalCount = totalCount;
		}
		if(pageSize == null || pageSize<3){
			this.pageSize = 3;
		}else{
			this.pageSize = pageSize;
		}
		this.totalPage = (this.totalCount+this.pageSize-1)/this.pageSize;
		if(this.currentPage>this.totalPage){
			this.currentPage=this.totalPage;
		}
	}
	
	public int getStart(){
		//设置逆序排列的起始点
		int start = this.totalCount-this.currentPage*this.pageSize;
		if(start<=0){
			this.pageSize += start;
			return 0;
		}else{
			return start;
		}
		/*return (this.currentPage-1)*this.pageSize;*/
	}
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
}
