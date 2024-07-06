package umc.hackathon.web.dto.Diary;

import jakarta.validation.constraints.Size;
import lombok.*;

public class DiaryRequestDTO {

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateDiaryRequestDTO {
        private String title;
        private String content;
        @Size(max = Integer.MAX_VALUE)
        private String imageUrl;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UpdateDiaryDTO {
        private String title;
        private String content;
    }

}
