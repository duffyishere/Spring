package org.duffy.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReplyPageDTO {

	private int replyCount;
	private List<ReplyVO> list;
}
