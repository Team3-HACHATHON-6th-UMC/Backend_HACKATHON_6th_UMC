package umc.hackathon.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.hackathon.apiPayload.ApiResponse;
import umc.hackathon.apiPayload.code.status.SuccessStatus;
import umc.hackathon.converter.UserConverter;
import umc.hackathon.domain.entity.User;
import umc.hackathon.service.UserService.UserCommandService;
import umc.hackathon.service.UserService.UserQueryService;
import umc.hackathon.web.dto.User.UserRequestDTO;
import umc.hackathon.web.dto.User.UserResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@CrossOrigin
@RequestMapping("/users")
@Slf4j
public class UserController {

    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

    // 회원가입
    @Operation(summary = "유저 생성", description = "User를 생성합니다."
    )
    @PostMapping("/sign_up")
    public ApiResponse<UserResponseDTO.CreateUserResultDTO> createUser(
            @RequestBody UserRequestDTO.CreateUserRequestDTO request
    ) {
        User newUser = userCommandService.createUser(request);
        return ApiResponse.onSuccess(UserConverter.toCreateResultDTO(newUser)
        );
    }

    // 로그인
    @Operation(summary = "로그인", description =
            "로그인"
    )
    @PostMapping("/sign_in")
    public ApiResponse<UserResponseDTO.SignInResultDTO> signIn(
            @RequestBody UserRequestDTO.SignInRequestDTO request
    ) {
        User findUser = userQueryService.signIn(request);
        return ApiResponse.onSuccess(UserConverter.toSignInResultDTO(findUser)
        );
    }




}
