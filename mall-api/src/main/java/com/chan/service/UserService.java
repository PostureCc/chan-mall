package com.chan.service;

import com.chan.bean.User;
import com.chan.response.ResultBean;

public interface UserService {

    ResultBean login(User user);

//    ResultBean logout();

    ResultBean search(User user);

    ResultBean addInfo(User user);

    ResultBean updateInfo(User user);

    ResultBean delInfo(Integer id);

}
