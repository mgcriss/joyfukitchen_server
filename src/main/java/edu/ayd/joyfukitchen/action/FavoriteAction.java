package edu.ayd.joyfukitchen.action;

import edu.ayd.joyfukitchen.entity.Favorite;
import edu.ayd.joyfukitchen.service.FavoriceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 萝莉 on 2017/4/24.
 */

@Controller
@RequestMapping("/recipe")
public class FavoriteAction {

    @Resource
    private FavoriceService favoriceService;

    /**
     * 添加一条喜欢的食谱的记录
     * @param favoriteId
     * @param userName
     * @return
     */
    @RequestMapping("/saveOneToFavorite")
    @ResponseBody
    public Integer saveOneFavorite(@RequestParam("favoriteId") Integer favoriteId,@RequestParam("userName") String userName){
        Integer judge=favoriceService.queryFavoriteExistence(favoriteId,userName);
        if(judge==1)
            return favoriceService.saveOneFavorite(favoriteId,userName);
        else
            return judge;
    }

    /**
     * 删除一条记录
     * @param favoriteId
     * @return
     */
    @GetMapping("/delectOneFavorite")
    @ResponseBody
    public Integer deleteOneFavorite(@RequestParam("favoriteId") Integer favoriteId){
        return favoriceService.deleteOneFavorite(favoriteId);
    }

    /**
     * 查询
     * @param userName
     * @return
     */
    @GetMapping("/queryOneFavorite")
    @ResponseBody
    public List<Favorite> queryOneFavorite(@RequestParam("userName") String userName){
        return favoriceService.queryOneFavorite(userName);
    }
}
