package com.chan.dao.user;

import com.chan.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface UserDao {

    User login(User user);

    List<User> search(User user);

    int addInfo(User user);

    int updateInfo(User user);

    int delInfo(@Param("id") Integer id);

}
