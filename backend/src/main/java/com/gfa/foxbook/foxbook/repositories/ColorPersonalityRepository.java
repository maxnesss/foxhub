package com.gfa.foxbook.foxbook.repositories;

import com.gfa.foxbook.foxbook.models.nonusermodels.ColorPersonality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ColorPersonalityRepository extends JpaRepository<ColorPersonality, Long> {
    List<ColorPersonality> findAll();
}
