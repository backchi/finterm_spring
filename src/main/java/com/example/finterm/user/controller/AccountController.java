package com.example.finterm.user.controller;

import com.example.finterm.user.domain.AccountVO;
import com.example.finterm.user.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class AccountController {

    @Resource(name = "com.example.finterm.user.service.AccountService")
    AccountService accountService;

    @RequestMapping("/signup") //게시글 작성폼 호출
    private String boardInsertForm() {

        return "signup";
    }

    @RequestMapping("/signUpProc")
    private String boardInsertProc(HttpServletRequest request) throws Exception {

        AccountVO accountVO = new AccountVO();

        accountVO.setId(request.getParameter("id"));
        accountVO.setPassword(request.getParameter("password"));
        accountVO.setName(request.getParameter("name"));
        accountVO.setTel(Integer.parseInt(request.getParameter("tel")));

        accountService.accountInsertService(accountVO);

        return "redirect:/list";
    }

}
