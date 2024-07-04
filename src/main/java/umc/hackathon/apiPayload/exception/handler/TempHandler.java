package umc.hackathon.apiPayload.exception.handler;

import umc.hackathon.apiPayload.code.BaseCode;
import umc.hackathon.apiPayload.code.status.ErrorStatus;
import umc.hackathon.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {
    public TempHandler(BaseCode errorCode) {
        super((ErrorStatus) errorCode);
    }
}