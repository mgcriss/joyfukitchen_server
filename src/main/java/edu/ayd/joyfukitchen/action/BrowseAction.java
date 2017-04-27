package edu.ayd.joyfukitchen.action;

import edu.ayd.joyfukitchen.entity.Browse;
import edu.ayd.joyfukitchen.service.BrowseService;
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
public class BrowseAction {

    @Resource
    private BrowseService browseService;

    /**
     * 添加一条浏览过的食谱的记录
     * @param browseId
     * @param userName
     * @return
     */
    @RequestMapping("/saveOneToBrowse")
    @ResponseBody
    public Integer saveOneBrowse(@RequestParam("browseId") Integer browseId,@RequestParam("userName") String userName){
        Integer judge=browseService.queryBrowseExistence(browseId,userName);
        if(judge==1)
            return browseService.saveOneBrowse(browseId,userName);
        else
            return judge;
    }

    /**
     * 删除一条记录
     * @param browseId
     * @return
     */
    @GetMapping("/delectOneBrowse")
    @ResponseBody
    public Integer deleteOneBrowse(@RequestParam("browseId") Integer browseId){
        return browseService.deleteOneBrowse(browseId);
    }
    /**
     * 查询
     * @param userName
     * @return
     */
    @GetMapping("/queryOneBrowse")
    @ResponseBody
    public List<Browse> queryOneBrowse(@RequestParam("userName") String userName){
        return browseService.queryOneBrowse(userName);
    }

}
