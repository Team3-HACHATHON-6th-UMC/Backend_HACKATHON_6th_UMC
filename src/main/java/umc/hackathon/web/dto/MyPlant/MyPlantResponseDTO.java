package umc.hackathon.web.dto.MyPlant;

import lombok.*;

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
}
