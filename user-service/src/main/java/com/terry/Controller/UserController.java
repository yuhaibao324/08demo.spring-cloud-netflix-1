package com.terry.Controller;

import com.terry.Bean.BaseResponse;
import com.terry.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/***
 * *
 * 名称：     LoginController
 * 作者：     Terry
 * 创建时间：  on 2018/1/30.
 * 说明：     
 * *
 ***/

@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService loginService;

    @PostMapping("/login")
    BaseResponse login(@RequestParam String name,
                       @RequestParam String pwd) {
        System.out.println("username is:"+name);
        logger.info("Login: name="+name+"; password="+pwd);
        return loginService.signOrLogin(name, pwd);
    }

    @GetMapping("/user/info")
    BaseResponse getUser(@RequestHeader String token) {

        logger.info("Login: token ======>" + token);

        return loginService.getUserInfo(token);
    }

    @GetMapping("/user/all")
    BaseResponse getUserList(@RequestHeader String token) {
        return loginService.getUserList(token);
    }

}
