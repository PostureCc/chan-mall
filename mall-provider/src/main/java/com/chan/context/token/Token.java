package com.chan.context.token;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Data
@Builder
@ApiModel(description = "UserTokenInfo")
public class Token {

    @ApiModelProperty(value = "用户编号")
    private String userId;

    @ApiModelProperty(value = "用户名称")
    private String userName;

    @ApiModelProperty(value = "用户邮箱")
    private String email;

    @ApiModelProperty(value = "用户手机")
    private String phone;

    @ApiModelProperty(value = "用户状态")
    private Integer state;

    @ApiModelProperty(value = "用户生日")
    private Date birthday;

}
