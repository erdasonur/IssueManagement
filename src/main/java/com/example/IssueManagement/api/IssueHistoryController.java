package com.example.IssueManagement.api;


import com.example.IssueManagement.dto.IssueHistoryDto;
import com.example.IssueManagement.impl.IssueHistoryServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/issueHistory")
@Slf4j
@Api
public class IssueHistoryController {

    private final IssueHistoryServiceImpl issueHistoryServiceImpl;

    public IssueHistoryController(IssueHistoryServiceImpl issueHistoryServiceImpl) {
        this.issueHistoryServiceImpl = issueHistoryServiceImpl;
    }

    @GetMapping("/{issueHistoryId}")
    @ApiOperation(value = "Get By Id Operation", response = IssueHistoryDto.class)
    public ResponseEntity<IssueHistoryDto> getIssueHistory(@PathVariable Long issueHistoryId){
        log.info("IssueHistoryController => GetById Param : " + issueHistoryId);
        return ResponseEntity.ok(issueHistoryServiceImpl.getById(issueHistoryId));
    }

    @PostMapping()
    @ApiOperation(value = "Post Operation", response = IssueHistoryDto.class)
    public ResponseEntity<IssueHistoryDto> createIssueHistory(@RequestBody IssueHistoryDto issueHistoryDto){
        log.debug("Create IssueHistory");
        return ResponseEntity.ok(issueHistoryServiceImpl.save(issueHistoryDto));
    }

    @PutMapping("/{issueHistoryId}")
    @ApiOperation(value = "Update Operation", response = IssueHistoryDto.class)
    public ResponseEntity<IssueHistoryDto> updateIssueHistory(@RequestBody IssueHistoryDto issueHistoryDto, @PathVariable Long issueHistoryId){
        log.debug("IssueHistory Update Params : " + issueHistoryDto + issueHistoryId);
        return ResponseEntity.ok(issueHistoryServiceImpl.update(issueHistoryDto, issueHistoryId));
    }

    @DeleteMapping("/{issueHistoryId}")
    @ApiOperation(value = "Delete Operation", response = Boolean.class)
    public ResponseEntity<Boolean> delete(@PathVariable Long issueHistoryId){
        log.debug("Delete IssueHistory Param : " + issueHistoryId);
        return ResponseEntity.ok(issueHistoryServiceImpl.delete(issueHistoryId));
    }
}
