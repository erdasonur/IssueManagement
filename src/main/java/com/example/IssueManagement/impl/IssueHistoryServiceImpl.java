package com.example.IssueManagement.impl;

import com.example.IssueManagement.entity.IssueHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.IssueManagement.repository.IssueHistoryRepository;
import com.example.IssueManagement.service.IssueHistoryService;


@Service
public class IssueHistoryServiceImpl implements IssueHistoryService {

    private final IssueHistoryRepository issueHistoryRepository;
    public IssueHistoryServiceImpl(IssueHistoryRepository issueHistoryRepository) {
        this.issueHistoryRepository = issueHistoryRepository;
    }

    @Override
    public IssueHistory save(IssueHistory issueHistory) {
        if(issueHistory.getDate() != null)
            return issueHistoryRepository.save(issueHistory);
        else
            throw new IllegalArgumentException("Issue can't be null");
    }

    @Override
    public IssueHistory getById(Long id) {
        return issueHistoryRepository.getOne(id);
    }

    @Override
    public Page<IssueHistory> getAllPageable(Pageable pageable) {
        return issueHistoryRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(IssueHistory issueHistory) {
        issueHistoryRepository.delete(issueHistory);
        return true;
    }
}
