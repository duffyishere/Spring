package org.duffy.domain;

import lombok.Data;

@Data
public class BoardAttachVO {

	private String uuid, filePath, fileName;
	private boolean fileType;
	private Long bno;
}
