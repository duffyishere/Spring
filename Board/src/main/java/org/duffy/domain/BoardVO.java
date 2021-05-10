package org.duffy.domain;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class BoardVO {

	private Long bno;
	private String title;
	private String context;
	private String writer;
	private Date regDate;
	private Date updateDate;
}
