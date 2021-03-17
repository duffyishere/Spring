package org.duffy.mapper;

import org.apache.ibatis.annotations.Select;
import org.duffy.domain.BoardVO;

import java.util.List;

public interface BoardMapper {

//    @Select("select * from tbl_board where bno>0 and ROWNUM>0 and ROWNUM <= 20")
    public List<BoardVO> getList();
}
