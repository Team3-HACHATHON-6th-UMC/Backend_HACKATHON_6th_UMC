package umc.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.hackathon.domain.entity.MyPlant;

import java.util.List;

public interface MyPlantRepository extends JpaRepository<MyPlant, Long> {

}
