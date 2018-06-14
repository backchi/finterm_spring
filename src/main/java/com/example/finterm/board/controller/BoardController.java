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
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Controller
public class BoardController {

    @Resource(name = "com.example.finterm.board.service.BoardService")
    BoardService mBoardService;

    @RequestMapping("/list") //게시판 리스트 화면 호출
    private String boardList(Model model) throws Exception {

        model.addAttribute("list", mBoardService.boardListService());

        return "posts"; //생성할 jsp
    }

    @RequestMapping("/detail/{bno}")
    private String boardDetail(@PathVariable int bno, Model model) throws Exception {

        model.addAttribute("detail", mBoardService.boardDetailService(bno));

        return "detail";
    }

    @RequestMapping("/insert") //게시글 작성폼 호출
    private String boardInsertForm() {

        return "insert";
    }

    @RequestMapping("/insertProc")
    private String boardInsertProc(HttpServletRequest request, @RequestPart MultipartFile files) throws Exception {

        BoardVO board = new BoardVO();
        FileVO file = new FileVO();

        board.setTitle(request.getParameter("title"));
        board.setContent(request.getParameter("content"));
        board.setUsername(request.getParameter("username"));

        if (files.isEmpty()) {
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
    @RequestMapping("/update/{id}") //게시글 작성폼 호출
    private String boardUpdateForm(@PathVariable int id, Model model) throws Exception{
        model.addAttribute("detail", mBoardService.boardDetailService(id));

        return "update";
    }
    @RequestMapping("/updateProc")
    private String boardUpdateProc(HttpServletRequest request, @RequestPart MultipartFile files) throws Exception {
        BoardVO board = new BoardVO();
        FileVO file = new FileVO();

        board.setTitle(request.getParameter("title"));
        board.setContent(request.getParameter("content"));
        board.setUsername(request.getParameter("username"));
        board.setId(Integer.parseInt(request.getParameter("id")));

        if (files.isEmpty()) {
            mBoardService.boardUpdateService(board);
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

            mBoardService.boardUpdateService(board);

            file.setId(board.getId());
            file.setFileName(destinationFileName);
            file.setFileOriName(fileName);
            file.setFileUrl(fileUrl);

            mBoardService.fileUpdateService(file); //file insert
        }

        return "redirect:/detail/" + request.getParameter("id");
    }

    @RequestMapping("/delete/{id}")
    private String boardDelete(@PathVariable int id) throws Exception {

        mBoardService.boardDeleteService(id);

        return "redirect:/list";
    }

    @RequestMapping("/image")
    private String showImage(String url, HttpServletRequest request) {
        request.setAttribute("path", url);
        return "/image";
    }

    //loginCheck 함수 수행
    @RequestMapping(value="/login/loginCheck")
    public String loginCheck(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int check = mBoardService.loginCheck(request.getParameter("id"), request.getParameter("password"));
        String returnUrl = "";

        if (check == 1) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", request.getParameter("id"));
            request.getSession().setAttribute("login", map);

            returnUrl = "redirect:/list";
        } else {
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('땡'); location.href='/list'</script>");
            out.flush();
        }

        return returnUrl;
    }
    //로그아웃 컨트롤러
    @RequestMapping(value="/login/logout")
    public String logOut(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/list";
    }


}
