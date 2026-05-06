package ru.z.kegerestwebservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.z.kegerestwebservice.entity.User;
import ru.z.kegerestwebservice.service.UserService;

import java.util.List;

@RestController
@RequestMapping(("users"))
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAll();
    }
    @GetMapping("/by_name/{fragment}")
    public List<User> getUserByFirstName(@PathVariable String fragment){
        return userService.findUsersContainsName(fragment);
    }
    @GetMapping("/id/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getById(id);
    }
    @PostMapping("/save_user")
    public User saveUser(@RequestBody User user){
        return userService.save(user);
    }
    @DeleteMapping("/delete_user")
    public String deleteUser(@RequestBody User user){
        return userService.delete(user);
    }
}
