package org.duffy.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Getter
@ToString
@Log4j
public class Criteria {

	private int pageNum;
	private int amount;

	public Criteria() {
		this(1);
	}
	
	public Criteria(int pageNum) {
		this.amount = (pageNum-1)*10;
		this.pageNum = pageNum;
	}
	
	public void setAmount() {
		log.info("pageNum: "+getPageNum());
		this.amount = (getPageNum()-1)*10;
	}
	
	public void setAmount(int amount) {
		log.info("pageNum: "+getPageNum());
		this.amount = (getPageNum()-1)*10;
	}
	
	public void setPageNum(int pageNum) {
		log.info("pageNum: "+getPageNum());
		this.amount = (pageNum-1)*10;
		this.pageNum = pageNum;
	}
	public void setPaegNum() {
		this.amount= 0;
		this.pageNum = 1;
	}
	

}
