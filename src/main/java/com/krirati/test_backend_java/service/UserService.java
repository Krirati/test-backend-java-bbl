package com.krirati.test_backend_java.service;

import com.krirati.test_backend_java.model.User;
import com.krirati.test_backend_java.model.UserRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<User> mockUserData = new ArrayList<User>(
            List.of(
                    new User(1, "Leanne Graham", "Bret", "Sincere@april.biz", "1-770-736-8031 x56442", "ildegard.org")
            )
    );

    public List<User> fetchAllUsers() {
        return mockUserData;
    }

    public User createUser(UserRequest request) {
        int newId = mockUserData.size() + 1;
        System.out.println("Test" + request.getName());
        User newUser = new User();
        newUser.setId(newId);
        newUser.setName(request.getName());
        newUser.setUsername(request.getUsername());
        newUser.setEmail(request.getEmail());
        newUser.setPhone(request.getPhone());
        newUser.setWebsite(request.getWebsite());

        mockUserData.add(newUser);

        return newUser;
    }
}
