package com.signin_up.signinup.repositores;

import com.signin_up.signinup.entities.User;
import com.signin_up.signinup.repositores.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testSaveUser() {
        User user = new User();
        user.setUsername("testuser");
        user.setEmail("testuser@example.com");
        user.setPassword("securepassword");

        userRepository.save(user);

        User fetchedUser = userRepository.findByUsername("testuser");
        assertThat(fetchedUser).isNotNull();
        assertThat(fetchedUser.getEmail()).isEqualTo("testuser@example.com");
    }
}
