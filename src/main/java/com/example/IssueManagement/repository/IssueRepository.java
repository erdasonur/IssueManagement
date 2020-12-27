package com.example.IssueManagement.repository;

import com.example.IssueManagement.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Long> {

}
