package umc.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.hackathon.domain.entity.PlantImage;

import java.util.Optional;

public interface PlantImageRepository extends JpaRepository<PlantImage, Long> {

    Optional<PlantImage> findFirstByPlant_Id(Long plantId);
}
