package com.praveen.copilot.taskmanager.repository;

import com.praveen.copilot.taskmanager.entity.Task;
import com.praveen.copilot.taskmanager.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(TaskStatus status);
}
