package umc.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.hackathon.domain.entity.Diary;
import umc.hackathon.domain.entity.MyPlant;
import umc.hackathon.domain.entity.User;

import java.util.List;

@Repository
public interface MyPlantRepository extends JpaRepository<MyPlant, Long> {
    List<MyPlant> findAllByUser(User user);
}
