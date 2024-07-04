package umc.hackathon.service.UserService;

import umc.hackathon.domain.entity.User;
import umc.hackathon.web.dto.User.UserRequestDTO;

public interface UserQueryService {
    User signIn(UserRequestDTO.SignInRequestDTO request);
}
