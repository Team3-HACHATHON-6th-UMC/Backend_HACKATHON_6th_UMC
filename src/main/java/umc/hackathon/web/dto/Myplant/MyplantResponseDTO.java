package umc.hackathon.web.dto.Myplant;

import lombok.*;

public class MyplantResponseDTO {

    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyplantDTO {
        private String nickname;
        private String imageUrl;
        private Integer status;

    }
}
