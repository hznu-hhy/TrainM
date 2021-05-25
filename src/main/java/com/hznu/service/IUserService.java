package com.hznu.service;

import com.hznu.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashMap;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HHY
 * @since 2020-07-13
 */
public interface IUserService extends IService<User> {
    Boolean Login(User user);
    Boolean changePwd(HashMap<String, String> newPwd);

}
