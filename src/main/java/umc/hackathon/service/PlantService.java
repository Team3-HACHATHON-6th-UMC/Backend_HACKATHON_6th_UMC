package umc.hackathon.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.hackathon.domain.entity.Plant;
import umc.hackathon.repository.PlantRepository;
import umc.hackathon.web.dto.Plant.PlantResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PlantService {

    private final PlantRepository plantRepository;

//    @Transactional
//    public List<PlantResponseDTO> getPlant() {
//        return plantRepository.findAll().stream()
//                .map(plantResponseDto::new)
//                .collect(Collectors.toList());
//    }

    @Transactional
    public PlantResponseDTO getPlantDetails(Long plantId) {
        Plant plant=plantRepository.findById(plantId).orElseThrow();
        return PlantResponseDTO.of(plant);
    }
}
