package com.zhirui.lmwy.wms.demo.web.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.apache.ibatis.annotations.Insert;

import javax.validation.constraints.*;

/** 为了测试 BeanCopy，UserDto 比 User类 多了个String addr; mobile 类型 变成了 int */

@Data
@Builder
@ApiModel
public class UserDto {

    public UserDto(Long uid, @NotBlank(message = "姓名不能为空") String username, @NotBlank(groups = Insert.class, message = "密码不能获取") int age) {
        this.uid = uid;
        this.username = username;
        this.age = age;
    }

    public UserDto(Long uid, @NotBlank(message = "姓名不能为空") String username, @NotBlank(groups = Insert.class, message = "密码不能获取") String password, String sex, @Max(value = 200, message = "年龄不能超过 " + 200) @PositiveOrZero(message = "年龄必须大于等于0") Integer age, @Future(message = "时间必须是将来时间") String createTime, String remark, @NotBlank(message = "手机号不能为空") @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号格式有误") int mobile,
                   @NotBlank(message = "联系邮箱不能为空") @Email(message = "邮箱格式不对") String email, String addr) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.createTime = createTime;
        this.remark = remark;
        this.mobile = mobile;
        this.email = email;
        this.addr = addr;
    }

    @TableId
    @ApiModelProperty(value = "用户id", required = true)
    private Long uid;

    @NotBlank(message = "姓名不能为空")
    @ApiModelProperty(value = "姓名", notes = "不能为空", required = true)
    private String username;

    @NotBlank(groups = Insert.class, message = "密码不能获取")
    @ApiModelProperty(value = "密码", required = true)
    private String password;

    @TableField(exist = false)
    private String sex;

    @Max(value = 200, message = "年龄不能超过 " + 200)
    @PositiveOrZero(message = "年龄必须大于等于0")
    private Integer age;

    @Future(message = "时间必须是将来时间")
    private String createTime;

    @TableField(exist = false) //数据库如果没该字段，通过exist = false设置，否则会报错
    private String remark;

    /** 手机号*/
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号格式有误")
    @TableField(exist = false)
    private int mobile;

    /** 邮箱*/
    @NotBlank(message = "联系邮箱不能为空")
    @Email(message = "邮箱格式不对")
    @TableField(exist = false)
    private String email;

    private String addr;

    public UserDto() {

    }
}
