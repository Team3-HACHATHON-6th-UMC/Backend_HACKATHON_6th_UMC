package umc.hackathon.web.dto.Plant;

import lombok.*;
import umc.hackathon.domain.entity.Plant;

@Builder
@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PlantResponseDTO {
    private Long plantId;
    private String plantName;
    private Integer cycle;
    private Integer sunLevel;
    private String description;
    private String imageUrl;


}
