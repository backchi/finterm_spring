package com.example.finterm.user.domain;

import lombok.Data;

@Data
public class AccountVO {
    private String id;
    private String password;
    private String name;
    private int tel;
}
