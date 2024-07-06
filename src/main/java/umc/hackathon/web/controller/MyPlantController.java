package umc.hackathon.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.hackathon.apiPayload.ApiResponse;
import umc.hackathon.converter.DiaryConverter;
import umc.hackathon.converter.MyPlantConverter;
import umc.hackathon.domain.entity.Diary;
import umc.hackathon.domain.entity.MyPlant;
import umc.hackathon.repository.MyPlantImageRepository;
import umc.hackathon.service.MyPlantService.MyPlantService;
import umc.hackathon.web.dto.Diary.DiaryResponseDTO;
import umc.hackathon.web.dto.MyPlant.CreateMyPlantRequestDTO;
import umc.hackathon.web.dto.MyPlant.MyPlantResponseDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/my-plants")
public class MyPlantController {

    private final MyPlantService myPlantService;
    private final MyPlantImageRepository myPlantImageRepository;

    // 반려식물 생성
    @PostMapping
    @Operation(summary = "반려식물 생성 API", description = "반려식물 이름과 사진을 넣어주세요.")
    public ApiResponse<?> createMyPlant(@RequestParam Long plantId, @RequestParam Long userId, @RequestBody CreateMyPlantRequestDTO createMyPlantRequestDTO){
        myPlantService.createMyPlant(plantId, userId, createMyPlantRequestDTO);
        return ApiResponse.onSuccess("반려식물 생성 완료");

    }


    // 반려식물 상세정보 조회(= 메인화면) (반려식물 1개만 할거라 반려식물 리스트 조회 안 하기로 함)
    @GetMapping("/{myPlantId}")
    @Operation(summary = "반려식물 조회 API", description = "반려식물 메인페이지입니다 :)")
    public ApiResponse<MyPlantResponseDTO.MyPlantDTO> getMyPlant(@PathVariable Long myPlantId) {
        return ApiResponse.onSuccess(myPlantService.getMyPlant(myPlantId));
    }


    // 반려식물 수정 <- 제일 마지막에 하기




    // 반려식물 삭제
    @DeleteMapping("/{myPlantId}")
    @Operation(summary = "반려식물 삭제 API", description = "내가 추가한 반려식물을 삭제합니다.")
    public ApiResponse<?> deleteMyplant(@PathVariable Long myPlantId) {
        myPlantService.deleteMyPlant(myPlantId);
        String message = "리뷰가 삭제되었습니다.";
        return new ApiResponse<>(true, "COMMON200", message, myPlantId);

    }



    // 반려 식물 리스트 조회
    // Controller method
//    @GetMapping("/myplantlist/{userId}")
//    @Operation(
//            summary = "유저의 반려 식물 조회 API",
//            description = "유저의 반려 식물을 조회할 수 있습니다."
//    )
//    public ApiResponse<MyPlantResponseDTO.UserMyPlantResultListDTO> findUserMyPlant(
//            @PathVariable Long userId
//    ) {
//        List<MyPlant> userMyPlantList = myPlantService.getUserMyPlant(userId);
//        return ApiResponse.onSuccess(
//                MyPlantConverter.toUserMyPlantResultListDTO(userMyPlantList)
//        );
//    }

//    @GetMapping("/myplantlist/{userId}")
//    @Operation(
//            summary = "유저의 반려 식물 조회 API",
//            description = "유저의 반려 식물을 조회할 수 있습니다."
//    )
//    public ApiResponse<MyPlantResponseDTO.UserMyPlantResultListDTO> findUserMyPlant(
//            @PathVariable Long userId
//    ) {
//        List<MyPlant> userMyPlantList = myPlantService.getUserMyPlant(userId);
//        //MyPlantConverter converter = new MyPlantConverter;
//        return ApiResponse.onSuccess(
//                MyPlantConverter.toUserMyPlantResultListDTO(userMyPlantList)
//        );
//    }

}
