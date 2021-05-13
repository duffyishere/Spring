package org.duffy.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Criteria {

	private int pageNum;
	private int amount;

	public Criteria() {
		this.pageNum = 1;
		this.amount = 0;
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = (pageNum-1)*10;
	}

}
