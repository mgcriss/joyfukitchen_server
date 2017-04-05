package edu.ayd.joyfukitchen.action;

import edu.ayd.joyfukitchen.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/4/1.
 */
@Controller
@RequestMapping("/menu")
public class MenuAction {

    @Resource
    private MenuService menuService;

    /**
     * 返回json格式的菜谱数据
     * */
    @RequestMapping("/searchMenu")
    @ResponseBody
    public String getMenuForName(@RequestParam("menuName") String name){
        return menuService.searchMenuForName("番茄");
    }

}
