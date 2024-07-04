package umc.hackathon.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.hackathon.apiPayload.code.status.ErrorStatus;
import umc.hackathon.apiPayload.exception.handler.TempHandler;
import umc.hackathon.domain.entity.Plant;
import umc.hackathon.domain.entity.PlantImage;
import umc.hackathon.repository.PlantImageRepository;
import umc.hackathon.repository.PlantRepository;
import umc.hackathon.web.dto.Plant.PlantListDTO;
import umc.hackathon.web.dto.Plant.PlantListResponseDTO;
import umc.hackathon.web.dto.Plant.PlantResponseDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PlantService {

    private final PlantRepository plantRepository;
    private final PlantImageRepository plantImageRepository;

    public PlantListResponseDTO getPlants() {

        List<Plant> plants = plantRepository.findAll();
        List<PlantListDTO> plantListDTOS = new ArrayList<>();

        for (Plant plant : plants) {
            PlantImage plantImage = plantImageRepository.findFirstByPlant_Id(plant.getId())
                    .orElseThrow(() -> new TempHandler(ErrorStatus.MY_PLANT_NOT_FOUND));

            PlantListDTO plantListDTO = PlantListDTO.builder()
                    .id(plant.getId())
                    .name(plant.getName())
                    .imageUrl(plantImage.getImageUrl())
                    .build();

            plantListDTOS.add(plantListDTO);
        }

        return new PlantListResponseDTO(plantListDTOS);
    }

    @Transactional
    public PlantResponseDTO getPlantDetails(Long plantId) {
        Plant plant=plantRepository.findById(plantId).orElseThrow();

        PlantImage plantImage = plantImageRepository.findFirstByPlant_Id(plant.getId())
                .orElseThrow(() -> new TempHandler(ErrorStatus.MY_PLANT_NOT_FOUND));

                //PLANT_IMAGE_NOT_FOUND
        PlantResponseDTO plantResponseDTO = PlantResponseDTO.builder()
                .plantId(plant.getId())
                .plantName(plant.getName())
                .cycle(plant.getCycle())
                .sunLevel(plant.getSunLevel())
                .description(plant.getDescription())
                .imageUrl(plantImage.getImageUrl())
                .build();

        return plantResponseDTO;
    }
}
