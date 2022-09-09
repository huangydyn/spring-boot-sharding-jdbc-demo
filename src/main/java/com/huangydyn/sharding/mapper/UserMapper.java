package com.huangydyn.sharding.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huangydyn.sharding.pojo.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface UserMapper extends BaseMapper<UserModel> {


    @Select("select test_user.* from test_user join test_user_status on test_user.id=test_user_status.user_id")
    List<UserModel> selectByJoinStatus();
}
 