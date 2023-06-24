package com.example.demo.service;

import com.example.demo.dto.TestData;
import com.example.demo.entity.TestEntity;
import com.example.demo.exception.ApiException;
import com.example.demo.exception.ApiExceptionEnum;
import com.example.demo.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository testRepository;

    public List<TestEntity> read_all()
    {
        List<TestEntity> testEntities = testRepository.findAll();

        return testEntities;
    }

    public TestEntity read(String name, String age)
    {
        TestEntity testEntity = testRepository.findAllByNameAndAge(name, age);

        if (testEntity == null) {
            throw new ApiException(ApiExceptionEnum.TEST_EXCEPTION);
        }

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

    public Optional<TestEntity> delete(Integer id)
    {
        Optional<TestEntity> testEntity = testRepository.findById(id);
        testRepository.deleteById(id);

        return testEntity;
    }
}
