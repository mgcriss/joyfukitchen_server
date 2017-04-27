package edu.ayd.joyfukitchen.action;

import com.google.gson.Gson;
import com.mysql.jdbc.log.Log;
import edu.ayd.joyfukitchen.entity.Users;
import edu.ayd.joyfukitchen.service.UserService;
import edu.ayd.joyfukitchen.util.SendEmail;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

/**
 * Created by 萝莉 on 2017/4/24.
 */

@Controller
@RequestMapping("/recipe")
public class UsersAction {

    @Resource
    private UserService userService;
    private Users users;
    private String userName;
    private String identifyingCode;

/*
    private Integer judge;
*/

    /**
     * 登陆
     * @param userName
     * @return 返回一个对象
     */
    @GetMapping("/findOneUsers")
    @ResponseBody
    public Users findOneUsers(@RequestParam("userName") String userName,@RequestParam("password") String password){
        return userService.getOneUser(userName,password);
    }

    /**
     * 判断用户是否存在
     * @param user
     * @return 1 不存在，0 存在
     */
    @GetMapping("/queryOneUser")
    @ResponseBody
    public Integer queryOneUser(@RequestParam("user") String user,@RequestParam("password") String password){
        users=userService.StringToObject(user);
        users.setPassword(password);
        userName=users.getUsername();
        //System.out.println(user);
       // System.out.println(users.toString());
        return userService.findOneUser(userName);
    }

    /**
     * 发送验证码
     * @return 1 成功，0 失败
     */
    @RequestMapping("/sendVerificationCode")
    @ResponseBody
    public Integer sendVerificationCode(){
        SendEmail instance = SendEmail.getInstance();
        identifyingCode=instance.send(userName);
       // System.out.println(userName+"================================");
       // System.out.println(identifyingCode);
        if(!identifyingCode.equals("0"))
            return 1;
        else
            return 0;
    }

    /**
     * 检验验证码
     * @param Verification
     * @return 非0表示成功
     */
    @GetMapping("/judgmentVerificationCode")
    @ResponseBody
    public Integer judgmentVerificationCode(@RequestParam("Verification") String Verification){
       // System.out.println(identifyingCode);
       // System.out.println(Verification);
        if (identifyingCode.equals(Verification))
            return userService.saveOneUser(users);
        else
            return 0;
    }

    /**
     * 更新
     * @param user
     * @return 1表示成功，0表示失败
     */
    @GetMapping("/updateUserData")
    @ResponseBody
    public Integer updateUserData(@RequestParam("users") String user){
        users=userService.StringToObject(user);
        //System.out.println(users);
        return userService.updateUserData(users);

    }


}

