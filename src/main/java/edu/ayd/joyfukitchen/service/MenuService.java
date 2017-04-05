package edu.ayd.joyfukitchen.service;

import edu.ayd.joyfukitchen.util.JuheUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/4/1.
 */
@Service
@Transactional
public class MenuService {



    /**
     * 根据名字搜索菜谱
     * */
    public String searchMenuForName(String name){
        return JuheUtil.getRequest1(name);
    }
}
