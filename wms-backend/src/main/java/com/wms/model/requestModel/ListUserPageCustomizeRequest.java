package com.wms.model.requestModel;

import com.wms.common.model.QueryPageParam;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ListUserPageCustomizeRequest {
//    private Integer id;
//    private String no;
    private String name;
//    private Integer age;
//    private Integer sex;
//    private String phone;
//    private Integer roleId;
//    private String isValid;
    private QueryPageParam param;
}
