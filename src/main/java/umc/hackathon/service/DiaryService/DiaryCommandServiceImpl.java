package umc.hackathon.service.DiaryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.hackathon.converter.DiaryConverter;
import umc.hackathon.domain.entity.Diary;
import umc.hackathon.domain.entity.User;
import umc.hackathon.repository.DiaryRepository;
import umc.hackathon.repository.UserRepository;
import umc.hackathon.web.dto.Diary.DiaryRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class DiaryCommandServiceImpl implements DiaryCommandService{

    private final DiaryRepository diaryRepository;
    private final UserRepository userRepository;

    @Override
    public Diary createDiary(Long userId, DiaryRequestDTO.CreateDiaryRequestDTO request){
        Diary newDiary = DiaryConverter.toDiary(request);
        User getUser = userRepository.findById(userId).get();
        newDiary.setUser(getUser);

        Diary savedDiary = diaryRepository.save(newDiary);

        return savedDiary;
    }

    @Override
    public Diary updateDiary(Long userId, Long diaryId, DiaryRequestDTO.UpdateDiaryDTO request) {

        User getUser = userRepository.findById(userId).get();

        Diary updateDiary = diaryRepository.findById(diaryId).get();
        updateDiary.update(request);

        return updateDiary;
    }

    @Override
    public void deleteDiary(Long userId, Long diaryId) {
        User getUser = userRepository.findById(userId).get();

        Diary deleteDiary = diaryRepository.findById(diaryId).get();
        diaryRepository.delete(deleteDiary);
    }

}
