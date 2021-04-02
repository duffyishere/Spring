package org.duffy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.duffy.domain.BoardVO;
import org.duffy.domain.Criteria;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface BoardMapper {
//	@Select("select * from tbl_board where bno>0 and ROWNUM>0 and ROWNUM <= 20")
	public List<BoardVO> getList();
	public List<BoardVO> getListWithPaging(Criteria cri);
	public void insert(BoardVO baord);
	public void insertSelectKey(BoardVO board);
	public BoardVO read(Long bno);
	public int delete(Long bno);
	public int update(BoardVO board);
}
