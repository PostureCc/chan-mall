package com.chan.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chan.bean.User;
import com.chan.dao.user.UserDao;
import com.chan.exception.ErrorCodes;
import com.chan.exception.ValidationException;
import com.chan.token.Token;
import com.chan.utils.redis.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service("userService")
public class UserServiceImpl implements UserService {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass().toString());

    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    @Autowired
    @Qualifier("redisService")
    private RedisService redisService;

    @Override
    public User login(User user) {
        if (Objects.isNull(user)) {
            throw new ValidationException(ErrorCodes.PARAMETERS_OF_THE_ABNORMAL);
        }
        try {
            User cacheToken = null;
            StringBuilder token = new StringBuilder(Token.USER_ID).append("_").append(user.getUserId());
            Object obj = redisService.get(token.toString());
            if (Objects.isNull(obj)) {
                cacheToken = userDao.login(user);
                if (Objects.isNull(cacheToken)) {
                    throw new ValidationException(ErrorCodes.USER_IS_NULL);
                } else {
                    redisService.set(token.toString(), cacheToken, RedisService.HALF_DAY);
                }
            } else {
                cacheToken = JSON.parseObject(JSONObject.toJSONString(obj), User.class);
            }
            return cacheToken;
        } catch (ValidationException e) {
            LOG.error(e.getMessage(), e);
            throw new ValidationException(e.getError());
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            throw new ValidationException(ErrorCodes.RESULT_SYS_ERR);
        }
    }

    @Override
    public List<User> search(User user) {
        return userDao.search(user);
    }

    @Override
    public int addInfo(User user) {
        return userDao.addInfo(user);
    }

    @Override
    public int updateInfo(User user) {
        return userDao.updateInfo(user);
    }

    @Override
    public int delInfo(Integer id) {
        return userDao.delInfo(id);
    }
}
