package edu.ayd.joyfukitchen.service;

import edu.ayd.joyfukitchen.util.JuheUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/4/1.
 */
@Service
@Transactional
public class MenuService {


    @Resource
    private JuheUtil juheUtil;

    /**
     * 根据名字搜索菜谱
     * */
    public String searchMenuForName(String name){
        return juheUtil.getRequest1(name);
    }
}
