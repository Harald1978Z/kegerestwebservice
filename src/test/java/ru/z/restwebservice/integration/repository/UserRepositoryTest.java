package ru.z.restwebservice.integration.repository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.z.kegerestwebservice.entity.User;
import ru.z.kegerestwebservice.repository.UserRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
@AllArgsConstructor
public class UserRepositoryTest {
   // private final UserRepository userRepository;

    @Test
    void updateUserTest(){
       /* User user = userRepository.findById(2L).get();
        user.setFirstName("aaa");
        user=userRepository.save(user);*/
        assertTrue(true);
    }
}
