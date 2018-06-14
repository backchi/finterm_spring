package com.example.finterm.user.service;

import com.example.finterm.user.domain.AccountVO;
import com.example.finterm.user.mapper.AccountMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("com.example.finterm.user.service.AccountService")
public class AccountService {
    @Resource(name="com.example.finterm.user.mapper.AccountMapper")
    AccountMapper accountMapper;

    public int accountInsertService(AccountVO accountVO) throws Exception{
        return accountMapper.accountInsert(accountVO);
    }
}
