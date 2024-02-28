package com.myProject_2024_02_08.controller;

import com.models.mapStruct.MapConstructMappper;
import com.models.vo.UserVo;
import com.myProject_2024_02_08.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utils.MyResult;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/user")
    public MyResult test(){
        User user1 = User.builder().id(1).userName("name1").build();
        UserVo userVo = MapConstructMappper.INSTANCE.toUserVo(user1);
        return MyResult.success(userVo);
    }
    @GetMapping("/userlist")
    public MyResult testList(){
        List<User> list=new LinkedList<>();
        List<User> userList = IntStream.range(0, 3).boxed().map(t -> {
            return User.builder().id(t).userName("userName" + t).build();
        }).collect(Collectors.toList());
//        User user1 = User.builder().id(1).userName("name1").build();
//        UserVo userVo = MapConstructMappper.INSTANCE.toUserVo(user1);
        return MyResult.success(userList);
    }


}
