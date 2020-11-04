package com.thoughtworks.capacity.gtb.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService {
    private Map<Integer,User> userMap = new HashMap<>();

    public UserService(){


        userMap.put(1,new User("xiaoming","1234567","11111111111@qq.com"));
        userMap.put(2,new User("xiaoli","1234567","11111111111@qq.com"));
    }

    private Integer getId(){
        return userMap.keySet().stream().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        }).collect(Collectors.toList()).get(0)+1;
    }

    public void registUser(User user) {
        Integer id = getId();
        userMap.put(id,user);
    }

    public User signIn(String username, String password) {
        User user = userMap.get(1);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "can not found this user");
        }
        return user;
    }

    }

