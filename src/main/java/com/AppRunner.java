package com;

import com.service.IAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class AppRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    @Resource
    private IAdminService adminService;

    @Override
    public void run(String... args) throws Exception {
        logger.info(".... Fetching books");
        logger.info("isbn-1234 -->" + adminService.addAdmin(1));
        logger.info("isbn-4567 -->" + adminService.addAdmin(2));
        logger.info("isbn-1234 -->" + adminService.addAdmin(3));
        logger.info("isbn-4567 -->" + adminService.addAdmin(3));
        logger.info("isbn-1234 -->" + adminService.addAdmin(1));
        logger.info("isbn-1234 -->" + adminService.addAdmin(2));
    }
}
