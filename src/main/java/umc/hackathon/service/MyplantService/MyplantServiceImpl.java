package umc.hackathon.service.MyplantService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import umc.hackathon.apiPayload.code.status.ErrorStatus;
import umc.hackathon.apiPayload.exception.GeneralException;
import umc.hackathon.domain.entity.Myplant;
import umc.hackathon.domain.entity.MyplantImage;
import umc.hackathon.repository.MyPlantImageRepository;
import umc.hackathon.repository.MyPlantRepository;
import umc.hackathon.web.dto.Myplant.MyplantRequestDTO;
import umc.hackathon.web.dto.Myplant.MyplantResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

import static ch.qos.logback.classic.spi.ThrowableProxyVO.build;

@Service
@RequiredArgsConstructor

@Component
public class MyplantServiceImpl implements MyplantService{


    private final MyPlantRepository myPlantRepository;
    private final MyPlantImageRepository myPlantImageRepository;

    /*
    // 반려식물 생성 (nickname, imageUrl 만 추가하면 됨) imageUrl은 MyPlantImage에 있음.
    @Override
    public MyplantRequestDTO.AddMyplantDTO addMyPlant() {

    }

     */

    // 반려식물 정보조회(== 메인화면)
    @Override
    public MyplantResponseDTO.MyplantDTO getMyPlant(Long myPlantId) {
        //1. DB에서 myPlantId로 반려식물조회
        Myplant myPlant = myPlantRepository.findById(myPlantId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.PLANT_NOT_EXIST));

        MyplantImage myPlantImage = myPlantImageRepository.findByMyplant_Id(myPlantId);


        // DTO로 변환하여 반환
        MyplantResponseDTO.MyplantDTO myplantDTO = MyplantResponseDTO.MyplantDTO.builder()
                .nickname(myPlant.getName())
                .imageUrl(myPlantImage.getImageUrl())
                .status(myPlant.getStatus())
                .build();


        return myplantDTO;





    }
}
