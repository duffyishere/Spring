package org.duffy.mapper;

import java.util.List;
import java.util.Map;

import org.duffy.domain.BoardVO;
import org.duffy.domain.Criteria;

public interface BoardMapper {
	
//	@Select("select * from tbl_board order by bno desc")
	List<BoardVO> getList();
	
	void insert(BoardVO vo);
	
	void insertSelectKey(BoardVO vo);
	
	BoardVO read(Long bno);
	
	int delete(Long bno);
	
	int update(BoardVO vo);
	
	List<BoardVO> getListWithPaging(Criteria cri);
	
	List<BoardVO> searchTest(Map<String, Map<String, String>> map);
}
