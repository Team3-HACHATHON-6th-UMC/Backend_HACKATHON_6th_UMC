package umc.hackathon.web.dto.MyPlant;

<<<<<<< HEAD
<<<<<<<< HEAD:src/main/java/umc/hackathon/web/dto/MyPlant/MyPlantRequestDTO.java

========
// temp save
>>>>>>>> develop:src/main/java/umc/hackathon/web/dto/Myplant/MyplantRequestDTO.java
=======
// temp save
>>>>>>> develop
import lombok.*;
public class MyPlantRequestDTO {

    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
<<<<<<< HEAD
    public static class AddMyplantDTO{
=======
    public static class AddMyPlantDTO{
>>>>>>> develop

        private String nickname; // Entity에서는 name
        private String imageUrl;
    }

}
