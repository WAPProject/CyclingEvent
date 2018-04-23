package com.cs.service;

import com.cs.entity.Message;
import com.cs.entity.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author:Yanlong Wang
 * @Date:${date}_${time}
 * @Description:
 */
class UserServiceTest {
    private UserService service ;
    public UserServiceTest() {
        this.service = new UserService();
    }
    @Test
    void addUser() {
        User user = new User();
        user.setId("0");
        user.setPassword("0");
        user.setName("test");
        user.setEmail("test@qq.com");
        user.setUsername("test");
        User result = service.addUser(user);
        System.out.println(result);
    }

    @Test
    void checkLogin() {
        User user = new User();
        user.setId("1");
        user.setPassword("1");
        user.setUsername("bigdragon");
        User result = service.checkLogin(user);
        System.out.println(result);
    }

    @Test
    void getUserById() {
        User result = service.getUserById(2);
        System.out.println(result);
    }
    @Test
    void aa(){
        List<Message> msgList = new ArrayList<>();
        Message msg1 = new Message();
        msg1.setPaticipantids("1,2,3");
        msgList.add(msg1);
        Message msg2 = new Message();
        msg2.setPaticipantids("1,12,13");
        msgList.add(msg2);
        List<Message> resultList = msgList.stream().filter(message -> Arrays.stream(message.getPaticipantids()
                .split(","))
                .anyMatch(id -> id.equalsIgnoreCase("2"))
                ).collect(Collectors.toList());
        System.out.println(resultList);
    }
}