package com.example.FlorenceConsulting.Service;

import com.example.FlorenceConsulting.Helper.CSVHelper;
import com.example.FlorenceConsulting.Model.User;
import com.example.FlorenceConsulting.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CSVServiceImpl implements CSVService {
    @Autowired
    UserRepository userRepository;
    @Override
    public void save(MultipartFile file) {
        try {
            List<User> users = CSVHelper.csvToUser(file.getInputStream());
            userRepository.saveAll(users);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }
}
