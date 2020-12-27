package com.example.IssueManagement.service;

import com.example.IssueManagement.entity.IssueHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueHistoryService {
    IssueHistory save(IssueHistory issueHistory);
    IssueHistory getById(Long id);
    Page<IssueHistory> getAllPageable(Pageable pageable);
    Boolean delete(IssueHistory issueHistory);
}
