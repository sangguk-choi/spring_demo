package com.example.demo.service;

import com.example.demo.data.TestData;
import com.example.demo.entity.TestEntity;
import com.example.demo.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository testRepository;

    public TestEntity read(String name, String age)
    {
        TestEntity testEntity = testRepository.findAllByNameAndAge(name, age);

        return testEntity;
    }

    public TestEntity create(TestData testData)
    {
        TestEntity testEntity = new TestEntity();

        testEntity.setAge(testData.getAge());
        testEntity.setName(testData.getName());
        testEntity.setHometown(testData.getHometown());

        testEntity = testRepository.save(testEntity);

        return testEntity;
    }

    public TestEntity update(Integer id, TestData testData) {

        TestEntity testEntity = new TestEntity();

        testEntity.setId(id);
        testEntity.setAge(testData.getAge());
        testEntity.setName(testData.getName());
        testEntity.setHometown(testData.getHometown());

        testEntity = testRepository.save(testEntity);

        return testEntity;
    }

    public TestEntity delete(TestData testData)
    {
        TestEntity testEntity = testRepository.findAllByNameAndAgeAndHometown(testData.getName(), testData.getAge(), testData.getHometown());

        testRepository.deleteById(testEntity.getId());

        return testEntity;
    }
}
