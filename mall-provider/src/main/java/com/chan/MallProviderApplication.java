package com.chan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableCaching //开启缓存
@EnableTransactionManagement // 开启事务管理
@SpringBootApplication
public class MallProviderApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MallProviderApplication.class);
    }


//    CyclicBarrier
    //强一致性:当数据库的值发生更改时 可以异步一个任务去更新缓存
    //弱一致性:可以使用定时任务定时去刷新
    //分区锁 例如多个用户 可以将用户类别进行细分 例如性别 例如开V有单独的标识再用ConcurrentHashMap对线程进行存储
    public static void main(String[] args) {
        SpringApplication.run(MallProviderApplication.class, args);
        System.err.println("Hello Provider...");
    }

}

