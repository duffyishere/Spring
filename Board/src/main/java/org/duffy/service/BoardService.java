package org.duffy.service;

import org.duffy.domain.BoardVO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BoardService {
    public List<BoardVO> readList();
}
