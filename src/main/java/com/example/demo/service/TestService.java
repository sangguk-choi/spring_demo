package com.example.demo.service;

import com.example.demo.dto.TestDto;
import com.example.demo.entity.TestEntity;
import com.example.demo.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository testRepository;
    public TestDto findAllByNameAndAge(String name, Integer age){

        TestDto testDto = new TestDto();
        TestEntity testEntity = new TestEntity();

        testEntity = testRepository.findAllByNameAndAge(name, age);

        testDto.setId(testEntity.getId());
        testDto.setName(testEntity.getName());
        testDto.setAge(testEntity.getAge());
        testDto.setHometown(testEntity.getHometown());

        return testDto;
    }
    
}
