package edu.ayd.joyfukitchen.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import edu.ayd.joyfukitchen.dao.UsersDao;
import edu.ayd.joyfukitchen.entity.Atten;
import edu.ayd.joyfukitchen.entity.Users;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.swing.text.html.parser.Entity;
import java.io.StringReader;

/**
 * Created by 萝莉 on 2017/4/21.
 */
@Service
@Transactional
public class UserService {

    @Resource
    private UsersDao usersDao;

    /**
     * json解析
     * @param user
     * @return
     */
    public Users StringToObject(String user){
        Gson gson = new Gson();
        Users users = gson.fromJson(user, new TypeToken<Users>() {}.getType());
        return users;
    }

     /**插入一个用户
     * @param user
     * @return
     */
    public Integer saveOneUser(Users user){
        return usersDao.saveOneUser(user);
    }

    /**
     * 根据用户名查询一个用户
     * @param username
     * @return
     */
    public Integer findOneUser(String username){
        return usersDao.findOneUser(username);
    }


    /**
     * 根据用户名获取一个用户
     * @param username
     * @return
     */
    public Users getOneUser(String username,String password){
        return usersDao.getOneUser(username,password);
    }


    /**
     * 更新一个用户
     * @param users
     * @return
     */
    public Integer updateUserData(Users users){
        return usersDao.updateUserData(users);
    }


}
