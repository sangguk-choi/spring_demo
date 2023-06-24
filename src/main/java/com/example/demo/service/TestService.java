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
            throw new ApiException(ApiExceptionEnum.INVALID_INPUT_DATA_EXCEPTION);
        }

        return testEntity;
    }

    public TestEntity create(TestData testData)
    {
        TestEntity testEntity = new TestEntity();

        String age = testData.getAge();
        String name = testData.getName();
        String hometown = testData.getHometown();

        if(isStringEmpty(age)||isStringEmpty(name)||isStringEmpty(hometown))
        {
            throw new ApiException(ApiExceptionEnum.NULL_INPUT_DATA_EXCEPTION);
        }

        testEntity.setAge(age);
        testEntity.setName(name);
        testEntity.setHometown(hometown);

        testEntity = testRepository.save(testEntity);

        return testEntity;
    }

    public TestEntity update(Integer id, TestData testData) {

        TestEntity testEntity = new TestEntity();

        String age = testData.getAge();
        String name = testData.getName();
        String hometown = testData.getHometown();

        System.out.println(age + "age");
        System.out.println(name);
        System.out.println(hometown);

        if(isStringEmpty(age)||isStringEmpty(name)||isStringEmpty(hometown))
        {
            throw new ApiException(ApiExceptionEnum.NULL_INPUT_DATA_EXCEPTION);
        }

        testEntity.setId(id);
        testEntity.setAge(age);
        testEntity.setName(name);
        testEntity.setHometown(hometown);

        testEntity = testRepository.save(testEntity);

        return testEntity;
    }

    public Optional<TestEntity> delete(Integer id)
    {
        Optional<TestEntity> testEntity = testRepository.findById(id);
        testRepository.deleteById(id);

        return testEntity;
    }

    static boolean isStringEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
