package org.duffy.service;


import lombok.extern.log4j.Log4j;
import org.duffy.domain.BoardVO;
import org.duffy.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardMapper mapper;

    @Override
    public List<BoardVO> readList() {

        log.info("read List,,,,,,,,,");
        return mapper.getList();
    }
}
