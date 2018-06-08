package com.example.finterm.board.controller;

import com.example.finterm.board.domain.BoardVO;
import com.example.finterm.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class BoardController {
    @Resource(name="com.example.finterm.board.service.BoardService")
    BoardService mBoardService;

    @RequestMapping("/list") //게시판 리스트 화면 호출
    private String boardList(Model model) throws Exception{

        model.addAttribute("list", mBoardService.boardListService());

        return "list"; //생성할 jsp
    }

    @RequestMapping("/detail/{bno}")
    private String boardDetail(@PathVariable int bno, Model model) throws Exception{

        model.addAttribute("detail", mBoardService.boardDetailService(bno));

        return "detail";
    }

    @RequestMapping("/insert") //게시글 작성폼 호출
    private String boardInsertForm(){

        return "insert";
    }

    @RequestMapping("/insertProc")
    private String boardInsertProc(HttpServletRequest request) throws Exception{

        BoardVO board = new BoardVO();

        board.setTitle(request.getParameter("title"));
        board.setContent(request.getParameter("content"));

        mBoardService.boardInsertService(board);

        return "redirect:/list";
    }

    @RequestMapping("/update/{bno}") //게시글 수정폼 호출
    private String boardUpdateForm(@PathVariable int bno, Model model) throws Exception{

        model.addAttribute("detail", mBoardService.boardDetailService(bno));

        return "update";
    }

    @RequestMapping("/updateProc")
    private int boardUpdateProc(HttpServletRequest request) throws Exception{

        BoardVO board = (BoardVO) request.getParameterMap();

        return mBoardService.boardUpdateService(board);
    }

    @RequestMapping("/delete/{bno}")
    private String boardDelete(@PathVariable int bno) throws Exception{

        mBoardService.boardDeleteService(bno);

        return "redirect:/list";
    }
}
