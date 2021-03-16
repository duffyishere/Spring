package org.duffy.service;

import java.util.List;

import org.duffy.domain.BoardVO;
import org.duffy.domain.Criteria;
import org.duffy.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Service
@RequiredArgsConstructor
@ToString
public class BoardServiceImpl implements BoardService{
	
	private final BoardMapper mapper;

	@Override
	public void register(BoardVO board) {
		mapper.insert(board);		
	}

	@Override
	public BoardVO get(Long bno) {
		return mapper.read(bno);
	}

	@Override
	public int modify(BoardVO board) {
		return mapper.update(board);
	}

	@Override
	public int remove(Long bno) {
		return mapper.delete(bno);
	}

	@Override
	public List<BoardVO> getList() {
		return mapper.getList();
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		return mapper.getListWithPaging(cri);
	}

	
	
}
