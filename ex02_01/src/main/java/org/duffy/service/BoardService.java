package org.duffy.service;

import java.util.List;

import org.duffy.domain.BoardVO;

public interface BoardService {

	public void register(BoardVO board);
	
	public List<BoardVO> getListAll();
	
	public BoardVO getList(Long bno);
	
	public boolean remove(Long bno);
	
	public boolean modify(BoardVO board);
	
}
