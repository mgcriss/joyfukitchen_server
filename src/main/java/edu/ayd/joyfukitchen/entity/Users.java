package edu.ayd.joyfukitchen.entity;


import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by 萝莉 on 2017/4/17.
 */
@Entity
/*@Table(name = "Users")*/
public class Users {

    @Id
    @GeneratedValue
    private Integer uId;
    @Column(name = "username")
    private String username; //注册
    @Column(name = "password")
    private String password; //密码
    @Column(name = "nickname")
    private String nickname; //昵称
    @Column(name = "sex")
    private String sex; //性别
    @Column(name = "height")
    private Integer height; //身高
    @Column(name = "weight")
    private Double weight; //体重
    @Column(name = "birth")
    private Date birth; //生日
    @Column(name = "workStrength")
    private String workStrength; //工作强度
    @Column(name = "workTime")
    private Integer workTime; //工作时间
    @Column(name = "target")
    private String target; //目标

    @OneToMany(mappedBy = "users")
    private List<Atten> attens; //关注元素

    @OneToMany(mappedBy = "users")
    private List<Browse> browses; //浏览过的食谱

    @OneToMany(mappedBy = "users")
    private List<Favorite> favorites; //喜欢的食谱

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getWorkStrength() {
        return workStrength;
    }

    public void setWorkStrength(String workStrength) {
        this.workStrength = workStrength;
    }

    public Integer getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Integer workTime) {
        this.workTime = workTime;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public List<Atten> getAttens() {
        return attens;
    }

    public void setAttens(List<Atten> attens) {
        this.attens = attens;
    }

    public List<Browse> getBrowses() {
        return browses;
    }

    public void setBrowses(List<Browse> browses) {
        this.browses = browses;
    }

    public List<Favorite> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Favorite> favorites) {
        this.favorites = favorites;
    }

    @Override
    public String toString() {
        return "Users{" +
                "uId=" + uId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sex='" + sex + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", birth=" + birth +
                ", workStrength='" + workStrength + '\'' +
                ", workTime=" + workTime +
                ", target='" + target + '\'' +
                ", attens=" + attens +
                ", browses=" + browses +
                ", favorites=" + favorites +
                '}';
    }
}
