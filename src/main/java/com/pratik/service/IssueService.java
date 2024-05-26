package com.pratik.service;

import com.pratik.model.Issue;
import com.pratik.model.User;
import com.pratik.request.IssueRequest;

import java.util.List;
import java.util.Optional;

public interface IssueService {

    Issue getIssueById(Long issueId) throws Exception;

    List<Issue> getIssueByProjectId(Long projectId) throws Exception;

    Issue createIssue(IssueRequest issue, User user) throws Exception;

//    Optional<Issue> updateIssue(Long issueId, IssueRequest updatedIssue, Long userid) throws Exception;

    void deleteIssue(Long issueId, Long userId) throws Exception;

//    List<Issue> getIssuesByAssigneeId(Long assigneeId) throws Exception;

//    List<Issue> searchIssue(String title, String status, String priority, Long assigneeId) throws Exception;

//    List<User> getAssigneeForIssue(Long issueId) throws Exception;

    Issue addUserToIssue(Long issueId, Long userId) throws Exception;

    Issue updateStatus(Long issueId, String status) throws Exception;

}
