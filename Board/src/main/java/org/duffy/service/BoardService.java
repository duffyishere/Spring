package org.duffy.service;

import java.util.List;

import org.duffy.domain.BoardVO;

public interface BoardService {

	public List<BoardVO> getList();
	
	public BoardVO read(Long bno);
	
	public int register(BoardVO board);
	
	public int modify(BoardVO board);
	
	public int remove(Long bno);
}
