package com.example.demo.repository;

import com.example.demo.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestRepository extends JpaRepository<TestEntity, Integer> {
    TestEntity findAllByNameAndAge(String name, String age);

    TestEntity findAllByNameAndAgeAndHometown(String name, String age, String hometown);
}