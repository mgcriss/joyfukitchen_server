package edu.ayd.joyfukitchen.entity;

import javax.persistence.*;

/**
 * Created by 萝莉 on 2017/4/18.
 */
@Entity
@Table(name = "Browse")
public class Browse {

    @Id
    @GeneratedValue
    private Integer bId;

    @Column(name = "browseRecipes")
    private Integer browseRecipes; //浏览过的食谱

    @Column(name = "usersID")
    private Integer usersID;

    @ManyToOne
    private Users users;

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
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

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
