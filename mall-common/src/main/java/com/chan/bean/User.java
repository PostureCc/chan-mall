package com.chan.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

@Data
public class User extends BaseBean {

    private Integer id;
    @ApiModelProperty(value = "userId", required = true)
    private String userId;
    private String userName;
    @ApiModelProperty(value = "userPwd", required = true)
    private String userPwd;
    private String email;
    private String phone;
    private Integer sex;
    private String image;
    private Date birthday;
    private Date crtTime;
    private Date updateTime;
    private Integer state;


}
