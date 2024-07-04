package umc.hackathon.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.hackathon.apiPayload.code.BaseCode;
import umc.hackathon.apiPayload.code.ReasonDTO;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseCode {

    // 에러 응답
    INTERNER_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error", "서버 에러"),

    // 로그인 관련
    USER_ALREADY_EXISTS(HttpStatus.CONFLICT, "user already exists", "이미 존재하는 아이디입니다."),

    LOGIN_UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "LOGIN FAIL", "아이디 또는 비밀번호를 확인하세요"),

    // 세션 에러
    SESSION_UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "UNAUTHORIZED", "유효하지 않은 세션입니다."),

    // 반려식물 관련
    MY_PLANT_NOT_FOUND(HttpStatus.NOT_FOUND, "NOT FOUND", "존재하지 않는 반려식물입니다."),

    POINT_RANGE_EXCEEDED(HttpStatus.BAD_REQUEST, "BAD REQUEST", "점수 범위를 초과했습니다."),

    MY_PLANT_NOT_DELETE(HttpStatus.INTERNAL_SERVER_ERROR, "BAD REQUEST", "반려식물 삭제가 안 됩니다.");




    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ReasonDTO getReason() {
        return ReasonDTO.builder()
                .isSuccess(false)
                .httpStatus(httpStatus)
                .code(code)
                .message(message)
                .build();
    }

    @Override
    public ReasonDTO getReasonHttpStatus() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build()
                ;
    }

}