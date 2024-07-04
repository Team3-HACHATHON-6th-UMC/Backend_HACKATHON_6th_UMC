package umc.hackathon.apiPayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.hackathon.apiPayload.code.ReasonDTO;
import umc.hackathon.apiPayload.code.status.ErrorStatus;

@Getter
public class GeneralException extends RuntimeException {

    private final ErrorStatus errorStatus;

    public GeneralException(ErrorStatus errorStatus) {
        super(errorStatus.getMessage());
        this.errorStatus = errorStatus;
    }

    public ReasonDTO getErrorStatus() {
        return this.errorStatus.getReason();
    }

}