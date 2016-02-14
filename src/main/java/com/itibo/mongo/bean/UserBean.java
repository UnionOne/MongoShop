package com.itibo.mongo.bean;

import com.itibo.mongo.model.UserModel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by union on 15.02.2016.
 */

@ViewScoped
@ManagedBean(name = "users")
public class UserBean {
    private List<UserModel> users;

    @PostConstruct
    public void init() {
        users = new LinkedList<>();
        users.add(new UserModel(1001, "Audio Album", "A Love Supreme", "Sony Music", "John Coltrane", ""));
        users.add(new UserModel(1002, "Audio Album", "Zdorovo i Vechno", "Grob Records", "Egor Letov", "Egor Letov"));
        users.add(new UserModel(1003, "Audio Track", "Ivan Govnon", "Grob Records", "Egor Letov", "Egor Letov"));
        users.add(new UserModel(1005, "Audio Track", "Pesnya pro Lenina", "Grob Records", "Egor Letov", "Egor Letov"));
        users.add(new UserModel(1006, "Audio Track", "KGB-Rock", "Grob Records", "Egor Letov", "Egor Letov"));
    }

    public List<UserModel> getUsers() {
        return users;
    }

    public void setUsers(List<UserModel> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "users=" + users +
                '}';
    }
}
