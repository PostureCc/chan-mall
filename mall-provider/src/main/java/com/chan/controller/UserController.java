package com.chan.controller;

import com.chan.response.BaseService;
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
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController extends BaseService {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    /*
        将数据库的数据导入到redis中:
        mysql -utest -ptest stress --default-character-set=utf8 --skip-column-names --raw < order.sql
        redis-cli -h 192.168.42.111 -p 6379 -a 12345678  --pipe
    */
    @ApiOperation(value = "用户登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiImplicitParam(name = "token", value = "授权令牌", required = true, dataType = "String", paramType = "header")
    public ResultBean login(@RequestBody User user) {
        return super.successSingleResult(userService.login(user));
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ResultBean search(@RequestBody User user) {
        return super.successSingleResult(userService.search(user));
    }

    @RequestMapping(value = "/addInfo", method = RequestMethod.POST)
    public ResultBean addInfo(@RequestBody User user) {
        return super.successSingleResult(userService.addInfo(user));
    }

    @RequestMapping(value = "/updateInfo", method = RequestMethod.POST)
    public ResultBean updateInfo(@RequestBody User user) {
        return super.successSingleResult(userService.updateInfo(user));
    }

    @RequestMapping(value = "/delInfo", method = RequestMethod.POST)
    public ResultBean delInfo(Integer id) {
        return super.successSingleResult(userService.delInfo(id));
    }

}
