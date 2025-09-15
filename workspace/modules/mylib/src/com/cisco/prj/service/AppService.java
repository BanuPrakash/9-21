package com.cisco.prj.service;

import com.cisco.prj.repo.UserRepo;
import com.cisco.prj.util.DateUtil;
import java.util.logging.Logger;

public class AppService {
    Logger logger = Logger.getLogger("LoggerName");
    UserRepo userRepo = new UserRepo();
    public  void addUser() {
        logger.info("Add User!!!");
        System.out.println(DateUtil.getDate());
        userRepo.insertUser();
    }
}
