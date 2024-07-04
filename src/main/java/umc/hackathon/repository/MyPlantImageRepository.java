package umc.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.hackathon.domain.entity.MyPlantImage;

import java.util.List;
import java.util.Optional;

public interface MyPlantImageRepository extends JpaRepository<MyPlantImage, Long> {
    MyPlantImage findByMyPlant_Id(Long myPlantId);

}
