package com.ebooking.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ebooking.mapper.UserMapper;
import com.ebooking.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl {

    @Autowired
    private UserMapper userMapper;

    // 基础CRUD方法
    public User getById(Long id) {
        return userMapper.selectById(id);
    }


    public boolean save(User user) {
        if (user.getId() == null) {
            return userMapper.insert(user) > 0;
        }
        return userMapper.updateById(user) > 0;
    }


    public boolean delete(Long id) {
        return userMapper.deleteById(id) > 0;
    }

    // 自定义查询方法
    public User getByUsername(String username) {
        return userMapper.selectByUsername(username);
    }


    public List<User> listByCondition(User condition) {
        return userMapper.selectByCondition(condition);
    }

    // 分页查询

    public IPage<User> pageList(int pageNum, int pageSize) {
        Page<User> page = new Page<>(pageNum, pageSize);
        return userMapper.selectUserPage(page);
    }

    // 执行原生SQL

    public List<Map<String, Object>> executeQuery(String sql) {
        return userMapper.executeQuery(sql);
    }


    public int executeUpdate(String sql) {
        return userMapper.executeUpdate(sql);
    }

    // 复杂业务方法示例
    public boolean resetPassword(Long userId, String newPassword) {
        String sql = String.format("UPDATE user SET password = '%s' WHERE id = %d", newPassword, userId);
        return userMapper.executeUpdate(sql) > 0;
    }
}