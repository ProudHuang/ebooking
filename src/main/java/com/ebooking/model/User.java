package com.ebooking.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.util.Date;

@Data
@TableName("user") // 指定表名，如果类名和表名一致可省略
public class User {
    @TableId(type = IdType.AUTO) // 主键自增
    private Long id;

    private String username;
    private String password;
    private String email;

    @TableField(fill = FieldFill.INSERT) // 插入时自动填充
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE) // 插入和更新时自动填充
    private Date updateTime;

    @Version // 乐观锁版本字段
    private Integer version;

    @TableLogic // 逻辑删除字段
    private Integer deleted;
}