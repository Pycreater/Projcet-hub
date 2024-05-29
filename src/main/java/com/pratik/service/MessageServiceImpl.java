//package com.pratik.service;
//
//import com.pratik.model.Chat;
//import com.pratik.model.Message;
//import com.pratik.model.User;
//import com.pratik.repository.MessageRepository;
//import com.pratik.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class MessageServiceImpl implements MessageService{
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private MessageRepository messageRepository;
//
//    @Autowired
//    private ProjectService projectService;
//
//    @Override
//    public Message sendMessage(Long senderId, Long chatId, String content) throws Exception {
//        User sender = userRepository.findById(senderId)
//                .orElseThrow(() -> new Exception("User not found with id: " + senderId));
//
//        Chat chat = projectService.getProjectById(pro)
//
//        return null;
//    }
//
//    @Override
//    public List<Message> getMessageByProject(Long projectId) throws Exception {
//        return null;
//    }
//}
