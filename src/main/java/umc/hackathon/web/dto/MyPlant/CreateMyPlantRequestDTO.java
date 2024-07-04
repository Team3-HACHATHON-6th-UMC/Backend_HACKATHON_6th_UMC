package umc.hackathon.web.dto.MyPlant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateMyPlantRequestDTO {

    private String name;
    private String imageUrl;
}
