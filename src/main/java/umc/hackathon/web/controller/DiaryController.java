package umc.hackathon.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.hackathon.apiPayload.ApiResponse;
import umc.hackathon.apiPayload.code.status.SuccessStatus;
import umc.hackathon.converter.DiaryConverter;
import umc.hackathon.domain.entity.Diary;
import umc.hackathon.service.DiaryService.DiaryCommandService;
import umc.hackathon.service.DiaryService.DiaryQueryService;
import umc.hackathon.service.DiaryService.DiaryQueryServiceImpl;
import umc.hackathon.service.UserService.UserQueryService;
import umc.hackathon.web.dto.Diary.DiaryRequestDTO;
import umc.hackathon.web.dto.Diary.DiaryResponseDTO;

import java.util.List;

// temp 주석
@RestController
@RequiredArgsConstructor
@Validated
@CrossOrigin
@RequestMapping("/diary")
@Slf4j
public class DiaryController {

    private final DiaryCommandService diaryCommandService;
    private final DiaryQueryService diaryQueryService;
    private final UserQueryService userQueryService;

    // 일기 생성
    @PostMapping("/")
    @Operation(summary = "일기 생성", description = "일기를 생성합니다. endpoint에 /diary/userId=1 을 입력하세요"
    )
    public ApiResponse<DiaryResponseDTO.CreateDiaryResultDTO> diaryCreate(
            @RequestParam Long userId,
            @RequestBody DiaryRequestDTO.CreateDiaryRequestDTO request
            ) {
        Diary newDiary = diaryCommandService.createDiary(userId, request);
        return ApiResponse.onSuccess(DiaryConverter.toCreateResultDTO(newDiary)
        );
    }

    // 일기 수정
    @PatchMapping("/{diaryId}")
    @Operation(
            summary = "일기 수정 API"
            , description = "일기를 수정합니다. Path variable로 diaryId를 입력 받고, RequestBody에 일기 제목 title과 수정할 일기 content를 입력하세요"
    )
    public ApiResponse<DiaryResponseDTO.UpdateDiaryResultDTO> updateProject(
            @RequestParam Long userId,
            @RequestBody DiaryRequestDTO.UpdateDiaryDTO request,
            @PathVariable Long diaryId
    ) {
        return ApiResponse.onSuccess(DiaryConverter.UpdateDiaryResultDTO(
                        diaryCommandService.updateDiary(userId, diaryId, request)
                )
        );
    }

    // 일기 삭제
    @DeleteMapping("/{diaryId}")
    @Operation(
            summary = "일기 삭제 API"
            , description = "일기를 삭제합니다. Path variable로 삭제할 diaryId를 입력하세요"
    )
    public ApiResponse<?> deleteDiary(
            @RequestParam Long userId,
            @PathVariable Long diaryId) {

        diaryCommandService.deleteDiary(userId, diaryId);
        return ApiResponse.onSuccess(null
        );
    }


    // 일기 조회
    @GetMapping("/diaryList/{userId}")
    @Operation(
            summary = "유저가 작성한 일기 조회 API"
            , description = "유저가 작성한 일기를 조회할 수 있습니다."
    )
    public ApiResponse<DiaryResponseDTO.UserDiaryResultListDTO> findUserDiary(
            @PathVariable Long userId
    ) {
        List<Diary> userDiaryList = diaryQueryService.getUserDiary(userId);
        return ApiResponse.onSuccess(
                DiaryConverter.toUserDiaryResultListDTO(userDiaryList)
        );
    }



}
