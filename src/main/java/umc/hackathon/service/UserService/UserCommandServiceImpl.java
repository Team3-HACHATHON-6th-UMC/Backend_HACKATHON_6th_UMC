package umc.hackathon.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.hackathon.converter.UserConverter;
import umc.hackathon.domain.entity.User;
import umc.hackathon.repository.UserRepository;
import umc.hackathon.web.dto.User.UserRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;

    @Override
    public User createUser(UserRequestDTO.CreateUserRequestDTO request){
        User getUser = userRepository.findByUserName(request.getUserName());

        User newUser = UserConverter.toUser(request);
        User savedUser = userRepository.save(newUser);

        return savedUser;
    }
}
