package com.example.finterm.user.mapper;

import com.example.finterm.user.domain.AccountVO;
import org.springframework.stereotype.Repository;

@Repository("com.example.finterm.user.mapper.AccountMapper")
public interface AccountMapper {
    // 유저 추가
    public int accountInsert(AccountVO accountVO) throws Exception;
}
