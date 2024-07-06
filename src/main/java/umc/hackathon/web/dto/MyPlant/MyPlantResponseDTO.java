package umc.hackathon.web.dto.MyPlant;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

public class MyPlantResponseDTO {

    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyPlantDTO {
        private String nickname;
        private String imageUrl;
        private Integer status;

    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserMyPlantResultDTO {
        Long myPlantId;
        String nickName;
        String imageUrl;
        String name;
        Integer status;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserMyPlantResultListDTO {
        List<UserMyPlantResultDTO> myPlants;
    }
}
