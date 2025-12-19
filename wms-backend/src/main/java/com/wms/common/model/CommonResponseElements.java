package com.wms.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CommonResponseElements {
    private String responseCode;   //Http response code
    private String status;
    private String statusMsg;
    private String errorCode;   //Error code
    private String errorMsg; //http response msg
}
