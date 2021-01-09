package com.example.IssueManagement.api;

import com.example.IssueManagement.dto.IssueDto;
import com.example.IssueManagement.dto.ProjectDto;
import com.example.IssueManagement.entity.Issue;
import com.example.IssueManagement.impl.IssueServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/issue")
@Api(value = "Issue APIs")
@Slf4j
public class IssueController {

    private final IssueServiceImpl issueServiceImpl;

    public IssueController(IssueServiceImpl issueServiceImpl) {
        this.issueServiceImpl = issueServiceImpl;
    }

    @ApiOperation(value = "Get By Id Operation", response = IssueDto.class)
    @GetMapping("/{id}")
    public ResponseEntity<IssueDto> getIssue(@PathVariable(value = "id", required = true) Long id){
        log.debug("Issue Controller -> GetById -> PARAM: " +id);
        return ResponseEntity.ok(issueServiceImpl.getById(id));
    }

    @ApiOperation(value = "Create Operation", response = IssueDto.class)
    @PostMapping()
    public ResponseEntity<IssueDto> createIssue(@RequestBody IssueDto issueDto){
        log.debug("Issue Controller -> Create");
        return ResponseEntity.ok(issueServiceImpl.save(issueDto));
    }

    @ApiOperation(value = "Update Operation", response = IssueDto.class)
    @PutMapping("/{id}")
    public ResponseEntity<IssueDto> updateIssue(@PathVariable Long id, @RequestBody IssueDto issueDto){
        log.debug("Issue Controller -> Update");
        return ResponseEntity.ok(issueServiceImpl.update(id, issueDto));
    }

    @ApiOperation(value = "Delete Operation", response = Boolean.class)
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteIssue(@PathVariable Long id){
        log.debug("Issue Controller -> Delete");
        return ResponseEntity.ok(issueServiceImpl.delete(id));
    }
}
