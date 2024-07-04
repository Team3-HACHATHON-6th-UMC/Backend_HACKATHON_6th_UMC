package umc.hackathon.apiPayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.hackathon.apiPayload.code.BaseCode;
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

    private BaseCode code;

    public ReasonDTO getErrorReason() {
        return this.code.getReason();
    }

    public ReasonDTO getErrorReasonHttpStatus(){
        return this.code.getReasonHttpStatus();
    }

}