package com.example.demo.repository;

import com.example.demo.dto.TestDto;
import com.example.demo.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<TestEntity, Integer> {
    /* Read */
    TestEntity findAllByNameAndAge(String name, Integer age);

    boolean existsById(Integer id);

    /* Update */

    /* Delete */
    void deleteById(Integer id);
}
