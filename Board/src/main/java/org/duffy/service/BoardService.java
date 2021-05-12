package org.duffy.service;

import java.util.List;

import org.duffy.domain.BoardVO;

public interface BoardService {

	public List<BoardVO> getList();
	
	public BoardVO read(Long bno);
	
	public Long register(BoardVO board);
	
	public boolean modify(BoardVO board);
	
	public boolean delete(Long bno);
}
