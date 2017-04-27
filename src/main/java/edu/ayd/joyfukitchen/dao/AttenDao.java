package edu.ayd.joyfukitchen.dao;
import edu.ayd.joyfukitchen.entity.Atten;
import edu.ayd.joyfukitchen.entity.Users;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 萝莉 on 2017/4/20.
 */
@Repository
public class AttenDao {
    @Resource
    SessionFactory sessionFactory;

    /**
     * 插入一条关注元素信息
     * @param attenName
     * @param userName
     * @return
     */
    public Integer saveOneAtten(String attenName,String userName){
        Users users=(Users)sessionFactory.getCurrentSession().createQuery("from Users where username =?")
                .setString(0,userName).uniqueResult();
        Atten atten=new Atten();
        atten.setAttenElement(attenName);
        atten.setUsersID(users.getuId());

        return (Integer)sessionFactory.getCurrentSession().save(atten);

    }

    /**
     * 查询是否存在
     * @param attenName
     * @param userName
     * @return
     */
    public Integer queryAttenExistence(String attenName,String userName){
        Users users=(Users)sessionFactory.getCurrentSession().createQuery("from Users where username =?")
                .setString(0,userName).uniqueResult();
        Atten atten=(Atten)sessionFactory.getCurrentSession().createQuery("from Atten where attenElement=? and usersID=?")
                .setString(0,attenName).setInteger(1,users.getuId()).uniqueResult();
        if(atten!=null)
            return 0;
        else
            return 1;
    }

    /**
     * 查询关注的元素
     * @param userName
     * @return
     */
    public List<Atten> queryOneAtten(String userName){
        List<Atten> list=new ArrayList<Atten>();
        Users users=(Users)sessionFactory.getCurrentSession().createQuery("from Users where username =?")
                .setString(0,userName).uniqueResult();
        list= sessionFactory.getCurrentSession().createQuery("from Atten where usersID = ?")
                .setInteger(0,users.getuId()).list();

        return list;
    }

    /**
     * 取消关注元素
     * @param attenName
     * @return
     */
    public Integer deleteOneAtten(String attenName){
        try {
            Atten atten = (Atten) sessionFactory.getCurrentSession().createQuery("from Atten where attenElement =?")
                    .setParameter(0, attenName).uniqueResult();
            sessionFactory.getCurrentSession().delete(atten);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
