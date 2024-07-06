package umc.hackathon.service.UserService;

import umc.hackathon.domain.entity.User;
import umc.hackathon.web.dto.User.UserRequestDTO;

public interface UserCommandService {

    User createUser(UserRequestDTO.CreateUserRequestDTO request);
}
