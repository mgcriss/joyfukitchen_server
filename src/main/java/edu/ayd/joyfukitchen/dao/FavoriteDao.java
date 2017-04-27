package edu.ayd.joyfukitchen.dao;

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
public class FavoriteDao {
    @Resource
    SessionFactory sessionFactory;

    /**
     * 插入喜欢的食谱
     * @param favoriteId
     * @param userName
     * @return
     */
    public Integer saveOneFavorite(Integer favoriteId,String userName){
        Users users=(Users) sessionFactory.getCurrentSession().createQuery("from Users where username =?")
                .setString(0,userName).uniqueResult();

        Favorite favorite=new Favorite();
        favorite.setFavoriteRecipes(favoriteId);
        favorite.setUsersID(users.getuId());

        return (Integer)sessionFactory.getCurrentSession().save(favorite);
    }

    /**
     * 查询是否存在
     * @param favoriteId
     * @param userName
     * @return
     */
    public Integer queryFavoriteExistence(Integer favoriteId,String userName){
        Users users=(Users)sessionFactory.getCurrentSession().createQuery("from Users where username =?")
                .setString(0,userName).uniqueResult();
        Favorite favorite=(Favorite)sessionFactory.getCurrentSession().createQuery("from Favorite where favoriteRecipes=? and usersID=?")
                .setInteger(0,favoriteId).setInteger(1,users.getuId()).uniqueResult();
        if(favorite!=null)
            return 0;
        else
            return 1;
    }

    /**
     * 删除一条喜欢的食谱
     * @param favoriteId
     * @return
     */
    public Integer deleteOneFavorite(Integer favoriteId){

        try {
            Favorite favorite=(Favorite)sessionFactory.getCurrentSession().createQuery("from Favorite where favoriteRecipes =?")
                    .setInteger(0,favoriteId).uniqueResult();
            sessionFactory.getCurrentSession().delete(favorite);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }


    /**
     * 查询
     * @param userName
     * @return
     */
    public List<Favorite> queryOneFavorite(String userName){
        List<Favorite> list=new ArrayList<Favorite>();
        Users users=(Users)sessionFactory.getCurrentSession().createQuery("from Users where username=?")
                .setString(0,userName).uniqueResult();
        list= sessionFactory.getCurrentSession().createQuery("from Favorite where usersID = ?")
                .setInteger(0,users.getuId()).list();

        return list;
    }
}
