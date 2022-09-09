package com.huangydyn.sharding.pojo;

import lombok.Data;

@Data
public class UserModel {

    private static final long serialVersionUID = -1205226416664488559L;

    private Long id;

    private String username;

    private String password;
}