package com.wms.common.model;

import com.wms.common.enumModel.ErrorCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class BusinessException extends RuntimeException{
    private ErrorCode error;

    public BusinessException (String exceptionMessage) {
        super(exceptionMessage);
    }

    public BusinessException (String exceptionMessage, ErrorCode error){
        super(exceptionMessage);
        this.error = error;
    }
}
