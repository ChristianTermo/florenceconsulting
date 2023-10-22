package com.example.FlorenceConsulting.Service;

import com.example.FlorenceConsulting.Model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
    Iterable<User> getUsers();

    User create(User user);

    void delete(int id);

    Iterable<User>findByNome(String nome);

    Iterable<User> findByCognome(String cognome);

    Iterable<User> findByNomeAndCognome(String cognome, String nome);
}
