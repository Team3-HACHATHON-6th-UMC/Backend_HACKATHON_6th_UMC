package umc.hackathon.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import umc.hackathon.apiPayload.ApiResponse;
import umc.hackathon.repository.PlantRepository;
import umc.hackathon.service.PlantService;
import umc.hackathon.web.dto.Plant.PlantListResponseDTO;
import umc.hackathon.web.dto.Plant.PlantResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
public class PlantController {

    private final PlantService plantService;

    //식물 전체 조회
    @GetMapping("/plants")
    public ApiResponse<PlantListResponseDTO> getPlants() {
        return ApiResponse.onSuccess(plantService.getPlants());
    }

    //식물 상세 조회
    @GetMapping("/plants/{plantId}")
    public ApiResponse<PlantResponseDTO> getPlantDetails(@PathVariable Long plantId){
        return ApiResponse.onSuccess(plantService.getPlantDetails(plantId));
    }

}
