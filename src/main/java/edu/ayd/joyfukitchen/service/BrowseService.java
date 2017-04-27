package edu.ayd.joyfukitchen.service;

import com.google.gson.Gson;
import edu.ayd.joyfukitchen.dao.BrowseDao;
import edu.ayd.joyfukitchen.entity.Browse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 萝莉 on 2017/4/23.
 */
@Service
@Transactional
public class BrowseService {

    @Resource
    private BrowseDao browseDao;

    private static Gson gson = new Gson();

    /**
     * 插入一条浏览过的食谱
     * @param browseId
     * @param userName
     * @return
     */
    public Integer saveOneBrowse(Integer browseId,String userName){
        return browseDao.saveOneBrowse(browseId,userName);
    }

    /**
     * 查询是否存在
     * @param browseId
     * @param userName
     * @return
     */
    public Integer queryBrowseExistence(Integer browseId,String userName){
        return browseDao.queryBrowseExistence(browseId,userName);
    }

    /**
     * 根据删除浏览过的食谱
     * @param browseId
     * @return
     */
    public Integer deleteOneBrowse(Integer browseId){
        return browseDao.deleteOneBrowse(browseId);
    }

    /**
     * 查询关注的元素
     * @param userName
     * @return
     */
    public List<Browse> queryOneBrowse(String userName){
        return browseDao.queryOneBrowse(userName);
    }
}
