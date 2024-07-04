package umc.hackathon.converter;

import umc.hackathon.domain.entity.Diary;
import umc.hackathon.web.dto.Diary.DiaryRequestDTO;
import umc.hackathon.web.dto.Diary.DiaryResponseDTO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public static DiaryResponseDTO.UpdateDiaryResultDTO UpdateDiaryResultDTO(Diary diary) {
        return DiaryResponseDTO.UpdateDiaryResultDTO.builder()
                .diaryId(diary.getId())
                .title(diary.getTitle())
                .content(diary.getContent())
                .build();
    }

    public static DiaryResponseDTO.UserDiaryResultDTO toUserDiaryResultDTO(Diary diary) {
        return DiaryResponseDTO.UserDiaryResultDTO.builder()
                .diaryId(diary.getId())
                .content(diary.getContent())
                .createdAt(diary.getCreatedAt())
                .build();
    }

    public static DiaryResponseDTO.UserDiaryResultListDTO toUserDiaryResultListDTO(List<Diary> userDiaryList) {
        List<DiaryResponseDTO.UserDiaryResultDTO> userDiaryResultDTOList = IntStream.range(0, userDiaryList.size())
                .mapToObj(i->toUserDiaryResultDTO(userDiaryList.get(i)))
                .collect(Collectors.toList());
        return DiaryResponseDTO.UserDiaryResultListDTO.builder()
                .diaries(userDiaryResultDTOList)
                .build();
    }
}
