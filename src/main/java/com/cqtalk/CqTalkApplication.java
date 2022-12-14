package com.cqtalk;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@Slf4j
@SpringBootApplication
@ServletComponentScan("com.cqtalk.dao")
public class CqTalkApplication {

    public static void main(String[] args) {
        SpringApplication.run(CqTalkApplication.class, args);
        log.info("项目启动成功");
    }

}
