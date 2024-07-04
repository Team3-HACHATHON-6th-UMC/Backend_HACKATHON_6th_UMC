package umc.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.hackathon.domain.entity.MyplantImage;

import java.util.List;
import java.util.Optional;

public interface MyPlantImageRepository extends JpaRepository<MyplantImage, Long> {
    MyplantImage findByMyplant_Id(Long myPlantId);

}
