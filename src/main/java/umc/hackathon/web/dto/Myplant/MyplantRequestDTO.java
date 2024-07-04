package umc.hackathon.web.dto.Myplant;


import lombok.*;
public class MyplantRequestDTO {

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
