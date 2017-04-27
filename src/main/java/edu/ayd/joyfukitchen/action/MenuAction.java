package edu.ayd.joyfukitchen.action;

import edu.ayd.joyfukitchen.entity.RecipeType;
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
@RequestMapping("/recipe")
public class MenuAction {

    @Resource
    private MenuService menuService;

    /**
     * 返回json格式的菜谱数据,没有数据返回null
     * @param times: 次数,分页用，从0开始计算,加载一次 +1.
     * */
    @GetMapping("/searchRecipeFromName")
    @ResponseBody
    public List<Result.ResultBean.DataBean> getMenuForName_Get(@RequestParam("recipeName") String name, @RequestParam("times") Integer times){
        /*String menuName = null;*/
        menuService.setStart(menuService.getStart()+(menuService.getStepSize()*times));
      /* try {
            menuName = new String(name.getBytes("iso-8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/
        List<Result.ResultBean.DataBean> dataBeans = menuService.searchMenuForName(name, times);
        return dataBeans;
    }

    @PostMapping("/searchRecipeFromName")
    @ResponseBody
    public List<Result.ResultBean.DataBean> getMenuForName_Post(@RequestParam("recipeName") String name, @RequestParam("times") Integer times){
        return menuService.searchMenuForName(name, times);
    }


    /**
     * 返回所有的标签
     * @param name:标签名。为Null则返回所有标签
     * */
    @ResponseBody
    @GetMapping("/searchTags")
    public List<RecipeType> getAllTags_Get(@RequestParam("recipeTypeName") String name){
        String typeName = null;
        try {
            typeName = new String(name.getBytes("iso-8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return menuService.getAllRecipeType(typeName);
    }
    @ResponseBody
    @PostMapping("/searchTags")
    public List<RecipeType> getAllTags_Post(@RequestParam("recipeTypeName") String name){
        return menuService.getAllRecipeType(name);
    }

    /**
     * 根据标签id查询菜谱
     * @param tagId : 标签id
     *          times : 请求的次数
     * */
    @ResponseBody
    @GetMapping("/searchRecipeFromTagId")
    public List<Result.ResultBean.DataBean> getMenuForTag_Get(@RequestParam("recipeTypeId") String tagId, @RequestParam("times") Integer times){
        String tag = null;
        menuService.setStart(menuService.getStart()+(menuService.getStepSize()*times));
        try {
            tag = new String(tagId.getBytes("iso-8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        List<Result.ResultBean.DataBean> dataBeans = menuService.searchMenuForTagId(tag, times);
        return dataBeans;
    }
    @ResponseBody
    @PostMapping("/searchRecipeFromTagId")
    public List<Result.ResultBean.DataBean> getMenuForTag_Post(@RequestParam("recipeTypeId") String tagId, @RequestParam("times") Integer times){
        menuService.setStart(menuService.getStart()+(menuService.getStepSize()*times));
        List<Result.ResultBean.DataBean> dataBeans = menuService.searchMenuForTagId(tagId, times);
        return dataBeans;
    }

    /*
     * 根据id查询菜谱详细信息
     *
     * */
    @ResponseBody
    @GetMapping("/searchRecipeFromRecipeId")
    public Result.ResultBean.DataBean getMenuForId_Get(@RequestParam("recipeId") String id){
//        try {
//            id = new String(id.getBytes("iso-8859-1"),"UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        return menuService.searchMenuForId(id);
    }
    @ResponseBody
    @PostMapping("/searchRecipeFromRecipeId")
    public Result.ResultBean.DataBean getMenuForId_Post(@RequestParam("recipeId") String id){
        return menuService.searchMenuForId(id);
    }


}
