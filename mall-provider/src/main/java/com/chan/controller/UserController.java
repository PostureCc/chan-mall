package com.chan.controller;

import com.alibaba.fastjson.JSON;
import com.chan.response.ResultBean;
import com.chan.service.UserService;
import com.chan.bean.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @ApiOperation(value = "测试接口")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "test";
    }

    /*
        将数据库的数据导入到redis中:
        mysql -utest -ptest stress --default-character-set=utf8 --skip-column-names --raw < order.sql
        redis-cli -h 192.168.42.111 -p 6379 -a 12345678  --pipe
    */
    @ApiOperation(value = "用户登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    @ApiImplicitParam(name = "token", value = "授权令牌", required = true, dataType = "String", paramType = "header")
    public ResultBean login(@RequestBody User user) {
        return userService.login(user);
    }

//    @ApiOperation(value = "用户退出登录")
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    @ApiImplicitParam(name = "token", value = "授权令牌", required = true, dataType = "String", paramType = "header")
//    public ResultBean logout() {
//        return userService.logout();
//    }

    @ApiOperation(value = "查找用户")
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ApiImplicitParam(name = "token", value = "授权令牌", required = true, dataType = "String", paramType = "header")
    public ResultBean search(@RequestBody User user) {
        return userService.search(user);
    }

    @ApiOperation(value = "添加新用户")
    @RequestMapping(value = "/addInfo", method = RequestMethod.POST)
    @ApiImplicitParam(name = "token", value = "授权令牌", required = true, dataType = "String", paramType = "header")
    public ResultBean addInfo(@RequestBody User user) {
        return userService.addInfo(user);
    }

    @ApiOperation(value = "修改用户信息")
    @RequestMapping(value = "/updateInfo", method = RequestMethod.POST)
    @ApiImplicitParam(name = "token", value = "授权令牌", required = true, dataType = "String", paramType = "header")
    public ResultBean updateInfo(@RequestBody User user) {
        return userService.updateInfo(user);
    }

    @ApiOperation(value = "删除用户")
    @RequestMapping(value = "/delInfo", method = RequestMethod.POST)
    @ApiImplicitParam(name = "token", value = "授权令牌", required = true, dataType = "String", paramType = "header")
    public ResultBean delInfo(Integer id) {
        return userService.delInfo(id);
    }

}
