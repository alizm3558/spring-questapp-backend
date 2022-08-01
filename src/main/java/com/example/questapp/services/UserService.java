package com.example.questapp.services;

import com.example.questapp.entities.User;
import com.example.questapp.repos.UserRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User save(User newUser) {
        return userRepository.save(newUser);
    }

    public User getOneUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }


    public User updateOneUser(Long userId, User newUser) {
        // güncellemek için ilk önce userId eşitliğine sahip kullanıcıyı bulmamız gerekmektedir..
        Optional<User> user = userRepository.findById(userId);
        //isPresent obje var demek
        if (user.isPresent()) {
            User foundUser = user.get();
            foundUser.setUserName(newUser.getUserName());
            foundUser.setPassword(newUser.getPassword());
            userRepository.save(foundUser);

            return foundUser;

        } else {
            return null;
        }
    }

    public void deleteById(Long userId) {
        try {
            userRepository.deleteById(userId);
        }catch(EmptyResultDataAccessException e) { //user zaten yok, db'den empty result gelmiş
            System.out.println("User "+userId+" doesn't exist"); //istersek loglayabiliriz
        }
    }


}
