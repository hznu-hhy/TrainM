package com.hznu.controller;


import com.hznu.entity.User;

import com.hznu.mybean.R;
import com.hznu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author HHY
 * @since 2020-07-13
 */
@RestController
public class UserController {
    @Autowired
    private IUserService userService;
    @PostMapping(value = "/login")
    public R Login(@RequestBody  User user){
        if(userService.Login(user)){
            return R.ok();
        }
        else{
            return R.error("用户名或者密码错误");
        }

    }

    @PostMapping(value = "/admin/changePwd")
    public R changePwd(@RequestBody HashMap<String, String> newPwd){
        try {
            if (userService.changePwd(newPwd)) {
                return R.ok();
            }
            else {
                return R.error();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return R.error(e.toString());
        }
    }




}
