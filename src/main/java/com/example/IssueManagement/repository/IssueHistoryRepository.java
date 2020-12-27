package com.example.IssueManagement.repository;

import com.example.IssueManagement.entity.IssueHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueHistoryRepository extends JpaRepository<IssueHistory, Long> {

}
