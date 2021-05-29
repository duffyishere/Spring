package org.duffy.service;

import java.util.List;

import org.duffy.domain.ReplyVO;
import org.duffy.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ReplyServiceImpl implements ReplyService{

	@Setter(onMethod_ = @Autowired)
	private ReplyMapper replyMapper;
	
	@Override
	public List<ReplyVO> getReplyList(Long bno) {
		
		log.info("(Service) getReplyList.............");
		return replyMapper.getList(bno);
	}

}
