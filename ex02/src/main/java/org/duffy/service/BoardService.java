package org.duffy.service;

import java.util.List;

import org.duffy.domain.BoardVO;
import org.duffy.domain.Criteria;

public interface BoardService {

	void register(BoardVO board);
	
	BoardVO get(Long bno);
	
	int modify(BoardVO board);
	
	int remove(Long bno);
	
	List<BoardVO> getList();
	
	List<BoardVO> getList(Criteria cri);
} 
