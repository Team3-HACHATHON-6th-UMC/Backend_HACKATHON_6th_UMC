package umc.hackathon.service.DiaryService;

import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import umc.hackathon.domain.entity.Diary;
import umc.hackathon.domain.entity.User;
import umc.hackathon.repository.DiaryRepository;
import umc.hackathon.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
@Getter
public class DiaryQueryServiceImpl implements DiaryQueryService{
    private final DiaryRepository diaryRepository;
    private final UserRepository userRepository;

//    @Override
//    public Diary findById(Long diaryId) {
//        Diary diary = diaryRepository.findById(diaryId).get();
//        return diaryRepository.save(diary);
//    }

    @Override
    public List<Diary> getUserDiary(Long userId) {
        User getUser = userRepository.findById(userId).get();
        List<Diary> UserDiaryList = diaryRepository.findAllByUser(getUser);

        return UserDiaryList;
    }

}
