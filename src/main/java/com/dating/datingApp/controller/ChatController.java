package com.dating.datingApp.controller;

import com.dating.datingApp.dto.user.UserDTO;
import com.dating.datingApp.model.Chat;
import com.dating.datingApp.model.User;
import com.dating.datingApp.service.chat.ChatService;
import com.dating.datingApp.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/chats")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @GetMapping("/{id}")
    public ResponseEntity<Chat> getChatById(@PathVariable int id) {
        Chat chat = chatService.getChat(id);
        if (chat == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(chat, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Void> createChat(@RequestBody Chat chat) {

        chatService.createChat(chat);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChat(@PathVariable int id) {
        Chat chat = chatService.getChat(id);
        if (chat != null) {
            chatService.deleteChat(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
