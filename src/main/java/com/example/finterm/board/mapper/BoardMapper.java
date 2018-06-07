package com.example.finterm.board.mapper;

import org.springframework.stereotype.Repository;

@Repository("com.example.finterm.board.mapper.BoardMapper")
public interface BoardMapper {

    public int boardCount() throws Exception;
}
