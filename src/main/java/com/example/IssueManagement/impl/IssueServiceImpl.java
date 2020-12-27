package com.example.IssueManagement.impl;

import com.example.IssueManagement.dto.IssueDto;
import com.example.IssueManagement.entity.Issue;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.IssueManagement.repository.IssueRepository;
import com.example.IssueManagement.service.IssueService;
import com.example.IssueManagement.util.TPage;

import java.util.Arrays;


@Service
public class IssueServiceImpl implements IssueService {

    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;

    public IssueServiceImpl(IssueRepository issueRepository, ModelMapper modelMapper){
        this.issueRepository = issueRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public IssueDto save(IssueDto issue) {

        if(issue.getDate() == null)
            throw new IllegalArgumentException("Issue Data can't be null");
        Issue issueDb = modelMapper.map(issue, Issue.class);
        issueDb = issueRepository.save(issueDb);
        issue.setId(issueDb.getId());
        return modelMapper.map(issueDb, IssueDto.class);
    }

    @Override
    public IssueDto getById(Long id) {
        Issue issueDb = issueRepository.getOne(id);
        return modelMapper.map(issueDb, IssueDto.class);
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable pageable) {


        Page<Issue> data =  issueRepository.findAll(pageable);
        IssueDto[] dtos = modelMapper.map(data.getContent(), IssueDto[].class);
        TPage<IssueDto> page = new TPage<IssueDto>();
        page.setStat(data, Arrays.asList(dtos));
        return page;
    }

    @Override
    public Boolean delete(IssueDto issue) {
        Issue issueDb = modelMapper.map(issue,Issue.class);
        issueRepository.delete(issueDb);
        return true;
    }
}
