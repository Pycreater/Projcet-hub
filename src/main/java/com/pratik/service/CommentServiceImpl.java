package com.pratik.service;

import com.pratik.model.Comment;

import java.util.List;

public class CommentServiceImpl implements CommentService{
    @Override
    public Comment createComment(Long issueId, Long userId, String comment){
        return null;
    }

    @Override
    public void deleteComment(Long commentId, Long userId) {

    }

    @Override
    public List<Comment> findCommentByIssue(Long issueId) {
        return null;
    }
}
