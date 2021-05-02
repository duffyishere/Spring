package org.duffy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.duffy.domain.Criteria;
import org.duffy.domain.ReplyVO;

public interface ReplyMapper {
	
	public int insert(ReplyVO replyVO);
	
	public ReplyVO read(Long rno);
	
	public int delete(Long rno);
	
	public int deleteByBno(Long bno);
	
	public int update(ReplyVO replyVO);
	
	public List<ReplyVO> getListWithPaging(@Param("cri")Criteria cri, @Param("bno")Long bno);
	
	public int getCountByBno(Long bno);
}
