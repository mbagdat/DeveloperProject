package com.example.DeveloperProjeect.Service;


import com.example.DeveloperProjeect.Entity.Meeting;
import com.example.DeveloperProjeect.Entity.User;
import com.example.DeveloperProjeect.Model.UserUpdateRequestModel;
import com.example.DeveloperProjeect.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }


    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }


    public User save(User user) {
        return userRepository.save(user);
    }


    public User update(Long id, UserUpdateRequestModel userUpdateRequestModel) {
        User user = userRepository.findById(id).orElseThrow(EntityExistsException::new);

        user.setName(userUpdateRequestModel.getName());
        user.setPassword(userUpdateRequestModel.getPassword());
        user.setEmail(userUpdateRequestModel.getEmail());
        userRepository.save(user);
        return user;
    }


    public User delete(Long id) {
        User user = userRepository.findById(id).get();
        userRepository.deleteById(id);
        return user;
    }
}
