package edu.ayd.joyfukitchen.entity;

import javax.persistence.*;

/**
 * Created by 萝莉 on 2017/4/18.
 */
@Entity
@Table(name = "Browse",schema = "root")
public class Browse {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "browseRecipes")
    private Integer browseRecipes; //浏览过的食谱

    @Column(name = "usersID")
    private Integer usersID;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBrowseRecipes() {
        return browseRecipes;
    }

    public void setBrowseRecipes(Integer browseRecipes) {
        this.browseRecipes = browseRecipes;
    }

    public Integer getUsersID() {
        return usersID;
    }

    public void setUsersID(Integer usersID) {
        this.usersID = usersID;
    }
}
