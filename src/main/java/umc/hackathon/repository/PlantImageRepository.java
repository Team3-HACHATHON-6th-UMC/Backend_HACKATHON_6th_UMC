package umc.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.hackathon.domain.entity.PlantImage;

import java.util.Optional;

@Repository
public interface PlantImageRepository extends JpaRepository<PlantImage, Long> {

    Optional<PlantImage> findFirstByPlant_Id(Long plantId);
}
