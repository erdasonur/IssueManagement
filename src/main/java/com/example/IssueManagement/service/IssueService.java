package com.example.IssueManagement.service;

import com.example.IssueManagement.dto.IssueDto;
import org.springframework.data.domain.Pageable;
import com.example.IssueManagement.util.TPage;


public interface IssueService {

    IssueDto save(IssueDto issue);
    IssueDto getById(Long id);
    IssueDto update(Long id, IssueDto issueDto);
    TPage<IssueDto> getAllPageable(Pageable pageable);
    Boolean delete(Long id);
}
