package edu.ayd.joyfukitchen.service;

import com.google.gson.Gson;
import edu.ayd.joyfukitchen.entity.Result;
import edu.ayd.joyfukitchen.util.JuheUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1.
 */
@Service
@Transactional
public class MenuService {

    private Integer start = 0;
    private Integer stepSize = 8;  //默认显示8条数据
    private Integer t = 0;  // 第几次调用接口查询。

    private List<Result.ResultBean.DataBean> data;


    //服务器读取三十条，分批次返回给客户端  减少服务器请求次数

    private static Gson gson = new Gson();

    /**
     * 根据名字搜索菜谱,
     * 搜索30条， 返回指定的条数.
     * @param name :搜索的菜谱名
     *         times: 第几次
     * */
    public List<Result.ResultBean.DataBean> searchMenuForName(String name, Integer times){
        Integer end =  start+stepSize;
        if(data == null) {
            String resultString = JuheUtil.getRequest5(name, t);
            Result result = gson.fromJson(resultString, Result.class);
            data = result.getResult().getData();
        }
        //如果查询的下标大于已查询出来的总条数,则需要再查询一次30条
        if(end > data.size()){
            t++;
            data.addAll(gson.fromJson(JuheUtil.getRequest5(name, t), Result.class)
                    .getResult().getData());
        }
        return data.subList(start, end);
    }







    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getStepSize() {
        return stepSize;
    }

    public void setStepSize(Integer stepSize) {
        this.stepSize = stepSize;
    }

    public MenuService(Integer start, Integer stepSize) {
        this.start = start;
        this.stepSize = stepSize;
    }
    public Integer getT() {
        return t;
    }

    public void setT(Integer t) {
        this.t = t;
    }

}
