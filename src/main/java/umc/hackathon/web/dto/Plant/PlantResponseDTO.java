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
    private Integer sunlevel;
    private String description;
    private String imageUrl;

    public static PlantResponseDTO of(Plant plant) {
        PlantResponseDTO plantResponseDTO = new PlantResponseDTO();
        plantResponseDTO.plantId = plant.getId();
        plantResponseDTO.plantName = plant.getName();
        plantResponseDTO.cycle = plant.getCycle();
        plantResponseDTO.sunlevel = plant.getSunLevel();
        plantResponseDTO.description = plant.getDescription();
        //plantResponseDTO.imageUrl = plant.getPl();
        return plantResponseDTO;
    }

}
