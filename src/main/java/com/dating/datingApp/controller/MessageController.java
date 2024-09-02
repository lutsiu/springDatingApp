package com.dating.datingApp.controller;

import com.dating.datingApp.dto.message.UpdateMessageDTO;
import com.dating.datingApp.model.Message;
import com.dating.datingApp.service.message.MessageService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService service;

    @PostMapping
    public ResponseEntity<Message> saveMessage(@RequestBody Message message) {
        Message savedMessage = service.saveMessage(message);
        return ResponseEntity.status(201).body(savedMessage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getMessage(@PathVariable int id) {
        Message message = service.getMessage(id);
        if (message != null) {
            return ResponseEntity.status(201).body(message);
        } else {
            return ResponseEntity.status(404).build();
        }
    }


    @GetMapping("/chatId/{id}")
    public ResponseEntity<List<Message>> findAllMessagesByChatId(@PathVariable int id) {
        List<Message> messages = service.findAllMessagesByChatId(id);
        if (messages.isEmpty()) {
            return ResponseEntity.status(404).build();
        } else {
            return ResponseEntity.status(201).body(messages);
        }
    }

    @GetMapping("/findByWord")
    public ResponseEntity<List<Message>> findMessageByWord(@RequestBody String word) {
        System.out.println(word);
        Optional<List<Message>> messages = service.findMessageByWord(word);
        if (messages.isEmpty()) {
            return ResponseEntity.status(404).build();
        } else {
            List<Message> foundMessages = messages.get();
            return ResponseEntity.status(201).body(foundMessages);
        }
    }

    @PutMapping
    public ResponseEntity<Message> updateMessage(@RequestBody UpdateMessageDTO messageDTO) {
        Optional<Message> updatedMessage = service.updateMessage(messageDTO.getId(), messageDTO.getMessage());
        if (updatedMessage.isEmpty()) {
            return ResponseEntity.status(404).build();
        } else {
            return ResponseEntity.status(201).body(updatedMessage.get());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable int id) {
        Message message = service.getMessage(id);
        if (message == null) {
            return ResponseEntity.status(404).build();
        } else {
            service.deleteMessage(id);
            return ResponseEntity.status(204).build();
        }
    }
}
