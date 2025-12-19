package com.wms.model.responseModel;

import com.wms.common.model.CommonResponse;
import com.wms.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ListUserPageCustomizeResponse extends CommonResponse {
    private List<User> userList;
}
