package com.hznu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hznu.entity.User;
import com.hznu.mapper.UserMapper;
import com.hznu.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HHY
 * @since 2020-07-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private IUserService userService;

    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public Boolean Login(User user) {
        try {
            QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
            userQueryWrapper.eq("username", user.getUsername());
            User booleanuser = userMapper.selectOne(userQueryWrapper);
            if (booleanuser == null) {
                return false;
            }
            if (booleanuser.getPassword().equals(user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            throw  e;
        }
    }

    /*

    pwd{
        "id": ,
        "password": ,
        "newpassword":

    }

     */

    @Override
    public Boolean changePwd(HashMap<String, String> newPwd) {
        String id = newPwd.get("id");
        String password = newPwd.get("password");
        String newPassword = newPwd.get("newpassword");
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("id", id).eq("password", password);
        try{
            if (userMapper.selectCount(userQueryWrapper) == 0){
                return false;
            }
            User user = userMapper.selectOne(userQueryWrapper);
            user.setPassword(newPassword);
            System.out.println(".........................");
            System.out.println(user.getPassword());
            if (userMapper.updateById(user) == 1) {
                return true;
            }
            else {
                return  false;
            }
        }
        catch (Exception e) {
            throw e;
        }
    }


}
