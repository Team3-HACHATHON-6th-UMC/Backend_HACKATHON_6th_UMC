package umc.hackathon.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.hackathon.domain.entity.User;
import umc.hackathon.repository.UserRepository;
import umc.hackathon.web.dto.User.UserRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserQueryServiceImpl implements UserQueryService {

    private final UserRepository userRepository;

    @Override
    public User signIn(UserRequestDTO.SignInRequestDTO request){
        User findUser = userRepository.findByUserName(request.getUserName());
        if(findUser != null){
            if(request.getPassword().equals(findUser.getPassword())) return findUser; // 예외처리 해주기
        }
        return null;
    }
}
