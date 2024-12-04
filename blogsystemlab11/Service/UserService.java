package com.example.blogsystemlab11.Service;

import com.example.blogsystemlab11.ApiResponse.ApiException;
import com.example.blogsystemlab11.Model.User;
import com.example.blogsystemlab11.Repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service


public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(Integer id) {
        return userRepository.findUserById(id);
    }

    public void addUser(User user) {
        userRepository.save(user);

    }

    public void updateUser(Integer id, User user) {
        User userCheck = userRepository.findUserById(id);
        if (userCheck != null) {
            userCheck.setUserName(user.getUserName());
            userCheck.setEmail(user.getEmail());
            userCheck.setPassword(user.getPassword());
            userCheck.setRegistrationDate(LocalDate.now());
            userRepository.save(userCheck);
        }
        throw new ApiException("User not found");
    }

    public void deleteUser(Integer id) {
        if (userRepository.findUserById(id) != null) {
            userRepository.delete(userRepository.findUserById(id));
        }
        throw new ApiException("User not found");
    }

}
