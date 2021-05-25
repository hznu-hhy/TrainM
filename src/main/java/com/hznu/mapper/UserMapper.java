package com.hznu.mapper;

import com.hznu.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 *
 * @author HHY
 * @since 2020-07-13
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
