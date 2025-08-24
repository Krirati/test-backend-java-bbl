package com.krirati.test_backend_java.service;

import com.krirati.test_backend_java.model.User;
import com.krirati.test_backend_java.model.UserRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void fetchAllUserShouldReturnMockUserData() {
        // given

        // when
        List<User> result = userService.fetchAllUsers();

        // then
        List<User> expect = new ArrayList<>(
                List.of(
                        new User(1, "Leanne Graham", "Bret", "Sincere@april.biz", "1-770-736-8031 x56442", "ildegard.org"),
                        new User(2, "Ervin Howell", "Antonette", "Shanna@melissa.tv", "010-692-6593 x09125", "anastasia.net"),
                        new User(3, "Leanne Graham", "Bret", "Sincere@april.biz", "1-770-736-8031 x56442", "ildegard.org")
                )
        );
        assertEquals(expect, result);
    }

    @Test
    void createUserShouldReturnMockUserData() {
        // given
        UserRequest request = new UserRequest();
        request.setEmail("test@gmail.com");
        request.setName("myname");
        request.setUsername("my_username");
        request.setPhone("0911111111");
        request.setWebsite("ramiro.info");

        // when
        User result = userService.createUser(request);

        // then
        User expect = new User();
        expect.setId(4);
        expect.setEmail("test@gmail.com");
        expect.setName("myname");
        expect.setUsername("my_username");
        expect.setPhone("0911111111");
        expect.setWebsite("ramiro.info");
        assertEquals(expect, result);
    }
}