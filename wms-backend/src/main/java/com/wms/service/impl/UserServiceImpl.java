package com.wms.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wms.common.enumModel.ErrorCode;
import com.wms.common.model.BusinessException;
import com.wms.entity.User;
import com.wms.mapper.UserMapper;
import com.wms.model.responseModel.ListUserPageCustomizeResponse;
import com.wms.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author maxy31
 * @since 2025-12-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ListUserPageCustomizeResponse pageCustomize(Page<User> page) {
        ListUserPageCustomizeResponse response = new ListUserPageCustomizeResponse();

        try{
            IPage<User> result = userMapper.pageCustomize(page);
            System.out.println("Total Result    ==> " + result.getTotal());
            response.setUserList(result.getRecords());
            response.setResponse(
                    ErrorCode.SUCCESS.getErrorCode(),
                    ErrorCode.SUCCESS.getStatus().name(),
                    "User List is Retrieved Successfully.",
                    "",
                    ""
            );
        } catch (Exception e) {
            throw new BusinessException(e.getMessage(), ErrorCode.BUSINESS_EXCEPTION_002);
        }

        return response;
    }
}
