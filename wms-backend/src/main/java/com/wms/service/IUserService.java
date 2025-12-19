package com.wms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wms.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wms.model.responseModel.ListUserPageCustomizeResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author maxy31
 * @since 2025-12-12
 */
public interface IUserService extends IService<User> {

    ListUserPageCustomizeResponse pageCustomize(Page<User> page);
}
