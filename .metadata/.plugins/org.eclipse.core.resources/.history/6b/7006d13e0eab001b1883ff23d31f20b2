package org.duffy.service;

import java.util.List;

import org.duffy.domain.BoardVO;
import org.duffy.domain.Criteria;
import org.duffy.domain.ReplyPageDTO;
import org.duffy.domain.ReplyVO;
import org.duffy.mapper.BoardMapper;
import org.duffy.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
@NoArgsConstructor
public class ReplyServiecImpl implements ReplyService{

	@Setter(onMethod_ = {@Autowired})
	private ReplyMapper replyMapper;
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Transactional
	@Override
	public int register(ReplyVO replyVO) {

		log.info("register......."+replyVO);
		
		boardMapper.updateReplyCnt(replyVO.getBno(), 1);
		
		return replyMapper.insert(replyVO);
	}

	@Override
	public ReplyVO get(Long rno) {
		
		log.info("get........"+rno);
		return replyMapper.read(rno);
	}

	@Override
	public int modify(ReplyVO replyVO) {
		
		log.info("modify........."+replyMapper);
		return replyMapper.update(replyVO);
	}

	@Override
	public int remove(Long rno) {
		
		log.info("remove......."+rno);
		
		ReplyVO reply = replyMapper.read(rno);
		
		boardMapper.updateReplyCnt(reply.getBno(), -1);
		
		return replyMapper.delete(rno);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {
		
		log.info("getList........."+bno);
		return replyMapper.getListWithPaging(cri, bno);
	}

	@Override
	public ReplyPageDTO getListPage(Criteria cri, Long bno) {
		
		log.info("getListPage........."+bno);
		return new ReplyPageDTO(replyMapper.getCountByBno(bno), replyMapper.getListWithPaging(cri, bno));
	}
	
}
