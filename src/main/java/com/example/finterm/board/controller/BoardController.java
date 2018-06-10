package com.example.finterm.board.controller;

import com.example.finterm.board.domain.BoardVO;
import com.example.finterm.board.domain.FileVO;
import com.example.finterm.board.service.BoardService;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
public class BoardController {
    @Resource(name="com.example.finterm.board.service.BoardService")
    BoardService mBoardService;

    @RequestMapping("/list") //게시판 리스트 화면 호출
    private String boardList(Model model) throws Exception{

        model.addAttribute("list", mBoardService.boardListService());

        return "posts"; //생성할 jsp
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
    private String boardInsertProc(HttpServletRequest request, @RequestPart MultipartFile files) throws Exception{

        BoardVO board = new BoardVO();
        FileVO file  = new FileVO();

        board.setTitle(request.getParameter("title"));
        board.setContent(request.getParameter("content"));

        if(files.isEmpty()){
            mBoardService.boardInsertService(board);
        } else {
            String fileName = files.getOriginalFilename();
            String fileNameExtension = FilenameUtils.getExtension(fileName).toLowerCase();
            File destinationFile;
            String destinationFileName;
            String fileUrl = "C:/Users/ekgml/Desktop/finterm_spring/src/main/webapp/WEB-INF/uploadFiles/";

            do {
                destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + fileNameExtension;
                destinationFile = new File(fileUrl + destinationFileName);
            } while (destinationFile.exists());

            destinationFile.getParentFile().mkdirs();
            files.transferTo(destinationFile);

            mBoardService.boardInsertService(board);

            file.setId(board.getId());
            file.setFileName(destinationFileName);
            file.setFileOriName(fileName);
            file.setFileUrl(fileUrl);

            mBoardService.fileInsertService(file); //file insert
        }

        return "redirect:/list";
    }

    @RequestMapping("/updateProc")
    private String boardUpdateProc(HttpServletRequest request) throws Exception{
        BoardVO board = new BoardVO();
        board.setTitle(request.getParameter("title"));
        board.setContent(request.getParameter("content"));
        board.setId(Integer.parseInt(request.getParameter("id")));

        mBoardService.boardUpdateService(board);

        return "redirect:/detail/"+request.getParameter("id");
    }

    @RequestMapping("/delete/{bno}")
    private String boardDelete(@PathVariable int bno) throws Exception{

        mBoardService.boardDeleteService(bno);

        return "redirect:/list";
    }

    @RequestMapping("/image")
    private String showImage(String url, HttpServletRequest request) {
        request.setAttribute("path", url);
        return "/image";
    };
}
