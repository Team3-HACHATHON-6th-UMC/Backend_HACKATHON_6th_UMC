package umc.hackathon.service.MyplantService;

import umc.hackathon.web.dto.Myplant.MyplantRequestDTO;
import umc.hackathon.web.dto.Myplant.MyplantResponseDTO;

import java.util.List;

public interface MyplantService {

    /*
    // 반려식물 생성
    MyplantRequestDTO.AddMyplantDTO addMyPlant();

     */

    // 반려식물 정보조회(== 메인화면)
    MyplantResponseDTO.MyplantDTO getMyPlant(Long myPlantId);
}
