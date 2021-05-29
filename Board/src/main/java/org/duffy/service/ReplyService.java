package org.duffy.service;

import java.util.List;

import org.duffy.domain.ReplyVO;

public interface ReplyService {

	public List<ReplyVO> getReplyList(Long bno);
}
