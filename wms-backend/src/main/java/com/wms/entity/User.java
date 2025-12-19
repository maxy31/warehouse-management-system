package com.wms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author maxy31
 * @since 2025-12-12
 */
@Getter
@Setter
@ToString
@TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * user account
     */
    @TableField("no")
    private String no;

    /**
     * user name
     */
    @TableField("name")
    private String name;

    /**
     * user password
     */
    @TableField("password")
    private String password;

    @TableField("age")
    private Integer age;

    /**
     * user sexual 0=female, 1=male
     */
    @TableField("sex")
    private Integer sex;

    /**
     * user phone number
     */
    @TableField("phone")
    private String phone;

    /**
     * 0=Superadmin 1=admin 2=normal
     */
    @TableField("role_id")
    private Integer roleId;

    /**
     * Y=valid <others>=notValid
     */
    @TableField("isValid")
    private String isValid;
}
