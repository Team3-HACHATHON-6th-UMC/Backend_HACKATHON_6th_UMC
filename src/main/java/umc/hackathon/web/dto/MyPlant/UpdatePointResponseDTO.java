package umc.hackathon.web.dto.MyPlant;

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
