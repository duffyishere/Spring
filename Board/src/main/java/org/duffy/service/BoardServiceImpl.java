package org.duffy.service;

import java.util.List;

import org.duffy.domain.BoardVO;
import org.duffy.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class BoardServiceImpl implements BoardService{

	@Setter(onMethod_ = @Autowired)
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardVO> getList() {
		log.info("get List,,,,,,,,,,,");
		
		return boardMapper.getList();
	}

	@Override
	public BoardVO read(Long bno) {
		log.info("read,,,,,,,,,,"+bno);
		
		return boardMapper.read(bno);
	}

	@Override
	public int register(BoardVO board) {
		log.info("register.........."+board.getBno());
		
		return boardMapper.insert(board);
	}

	@Override
	public int modify(BoardVO board) {
		log.info("modify,,,,,,,,,,,"+board.getBno());
		
		return boardMapper.update(board);
	}

	@Override
	public int delete(Long bno) {
		log.info("remove,,,,,,,,,,,,"+bno);
		
		return boardMapper.delete(bno);
	}

}
