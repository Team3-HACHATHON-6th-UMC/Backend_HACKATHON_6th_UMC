package umc.hackathon.web.dto.MyPlant.Point;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePointResponseDTO {

    private Integer total;
    private Integer status;
}
