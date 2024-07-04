package umc.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.hackathon.domain.entity.MyPlantImage;

import java.util.List;
import java.util.Optional;

@Repository
public interface MyPlantImageRepository extends JpaRepository<MyPlantImage, Long> {
    MyPlantImage findByMyPlant_Id(Long myPlantId);

}
