package umc.hackathon.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.hackathon.apiPayload.ApiResponse;
import umc.hackathon.service.MyPlantService.MyPlantService;
import umc.hackathon.web.dto.MyPlant.MyPlantRequestDTO;
import umc.hackathon.web.dto.MyPlant.MyPlantResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/myplants")
public class MyPlantController {

    private final MyPlantService myPlantService;

    /*
    // 반려식물 생성
    @PostMapping()
    @Operation(summary = "반려식물 생성 API", description = "반려식물 이름과 사진을 넣어주세요.")
    public ApiResponse<MyplantRequestDTO.AddMyplantDTO> createMyplant(){
        return ApiResponse.onSuccess(myplantService.addMyPlant());

    }
    */


    // 반려식물 상세정보 조회(= 메인화면) (반려식물 1개만 할거라 반려식물 리스트 조회 안 하기로 함)
    @GetMapping("/{myPlantId}")
    @Operation(summary = "반려식물 조회 API", description = "반려식물 메인페이지입니다 :)")
    public ApiResponse<MyPlantResponseDTO.MyPlantDTO> getMyPlant(@PathVariable Long myPlantId) {
        return ApiResponse.onSuccess(myPlantService.getMyPlant(myPlantId));
    }


    // 반려식물 수정 <- 제일 마지막에 하기




    /*
    // 반려식물 삭제
    @DeleteMapping("/{myPlantId}")
    @Operation(summary = "반려식물 삭제 API", description = "내가 추가한 반려식물을 삭제합니다.")
    public ApiResponse<?> deleteMyplant(@PathVariable Long myPlantId) {

    }

     */



}
