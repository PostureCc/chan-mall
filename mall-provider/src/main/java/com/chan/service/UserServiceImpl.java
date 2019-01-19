package com.chan.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chan.bean.User;
import com.chan.context.Constants;
import com.chan.context.UserInfo;
import com.chan.dao.user.UserDao;
import com.chan.exception.ErrorCodes;
import com.chan.exception.ValidationException;
import com.chan.response.BaseService;
import com.chan.response.ResultBean;
import com.chan.utils.redis.RedisService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service("userService")
public class UserServiceImpl extends BaseService implements UserService {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass().toString());

    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    @Autowired
    @Qualifier("redisService")
    private RedisService redisService;

    @Autowired
    private UserInfo userInfo;

    @Override
    public ResultBean login(User user) {
        if (StringUtils.isBlank(user.getUserId()) || StringUtils.isBlank(user.getUserPwd())) {
            return super.errorResult(ErrorCodes.PARAMETERS_OF_THE_ABNORMAL);
        }
        try {
            User cacheToken = null;
            StringBuilder token = new StringBuilder(Constants.USER_ID).append("_").append(user.getUserId());
            Object obj = redisService.get(token.toString());
            if (Objects.isNull(obj)) {
                cacheToken = userDao.login(user);
                if (Objects.isNull(cacheToken)) {
                    return super.errorResult(ErrorCodes.USER_IS_NULL);
                } else {
                    redisService.set(token.toString(), cacheToken, RedisService.HALF_DAY);
                }
            } else {
                cacheToken = JSON.parseObject(JSONObject.toJSONString(obj), User.class);
            }
            return super.successSingleResult(cacheToken);
        } catch (ValidationException e) {
            LOG.error(e.getMessage(), e);
            return super.errorResult(e.getError());
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return super.errorResult(ErrorCodes.RESULT_SYS_ERR);
        }
    }

//    @Override
//    public ResultBean logout() {
//        StringBuilder token = new StringBuilder(Constants.USER_ID).append("_").append(user.getUserId());
//        return null;
//    }

    @Override
    public ResultBean search(User user) {
        return super.successSingleResult(userDao.search(user));
    }

    @Override
    public ResultBean addInfo(User user) {
        return super.successSingleResult(userDao.addInfo(user));
    }

    @Override
    public ResultBean updateInfo(User user) {
        return super.successSingleResult(userDao.updateInfo(user));
    }

    @Override
    public ResultBean delInfo(Integer id) {
        return super.successSingleResult(userDao.delInfo(id));
    }
}
