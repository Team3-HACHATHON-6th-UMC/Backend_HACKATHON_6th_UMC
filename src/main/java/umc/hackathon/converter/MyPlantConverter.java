package umc.hackathon.converter;

import lombok.RequiredArgsConstructor;
import umc.hackathon.apiPayload.code.status.ErrorStatus;
import umc.hackathon.apiPayload.exception.GeneralException;
import umc.hackathon.domain.entity.Diary;
import umc.hackathon.domain.entity.MyPlant;
import umc.hackathon.domain.entity.MyPlantImage;
import umc.hackathon.repository.MyPlantImageRepository;
import umc.hackathon.repository.MyPlantRepository;
import umc.hackathon.web.dto.Diary.DiaryResponseDTO;
import umc.hackathon.web.dto.MyPlant.MyPlantResponseDTO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequiredArgsConstructor
public class MyPlantConverter {

    private final MyPlantRepository myPlantRepository;
    private final MyPlantImageRepository myPlantImageRepository;

//    public MyPlantResponseDTO.MyPlantDTO convertToDTO(Long myPlantId) {
//        MyPlant myPlant = myPlantRepository.findById(myPlantId)
//                .orElseThrow(() -> new GeneralException(ErrorStatus.MY_PLANT_NOT_FOUND));
//
//        MyPlantImage myPlantImage = myPlantImageRepository.findByMyPlant_Id(myPlantId);
//
//        return MyPlantResponseDTO.MyPlantDTO.builder()
//                .nickname(myPlant.getName())
//                .imageUrl(myPlantImage.getImageUrl())
//                .status(myPlant.getStatus())
//                .build();
//    }

    // 될거같은데 안되는
//    public static MyPlantResponseDTO.UserMyPlantResultDTO toUserMyPlantResultDTO(MyPlant myPlant) {
//        MyPlantImage myPlantImage = myPlantImageRepository.findByMyPlant_Id(myPlantId);
//        return MyPlantResponseDTO.UserMyPlantResultDTO.builder()
//                .myPlantId(myPlant.getId())
//                .nickName(myPlant.getName())
//                .imageUrl(myPlantImage != null ? myPlantImage.getImageUrl() : null)
//                .status(myPlant.getStatus())
//                .build();
//    }

//    public static MyPlantResponseDTO.UserMyPlantResultListDTO toUserMyPlantResultListDTO(List<MyPlant> userMyPlantList) {
//        List<MyPlantResponseDTO.UserMyPlantResultDTO> userMyPlantResultDTOList = IntStream.range(0, userMyPlantList.size())
//                .mapToObj(i->toUserMyPlantResultDTO(userMyPlantList.get(i)))
//                .collect(Collectors.toList());
//        return MyPlantResponseDTO.UserMyPlantResultListDTO.builder()
//                .myPlants(userMyPlantResultDTOList)
//                .build();
//    }

//    public static MyPlantResponseDTO.UserMyPlantResultListDTO toUserMyPlantResultListDTO(List<MyPlant> userMyPlantList) {
//        List<MyPlantResponseDTO.UserMyPlantResultDTO> userMyPlantResultDTOList = IntStream.range(0, userMyPlantList.size())
//                .mapToObj(i->toUserMyPlantResultDTO(userMyPlantList.get(i)))
//                .collect(Collectors.toList());
//        return MyPlantResponseDTO.UserMyPlantResultListDTO.builder()
//                .myPlants(userMyPlantResultDTOList)
//                .build();
//    }
}
