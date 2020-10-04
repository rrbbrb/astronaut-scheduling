package org.ntutsmartmedicalcloud.schedulerbackend.dao;

import org.ntutsmartmedicalcloud.schedulerbackend.entity.Astronaut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AstronautRepository extends JpaRepository<Astronaut, Integer> {
}
