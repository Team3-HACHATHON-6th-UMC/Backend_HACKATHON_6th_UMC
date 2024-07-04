package umc.hackathon.web.dto.MyPlant;

// 대문자..
import lombok.*;
public class MyPlantRequestDTO {

    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddMyPlantDTO{

        private String nickname; // Entity에서는 name
        private String imageUrl;
    }

}
