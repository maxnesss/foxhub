package com.gfa.foxbook.foxbook.repositories;
import com.gfa.foxbook.foxbook.models.nonusermodels.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
