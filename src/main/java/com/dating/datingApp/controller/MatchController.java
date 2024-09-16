package com.dating.datingApp.controller;

import com.dating.datingApp.model.Match;
import com.dating.datingApp.service.match.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/matches")
public class MatchController {

    @Autowired
    private MatchService service;

    @GetMapping("/{id}")
    private ResponseEntity<Match> getMatch(@PathVariable int id) {
        Match match = service.getMatch(id);
        if (match == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(match);
    }

    @GetMapping("/userId/{userId}")
    private ResponseEntity<List<Match>> getMatchesByUserId(@PathVariable int userId) {
        List<Match> matches = service.getAllUserMatches(userId);
        if (matches == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(matches);
    }

}
