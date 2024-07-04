package umc.hackathon.converter;

import umc.hackathon.domain.entity.Myplant;
import umc.hackathon.web.dto.MyPlant.Point.UpdatePointResponseDTO;

public class PointConverter {

    public static UpdatePointResponseDTO toUpdatePointResponseDTO (Myplant myplant) {

        return UpdatePointResponseDTO.builder()
                .total(myplant.getTotal())
                .status(myplant.getStatus())
                .build();
    }
}
