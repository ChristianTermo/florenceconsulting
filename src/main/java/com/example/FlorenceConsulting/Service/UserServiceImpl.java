package com.example.FlorenceConsulting.Service;

import com.example.FlorenceConsulting.Model.User;
import com.example.FlorenceConsulting.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }
    @Override
    public User create(User user) {
        return userRepository.save(user);
    }
    @Override
    public void delete(int id){
        userRepository.deleteById(id);
    }
    @Override
    public   Iterable<User> findByNome(String nome){
        Iterable<User> user = userRepository.findByNome(nome);
        return  user;
    }
    @Override
    public   Iterable<User> findByCognome(String cognome){
        Iterable<User> user = userRepository.findByCognome(cognome);
        return  user;
    }
    @Override
    public Iterable<User> findByNomeAndCognome(String cognome, String nome){
        Iterable<User> user = userRepository.findByNomeAndCognome(nome,cognome);
        return  user;
    }
}
