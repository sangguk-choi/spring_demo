package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.UserEntity;
import com.example.demo.exception.ApiException;
import com.example.demo.exception.ApiExceptionEnum;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserEntity> read_users(String job, String description, Pageable pageable) {
        List<UserEntity> userEntity_Page = userRepository.findAllByJobAndDescription(job, description, pageable);

        return userEntity_Page;
    }

    public UserEntity create_user(UserDto userDto) {
        UserEntity userEntity = new UserEntity();

        String name = userDto.getName();
        String userid = userDto.getUserid();
        String password = userDto.getPassword();
        String email = userDto.getEmail();
        String job = userDto.getJob();
        String company = userDto.getCompany();
        String description = userDto.getDescription();

        userEntity.setName(name);
        userEntity.setUserid(userid);
        userEntity.setPassword(password);
        userEntity.setEmail(email);
        userEntity.setJob(job);
        userEntity.setCompany(company);
        userEntity.setDescription(description);

        if(userRepository.findAllByNameAndUserid(name, userid) == null) {
            userEntity = userRepository.save(userEntity);
        }
        else {
            throw new ApiException(ApiExceptionEnum.INVALID_INPUT_DATA_EXCEPTION);
        }

        return userEntity;
    }

    public UserEntity update_user(UserDto userDto) {
        UserEntity userEntity = new UserEntity();

        String userid = userDto.getUserid();
        String password = userDto.getPassword();

        if(userRepository.findAllByUseridAndPassword(userid, password) != null) {
            userEntity.setUserid(userid);
            userEntity.setPassword(password);

            userEntity = userRepository.save(userEntity);
        }
        else {
            throw new ApiException(ApiExceptionEnum.INVALID_INPUT_DATA_EXCEPTION);
        }

        return userEntity;
    }

    public UserEntity delete_user(UserDto userDto) {
        String name = userDto.getName();
        String userid = userDto.getUserid();
        String password = userDto.getPassword();

        UserEntity userEntity = userRepository.findAllByNameAndUseridAndPassword(name, userid, password);
        if(userEntity != null) {
            userRepository.deleteById(userEntity.getId());

            return userEntity;
        }
        else {
            throw new ApiException(ApiExceptionEnum.INVALID_INPUT_DATA_EXCEPTION);
        }
    }
}
