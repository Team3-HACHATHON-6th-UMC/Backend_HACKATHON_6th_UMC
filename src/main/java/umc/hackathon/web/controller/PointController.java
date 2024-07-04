package umc.hackathon.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.hackathon.apiPayload.ApiResponse;
import umc.hackathon.service.PointService.PointServiceImpl;
import umc.hackathon.web.dto.MyPlant.Point.UpdatePointResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/points")
public class PointController {

    private final PointServiceImpl pointServiceImpl;

    @PatchMapping("/{myPlantId}")
    public ApiResponse<UpdatePointResponseDTO> updatePoint(@PathVariable Long myPlantId) {

        return ApiResponse.onSuccess(pointServiceImpl.updatePoint(myPlantId));
    }
}
