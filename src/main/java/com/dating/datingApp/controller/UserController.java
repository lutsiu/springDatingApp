package com.dating.datingApp.controller;

import com.dating.datingApp.dto.user.UserCreateDTO;
import com.dating.datingApp.dto.user.UserDTO;
import com.dating.datingApp.dto.user.UserUpdateDTO;
import com.dating.datingApp.model.Interest;
import com.dating.datingApp.model.User;
import com.dating.datingApp.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserCreateDTO userCreateDTO) {
        UserDTO dto = service.createUser(userCreateDTO);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable int id) {
        UserDTO dto = service.getUser(id);

        if (dto != null) {
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable int id, @RequestBody UserUpdateDTO userUpdateDTO) {
        UserDTO updatedUser = service.updateUser(id, userUpdateDTO);

        if (updatedUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        }
    }

    @PostMapping("/{userId}/interest")
    public ResponseEntity<Void> addInterestToUser(@PathVariable int userId, @RequestBody Interest interest) {
        service.addInterestToUser(userId, interest);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}/password")
    public ResponseEntity<Void> updatePassword(@PathVariable int id, @RequestBody String newPassword) {
        service.updateUserPassword(id, newPassword);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}/profilePicture")
    public ResponseEntity<Void> updateUserProfilePicture(@PathVariable int id, @RequestBody String profilePicture) {
        service.updateUserProfilePicture(id, profilePicture);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        service.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
