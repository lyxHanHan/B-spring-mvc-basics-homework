package com.thoughtworks.capacity.gtb.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService {
    private Map<Integer, User> userMap = new HashMap<>();

    public UserService() {


        userMap.put(1, new User(1, "xiaoming", "1234567", "11111111111@qq.com"));
        userMap.put(2, new User(2, "xiaoli", "1234567", "11111111111@qq.com"));
    }

    private Integer getId() {
        return userMap.keySet().stream().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        }).collect(Collectors.toList()).get(0) + 1;
    }

    public void registUser(User user) {
        Integer id = getId();
        userMap.put(id, user);
    }

    public User signIn(String username, String password) {
//        for (User value : userMap.values()) {
//            if (username == value.getUsername()) {
//                User user = userMap;
//            }
//        }

        List<User> userList = userMap.values().stream()
                .filter(User -> User.getUsername().equals(username) && User.getPassword().equals(password)).collect(Collectors.toList());

        if (userList == null|| userList.size()==0) {
            throw new UserNotFoundException("用户名或者密码错误");
        } else {
            return userList.get(0);
        }
    }
}
//        User user = userMap.get(1);
//        if (user == null) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "can not found this user");
//        }
//        return user;
//    }
//
//    }

