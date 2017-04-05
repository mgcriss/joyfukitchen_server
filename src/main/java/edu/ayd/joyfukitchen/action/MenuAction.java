package edu.ayd.joyfukitchen.action;

import edu.ayd.joyfukitchen.entity.Result;
import edu.ayd.joyfukitchen.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by Administrator on 2017/4/1.
 */
@Controller
@RequestMapping("/menu")
public class MenuAction {

    @Resource
    private MenuService menuService;

    /**
     * 返回json格式的菜谱数据,没有数据返回null
     * @param times: 次数,分页用，从0开始计算,加载一次 +1.
     * */
    @GetMapping("/searchMenu")
    @ResponseBody
    public List<Result.ResultBean.DataBean> getMenuForName_Get(@RequestParam("menuName") String name, @RequestParam("times") Integer times){
        String menuName = null;
        menuService.setStart(menuService.getStart()+(menuService.getStepSize()*times));
        try {
            menuName = new String(name.getBytes("iso-8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        List<Result.ResultBean.DataBean> dataBeans = menuService.searchMenuForName(menuName, times);
        return dataBeans;
    }
    @PostMapping("/searchMenu")
    @ResponseBody
    public List<Result.ResultBean.DataBean> getMenuForName_Post(@RequestParam("menuName") String name, @RequestParam("times") Integer times){
        return menuService.searchMenuForName(name, times);
    }

}
