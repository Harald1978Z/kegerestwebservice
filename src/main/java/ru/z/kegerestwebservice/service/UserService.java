package ru.z.kegerestwebservice.service;

import org.springframework.stereotype.Service;
import ru.z.kegerestwebservice.entity.User;
import ru.z.kegerestwebservice.repository.UserRepository;
import ru.z.kegerestwebservice.service.common.CommonService;

import java.util.List;


@Service
public class UserService extends CommonService<User, Long> {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        super(userRepository);
        this.userRepository=userRepository;
    }

    public List<User> findUsersContainsName(String fragment){
        return userRepository.findAllByFirstNameContaining(fragment);
    }

}
