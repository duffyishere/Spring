package org.duffy.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageDTO {

	private int total;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	private Criteria criteria;
	
	public PageDTO(Criteria cri, int total) {

		this.criteria = cri;
		this.total = total;
		this.endPage = (int) (Math.ceil(cri.getPageNum()/10.0)*10);
		this.startPage = this.endPage-9;
		int realEnd = (int) Math.ceil(total/10.0);
		
		if(realEnd<=endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage!=1;
		this.next = this.endPage<realEnd;

	}
}
