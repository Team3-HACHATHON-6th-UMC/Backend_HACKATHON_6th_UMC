package umc.hackathon.web.dto.MyPlant;


import lombok.*;
public class MyPlantRequestDTO {

    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddMyplantDTO{

        private String nickname; // Entity에서는 name
        private String imageUrl;
    }

}
