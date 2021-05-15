package org.duffy.service;

import java.util.List;

import org.duffy.domain.BoardVO;
import org.duffy.domain.Criteria;
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
	public List<BoardVO> getList(Criteria cri) {
		log.info("Service get List,,,,,,,,,,,cri :"+cri);
		
		
		return boardMapper.getList(cri);
	}

	@Override
	public BoardVO read(Long bno) {
		log.info("read,,,,,,,,,,"+bno);
		
		return boardMapper.read(bno);
	}

	@Override
	public Long register(BoardVO board) {
		log.info("register.........."+board.getBno());
		
		boardMapper.insert(board);
		
		return board.getBno();
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info("modify,,,,,,,,,,,"+board.getBno());
		
		return boardMapper.update(board)>=1? true: false;
	}

	@Override
	public boolean delete(Long bno) {
		log.info("remove,,,,,,,,,,,,"+bno);
		
		return boardMapper.delete(bno)>=1? true: false;
	}

	@Override
	public int getTotal(Criteria cri) {
		log.info("get total,,,,,,,, cri: "+cri);
		
		return boardMapper.getTotal(cri);
	}

}
