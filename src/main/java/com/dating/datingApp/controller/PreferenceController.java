package com.dating.datingApp.controller;

import com.dating.datingApp.model.Preference;
import com.dating.datingApp.service.preference.PreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;

@Controller
@RequestMapping("/api/preferences")
public class PreferenceController {

    @Autowired
    private PreferenceService service;

    @PostMapping
    private ResponseEntity<Preference> savePreference(@RequestBody Preference preference) {
        Preference savedPreference = service.savePreference(preference);
        if (savedPreference == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(savedPreference);
    }
    @PutMapping
    private ResponseEntity<Preference> updatePreference(@RequestBody Preference preference) {
        Preference updatedPreference = service.changePreference(preference);
        if (updatedPreference == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(updatedPreference);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Preference> getPreference(@PathVariable int id) {
        Preference preference = service.getPreference(id);
        if (preference == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(preference);
        }
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<Preference> deletePreference(@PathVariable int id) {
        Preference preference = service.getPreference(id);
        if (preference == null) {
            return ResponseEntity.notFound().build();
        } else {
            service.deletePreference(id);
            return ResponseEntity.noContent().build();
        }
    }

}
