package com.dating.datingApp.controller;

import com.dating.datingApp.model.Interest;
import com.dating.datingApp.service.interest.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/interests")
public class InterestController {

    @Autowired
    private InterestService service;

    @GetMapping("/{id}")
    public ResponseEntity<Interest> getInterestById(@PathVariable int id) {
        Interest interest = service.findInterestById(id);
        return interest != null ? ResponseEntity.ok(interest) : ResponseEntity.notFound().build();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Interest> getInterestByName(@PathVariable String name) {

        Interest interest = service.findInterestByName(name);
        return new ResponseEntity<>(interest, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Interest>> getAllInterests() {
        return new ResponseEntity<>(service.findAllInterests(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createInterest(@RequestBody Interest interest) {
        service.saveInterest(interest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInterest(@PathVariable int id) {
        service.deleteInterest(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
