package org.duffy.service;

import org.duffy.domain.BoardVO;

import java.util.List;

public interface BoardService {
    List<BoardVO> getAllPost();
    BoardVO getPost(Long bno);
    int register(BoardVO boardVO);
    boolean remove(Long bno);
    boolean modify(BoardVO boardVO);
}
