package edu.ayd.joyfukitchen.service;

import com.google.gson.Gson;
import edu.ayd.joyfukitchen.entity.Result;
import edu.ayd.joyfukitchen.util.JuheUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1.
 */
@Service
@Transactional
public class MenuService {

    private static final Logger log = Logger.getLogger(MenuService.class);
    private int start = 0;
    private int stepSize = 8;  //默认显示8条数据
    private int t = 0;  // 第几次调用接口查询。

    //根据名字查询出来的菜谱
    private List<Result.ResultBean.DataBean> data;

    //根据标签查询出来的菜谱
    private List<Result.ResultBean.DataBean> dataFromTag;

    //历史一次搜索的菜谱name，用于比较当前次，是否清空data集合
    private String nameHistory;


    //服务器读取三十条，分批次返回给客户端  减少服务器请求次数

    private static Gson gson = new Gson();

    /**
     * 根据名字搜索菜谱,
     * 搜索30条， 返回指定的条数.
     * @param name :搜索的菜谱名
     *         times: 第几次
     * */
    public List<Result.ResultBean.DataBean> searchMenuForName(String name, Integer times){

        if(name == null){
            return null;
        }
        //如果当前的name与上一次搜索的name不一样，初始化start,end
        if(nameHistory == null) {
            nameHistory = name;
            start = 0;
            t = 0;
        }
        if( !nameHistory.equals(name)){
            data = null;
        }
        Integer end =  start+stepSize;
        if(data == null) {
            log.info("没有数据，获取最初30条数据");
            String resultString = JuheUtil.getRequest5(name, t);
            //判断返回的数据是否为空
            if(resultString == null || "".equals(resultString)){
                log.info("没有数据");
                return null;
            }
            Result result = gson.fromJson(resultString, Result.class);
            data = result.getResult().getData();

        }
        //如果查询的下标大于已查询出来的总条数,则需要再查询一次30条
        if(end > data.size()){
            log.info("下标大于数组长度，增加数组长度");
            t++;
            data.addAll(gson.fromJson(JuheUtil.getRequest5(name, t), Result.class)
                    .getResult().getData());
        }
        log.info("获取的是现有的数据");
        return data.subList(start, end);
    }


    /**
     * 根据标签id查询菜谱
     * */



































    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getStepSize() {
        return stepSize;
    }

    public void setStepSize(int stepSize) {
        this.stepSize = stepSize;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    public List<Result.ResultBean.DataBean> getData() {
        return data;
    }

    public void setData(List<Result.ResultBean.DataBean> data) {
        this.data = data;
    }
}
