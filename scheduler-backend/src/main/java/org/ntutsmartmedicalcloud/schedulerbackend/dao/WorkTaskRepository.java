package org.ntutsmartmedicalcloud.schedulerbackend.dao;

import org.ntutsmartmedicalcloud.schedulerbackend.entity.WorkTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkTaskRepository extends JpaRepository<WorkTask, Integer> {
}
