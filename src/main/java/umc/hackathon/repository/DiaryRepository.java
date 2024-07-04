package umc.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.hackathon.domain.entity.Diary;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long> {
}
