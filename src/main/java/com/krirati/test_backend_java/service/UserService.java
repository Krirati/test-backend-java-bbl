package com.krirati.test_backend_java.service;

import com.krirati.test_backend_java.exception.DataNotFoundException;
import com.krirati.test_backend_java.model.User;
import com.krirati.test_backend_java.model.UserRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<User> mockUserData = new ArrayList<>(
            List.of(
                    new User(1, "Leanne Graham", "Bret", "Sincere@april.biz", "1-770-736-8031 x56442", "ildegard.org"),
                    new User(2, "Ervin Howell", "Antonette", "Shanna@melissa.tv", "010-692-6593 x09125", "anastasia.net"),
                    new User(3, "Leanne Graham", "Bret", "Sincere@april.biz", "1-770-736-8031 x56442", "ildegard.org")
            )
    );

    public List<User> fetchAllUsers() {
        return mockUserData;
    }

    public User createUser(UserRequest request) {
        int newId = mockUserData.size() + 1;

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

    public User fetchUserByID(int userId) {
        Optional<User> result = mockUserData.stream()
                .filter(user -> user.getId() == userId)
                .findFirst();
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new DataNotFoundException("userId not found");
        }
    }

    public User updateUserByID(int userId, UserRequest request) {
        Optional<User> result = mockUserData.stream()
                .filter(user -> user.getId() == userId)
                .findFirst();
        if (result.isPresent()) {
            User newUser = result.get();
            newUser.setName(request.getName());
            newUser.setEmail(request.getEmail());
            newUser.setUsername(request.getUsername());

            if (request.getPhone() != null) {
                newUser.setPhone(request.getPhone());
            }
            if (request.getWebsite() != null) {
                newUser.setWebsite(request.getWebsite());
            }
            return newUser;
        } else {
            throw new DataNotFoundException("userId not found");
        }
    }

    public List<User> deleteUserByID(int userId) {
        Optional<User> result = mockUserData.stream()
                .filter(user -> user.getId() == userId)
                .findFirst();
        if (result.isPresent()) {
            mockUserData.remove(result.get());
            return mockUserData;
        } else {
            throw new DataNotFoundException("userId not found");
        }
    }
}
