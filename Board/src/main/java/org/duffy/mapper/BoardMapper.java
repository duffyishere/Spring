package org.duffy.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.duffy.domain.BoardVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BoardMapper {

    @Select("select * from tbl_board")
    public List<BoardVO> getList();
}
