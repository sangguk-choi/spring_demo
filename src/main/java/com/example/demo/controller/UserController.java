package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.TestEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping( value = "register/read")
    @ApiOperation(value = "Read User Infomation : CRUD")
    public ResponseEntity<List<UserEntity>> read_users(@RequestParam String job,
                                                       @RequestParam String description,
                                                       @RequestParam Integer page_num,
                                                       @RequestParam Integer page_size) {
        Pageable pageable = PageRequest.of(page_num, page_size);

        List<UserEntity> userResponses = userService.read_users(job, description, pageable);

        return ResponseEntity.ok(userResponses);
    }

    @PostMapping( value = "register")
    @ApiOperation(value = "Create User Infomation : CRUD")
    public ResponseEntity<UserEntity> create_user(@RequestBody UserDto userReq) {
        UserEntity userResp = userService.create_user(userReq);

        return ResponseEntity.ok(userResp);
    }

    @GetMapping( value = "register/update")
    @ApiOperation(value = "Update User Infomation : CRUD")
    public ResponseEntity<UserEntity> update_user(@RequestBody UserDto userReq) {
        UserEntity userResponses = userService.update_user(userReq);

        return ResponseEntity.ok(userResponses);
    }

    @PostMapping( value = "register/delete")
    @ApiOperation(value = "Delete User Infomation : CRUD")
    public ResponseEntity<UserEntity> delete_user(@RequestBody UserDto userReq) {
        UserEntity userResp = userService.delete_user(userReq);

        return ResponseEntity.ok(userResp);
    }

}
