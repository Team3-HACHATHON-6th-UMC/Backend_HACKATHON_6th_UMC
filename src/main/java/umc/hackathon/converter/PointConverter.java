package umc.hackathon.converter;

import umc.hackathon.domain.entity.MyPlant;
import umc.hackathon.web.dto.MyPlant.UpdatePointResponseDTO;

public class PointConverter {

    public static UpdatePointResponseDTO toUpdatePointResponseDTO (MyPlant myPlant) {

        return UpdatePointResponseDTO.builder()
                .total(myPlant.getTotal())
                .status(myPlant.getStatus())
                .build();
    }
}
