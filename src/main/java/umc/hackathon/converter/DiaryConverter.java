package umc.hackathon.converter;

import umc.hackathon.domain.entity.Diary;
import umc.hackathon.web.dto.Diary.DiaryRequestDTO;
import umc.hackathon.web.dto.Diary.DiaryResponseDTO;

public class DiaryConverter {

    public static Diary toDiary(DiaryRequestDTO.CreateDiaryRequestDTO request){
        return Diary.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build();
    }

    public static DiaryResponseDTO.CreateDiaryResultDTO toCreateResultDTO(Diary diary){
        return DiaryResponseDTO.CreateDiaryResultDTO.builder()
                .diaryId(diary.getId())
                .title(diary.getTitle())
                .content(diary.getContent())
                .createAt(diary.getCreatedAt())
                .build();
    }
}
