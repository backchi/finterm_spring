package com.example.finterm.board.service;

import com.example.finterm.board.domain.BoardVO;
import com.example.finterm.board.domain.FileVO;
import com.example.finterm.board.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("com.example.finterm.board.service.BoardService")
public class BoardService {
    @Resource(name="com.example.finterm.board.mapper.BoardMapper")
    BoardMapper mBoardMapper;

    public List<BoardVO> boardListService() throws Exception{
        return mBoardMapper.boardList();
    }

    public BoardVO boardDetailService(int bno) throws Exception{
        return mBoardMapper.boardDetail(bno);
    }

    public int boardInsertService(BoardVO board) throws Exception{
        return mBoardMapper.boardInsert(board);
    }

    public int fileInsertService(FileVO file) throws Exception{
        return mBoardMapper.fileInsert(file);
    }

    public int boardUpdateService(BoardVO board) throws Exception{
        return mBoardMapper.boardUpdate(board);
    }

    public int boardDeleteService(int bno) throws Exception{
        return mBoardMapper.boardDelete(bno);
    }

    public int loginCheck(String id, String password) {
        return mBoardMapper.loginCheck(id, password);
    }
}
