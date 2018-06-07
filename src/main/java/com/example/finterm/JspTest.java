package com.example.finterm;

import com.example.finterm.board.mapper.BoardMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class JspTest {
    @Resource(name="com.example.finterm.board.mapper.BoardMapper")
    BoardMapper mBoardMapper;

    @RequestMapping("/test")
    private String jspTest() throws Exception{

        System.out.println(mBoardMapper.boardCount()); // <<<<TEST

        return "test";
    }
}
