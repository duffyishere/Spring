package org.duffy.service;

import java.util.List;

import org.duffy.domain.BoardVO;
import org.duffy.domain.Criteria;

public interface BoardService {

	public List<BoardVO> getList(Criteria cri);
	
	public BoardVO read(Long bno);
	
	public Long register(BoardVO board);
	
	public boolean modify(BoardVO board);
	
	public boolean delete(Long bno);
	
	public int getTotal(Criteria cri);
}
