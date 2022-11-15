package com.soundai.nat.institution.admin;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 启动程序
 *
 * @author soundai
 */
@EnableApolloConfig
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, MongoAutoConfiguration.class})
public class NatInstitutionAdminApplication {
    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application =
                SpringApplication.run(NatInstitutionAdminApplication.class, args);
        System.out.println("============================================= 三方接入后台API 启动成功！========================================");
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");
        System.out.println("\n----------------------------------------------------------\n" +
                "Application nat-institution-admin-api is running! Access URLs:\n" +
                "External: http://" + ip + ":" + port + path + "\n" +
                "----------------------------------------------------------");

    }
}
