package com.example.FlorenceConsulting.Controller;

import com.example.FlorenceConsulting.Helper.CSVHelper;
import com.example.FlorenceConsulting.Model.User;
import com.example.FlorenceConsulting.Request.FilterRequest;
import com.example.FlorenceConsulting.Response.ResponseMessage;
import com.example.FlorenceConsulting.Service.CSVService;
import com.example.FlorenceConsulting.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    CSVService csvService;
    @GetMapping("/users")
    public Iterable getUsers(){
        return userService.getUsers();
    }
    @PostMapping("/create")
    public User create(@RequestBody User user){
        return userService.create(user);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){ userService.delete(id);}
    @PostMapping("/filter")
    public  Iterable<User> filter(@RequestBody FilterRequest filterRequest){
        Iterable<User> user = null;
     if (filterRequest.nome !=null && filterRequest.cognome == null){
          user = userService.findByNome(filterRequest.nome);
     } else if (filterRequest.nome== null && filterRequest.cognome!=null) {
          user = userService.findByCognome(filterRequest.cognome);
     } else if (filterRequest.nome== null && filterRequest.cognome== null) {
          user =userService.getUsers();
     } else if (filterRequest.nome!=null && filterRequest.cognome!=null) {
          user =userService.findByNomeAndCognome(filterRequest.nome,filterRequest.cognome);
     }
     return user;
    }
    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (CSVHelper.hasCSVFormat(file)) {
            try {
                csvService.save(file);
                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }

        message = "Please upload a csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }
}
