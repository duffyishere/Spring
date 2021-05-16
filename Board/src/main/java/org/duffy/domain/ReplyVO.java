package org.duffy.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	private Long rno;
	private Long bno;

	private String replyer;
	private String reply;
	
	private Date replyDate;
	private Date updateDate;
}
