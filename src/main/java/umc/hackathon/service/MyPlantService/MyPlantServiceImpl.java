package umc.hackathon.service.MyPlantService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.hackathon.apiPayload.code.status.ErrorStatus;
import umc.hackathon.apiPayload.exception.GeneralException;
import umc.hackathon.apiPayload.exception.handler.TempHandler;
import umc.hackathon.domain.entity.*;
import umc.hackathon.repository.MyPlantImageRepository;
import umc.hackathon.repository.MyPlantRepository;
import umc.hackathon.repository.PlantRepository;
import umc.hackathon.repository.UserRepository;
import umc.hackathon.web.dto.MyPlant.CreateMyPlantRequestDTO;
import umc.hackathon.web.dto.MyPlant.MyPlantResponseDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
@Component
@Transactional
@Slf4j
public class MyPlantServiceImpl implements MyPlantService {


    private final MyPlantRepository myPlantRepository;
    private final MyPlantImageRepository myPlantImageRepository;
    private final PlantRepository plantRepository;
    private final UserRepository userRepository;

    // 반려식물 생성
    @Override
    @Transactional
    public void createMyPlant(Long plantId, Long userId, CreateMyPlantRequestDTO createMyPlantRequestDTO) {

        Plant plant = plantRepository.findById(plantId)
                .orElseThrow(() -> new TempHandler(ErrorStatus.PLANT_NOT_FOUND));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new TempHandler(ErrorStatus.LOGIN_UNAUTHORIZED));

        MyPlant myPlant = MyPlant.builder()
                .plant(plant)
                .user(user)
                .name(createMyPlantRequestDTO.getName())
                .total(0)
                .status(0)
                .build();

        myPlantRepository.save(myPlant);

        MyPlantImage myPlantImage = MyPlantImage.builder()
                .myPlant(myPlant)
                .imageUrl(createMyPlantRequestDTO.getImageUrl())
                .build();

        myPlantImageRepository.save(myPlantImage);

    }

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

    @Override
    public List<MyPlant> getUserMyPlant(Long userId) {
        User getUser = userRepository.findById(userId).get();
        List<MyPlant> UserMyPlantList = myPlantRepository.findAllByUser(getUser);

        return UserMyPlantList;
    }

}
