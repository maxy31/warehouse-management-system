package com.wms.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wms.common.enumModel.ErrorCode;
import com.wms.common.model.BusinessException;
import com.wms.common.model.CommonResponse;
import com.wms.model.requestModel.ListUserPageCustomizeRequest;
import com.wms.entity.User;
import com.wms.model.responseModel.ListUserPageCustomizeResponse;
import com.wms.service.IUserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author maxy31
 * @since 2025-12-12
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

//    Create
    @PostMapping("/save")
    public boolean create(@RequestBody User user) {
        return userService.save(user);
    }
//    Edit
    @PostMapping("/edit")
    public boolean update(@RequestBody User user){
        return userService.updateById(user);
    }
//    Create or Edit
    @PostMapping("/saveOrEdit")
    public boolean createOrUpdate(@RequestBody User user){
        return userService.saveOrUpdate(user);
    }
//    Delete
    @DeleteMapping("/delete")
    public boolean delete(Integer id){
        return userService.removeById(id);
    }
//    Search
    @PostMapping("/searchUser")
    public List<User> searchUser(@RequestBody User user){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//        exactly same
//        lambdaQueryWrapper.eq(User::getName, user.getName());

//        something like
        lambdaQueryWrapper.like(User::getName, user.getName());
        return userService.list(lambdaQueryWrapper);
    }

    @PostMapping("/listUserPage")
    public List<User> listUserPage(@RequestBody ListUserPageCustomizeRequest request){
        int pageNum = request.getParam().getPageNum();
        int pageSize = request.getParam().getPageSize();

        System.out.println("pageNum     ==> " + pageNum);
        System.out.println("pageSize    ==> " + pageSize);

        Page<User> page = new Page<>(pageNum, pageSize);  // (当前页数，每页多少条)
        /** 也可以用这样的方式来定义
         * Page<User> page = new Page();
         * page.setCurrent(query.getPageNum()); //当前页数
         * page.setSize(query.getPageSize());   //每页多少
         */

        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getName, request.getName());

        IPage<User> result = userService.page(page, lambdaQueryWrapper);
        System.out.println("Total Result    ==> " + result.getTotal());
        return result.getRecords();
    }

    @PostMapping("/listUserPageCustomize")
    public ResponseEntity<ListUserPageCustomizeResponse> listUserPageCustomize(@RequestBody ListUserPageCustomizeRequest request, HttpServletRequest httpServletRequest){
        int pageNum = request.getParam().getPageNum();
        int pageSize = request.getParam().getPageSize();

        System.out.println("pageNum     ==> " + pageNum);
        System.out.println("pageSize    ==> " + pageSize);

        Page<User> page = new Page<>(pageNum, pageSize);

        ListUserPageCustomizeResponse response = new ListUserPageCustomizeResponse();
        response=userService.pageCustomize(page);

        return ResponseEntity.ok(response);
    }
}
