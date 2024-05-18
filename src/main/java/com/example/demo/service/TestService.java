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

    public TestDto findAllByNameAndAge(String name, Integer age) {

        TestDto testDto = new TestDto();
        TestEntity testEntity = new TestEntity();

        testEntity = testRepository.findAllByNameAndAge(name, age);

        testDto.setId(testEntity.getId());
        testDto.setName(testEntity.getName());
        testDto.setAge(testEntity.getAge());
        testDto.setHometown(testEntity.getHometown());

        return testDto;
    }
    
    public TestDto save(TestDto testDto) {

        TestEntity testEntity_in = new TestEntity();
        TestEntity testEntity_out = new TestEntity();

        TestDto testDto_out = new TestDto();

        testEntity_in.setId(testDto.getId());
        testEntity_in.setName(testDto.getName());
        testEntity_in.setAge(testDto.getAge());
        testEntity_in.setHometown(testDto.getHometown());

        testEntity_out = testRepository.save(testEntity_in);

        testDto_out.setId(testEntity_out.getId());
        testDto_out.setName(testEntity_out.getName());
        testDto_out.setAge(testEntity_out.getAge());
        testDto_out.setHometown(testEntity_out.getHometown());

        return testDto_out;
    }

    public String deleteById(Integer id) {

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
