package org.duffy.service;

import java.util.List;

import org.duffy.domain.BoardVO;
import org.duffy.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper boardMapper;
	
	public BoardServiceImpl() {}
	
	@Override
	public void register(BoardVO board) {
		log.info("register........."+board);
		
		boardMapper.insertSelectKey(board);
	}

	@Override
	public List<BoardVO> getListAll() {
		log.info("get all List........");
		
		return boardMapper.getList();
	}

	@Override
	public BoardVO getList(Long bno) {
		log.info("getList........"+bno);
		
		return boardMapper.read(bno);
	}

	@Override
	public boolean remove(Long bno) {
		log.info("remove......."+bno);
		
		return boardMapper.delete(bno)==1;
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info("modify......."+board);
		
		return boardMapper.update(board)==1;
	}

}
