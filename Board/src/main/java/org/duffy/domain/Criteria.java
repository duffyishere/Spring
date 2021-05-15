package org.duffy.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Setter
@Getter
@ToString
@Log4j
public class Criteria {

	private int pageNum;
	private int amount;
	private String keyword;

	public Criteria() {
		this(1);
	}
	
	public Criteria(int pageNum) {
		this.pageNum = pageNum;
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
	
	public void setKeyword(String keyword) {
		char c = keyword.charAt(keyword.length() -1);
		
		log.info(c);
		
		if(c != '%') {
			log.info("not equals........");
			this.keyword = keyword+"%";
		}
		else {
			log.info("equals........");
			this.keyword = keyword;
		}
		
	}
}
