package com.pratik.controller;

import com.pratik.model.Chat;
import com.pratik.model.Message;
import com.pratik.model.User;
import com.pratik.request.CreateMessageRequest;
import com.pratik.service.MessageService;
import com.pratik.service.ProjectService;
import com.pratik.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;
//get
    @PostMapping("/send")
    public ResponseEntity<Message> sendMessage(
            @RequestBody CreateMessageRequest request) throws Exception{
        User user = userService.findUserById(request.getSenderId());

        Chat chat = projectService.getProjectById(request.getProjectId()).getChat();

        if (chat == null) throw new Exception("Chat not found.");

        Message sentMessage = messageService.sendMessage(request.getSenderId(),
                request.getProjectId(),
                request.getContent());

        return ResponseEntity.ok(sentMessage);
    }

    @GetMapping("/chat/{projectId}")
    public ResponseEntity<List<Message>> getMessageByChatId(@PathVariable Long projectId)
        throws Exception {
        List<Message> messages = messageService.getMessageByProject(projectId);
        return ResponseEntity.ok(messages);
    }
}
