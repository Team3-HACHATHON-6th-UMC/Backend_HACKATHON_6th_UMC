package umc.hackathon.apiPayload.exception.handler;

import umc.hackathon.apiPayload.code.BaseCode;
import umc.hackathon.apiPayload.code.status.ErrorStatus;
import umc.hackathon.apiPayload.exception.GeneralException;

public class UserHandler extends GeneralException {

    public UserHandler(BaseCode baseErrorCode){
        super((ErrorStatus) baseErrorCode);
    }
}
