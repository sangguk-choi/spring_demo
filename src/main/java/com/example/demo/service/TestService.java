package com.example.demo.service;

import com.example.demo.dto.TestRequest;
import com.example.demo.dto.TestResponse;
import com.example.demo.entity.TestEntity;
import com.example.demo.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository testRepository;

    public TestResponse readService(String name, Integer age) {

        TestResponse testResponse = new TestResponse();
        TestEntity testEntity = new TestEntity();

        testEntity = testRepository.findAllByNameAndAge(name, age);

        testResponse.setId(testEntity.getId());
        testResponse.setName(testEntity.getName());
        testResponse.setAge(testEntity.getAge());
        testResponse.setHometown(testEntity.getHometown());

        return testResponse;
    }
    
    public TestResponse createService(TestRequest testRequest) {

        TestEntity testEntity_in = new TestEntity();
        TestEntity testEntity_out = new TestEntity();

        TestResponse testResponse = new TestResponse();

//        testEntity_in.setId(testRequest.getId());
        testEntity_in.setName(testRequest.getName());
        testEntity_in.setAge(testRequest.getAge());
        testEntity_in.setHometown(testRequest.getHometown());

        testEntity_out = testRepository.save(testEntity_in);

        testResponse.setId(testEntity_out.getId());
        testResponse.setName(testEntity_out.getName());
        testResponse.setAge(testEntity_out.getAge());
        testResponse.setHometown(testEntity_out.getHometown());

        return testResponse;
    }

    public TestResponse updateService(Integer id, TestRequest testRequest) {

        boolean isEntity = testRepository.existsById(id);

        TestEntity testEntity_in = new TestEntity();
        TestEntity testEntity_out = new TestEntity();

        TestResponse testResponse = new TestResponse();

        if(isEntity) {
            testEntity_in.setId(id);
            testEntity_in.setName(testRequest.getName());
            testEntity_in.setAge(testRequest.getAge());
            testEntity_in.setHometown(testRequest.getHometown());

            testEntity_out = testRepository.save(testEntity_in);

            testResponse.setId(testEntity_out.getId());
            testResponse.setName(testEntity_out.getName());
            testResponse.setAge(testEntity_out.getAge());
            testResponse.setHometown(testEntity_out.getHometown());
        }
        else {
            testResponse = null;
        }

        return testResponse;
    }
    

    public String deleteService(Integer id) {

        boolean isEntity = testRepository.existsById(id);
        String retValue;

        if(isEntity) {
            testRepository.deleteById(id);

            retValue = "delete success";
        }
        else {
            retValue = "delete fail";
        }

        return retValue;
    }
}
