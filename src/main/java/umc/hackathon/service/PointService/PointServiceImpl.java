package umc.hackathon.service.PointService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.hackathon.apiPayload.code.status.ErrorStatus;
import umc.hackathon.apiPayload.exception.handler.TempHandler;
import umc.hackathon.converter.PointConverter;
import umc.hackathon.domain.entity.MyPlant;
import umc.hackathon.repository.MyPlantRepository;
import umc.hackathon.web.dto.MyPlant.Point.UpdatePointResponseDTO;

@Service
@RequiredArgsConstructor
public class PointServiceImpl implements PointService{

    private final MyPlantRepository myplantRepository;

    public UpdatePointResponseDTO updatePoint(Long myPlantId) {

        MyPlant myPlant = myplantRepository.findById(myPlantId)
                .orElseThrow(() -> new TempHandler(ErrorStatus.MY_PLANT_NOT_FOUND));
        if (myPlant.getTotal() >= 100) {
            throw new TempHandler(ErrorStatus.POINT_RANGE_EXCEEDED);
        }

        myPlant.updatePoint();
        myplantRepository.save(myPlant);

        if (myPlant.getTotal() < 25) {
            myPlant.updateStatus(0);
        }
        else if (myPlant.getTotal() < 50) {
            myPlant.updateStatus(1);
        }
        else if (myPlant.getTotal() < 75) {
            myPlant.updateStatus(2);
        }
        else if (myPlant.getTotal() < 100){
            myPlant.updateStatus(3);
        }
        myplantRepository.save(myPlant);

        UpdatePointResponseDTO updatePointResponseDTO = PointConverter.toUpdatePointResponseDTO(myPlant);
        return updatePointResponseDTO;
    }
}
