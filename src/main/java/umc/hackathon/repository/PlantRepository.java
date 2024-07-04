package umc.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.hackathon.domain.entity.Plant;

@Repository
public interface PlantRepository extends JpaRepository<Plant,Long> {
}
