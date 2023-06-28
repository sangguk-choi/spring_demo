package com.example.demo.dto;

import lombok.Data;

@Data
public class UserCreateDto {
    private String userid;

    private String password;

    private String email;

    private String job;

    private String company;

    private String description;
}
