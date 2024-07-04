package umc.hackathon.service.PointService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.hackathon.apiPayload.code.status.ErrorStatus;
import umc.hackathon.apiPayload.exception.handler.TempHandler;
import umc.hackathon.converter.PointConverter;
import umc.hackathon.domain.entity.Myplant;
import umc.hackathon.repository.myplantRepository;
import umc.hackathon.web.dto.MyPlant.Point.UpdatePointResponseDTO;

@Service
@RequiredArgsConstructor
public class PointServiceImpl implements PointService{

    private final myplantRepository myplantRepository;

    public UpdatePointResponseDTO updatePoint(Long myPlantId) {

        Myplant myplant = myplantRepository.findById(myPlantId)
                .orElseThrow(() -> new TempHandler(ErrorStatus.MY_PLANT_NOT_FOUND));

        myplant.updatePoint();
        myplantRepository.save(myplant);

        if (myplant.getTotal() < 25) {
            myplant.updateStatus(0);
        }
        else if (myplant.getTotal() < 50) {
            myplant.updateStatus(1);
        }
        else if (myplant.getTotal() < 75) {
            myplant.updateStatus(2);
        }
        else if (myplant.getTotal() <= 100){
            myplant.updateStatus(3);
        }
        else {
            throw new TempHandler(ErrorStatus.POINT_RANGE_EXCEEDED);
        }
        myplantRepository.save(myplant);

        UpdatePointResponseDTO updatePointResponseDTO = PointConverter.toUpdatePointResponseDTO(myplant);
        return updatePointResponseDTO;
    }
}
