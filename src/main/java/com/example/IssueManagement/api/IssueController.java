package com.example.IssueManagement.api;

import com.example.IssueManagement.dto.IssueDto;
import com.example.IssueManagement.impl.IssueServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/issue")
public class IssueController {

    private final IssueServiceImpl issueServiceImpl;

    public IssueController(IssueServiceImpl issueServiceImpl) {
        this.issueServiceImpl = issueServiceImpl;
    }

    @GetMapping("/{id}")
    public ResponseEntity<IssueDto> getIssue(@PathVariable(value = "id", required = true) Long id){
        return ResponseEntity.ok(issueServiceImpl.getById(id));
    }

    @PostMapping()
    public ResponseEntity<IssueDto> createIssue(@RequestBody IssueDto issueDto){
        return ResponseEntity.ok(issueServiceImpl.save(issueDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<IssueDto> updateIssue(@PathVariable Long id, @RequestBody IssueDto issueDto){
        return ResponseEntity.ok(issueServiceImpl.update(id, issueDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteIssue(@PathVariable Long id){
        return ResponseEntity.ok(issueServiceImpl.delete(id));
    }
}
