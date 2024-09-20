package com.dating.datingApp.controller;

import com.dating.datingApp.model.Picture;
import com.dating.datingApp.service.picture.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/pictures")
public class PictureController {

    @Autowired
    private PictureService service;

    @PostMapping
    private ResponseEntity<Picture> savePicture(@RequestBody Picture picture) {
        Picture picture1 = service.savePicture(picture);
        if (picture1 != null) {
            return ResponseEntity.ok(picture1);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    private ResponseEntity<Picture> getPicture(@PathVariable int id) {
        Picture picture = service.getPicture(id);
        if (picture != null) {
            return ResponseEntity.ok(picture);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/userId/{userId}")
    private ResponseEntity<List<Picture>> getAllUserPictures(@PathVariable int userId) {
        List<Picture> userPictures = service.getAllUserPictures(userId);

        if (userPictures != null) {
            return ResponseEntity.ok(userPictures);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/setProfilePicture/{userId}")
    public ResponseEntity<String> setProfilePicture(@PathVariable int userId, @RequestParam String newProfilePicture) {
        service.updateUserProfilePicture(userId, newProfilePicture);
        return ResponseEntity.ok("Profile picture updated successfully");
    }


    @DeleteMapping("/{pictureId}")
    private ResponseEntity<Void> deletePicture(@PathVariable int pictureId) {
        Picture picture = service.getPicture(pictureId);

        if (picture == null) {
            return ResponseEntity.notFound().build();
        } else {
            service.deletePicture(pictureId);
            return ResponseEntity.noContent().build();
        }

    }


}
