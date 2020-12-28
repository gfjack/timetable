package com.education.timetable.exception;

import com.education.timetable.exception.exceptionBodyInit.BaseErrorInfoInterface;

public class TimeTableException extends RuntimeException {

    private static final long serivalVersionUID = 1L;

    protected int errorCode;

    protected String errorMsg;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public TimeTableException() {
        super();
    }

    public TimeTableException(BaseErrorInfoInterface errorInfoInterface) {
        super(errorInfoInterface.getResultCode().toString());
        this.errorCode = errorInfoInterface.getResultCode();
        this.errorMsg = errorInfoInterface.getResultMessage();
    }

    public TimeTableException(BaseErrorInfoInterface errorInfoInterface, Throwable cause) {
        super(errorInfoInterface.getResultCode().toString(), cause);
        this.errorCode = errorInfoInterface.getResultCode();
        this.errorMsg = errorInfoInterface.getResultMessage();
    }

    public TimeTableException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public TimeTableException(Integer errorCode, String errorMsg) {
        super(errorCode.toString());
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public TimeTableException(Integer errorCode, String errorMsg, Throwable cause) {
        super(errorCode.toString(), cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

}
