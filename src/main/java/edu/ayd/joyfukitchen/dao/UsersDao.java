package edu.ayd.joyfukitchen.dao;

import edu.ayd.joyfukitchen.entity.Atten;
import edu.ayd.joyfukitchen.entity.Browse;
import edu.ayd.joyfukitchen.entity.Favorite;
import edu.ayd.joyfukitchen.entity.Users;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by 萝莉 on 2017/4/20.
 */
@Repository
public class UsersDao {
    @Resource
    SessionFactory sessionFactory;

    /**
     * 添加用户
     * @param users
     * @return
     */
    public Integer saveOneUser(Users users){
        return  (Integer)sessionFactory.getCurrentSession().save(users);
    }

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    public Integer findOneUser(String username){
        Users users = (Users)sessionFactory.getCurrentSession().createQuery("from Users where username =?")
                .setString(0,username).uniqueResult();
       /* System.out.println(users.toString()+"-----------------");*/
        if(users!=null)
            return 0;
        else
            return 1;
    }

    /**
     * 查询用户
     * @param username
     * @return
     */
    public Users getOneUser(String username,String password){
        Users users=(Users)sessionFactory.getCurrentSession().createQuery("from Users where username =? and password =?")
                .setString(0,username)
                .setString(1,password)
                .uniqueResult();
        List<Atten> atten=sessionFactory.getCurrentSession().createQuery("from Atten where usersID =?")
                .setInteger(0,users.getuId()).list();
        List<Browse> browse=sessionFactory.getCurrentSession().createQuery("from Browse where usersID =?")
                .setInteger(0,users.getuId()).list();
        List<Favorite> favorite=sessionFactory.getCurrentSession().createQuery("from Favorite where usersID =?")
                .setInteger(0,users.getuId()).list();

        users.setAttens(atten);
        users.setBrowses(browse);
        users.setFavorites(favorite);

        return  users;
    }


    /**
     * 更新
     * @param users
     * @return
     */
    public Integer updateUserData(Users users){
        try {
            sessionFactory.getCurrentSession().update(users);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }


}
