package umc.hackathon.web.dto.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserRequestDTO {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateUserRequestDTO {
        private String name;  // 이름(or 닉네임)
        private String userName;  // 로그인 ID
        private String password;
    }


    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class signInRequestDTO {
        private String userName;
        private String password;
    }
}
