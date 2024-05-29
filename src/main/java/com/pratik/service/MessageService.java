package com.pratik.service;

import com.pratik.model.Message;

import java.util.List;

public interface MessageService {

    Message sendMessage(Long senderId, Long chatId, String content) throws Exception;

    List<Message> getMessageByProject(Long projectId) throws Exception;
}
