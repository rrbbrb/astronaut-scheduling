package org.ntutsmartmedicalcloud.schedulerbackend.dao;

import org.ntutsmartmedicalcloud.schedulerbackend.entity.NonWorkTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NonWorkTaskRepository extends JpaRepository<NonWorkTask, Integer> {
}
