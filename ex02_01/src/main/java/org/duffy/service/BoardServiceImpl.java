package org.duffy.service;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.duffy.domain.BoardVO;
import org.duffy.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{

    @Setter(onMethod_ = {@Autowired})
    private BoardMapper boardMapper;

    @Override
    public List<BoardVO> getAllPost() {
        log.info("getAllPost...........");
        return boardMapper.getList();
    }

    @Override
    public BoardVO getPost(Long bno) {
        log.info("getPost..............");
        return boardMapper.read(bno);
    }

    @Override
    public int register(BoardVO boardVO) {
        log.info("register........." + boardVO);
        return boardMapper.insertSelectKey(boardVO);
    }

    @Override
    public boolean remove(Long bno) {
        log.info("remove............"+bno);
        return boardMapper.delete(bno) > 0;
    }

    @Override
    public boolean modify(BoardVO boardVO) {
        log.info("modify............"+boardVO);
        return boardMapper.update(boardVO) > 0;
    }
}
