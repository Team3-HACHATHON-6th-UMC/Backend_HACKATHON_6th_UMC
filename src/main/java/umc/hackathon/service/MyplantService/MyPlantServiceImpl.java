package umc.hackathon.service.MyPlantService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.hackathon.apiPayload.code.status.ErrorStatus;
import umc.hackathon.apiPayload.exception.GeneralException;
import umc.hackathon.domain.entity.MyPlant;
import umc.hackathon.domain.entity.MyPlantImage;
import umc.hackathon.repository.MyPlantImageRepository;
import umc.hackathon.repository.MyPlantRepository;
import umc.hackathon.web.dto.MyPlant.MyPlantResponseDTO;

@Service
@RequiredArgsConstructor

@Component

@Transactional
@Slf4j
public class MyPlantServiceImpl implements umc.hackathon.service.MyPlantService.MyPlantService {


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
    public MyPlantResponseDTO.MyPlantDTO getMyPlant(Long myPlantId) {
        //1. DB에서 myPlantId로 반려식물조회
        MyPlant myPlant = myPlantRepository.findById(myPlantId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.MY_PLANT_NOT_FOUND));

        MyPlantImage myPlantImage = myPlantImageRepository.findByMyPlant_Id(myPlantId);


        // DTO로 변환하여 반환
        MyPlantResponseDTO.MyPlantDTO myPlantDTO = MyPlantResponseDTO.MyPlantDTO.builder()
                .nickname(myPlant.getName())
                .imageUrl(myPlantImage.getImageUrl())
                .status(myPlant.getStatus())
                .build();


        return myPlantDTO;

    }

    // 반려 식물 삭제
    @Override
    public void deleteMyPlant(Long myPlantId) {
        MyPlant myPlant = myPlantRepository.findById(myPlantId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.MY_PLANT_NOT_DELETE));

        myPlantRepository.delete(myPlant);

    }

}
