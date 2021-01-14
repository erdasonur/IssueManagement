package com.example.IssueManagement.impl;

import com.example.IssueManagement.dto.IssueHistoryDto;
import com.example.IssueManagement.entity.IssueHistory;
import com.example.IssueManagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.IssueManagement.repository.IssueHistoryRepository;
import com.example.IssueManagement.service.IssueHistoryService;

import java.util.Arrays;


@Service
public class IssueHistoryServiceImpl implements IssueHistoryService {

    private final IssueHistoryRepository issueHistoryRepository;
    private final ModelMapper modelMapper;
    public IssueHistoryServiceImpl(IssueHistoryRepository issueHistoryRepository, ModelMapper modelMapper) {
        this.issueHistoryRepository = issueHistoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public IssueHistoryDto save(IssueHistoryDto issueHistoryDto) {
        if(issueHistoryDto.getDate() != null){
            IssueHistory issueHistory = modelMapper.map(issueHistoryDto,IssueHistory.class);
            IssueHistoryDto issueHistoryData = modelMapper.map(issueHistoryRepository.save(issueHistory),IssueHistoryDto.class);
            issueHistoryData.setId(issueHistory.getId());
            return issueHistoryData;
        }
        else
            throw new IllegalArgumentException("Issue can't be null");
    }

    @Override
    public IssueHistoryDto getById(Long id) {
        return modelMapper.map(issueHistoryRepository.getOne(id),IssueHistoryDto.class);
    }

    @Override
    public IssueHistoryDto update(IssueHistoryDto issueHistoryDto, Long id) {
        IssueHistory issueHistory = issueHistoryRepository.getOne(id);
        if(issueHistory == null){
            throw new IllegalArgumentException("IssueHistoryId doesn't exist");
        }
        else {
            issueHistory.setDescription(issueHistoryDto.getDescription());
            issueHistory.setDetails(issueHistoryDto.getDetails());
            issueHistory.setDate(issueHistoryDto.getDate());
            issueHistory.setIssueStatus(issueHistoryDto.getIssueStatus());
            IssueHistoryDto issueHistoryData = modelMapper.map(issueHistoryRepository.save(issueHistory),IssueHistoryDto.class);
            return issueHistoryData;
        }
    }

    @Override
    public TPage<IssueHistoryDto> getAllPageable(Pageable pageable) {
        Page<IssueHistory> page = issueHistoryRepository.findAll(pageable);
        IssueHistoryDto[] issueHistoriesDto = modelMapper.map(page.getContent(),IssueHistoryDto[].class);
        TPage<IssueHistoryDto> tPage = new TPage<>();
        tPage.setStat(page, Arrays.asList(issueHistoriesDto));
        return tPage;
    }

    @Override
    public Boolean delete(Long issueHistoryId) {
        IssueHistory issueHistory = issueHistoryRepository.getOne(issueHistoryId);
        issueHistoryRepository.delete(issueHistory);
        return true;
    }
}
