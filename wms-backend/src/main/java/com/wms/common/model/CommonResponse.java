package com.wms.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CommonResponse {
    private CommonResponseElements response;

    public void setResponse(String responseCode, String status, String statusMsg, String errorCode, String errorMsg) {
        this.response = new CommonResponseElements(responseCode, status, statusMsg, errorCode, errorMsg);
    }
}
