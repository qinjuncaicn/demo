package com.qjc.mapper;

import com.qjc.model.User;
import org.apache.ibatis.annotations.Mapper;

//@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}