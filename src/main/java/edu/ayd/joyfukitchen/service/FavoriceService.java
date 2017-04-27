package edu.ayd.joyfukitchen.service;

import com.google.gson.Gson;
import edu.ayd.joyfukitchen.dao.FavoriteDao;
import edu.ayd.joyfukitchen.entity.Favorite;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 萝莉 on 2017/4/23.
 */
@Service
@Transactional
public class FavoriceService {
    @Resource
    private FavoriteDao favoriteDao;

    private static Gson gson = new Gson();

    /**
     * 插入喜欢的食谱
     * @param favoriteId
     * @param userName
     * @return
     */
    public Integer saveOneFavorite(Integer favoriteId,String userName){
        return  favoriteDao.saveOneFavorite(favoriteId,userName);

    }

    /**
     * 查询是否存在
     * @param favoriteId
     * @param userName
     * @return
     */
    public Integer queryFavoriteExistence(Integer favoriteId,String userName){
        return favoriteDao.queryFavoriteExistence(favoriteId,userName);
    }

    /**
     * 删除一条喜欢的食谱
     * @param favoriteId
     * @return
     */
    public Integer deleteOneFavorite(Integer favoriteId){
        return favoriteDao.deleteOneFavorite(favoriteId);
    }

    /**
     * 查询关注的元素
     * @param userName
     * @return
     */
    public List<Favorite> queryOneFavorite(String userName){
        return favoriteDao.queryOneFavorite(userName);
    }
}
