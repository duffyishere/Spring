package org.duffy.mapper;

import org.duffy.domain.ReplyVO;

public interface ReplyMapper {
	public int insert(ReplyVO replyVO);
	
	public ReplyVO read(Long rno);
	
	public int delete(Long rno);
	
	public int update(ReplyVO replyVO);
}
