package com.aacademy.firstrestproject.service.impl;

import com.aacademy.firstrestproject.model.User;
import com.aacademy.firstrestproject.repository.UserRepository;
import com.aacademy.firstrestproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Set<User> findAll() {
        return new HashSet<>(userRepository.findAll());
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return null;
    }

   @Override
    public User update(Long id, User user) {
        User foundUser = this.findById(id);
        User updatedUser = User.builder()
                .id(foundUser.getId())
                .name(user.getName())
                .build();

        return userRepository.save(updatedUser);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById( id);


    }

    @Override
    public void delete(String name) {

       // User user = userRepository.findByName(name)


        User user = userRepository.findByName(name)
                .orElseThrow(IllegalAccessError::new);

        userRepository.deleteByName(user.getName());
    }
}
