package com.thoughtworks.capacity.gtb.mvc;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private Map<Integer,User> userMap = new HashMap<>();

    public UserService(){
        userMap.put(1,new User());
        userMap.put(2,new User());
    }

    public void registUser(User user) {userMap.put(user);}
}
