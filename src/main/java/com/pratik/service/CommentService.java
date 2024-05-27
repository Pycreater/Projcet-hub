package com.pratik.service;

import com.pratik.model.Comment;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {

    Comment createComment(Long issueId, Long userId, String comment);

    void deleteComment(Long commentId, Long userId);

    List<Comment> findCommentByIssue(Long issueId);
}
