package com.dating.datingApp.controller;

import com.dating.datingApp.model.Like;
import com.dating.datingApp.model.Message;
import com.dating.datingApp.service.like.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.HTML;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/likes")
public class LikeController {

    @Autowired
    private LikeService service;

    @GetMapping("/{id}")
    public ResponseEntity<Like> getLike(@PathVariable int id) {
        Like like = service.getLike(id);
        if (like != null) {
            return ResponseEntity.status(201).body(like);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Like>> getAllLikesByUser(@RequestParam int likerId) {
        System.out.println(likerId);
        List<Like> likes = service.getAllLikesByUser(likerId);
        if (likes == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.status(201).body(likes);
        }
    }

    @PostMapping
    public ResponseEntity<Like> saveLike(@RequestBody Like like) {
        Optional<Like> optional = service.saveLike(like);
        if (optional.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(201).body(like);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLike(@PathVariable int id) {
        Like like = service.getLike(id);
        if (like == null) {
            return ResponseEntity.status(404).build();
        } else {
            service.deleteLike(id);
            return ResponseEntity.status(204).build();
        }
    }
}
