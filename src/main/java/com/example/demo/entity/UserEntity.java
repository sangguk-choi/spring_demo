package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name= "user")
public class UserEntity {
    @Id
//    @GeneratedValue
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_seq")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "userid")
    private String userid;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "job")
    private String job;

    @Column(name = "company")
    private String company;

    @Column(name = "description")
    private String description;
}
