package edu.ayd.joyfukitchen.entity;

import javax.persistence.*;

import static javafx.scene.input.KeyCode.T;

/**
 * Created by 萝莉 on 2017/4/18.
 */
@Entity
@Table(name = "Favorite",schema = "root")
public class Favorite {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "favoriteRecipes")
    private Integer favoriteRecipes; //喜欢的食谱

    @Column(name = "usersID")
    private Integer usersID;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
