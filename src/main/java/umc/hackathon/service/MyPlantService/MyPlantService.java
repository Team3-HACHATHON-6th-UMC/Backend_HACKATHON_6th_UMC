package umc.hackathon.service.MyPlantService;

import umc.hackathon.web.dto.MyPlant.CreateMyPlantRequestDTO;
import umc.hackathon.web.dto.MyPlant.MyPlantResponseDTO;

public interface MyPlantService {

    // 반려식물 생성
    void createMyPlant(Long plantId, Long userId, CreateMyPlantRequestDTO createMyPlantRequestDTO);

    // 반려식물 정보조회(== 메인화면)
    MyPlantResponseDTO.MyPlantDTO getMyPlant(Long myPlantId);

    // 반려식물 삭제
    void deleteMyPlant(Long myPlantId);
}
