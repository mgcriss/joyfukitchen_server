package edu.ayd.joyfukitchen.service;

import com.google.gson.Gson;
import edu.ayd.joyfukitchen.dao.AttenDao;
import edu.ayd.joyfukitchen.entity.Atten;
import edu.ayd.joyfukitchen.entity.Users;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 萝莉 on 2017/4/23.
 */
@Service
@Transactional
public class AttenService {

    @Resource
    private AttenDao attenDao;


   /* private static Gson gson = new Gson();*/


    /**
     * 根据元素名和用户名关注元素
     * @param attenName
     * @param userName
     */
    public Integer saveOneAtten(String attenName, String userName){
        return attenDao.saveOneAtten(attenName,userName);
    }

    /**
     *根据元素名取消关注 的元素
     * @param attenName
     * @return
     */
    public Integer deleteOneAtten(String attenName){
        return attenDao.deleteOneAtten(attenName);
    }


    /**
     * 查询关注的元素
     * @param userName
     * @return
     */
    public List<Atten> queryOneAtten(String userName){
       return attenDao.queryOneAtten(userName);
    }

    /**
     * 查询是否存在
     * @param attenName
     * @param userName
     * @return
     */
    public Integer queryAttenExistence(String attenName,String userName){
        return attenDao.queryAttenExistence(attenName,userName);
    }
}
