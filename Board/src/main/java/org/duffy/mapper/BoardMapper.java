package org.duffy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.duffy.domain.BoardVO;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BoardMapper {

	public List<BoardVO> getList();
	
	public BoardVO read(Long bno);
	
	public int insert(BoardVO board);
	
	public int update(BoardVO board);
	
	public int delete(Long bno);
}
