package edu.ayd.joyfukitchen.action;

import edu.ayd.joyfukitchen.entity.Atten;
import edu.ayd.joyfukitchen.service.AttenService;
import net.sf.json.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by 萝莉 on 2017/4/23.
 */
@Controller
@RequestMapping("/recipe")
public class AttenAction {

    @Resource
    private AttenService attenService;

    /**
     * 添加一条关注元素的记录
     * @param attenName
     * @param userName
     * @return 非0表示成功
     */
    @RequestMapping("/saveOneToAtten")
    @ResponseBody
    public Integer saveOneAtten(@RequestParam("attenName") String attenName,@RequestParam("userName") String userName){
        Integer judge=attenService.queryAttenExistence(attenName,userName);
        if(judge==1)
            return attenService.saveOneAtten(attenName,userName);
        else
            return judge;
    }

    /**
     * 查询
     * @param userName
     * @return
     */
    @GetMapping("/queryOneAtten")
    @ResponseBody
    public List<Atten> queryOneAtten(@RequestParam("userName") String userName){
        return attenService.queryOneAtten(userName);
    }


    /**
     * 删除一条关注元素的记录
     * @param attenName
     * @return
     */
    @GetMapping("/delectOneAtten")
    @ResponseBody
    public Integer deleteOneAtten(@RequestParam("attenName") String attenName){
        return attenService.deleteOneAtten(attenName);
    }

}
