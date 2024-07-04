package umc.hackathon.converter;

import umc.hackathon.domain.entity.User;
import umc.hackathon.web.dto.User.UserRequestDTO;
import umc.hackathon.web.dto.User.UserResponseDTO;

public class UserConverter {

    public static User toUser(UserRequestDTO.CreateUserRequestDTO request){
        return User.builder()
                .name(request.getName())
                .userName(request.getUserName())
                .password(request.getPassword())
                .build();
    }

    public static UserResponseDTO.CreateUserResultDTO toCreateResultDTO(User user){
        return UserResponseDTO.CreateUserResultDTO.builder()
                .userId(user.getId())
                .name(user.getName())
                .build();
    }

}
