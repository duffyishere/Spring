package org.duffy.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	
	private Long bno;
	private String title, context, writer;
	private Date regdate, updatedate;

} 
