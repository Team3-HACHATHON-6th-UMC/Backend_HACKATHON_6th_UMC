package umc.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.hackathon.domain.entity.MyPlant;

public interface MyPlantRepository extends JpaRepository<MyPlant, Long> {
}
