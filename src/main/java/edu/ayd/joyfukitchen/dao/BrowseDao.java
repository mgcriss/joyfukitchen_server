package edu.ayd.joyfukitchen.dao;

import edu.ayd.joyfukitchen.entity.Atten;
import edu.ayd.joyfukitchen.entity.Browse;
import edu.ayd.joyfukitchen.entity.Favorite;
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
public class BrowseDao {
    @Resource
    SessionFactory sessionFactory;

    /**
     * 插入一条浏览过的食谱
     * @param browseId
     * @param userName
     * @return
     */
    public Integer saveOneBrowse(Integer browseId,String userName){
        Users users=(Users) sessionFactory.getCurrentSession().createQuery("from Users where username =?")
                .setString(0,userName).uniqueResult();

        Browse browse=new Browse();
        browse.setBrowseRecipes(browseId);
        browse.setUsersID(users.getuId());

        return (Integer)sessionFactory.getCurrentSession().save(browse);
    }

    /**
     * 查询是否存在
     * @param browseId
     * @param userName
     * @return
     */
    public Integer queryBrowseExistence(Integer browseId,String userName){
        Users users=(Users)sessionFactory.getCurrentSession().createQuery("from Users where username =?")
                .setString(0,userName).uniqueResult();
        Browse browse=(Browse)sessionFactory.getCurrentSession().createQuery("from Browse where browseRecipes=? and usersID=?")
                .setInteger(0,browseId).setInteger(1,users.getuId()).uniqueResult();
        if(browse!=null)
            return 0;
        else
            return 1;
    }

    /**
     * 查询
     * @param userName
     * @return
     */
    public List<Browse> queryOneBrowse(String userName){
        List<Browse> list=new ArrayList<Browse>();
        Users users=(Users)sessionFactory.getCurrentSession().createQuery("from Users where username =?")
                .setString(0,userName).uniqueResult();
        list= sessionFactory.getCurrentSession().createQuery("from Browse where usersID = ?")
                .setInteger(0,users.getuId()).list();

        return list;
    }

    /**
     * 删除浏览过的食谱
     * @param browseId
     * @return
     */
    public Integer deleteOneBrowse(Integer browseId){

        try {
            Browse browse=(Browse)sessionFactory.getCurrentSession().createQuery("from Browse where browseRecipes =?")
                    .setInteger(0,browseId).uniqueResult();
            sessionFactory.getCurrentSession().delete(browse);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
