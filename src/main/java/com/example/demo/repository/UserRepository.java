package com.example.demo.repository;

import com.example.demo.entity.UserEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    List<UserEntity> findAllByJobAndDescription(String job, String description, Pageable pageable);

    UserEntity findAllByNameAndUserid(String name, String userid);

    UserEntity findAllByUseridAndPassword(String userid, String pasword);

    UserEntity findAllByNameAndUseridAndPassword(String name, String userid, String password);
}
