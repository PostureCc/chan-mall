package com.chan.service;


import com.chan.bean.User;

import java.util.List;

public interface UserService {

    User login(User user);

    List<User> search(User user);

    int addInfo(User user);

    int updateInfo(User user);

    int delInfo(Integer id);

}
