package co.qingmei.pm.utils;

import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.Page;


/**
 * 分页信息
 * 
 * @author roy tang
 * 
 *  2009-03-09
 */
public class PagesInfo {
	private int pageSize =20;//每页记录�?
	private int currentPage =1;//当前页面�?1�?小为1
	private int rowCount =0;//总记录数
	private int pageCount=0;//总页�?
	
	private List<Object> result = new ArrayList<Object>();
	
	
	public PagesInfo(Page  p){
		this.pageSize =p.getPageSize();
		this.currentPage =p.getPageNum();
		this.rowCount = (int) p.getTotal();
		this.pageCount = p.getPages();
		  
	}
	
	
	
	
	
	public PagesInfo( ){
		  
	}
	
	
	
	
	
	public List<Object> getResult() {
		return result;
	}





	public void setResult(List<Object> result) {
		this.result = result;
	}





	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}





	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public int getPageCount() {
		return pageCount;
	}
	 
	
	
	 
	

}
