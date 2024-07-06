package umc.hackathon.service.DiaryService;

import umc.hackathon.domain.entity.Diary;
import umc.hackathon.web.dto.Diary.DiaryRequestDTO;

public interface DiaryCommandService {

    Diary createDiary(Long userId, DiaryRequestDTO.CreateDiaryRequestDTO request);

    Diary updateDiary(Long userId, Long diaryId, DiaryRequestDTO.UpdateDiaryDTO request);

    void deleteDiary(Long userId, Long diaryId);

}
