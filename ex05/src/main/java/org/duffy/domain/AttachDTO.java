package org.duffy.domain;

import lombok.Data;

@Data
public class AttachDTO {
	
	private String fileName, uploadPath, uuid;
	private boolean image;
}
