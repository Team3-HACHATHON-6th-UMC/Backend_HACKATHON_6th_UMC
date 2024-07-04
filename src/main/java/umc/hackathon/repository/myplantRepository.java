package umc.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.hackathon.domain.entity.Myplant;

public interface myplantRepository extends JpaRepository<Myplant, Long> {
}
