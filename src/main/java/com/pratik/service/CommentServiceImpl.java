package com.pratik.service;

import com.pratik.model.Comment;
import com.pratik.model.Issue;
import com.pratik.model.User;
import com.pratik.repository.CommentRepository;
import com.pratik.repository.IssueRepository;
import com.pratik.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Comment createComment(Long issueId, Long userId, String comment) throws Exception {
        Optional<Issue> issueOptional = issueRepository.findById(issueId);
        Optional<User> userOptional = userRepository.findById(userId);

        if (issueOptional.isEmpty()) {
            throw new Exception("issue not found with id " + issueId);
        }
        if (userOptional.isEmpty()) {
            throw new Exception("user not found with id " + userId);
        }

        Issue issue = issueOptional.get();
        User user = userOptional.get();

        Comment comment1 = new Comment();

        comment1.setIssue(issue);
        comment1.setUser(user);
        comment1.setCreatedDateTime(LocalDateTime.now());
        comment1.setContent(comment);

        Comment savedComment = commentRepository.save(comment1);

        issue.getComments().add(savedComment);
        return savedComment;
    }

    @Override
    public void deleteComment(Long commentId, Long userId) throws Exception {
        Optional<Comment> commentOptional = commentRepository.findById(commentId);
        Optional<User> userOptional = userRepository.findById(userId);

        if (commentOptional.isEmpty()) {
            throw new Exception("Comment not found with id " + commentId);
        }
        if (userOptional.isEmpty()) {
            throw new Exception("user not found with id " + userId);
        }

        Comment comment = commentOptional.get();
        User user = userOptional.get();

        if (comment.getUser().equals(user)) {
            commentRepository.delete(comment);
        } else {
            throw new Exception("User does not have permission to delete this comment!");
        }
    }

    @Override
    public List<Comment> findCommentByIssue(Long issueId) {
        return commentRepository.findByIssueId(issueId);
    }
}
