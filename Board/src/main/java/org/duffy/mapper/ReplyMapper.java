package org.duffy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.duffy.domain.ReplyVO;

@Mapper
public interface ReplyMapper {

	public List<ReplyVO> getList(Long bno);
	public ReplyVO read(Long rno);
	public int insert(ReplyVO reply);
	public int delete(Long rno);
	public int modify(ReplyVO reply);
}
