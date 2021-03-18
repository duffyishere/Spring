package org.duffy.mapper;

import org.apache.ibatis.annotations.Select;
import org.duffy.domain.BoardVO;

import java.util.List;

public interface BoardMapper {

//    @Select("select * from tbl_board where bno>0 and ROWNUM>0 and ROWNUM <= 20")
    public List<BoardVO> getList();
    public void insert(BoardVO boardVO);
    public int insertSelectKey(BoardVO boardVO);
    public BoardVO read(Long bno);
    public int delete(Long bno);
    public int update(BoardVO boardVO);
}
