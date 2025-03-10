package umc.hackathon.web.dto.Plant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlantListDTO {

    private Long id;
    private String name;
    private String imageUrl;
}
