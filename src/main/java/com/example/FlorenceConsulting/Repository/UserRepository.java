package com.example.FlorenceConsulting.Repository;

import com.example.FlorenceConsulting.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Iterable<User> findByNome( String nome);
    Iterable<User> findByCognome(String cognome);
    Iterable<User> findByNomeAndCognome(String cognome, String nome);
}
