package edu.ayd.joyfukitchen.entity;

import javax.persistence.*;

/**
 * Created by 萝莉 on 2017/4/18.
 */
@Entity
@Table(name = "Atten", schema = "root")
public class Atten {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "attenElement")
    private String attenElement;  //关注元素

    @Column(name = "usersID")
    private Integer usersID;

    @ManyToOne
    private Users users;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAttenElement() {
        return attenElement;
    }

    public void setAttenElement(String attenElement) {
        this.attenElement = attenElement;
    }

    public Integer getUsersID() {
        return usersID;
    }

    public void setUsersID(Integer usersID) {
        this.usersID = usersID;
    }
}
