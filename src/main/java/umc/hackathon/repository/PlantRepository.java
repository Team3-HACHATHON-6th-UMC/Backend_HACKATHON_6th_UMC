package umc.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.hackathon.domain.entity.Plant;

public interface PlantRepository extends JpaRepository<Plant,Long> {
}
