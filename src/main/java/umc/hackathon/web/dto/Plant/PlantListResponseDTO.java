package umc.hackathon.web.dto.Plant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PlantListResponseDTO<T> {

    private T plants;
}
