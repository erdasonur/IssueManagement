package com.example.IssueManagement.service;

import com.example.IssueManagement.dto.IssueHistoryDto;
import com.example.IssueManagement.entity.IssueHistory;
import com.example.IssueManagement.util.TPage;
import org.springframework.data.domain.Pageable;

public interface IssueHistoryService {
    IssueHistoryDto save(IssueHistoryDto issueHistory);
    IssueHistoryDto getById(Long id);
    IssueHistoryDto update(IssueHistoryDto issueHistoryDto,Long id);
    TPage<IssueHistoryDto> getAllPageable(Pageable pageable);
    Boolean delete(Long issueHistoryId);
}
