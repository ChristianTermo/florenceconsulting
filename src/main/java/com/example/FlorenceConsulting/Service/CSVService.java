package com.example.FlorenceConsulting.Service;

import com.example.FlorenceConsulting.Model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface CSVService {
    void save(MultipartFile file);
}
