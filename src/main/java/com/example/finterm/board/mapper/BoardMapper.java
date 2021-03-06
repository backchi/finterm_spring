package com.example.finterm.board.mapper;

import com.example.finterm.board.domain.BoardVO;
import com.example.finterm.board.domain.FileVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("com.example.finterm.board.mapper.BoardMapper")
public interface BoardMapper {
    //게시글 개수
    public int boardCount() throws Exception;

    //게시글 목록
    public List<BoardVO> boardList() throws Exception;

    //게시글 상세
    public BoardVO boardDetail(int bno) throws Exception;

    //게시글 작성
    public int boardInsert(BoardVO board) throws Exception;

    //파일 업로드
    public int fileInsert(FileVO file) throws Exception;

    //게시글 수정
    public int boardUpdate(BoardVO board) throws Exception;

    //게시글 삭제
    public int boardDelete(int id) throws Exception;

    public int loginCheck(@Param("id") String id, @Param("password") String password);

    public int fileUpdate(FileVO file) throws Exception;
}
