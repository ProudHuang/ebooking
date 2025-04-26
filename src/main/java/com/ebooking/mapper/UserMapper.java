package com.ebooking.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ebooking.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    // 1. 继承BaseMapper获得基础CRUD能力

    // 2. 自定义简单查询方法（使用注解）
    @Select("SELECT * FROM user WHERE username = #{username} AND deleted = 0")
    User selectByUsername(@Param("username") String username);

    @Select("SELECT * FROM user WHERE email = #{email} LIMIT 1")
    User selectByEmail(@Param("email") String email);

    // 3. 复杂查询方法（使用注解）
    @Select("<script>" +
            "SELECT * FROM user WHERE deleted = 0 " +
            "<if test='condition.username != null'>AND username LIKE CONCAT('%', #{condition.username}, '%')</if>" +
            "<if test='condition.email != null'>AND email = #{condition.email}</if>" +
            "</script>")
    List<User> selectByCondition(@Param("condition") User condition);

    // 4. 执行任意SQL查询（返回Map列表）
    @Select("${sql}")
    List<Map<String, Object>> executeQuery(@Param("sql") String sql);

    // 5. 执行任意更新SQL
    @Update("${sql}")
    int executeUpdate(@Param("sql") String sql);

    // 6. 分页查询（配合Page对象使用）
    @Select("SELECT * FROM user WHERE deleted = 0")
    IPage<User> selectUserPage(IPage<User> page);
}