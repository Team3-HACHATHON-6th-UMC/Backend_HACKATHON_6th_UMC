package umc.hackathon.service.DiaryService;

import umc.hackathon.domain.entity.Diary;

import java.util.List;

public interface DiaryQueryService {

    List<Diary> getUserDiary(Long userId);

}
