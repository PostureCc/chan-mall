package com.chan;

import com.alibaba.fastjson.JSONObject;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MallProviderApplicationTests {

    public static void main(String[] args){
        String str = "User(id=1, userId=admin, userName=admin, userPwd=admin, email=admin@chan.com, phone=123, sex=1, image=1234, birthday=Fri Jan 04 17:24:22 CST 2019, crtTime=Fri Jan 04 17:24:23 CST 2019, updateTime=Sun Jan 06 16:36:01 CST 2019, state=1)";
        System.err.println(JSONObject.toJSONString(str));
    }

}

