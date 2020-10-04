package org.ntutsmartmedicalcloud.schedulerbackend.dao;

import org.ntutsmartmedicalcloud.schedulerbackend.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    @Query(value = "SELECT * FROM tasks WHERE start_time = :time", nativeQuery = true)
    Optional<Task> findByStartTime(@Param("time") LocalDateTime time);
}
