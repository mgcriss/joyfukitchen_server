package edu.ayd.joyfukitchen.entity;

import javax.persistence.*;

import static javafx.scene.input.KeyCode.T;

/**
 * Created by 萝莉 on 2017/4/18.
 */
@Entity
@Table(name = "Favorite")
public class Favorite {

    @Id
    @GeneratedValue
    private Integer fId;

    @Column(name = "favoriteRecipes")
    private Integer favoriteRecipes; //喜欢的食谱

    @Column(name = "usersID")
    private Integer usersID;

    @ManyToOne
    private Users users;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public Integer getFavoriteRecipes() {
        return favoriteRecipes;
    }

    public void setFavoriteRecipes(Integer favoriteRecipes) {
        this.favoriteRecipes = favoriteRecipes;
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
