package org.duffy.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BoardVO {

	private Long bno;
	private String title, writer, context;
	private Date regDate, updateDate;
	
	private int replyCnt;
	
	private List<BoardAttachVO> attachList;
}
