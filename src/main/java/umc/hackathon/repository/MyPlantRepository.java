package umc.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.hackathon.domain.entity.Myplant;

import java.util.List;

public interface MyPlantRepository extends JpaRepository<Myplant, Long> {

    // 반려식물 상세 정보 조회(== 메인화면)
//    List<Myplant> findById(Long myPlantId);

}
